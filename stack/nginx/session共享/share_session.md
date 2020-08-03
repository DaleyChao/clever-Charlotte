## Session 共享
利用 memcached 做 tomcat 的session共享,单机启动 memcached，
其他tomcat服务器之间通过memcached做session同步。


### 安装 Memcached

可以用yum方式安装 `yum –y install memcached`

##### 启动 memcached

```
memcached -d -m 128 -u root -l 127.0.0.1 -p 11211 -c 256 -P /tmp/memcached.pid
检查是否启动成功，可否连接：memcached-tool 192.168.2.51:11211
参数解释：
	-d:后台启动服务
	-m:缓存大小
	-p：端口
	-l:IP （此参数为限制接入外部ip，不限制可以不填）
	-P:服务器启动后的系统进程ID，存储的文件
	-u:服务器启动是以哪个用户名作为管理用户

```

#### Nginx配置
配置被代理的两台服务器
```
upstream tomcat{
        server 192.168.2.52:8080;
        server 192.168.2.53:8080;
      }

        location /tomcat {
        proxy_pass http://tomcat/;
      } 

```

#### Tomcat配置

复制 lib 包内jir文件到下到tomcat的lib下，jar包见本文档同级目录下。

并且在每个tomcat里面的 context.xml 配置文件中加入

```
<Manager className="de.javakaffee.web.msm.MemcachedBackupSessionManager" 
	memcachedNodes="n1:192.168.43.151:11211" 
    sticky="false" 
    lockingMode="auto"
    sessionBackupAsync="false"
	requestUriIgnorePattern=".*\.(ico|png|gif|jpg|css|js)$"
    sessionBackupTimeout="1000" transcoderFactoryClass="de.javakaffee.web.msm.serializer.kryo.KryoTranscoderFactory" 
/>
192.168.43.151:11211 为 memcached 服务器 ip

```



