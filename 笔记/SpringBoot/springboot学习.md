# springboot开始

简单介绍：springboot是为了简化Spring应用的创建、运行、调试、部署等而出现的，使用它可以做到专注于Spring应用的开发，而无需过多关注XML的配置。

简单来说，它提供了一堆依赖打包，并已经按照使用习惯解决了依赖问题---习惯大于约定。

## 简单开发实例

​	使用maven配置springboot的依赖：

1.新建maven项目

2.在pom.xml中的parent标签设为*spring-boot-starter-parent*，建议使用最新RELEASE版本。否则可能需要设置 *<repositories/>* 和*<pluginRepositories/>* 。

3.添加starter模块。starter模块，简单的说，就是一系列的依赖包组合。例如web starter模块，就是包含了Spring Boot预定义的一些Web开发的常用依赖：

○ spring-web, spring-webmvc            Spring WebMvc框架
○ tomcat-embed-*                              内嵌Tomcat容器
○ jackson                                             处理json数据
○ spring-*                                            Spring框架
○ spring-boot-autoconfigure             Spring Boot提供的自动配置功能

换言之，当添加了相应的starter模块，就相当于添加了相应的所有必须的依赖包。（starter模块列表和含义，详见[springboot启动器starter详解](http://blog.csdn.net/chszs/article/details/50610474)

至此，pom内容如下：

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>cn.larry.spring</groupId>
    <artifactId>larry-spring-demo4</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

保存pom，刷新maven，加载依赖导入。

sb已有基本默认配置，如无特殊需要（指设置容器、访问端口、路径等），现在就可以写controller了。