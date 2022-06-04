package com.books.app.domain.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 書籍登録 リクエストクラス<br>
 *
 */
@Component
@Data
public class RegistBookRequestForm {
	/**
	 * タイトル
	 */
	@NotEmpty(message = "{task.title.required}")
	@Size(min = 1, max = 100, message = "{task.title.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.title.pattern}")
	private String title;
	
	/**
	 * 著者
	 */
	@NotEmpty(message = "{task.author.required}")
	@Size(min = 1, max = 100, message = "{task.author.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.author.pattern}")
	private String author;

	/**
	 * 分類
	 * TODO:Enumで保持する
	 */
	@NotEmpty(message = "{task.category.required}")
	@Size(min = 1, max = 24, message = "{task.category.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.category.pattern}")
	private String category;

	/**
	 * 概要
	 */
	@Size(min = 1, max = 500, message = "{task.summary.length}")
	@Pattern(regexp = "^[a-zA-Z0-9!-/:\\[\\-@-`{-~|^\\x20-\\x7e]*", message = "{task.summary.pattern}")
	private String summary;

	/**
	 * 画像<br>
	 * 値がnullの場合、チェック処理が行わない。 
	 */
	private String image;

}
