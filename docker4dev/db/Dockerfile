FROM mysql:8.0.26
COPY ./docker4dev/db/mysql.conf.d /etc/mysql/mysql.conf.d
# 「/docker-entrypoint-initdb.d/」に配置しているSQLを、コンテナ起動時に実行してくれる。
COPY ./docker4dev/db/sql/dml/create_tbl_book_list.sql /docker-entrypoint-initdb.d/create_tbl_book_list.sql