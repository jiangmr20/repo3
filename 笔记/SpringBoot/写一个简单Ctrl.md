springboot简单ctrl实例

```java
package cn.larry.spring.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
```

写完ctrl后，就可以启动主方法main了，sb的默认访问地址是：http://localhost:8080/

按照之前的web项目习惯，你可能会问，怎么没有项目路径？

这就是Spring Boot的默认设置了，将项目路径直接设为根路径。

当然，我们也可以设置自己的项目路径 -- 在classpath下的 application.properties 或者 application.yaml 文件中设置即可。

如下：application.properties

```properties
# application.yaml
# Server settings (ServerProperties)
server:
  port: 8080
  address: 127.0.0.1
  sessionTimeout: 30
  contextPath: /aaa

  # Tomcat specifics
  tomcat:
    accessLogEnabled: false
    protocolHeader: x-forwarded-proto
    remoteIpHeader: x-forwarded-for
    basedir:
    backgroundProcessorDelay: 30 # secs
```

application.yaml 

```yaml
# application.properties# Server settings (ServerProperties)server.port=8080server.address=127.0.0.1#server.sessionTimeout=30server.contextPath=/aaa# Tomcat specifics#server.tomcat.accessLogEnabled=falseserver.tomcat.protocolHeader=x-forwarded-protoserver.tomcat.remoteIpHeader=x-forwarded-forserver.tomcat.basedir=server.tomcat.backgroundProcessorDelay=30
```

