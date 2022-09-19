FROM centos:7
RUN yum -y update && yum clean all
RUN yum -y install httpd httpd-devel gcc* make && yum clean all
COPY ./docker4ecs/web_app/apache/httpd.conf /etc/httpd/conf/httpd.conf
# 静的コンテンツをコピー
COPY ./src/main/resources/static/base/ /var/www/html/base/
COPY ./src/main/resources/static/css/ /var/www/html/css/
COPY ./src/main/resources/static/images/ /var/www/html/images/
COPY ./src/main/resources/static/js/ /var/www/html/js/
COPY ./src/main/resources/static/about.html /var/www/html/about.html
COPY ./src/main/resources/static/gallery.html /var/www/html/gallery.html
COPY ./src/main/resources/static/index.html /var/www/html/index.html
COPY ./src/main/resources/static/link.html /var/www/html/link.html
COPY ./src/main/resources/static/register.html /var/www/html/register.html

EXPOSE 80

# dockerrun時に指定するコマンド
# serviceコマンドを使用すると、バックグラウンドで実行した後、serviceコマンド自体は終了する為コンテナも終了してしまう。
# そのため、httpdデーモンをフォアグラウンドで起動させる。
ENTRYPOINT ["/usr/sbin/httpd","-DFOREGROUND"]