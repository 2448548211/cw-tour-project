FROM ubuntu:18.04

ADD ./jdk-8u271-linux-x64.tar.gz  /opt/java
#配置Java参数
ENV  JAVA_HOME    /opt/java/jdk1.8.0_271
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar


COPY ./app.jar  /

CMD ["java","-jar","/app.jar"]