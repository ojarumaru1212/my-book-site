let app1 = new Vue({
	el: '#app',
	data: {
		loading: true, // ローディング表示可否フラグ（true:表示、false:非表示）
		title: null, // タイトル
		author: null, // 著者
		category: null, // 分類
		summary: null, // 概要
		image: null, // 画像（TODO）
		buttonActive: false, // 登録ボタン活性フラグ（true:活性、false:非活性）
		url: "/registBook", // タスク登録の際にサーバと通信するURL
		data: null, // サーバと通信時のリクエストパラメータ
		result: null,// ログイン処理実施結果（true:成功、false:失敗）
		locationUrl: "/index.html", // タスク登録成功時の遷移先URL、戻るボタン押下時のURL
	},
	mounted: function() {
		this.loading = false;
	},
	methods: {
		/* 入力されたタイトルを格納する */
		inputTitle: function(event) {
			const validChk = validExecute(event.target.value, true, 1, 100);
			if (!validChk) return;

			this.title = event.target.value;
			this.buttonActive = true;
			console.log("タイトル入力 : " + this.title);
		},
		/* 入力された著者を格納する */
		inputAuthor: function(event) {
			const validChk = validExecute(event.target.value, true, 1, 100);
			if (!validChk) return;

			this.author = event.target.value;
			this.buttonActive = true;
			console.log("著者入力 : " + this.author);
		},
		/* 入力された分類を格納する */
		inputCategory: function(event) {
			const validChk = validExecute(event.target.value, true, 1, 24);
			if (!validChk) return;

			this.category = event.target.value;
			this.buttonActive = true;
			console.log("分類入力 : " + this.category);
		},
		/* 入力された概要を格納する */
		inputSummary: function(event) {
			const validChk = validExecute(event.target.value, false, 1, 500);
			if (!validChk) return;

			this.summary = event.target.value;
			console.log("概要入力 : " + this.summary);
		},
		/* 入力された画像を格納する */
		inputImage: function(event) {
			// TOOD
		},
		/* タスクを登録するため、サーバと通信する */
		registTask: function(event) {
			console.log(event);

			// 入力チェック（サーバ側の入力処理の都合上、空文字の場合nullを設定する）
			this.data = {
				title: this.title === "" ? null : this.title,
				author: this.author === "" ? null : this.author,
				category: this.category === "" ? null : this.category,
				summary: this.summary === "" ? null : this.summary
			};

			// ローディング開始
			this.loading = true;

			axios.post(this.url, this.data
			).then(response => {
				this.result = response.data;
				// 登録が正常に完了した場合
				if (this.result.registSuccessFlg === true) {
					location.href = this.locationUrl;
					// 上記以外
				} else {
					// モーダルに表示する文言を格納
					modalApp.messages = this.result.messages;
					// モーダルを表示
					modalApp.modalOpen();
					// ローディング終了
					this.loading = false;
				}
			}).catch(err => {
				alert(err);
			})

		},
		/* 戻るボタン押下時にホーム画面に遷移する */
		backPage: function() {
			// ローディング開始
			this.loading = true;
			
			location.href = this.locationUrl;
		}
	}
})

/**
* 入力チェックを実施する。
* @param value チェック対象の値
* @param requiredFlg 必須フラグ（true:必須、false:任意）
* @param minLength 最小桁数
* @param maxLength 最大桁数
* @return true:チェックOK、false:チェックNG
*/
const validExecute = (value, requiredFlg, minLength, maxLength) => {
	// 必須チェック
	if (!isRequired(value)) {
		// 任意項目の場合、必須エラーとしない。
		return requiredFlg === true ? false : true;
	}

	// 桁チェック
	if (!isLength(value, minLength, maxLength)) return false;

	// 型チェック
	if (!isFormat(value)) return false;

	return true;
}