FROM java:8-alpine
EXPOSE 8080
COPY target/*.jar /vertx/
WOKRDIR /vertx
CMD java -jar *.jar -Dvertx.cacheDirBase=/tmp