package com.books.app.domain.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * 書籍登録 レスポンスクラス
 *
 */
//@Component
@Data
@Builder
public class RegistBookResponseForm implements Serializable {
	private List<String> messages;
	private boolean registSuccessFlg;
}
