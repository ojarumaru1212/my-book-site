my-book-site
====

## Overview
書籍の登録や検索、編集ができるサイト

## Description
ー

## Demo
ー

## Requirement
- PG言語<br>

|            | バージョン   | ライブラリ   | フレームワーク    |
|:-----------|:------------:|:------------:|:------------:     |
| HTML       | ー           | ー           | ー                |
| CSS        | ー           | ー           | ー                |
| JavaScript | ー           | JQuery 3.6.0 | Vue 2.6.14        |
| Java       | 1.8           | ー           | Spring Boot 2.7.0 |

- DB<br>
MySQL 8.0.29

- ツール等<br>
Docker 20.10.11<br>
※Apache、Tomcat、MySQLコンテナを起動している。

- ビルドツール<br>
Gradle 7.1.1

## Usage
- MySQLコンテナの起動方法
```
# ■コンテナ起動コマンド（./app/docker配下で実行）
# docker-compose up -d
#
# ■起動したコンテナに入るコマンド
# docker exec -it [コンテナ名/コンテナID] /bin/bash
#
# ■DBに入るコマンド
# mysql -u root -p
# enter押下後、rootのパスワードを入力
```

- サイトへの接続方法<br>
【ローカルの場合】<br>
アプリ実行後、下記URLへ接続する。<br>
`localhost:8080/index.html`<br><br>
【公開サイトの場合】<br>
ー

## Install
ー
## Contribution
ー

## Author
ojarumaru1212
