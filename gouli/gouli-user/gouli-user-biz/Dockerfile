
### 基础镜像
FROM java:8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD gouli-user-biz.jar app.jar

#启动容器时的进程
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#暴露8088端口,这个端口对应的是服务本身的端口
EXPOSE 8081