CREATE TABLE `tbl_book_list` (
    `book_no` bigint NOT NULL AUTO_INCREMENT UNIQUE COMMENT "連番",
    `title` char(255) NOT NULL COMMENT "タイトル",
    `author` char(255) NOT NULL COMMENT "著者",
    `category` char(255) COMMENT "分類",
    `summary` varchar(500) COMMENT "概要",
    `image` varchar(500) COMMENT "画像",
    `registed_date` datetime COMMENT "登録日時",
    `updated_date` datetime COMMENT "更新日時",
    PRIMARY KEY(title, author)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;