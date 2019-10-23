resin4：介绍网址：https://blog.csdn.net/qq_22805577/article/details/80394127

[TOC]

#### 一、resin简介

resin是java web容器，作用与tomcat类似，也需要运行在JVM上面，所以我们需先安装JDK。

Resin是CAUCHO公司的产品，是一个非常流行的支持servlets和jsp的引擎，速度非常快。Resin本身包含了一个支持HTTP/1.1的WEB服务器。虽然它可以显示动态内容，但是它显示静态内容的能力也非常强，速度直逼apache server。许多站点都是使用该WEB服务器构建的。

​    Resin也可以和许多其他的WEB服务器一起工作，比如Apache server和IIS等。Resin支持Servlets 2.3标准和JSP 1.2标准。熟悉ASP和PHP的用户可以发现用Resin来进行JSP编程是件很容易的事情。

​    Resin支持负载平衡（Load balancing），可以增加WEB站点的可靠性。方法是增加服务器的数量。比如一台SERVER的错误率是1%的话，那么支持负载平衡的两个Resin服务器就可以使错误率降到0.01%。

版本区别：

​    Resin 普通版本和pro版本主要区别是 pro支持缓存和负载均衡。pro因为有强大的cache功能，独立作为web服务器处理静态页面性能都可以和apache有一比。但普通版本独立作为web服务器性能就要差一些。当然可以使用apache+resin的方案借助apache的缓存功能提高性能。 但负载均衡就是普通版不能比的了。

#### 二、resin安装

1、Resin的下载

Resin的官方地址：http://caucho.com/

\# wget http://caucho.com/download/resin-pro-4.0.44.tar.gz

2、Resin的安装（linux上）

​    Resin这个软件比较特殊，我们可以直接解压出来使用，就和tomcat一样，如果需要和apache结合，或者需要其他一些特性就需要编译安装，编译和其他软件编译安装是一样的也是非常方便的，因为没有特殊的需求，我们这里就不进行编译，直接解压使用。

\# tar xf resin-pro-4.0.44.tar.gz -C /usr/local

\# mv resin-pro-4.0.44.tar.gz resin

\# vim /etc/profile.d/resin.sh

export RESIN_HOME=/usr/local/resin

\# . /etc/profile.d/resin.sh

3.resin启动命令

#/usr/local/resin/bin/resin.sh star

```shell
Resin/4.0.44 launching watchdog at 127.0.0.1:6600
Resin/4.0.44 started -server 'app-0' with watchdog at 127.0.0.1:6600
```

#netstat -tlnp|grep java

```shell
tcp       0      0 ::ffff:127.0.0.1:6600       :::*          LISTEN      1926/java       
tcp       0      0 :::8080                     :::*          LISTEN      1971/java       
tcp       0      0 ::ffff:127.0.0.1:6800       :::*          LISTEN      1971/java
```

#### 三、resin配置

1、点击【/resin-admin】进入登陆、注册页面，由于首次登陆Resin还没有用户，所以先注册一个管理员账号；如下图所示(图全挂了)

2、点击【Create Configuration File】；如若用户创建成功，提示如下图所示

3、注册用户创建成功后会在/usr/local/resion/conf目录下生成一个admin-users.xml.generated的模板文件，这个模板不能直接使用，我们需要将其改成为admin-users.xml文件

4、如果部署到无GUI界面的系统上如：CentOS Solaris Ubuntu-Server等，无法通过浏览器访问本地resin-admin，则需要修改resin.properties文件爱你，开启远程访问权限，然后再次登录

\# vim /usr/local/resin/conf/resin.properties

5、首次登陆后的界面如下：

#### 四、resin4基于目录和域名的部署

1、同一个域名下多个子app，根据url层级来指向

http://www.wzlinux.com/

http://www.wzlinux.com/app1

http://www.wzlinux.com/app2

2、多个域名对应指定的host，根据域名来指定

http://www.wzlinux.com/

http://www.a.com/

【第一种配置方法】

```xml
<!-- the default host, matching any host name -->
 <host id="" root-directory=".">
      <!--
         - webapps can be overridden/extended in the resin.xml
        -->
      <web-app id="/" root-directory="webapps/ROOT"/>
      <web-app id="/api" root-directory="webapps/app"/>
      <web-app id="/app1" root-directory="/data/www/app1"/>
      <web-app id="/app2" root-directory="/data/www/app2"/>
  
 </host>
```

【第二种配置方法】

第一个appserver

```xml
<host id="www.wzlinux.com" root-directory=".">
      <!--
         - webapps can be overridden/extended in the resin.xml
        -->
      <web-app id="/" root-directory="webapps/tset1/ROOT"/>
  
    </host>
```

第二个

```xml
<host id="www.a.com" root-directory=".">
      <!--
         - webapps can be overridden/extended in the resin.xml
        -->
      <web-app id="/" root-directory="webapps/test2/ROOT"/>
  
    </host>
```

#### 五、resin4基于不同端口的部署

1、Resin默认端口是8080；添加如下代码，在本机配置两个实例端口为8081、8082

```xml
<cluster id="app1">
    <!-- define the servers in the cluster -->
    <server-multi id-prefix="app1" address-list="${app1_servers}" port="6801"/>
  
    <!-- the default host, matching any host name -->
        <host id="" root-directory=".">
              <!--
                  - webapps can be overridden/extended in the resin.xml
                               -->
      <web-app id="/" root-directory="/data/www/app1/ROOT"/>
  
    </host>
    </cluster>
  
<cluster id="app2">
    <!-- define the servers in the cluster -->
    <server-multi id-prefix="app2" address-list="${app2_servers}" port="6802"/>
  
    <!-- the default host, matching any host name -->
        <host id="" root-directory=".">
              <!--
                   - webapps can be overridden/extended in the resin.xml
                                -->
      <web-app id="/" root-directory="/data/www/app2/ROOT"/>
  
    </host>
</cluster>
```

2、修改当前目录vim  resin.properties 修改如下内容：

```properties
# app-tier Triad servers: app-0 app-1 app-2
app_servers       : 127.0.0.1:6800
app1_servers      : 127.0.0.1:6801
app2_servers      : 127.0.0.1:6802
  
# Use overrides for individual server control, for example: app-0.http : 8081
app.http           : 8080
app1.http          : 8081
app2.http          : 8082
```

3、重新启动Resin服务使其重新加载Resin配置文件

#### 六、整合resin和apache

1、为什么要整合apache

Resin，tomcat对http服务支持不太好

   

2、安装apache

\# tar zxvf httpd-2.49.tar.gz 
\# cd httpd-2.49 
\# ./configure --prefix=/usr/local/httpd --enable-modules=so --enable-so 

\# make 
\# make install



3、Resin安装

\# tar zxvf resin-4.0.44.tar.gz 
\# cd resin-4.0.44 
\# ./configure --prefix=/usr/local/resin --with-apache=/usr/local/httpd 
\# make 
\# make install
此时已经生成Resin连接Apache2的.so文件了，其存在与$APACHE_HOME/modules/mod_caucho.so



此时conf/httpd.conf中就会多出以下语句：

```properties
`LoadModule caucho_modules modules``/mod_caucho``.so    ``ResinConfigServer localhost 6802`
```

分别先后启动Resin和Apache 
端口转发后访问：

http://localhost:9000/    显示it works

http://localhost:9000/caucho-status 可以看到Resin的状态页面

 

===============================

如果是已经装好了Resin后要装Apache（比如Apache要升级了哈）

简单可以这样整合，三步：

1：单独装完Apache或是升级的更高的版本

2：修改apache/conf/httpd.conf文件

在最后添加

```
`#``# mod_caucho Resin Configuration``#``LoadModule caucho_module ``/usr/local/apache_2``.2.8``/modules/mod_caucho``.so``ResinConfigServer localhost 6802``CauchoConfigCacheDirectory ``/tmp``CauchoStatus ``yes`
```

 

另外如果Log 的路径或是设置了cronlog的也把相应的修改一下

3：之后一定要确保/usr/local/apache_2.2.8/modules/路径下面有mod_caucho.so模块

如果没有要不从老系统Copy一个，要不单独下Resin源代码编译下mod_caucho.so模块

OK，启动Resin和Apache就行了。。。。。。



转载地址：http://blog.51cto.com/wzlinux/1692667