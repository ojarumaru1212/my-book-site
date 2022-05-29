package com.books.app.domain.logic;

import com.books.app.domain.mapper.BookMapper;
import com.books.app.domain.model.RegistBookRequestForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 書籍登録 ロジッククラス
 *
 */
@Component
public class RegistBookLogic {

	private final BookMapper mapper;

	@Autowired
	public RegistBookLogic(BookMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 書籍を登録する
	 * 
	 * @return true:登録件数1件、false:登録件数1件以外
	 */
	public boolean registBook(RegistBookRequestForm form) {
		int registCnt = mapper.registBook(form.getTitle(), form.getAuthor(), form.getCategory(), form.getSummary(), form.getImage());

		return registCnt == 1 ? true : false;
	}

}
