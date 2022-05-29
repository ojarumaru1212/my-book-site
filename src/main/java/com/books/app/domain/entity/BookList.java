package com.books.app.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 書籍テーブル エンティティクラス
 *
 */
@Data
public class BookList implements Serializable {
    private Long taskNo;
    private String title;
    private String userId;
    private String detail;
    private String remark;
    private String completedFlg;
    private String deletedFlg;
    private Timestamp registedDate;
    private Timestamp updatedDate;
}
