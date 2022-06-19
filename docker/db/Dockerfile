FROM mysql:8.0.26
COPY ./mysql.conf.d /etc/mysql/mysql.conf.d
# 「/docker-entrypoint-initdb.d/」に配置しているSQLを、コンテナ起動時に実行してくれる。
COPY ./sql/dml/create_tbl_book_list.sql /docker-entrypoint-initdb.d/create_tbl_book_list.sql