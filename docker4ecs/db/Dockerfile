FROM mysql:8.0.26
ENV MYSQL_ROOT_PASSWORD password
ENV MYSQL_DATABASE BOOK_DB
ENV TZ Asia/Tokyo

EXPOSE 3306

COPY ./docker4ecs/db/mysql.conf.d /etc/mysql/mysql.conf.d
# 「/docker-entrypoint-initdb.d/」に配置しているSQLを、コンテナ起動時に実行してくれる。
COPY ./docker4ecs/db/sql/dml/create_tbl_book_list.sql /docker-entrypoint-initdb.d/create_tbl_book_list.sql