package com.books.app.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 書籍テーブル マッパークラス
 *
 */
@Mapper
public interface BookMapper {

	/**
	 * 書籍を登録する
	 * 
	 * @param title  タイトル
	 * @param author  著者
	 * @param category 分類
	 * @param summary 概要
	 * @param image 画像
	 * @return 登録件数
	 */
	@Update("INSERT INTO tbl_book_list (title, author, category, summary, image, registed_date, updated_date) VALUES(#{title},  #{author}, #{category}, #{image}, '0', '0', now(), now())")
	int registBook(@Param("title") String title, @Param("author") String author, @Param("category") String category,
			@Param("summary") String summary, @Param("image") String image);
}
