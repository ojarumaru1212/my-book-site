FROM tomcat:9.0.1-alpine
COPY ./docker4ecs/web_app/tomcat/tomcat-users.xml /usr/local/tomcat/conf/
COPY ./docker4ecs/web_app/tomcat/server.xml $CATALINA_HOME/conf/server.xml
COPY ./build/libs/app.war $CATALINA_HOME/webapps/

EXPOSE 8009

#COPY ./jdk-11.0.15/ /usr/lib/jvm/java-1.8-openjdk/jre/
#COPY catalina.sh /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]