FROM tomcat:9.0.1-alpine
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY server.xml $CATALINA_HOME/conf/server.xml
COPY app.war $CATALINA_HOME/webapps/
#COPY ./jdk-11.0.15/ /usr/lib/jvm/java-1.8-openjdk/jre/
#COPY catalina.sh /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]