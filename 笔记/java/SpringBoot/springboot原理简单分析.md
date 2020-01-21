## 一、什么是SpringBoot?

SpringBoot是一个快速开发框架，快速的将一些常用的第三方依赖整合（原理：通过Maven子父工程的方式），简化XML配置，全部采用注解形式，内置Http服务器（Jetty和Tomcat），最终以java应用程序进行执行。

## 二、SpringBoot核心原理

1> 基于SpringMVC无配置文件（纯Java）完全注解化+内置tomcat-embed-core实现SpringBoot框架，Main函数启动。

2> SpringBoot核心快速整合第三方框架原理:Maven继承依赖关系。

## 三、SpringBoot重点

###### 3.1:快速整合第三方依赖：maven子父依赖关系。

springboot 通过引用spring-boot-starter-web依赖，整合SpingMVC框架。只需要引用一个jar包，就可以通过Maven继承的方式引用到Spring-aop,Spring-beans,Spring-core,Spring-web等相关依赖。

###### 3.2：完全无配置文件（采用注解化）

springboot没有配置文件，如何进行初始化？

在没有web.xml配置文件的情况，通过java代码操作整个SpringMVC的初始化过程，java代码最终会生成class文件,内置Tomcat就会加载这些class文件，当所有程序加载完成后，项目就可以访问了。

以前的web项目，通过Web.xml配置文件加载整个项目流程。

![web.xml](https://img-blog.csdn.net/20180720123147189?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDE3OTgz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![web1.xml](https://img-blog.csdn.net/20180720123228622?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDE3OTgz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

没有web.xml文件，那么Tomcat是如何启动（注解在什么时候产生）？

在Spring3.0以上（提供注解，在这个版本以后，有了巨大改变，完全不需要任何配置文件加载项目）。

SpringMVC内置注解加载整个SpringMVC容器。相当于使用Java代码编写SpringMVC初始化。

###### **3.3：内置Http服务器**

java代码创建Tomcat容器，加载class文件。 （不用写该代码其实也能自动创建）

```java
package com.springboot;
 
import java.io.File;
 
import javax.servlet.ServletException;
 
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
 
public class AppTomcat {
 
	public static void main(String[] args) throws ServletException, LifecycleException {
		// 使用Java内置Tomcat运行SpringMVC框架 原理：tomcat加载到
		// springmvc注解启动方式，就会创建springmvc容器
		start();
	}
 
	public static void start() throws ServletException, LifecycleException {
 
		// 创建Tomcat容器
		Tomcat tomcatServer = new Tomcat();
		// 端口号设置
		tomcatServer.setPort(9090);
		// 读取项目路径 加载静态资源
		StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
		// 禁止重新载入
		ctx.setReloadable(false);
		// class文件读取地址
		File additionWebInfClasses = new File("target/classes");
		// 创建WebRoot
		WebResourceRoot resources = new StandardRoot(ctx);
		// tomcat内部读取Class执行
		resources.addPreResources(
				new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		tomcatServer.start();
		// 异步等待请求执行
		tomcatServer.getServer().await();
 
	}
 
}

```

原文地址：https://blog.csdn.net/qq_38417983/article/details/81128299

