FROM centos:7
RUN yum -y update && yum clean all
RUN yum -y install httpd httpd-devel gcc* make && yum clean all
COPY httpd.conf /etc/httpd/conf/httpd.conf
# 静的コンテンツをコピー
COPY base/ /var/www/html/base/
COPY css/ /var/www/html/css/
COPY images/ /var/www/html/images/
COPY js/ /var/www/html/js/
COPY about.html /var/www/html/about.html
COPY gallery.html /var/www/html/gallery.html
COPY index.html /var/www/html/index.html
COPY link.html /var/www/html/link.html
COPY register.html /var/www/html/register.html
# dockerrun時に指定するコマンド
# serviceコマンドを使用すると、バックグラウンドで実行した後、serviceコマンド自体は終了する為コンテナも終了してしまう。
# そのため、httpdデーモンをフォアグラウンドで起動させる。
ENTRYPOINT ["/usr/sbin/httpd","-DFOREGROUND"]