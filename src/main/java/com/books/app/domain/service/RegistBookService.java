package com.books.app.domain.service;

import com.books.app.domain.logic.RegistBookLogic;
import com.books.app.domain.model.RegistBookRequestForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 書籍登録 サービスクラス
 *
 */
@Service
public class RegistBookService {

	private final RegistBookLogic logic;

	@Autowired
	public RegistBookService(RegistBookLogic logic) {
		this.logic = logic;
	}

	/**
	 * 書籍を登録するため、ロジッククラスを呼び出す
	 * 
	 * @param RegistBookRequestForm 書籍情報
	 * @return true:登録件数1件、false:登録件数1件以外
	 */
	public boolean RegistBook(RegistBookRequestForm form) {
		return logic.registBook(form);
	}
}
