let modalApp = new Vue({
	el: '#modal',
	data: {
		messages: [],
	},
	methods: {
		/* モーダルを表示する */
		modalOpen: function() {
			const modal = $("#easyModal")[0];
			modal.style.display = 'block';
		},
		/* モーダルを閉じる */
		modalClose: function() {
			const modal = $("#easyModal")[0];
			modal.style.display = 'none';
		}
	}
})