mybatis与ORM：https://www.jianshu.com/p/6d12949b7006

附上hibernate与ORM（选看）：https://www.jianshu.com/p/d3241b968437

ORM框架的优点：

- 符合Java的技术思想面向对象，将技术部分封装起来，程序猿只要专心写业务代码即可；
- 解耦，之前JDBC代码是将技术代码和业务代码融合在一起，耦合性太高，ORM框架就可以做到完美的解耦；
- 大大减少开发量，如果每次业务操作都手动连接数据库，然后做一些列操作，写繁杂冗余的代码，程序员们是会疯掉的；
- 提高代码的可维护性，通过映射关系，一目了然，降低了学习成本，同时也提高了可维护性。
- ……(感觉用的爽的都是优点)

### 配置文件！！！

配置文件是重头戏，这种规则是有了，但是数据库的连接，映射规则的读取，mapper接口和映射规则的关联等，都要在配置文件中体现和整合。另外还有一些对使用过程的一些优化配置，如插件、驼峰规则等。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 变量配置 -->
    <properties>
        <property name="userName" value="zdydoit"/>
        <property name="pwd" value="123456"/>
    </properties>
    <!-- 参数设置 -->
    <settings>
        <!-- 这个配置使全局的映射器启用或禁用缓存 -->
        <setting name="cacheEnabled" value="true" />
        <!-- 全局启用或禁用延迟加载。当禁用时，所有关联对象都会即时加载 -->
        <setting name="lazyLoadingEnabled" value="true" />
        <!-- 当启用时，有延迟加载属性的对象在被调用时将会完全加载任意属性。否则，每种属性将会按需要加载 -->
        <setting name="aggressiveLazyLoading" value="true" />
        <!-- 允许或不允许多种结果集从一个单独的语句中返回（需要适合的驱动） -->
        <setting name="multipleResultSetsEnabled" value="true" />
        <!-- 使用列标签代替列名。不同的驱动在这方便表现不同。参考驱动文档或充分测试两种方法来决定所使用的驱动 -->
        <setting name="useColumnLabel" value="true" />
        <!-- 允许JDBC支持生成的键。需要适合的驱动。如果设置为true则这个设置强制生成的键被使用，尽管一些驱动拒绝兼容但仍然有效（比如Derby） -->
        <setting name="useGeneratedKeys" value="true" />
        <!-- 指定MyBatis如何自动映射列到字段/属性。PARTIAL只会自动映射简单，没有嵌套的结果。FULL会自动映射任意复杂的结果（嵌套的或其他情况） -->
        <setting name="autoMappingBehavior" value="PARTIAL" />
        <!--当检测出未知列（或未知属性）时，如何处理，默认情况下没有任何提示，这在测试的时候很不方便，不容易找到错误。 NONE : 不做任何处理 
            (默认值) WARNING : 警告日志形式的详细信息 FAILING : 映射失败，抛出异常和详细信息 -->
        <setting name="autoMappingUnknownColumnBehavior" value="WARNING" />
        <!-- 配置默认的执行器。SIMPLE执行器没有什么特别之处。REUSE执行器重用预处理语句。BATCH执行器重用语句和批量更新 -->
        <setting name="defaultExecutorType" value="SIMPLE" />
        <!-- 设置超时时间，它决定驱动等待一个数据库响应的时间 -->
        <setting name="defaultStatementTimeout" value="25000" />
        <!--设置查询返回值数量，可以被查询数值覆盖 -->
        <setting name="defaultFetchSize" value="100" />
        <!-- 允许在嵌套语句中使用分页 -->
        <setting name="safeRowBoundsEnabled" value="false" />
        <!--是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 
            的类似映射。 -->
        <setting name="mapUnderscoreToCamelCase" value="false" />
        <!--MyBatis 利用本地缓存机制（Local Cache）防止循环引用（circular references）和加速重复嵌套查询。 
            默认值为 SESSION，这种情况下会缓存一个会话中执行的所有查询。 若设置值为 STATEMENT，本地会话仅用在语句执行上，对相同 SqlSession 
            的不同调用将不会共享数据。 -->
        <setting name="localCacheScope" value="SESSION" />
        <!-- 当没有为参数提供特定的 JDBC 类型时，为空值指定 JDBC 类型。 某些驱动需要指定列的 JDBC 类型，多数情况直接用一般类型即可，比如 
            NULL、VARCHAR OTHER。 -->
        <setting name="jdbcTypeForNull" value="OTHER" />
        <!-- 指定哪个对象的方法触发一次延迟加载。 -->
        <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString" />
    </settings>

    <!-- 别名定义 -->
    <typeAliases>
        <typeAlias alias="pageAccessURL" type="com.lgm.mybatis.model.PageAccessURL" />
    </typeAliases>

    <!--自定义类型处理器 -->
    <typeHandlers>
        <!-- <typeHandler handler="com.zdydoit.util.BooleanTypeHandlder" /> -->
        <!--扫描整个包下的自定义类型处理器 -->
        <package name="com.zdydoit.util" />
    </typeHandlers>

    <!--plugins插件之 分页拦截器 -->
    <plugins>
        <plugin interceptor="...PageInterceptor"></plugin>
    </plugins>

    <!--配置environment环境 -->
    <environments default="development1">
        <!-- 环境配置1，每个SqlSessionFactory对应一个环境 -->
        <environment id="development1">
            <!-- 事务配置 type= JDBC、MANAGED 1.JDBC:这个配置直接简单使用了JDBC的提交和回滚设置。它依赖于从数据源得到的连接来管理事务范围。 
                2.MANAGED:这个配置几乎没做什么。它从来不提交或回滚一个连接。而它会让容器来管理事务的整个生命周期（比如Spring或JEE应用服务器的上下文）。 
                默认情况下它会关闭连接。然而一些容器并不希望这样，因此如果你需要从连接中停止它，将closeConnection属性设置为false -->
            <transactionManager type="JDBC" />
            <!-- <transactionManager type="MANAGED"> <property name="closeConnection" 
                value="false"/> </transactionManager> -->
            <!-- 数据源类型：type = UNPOOLED、POOLED、JNDI 1.UNPOOLED：这个数据源的实现是每次被请求时简单打开和关闭连接。它有一点慢，这是对简单应用程序的一个很好的选择，因为它不需要及时的可用连接。 
                不同的数据库对这个的表现也是不一样的，所以对某些数据库来说配置数据源并不重要，这个配置也是闲置的 2.POOLED：这是JDBC连接对象的数据源连接池的实现，用来避免创建新的连接实例时必要的初始连接和认证时间。 
                这是一种当前Web应用程序用来快速响应请求很流行的方法。 3.JNDI：这个数据源的实现是为了使用如Spring或应用服务器这类的容器，容器可以集中或在外部配置数据源，然后放置一个JNDI上下文的引用 -->
            <dataSource type="UNPOOLED">
                <property name="driver" value="com.mysql.jdbc.Driver" />
                <property name="url" value="jdbc:mysql://localhost:3306/zdydoit" />
                <property name="username" value="root" />
                <property name="password" value="root" />
                <!-- 默认连接事务隔离级别 <property name="defaultTransactionIsolationLevel" value="" 
                    /> -->
            </dataSource>
        </environment>

        <!-- 环境配置2 -->
        <environment id="development2">
            <transactionManager type="JDBC" />
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver" />
                <property name="url" value="jdbc:mysql://localhost:3306/zdydoit" />
                <property name="username" value="root" />
                <property name="password" value="root" />
                <!-- 在任意时间存在的活动（也就是正在使用）连接的数量 -->
                <property name="poolMaximumActiveConnections" value="10" />
                <!-- 任意时间存在的空闲连接数 -->
                <property name="poolMaximumIdleConnections" value="5" />
                <!-- 在被强制返回之前，池中连接被检查的时间 -->
                <property name="poolMaximumCheckoutTime" value="20000" />
                <!-- 这是给连接池一个打印日志状态机会的低层次设置，还有重新尝试获得连接，这些情况下往往需要很长时间（为了避免连接池没有配置时静默失败） -->
                <property name="poolTimeToWait" value="20000" />
                <!-- 发送到数据的侦测查询，用来验证连接是否正常工作，并且准备接受请求。 -->
                <property name="poolPingQuery" value="NO PING QUERY SET" />
                <!-- 这是开启或禁用侦测查询。如果开启，你必须用一个合法的SQL语句（最好是很快速的）设置poolPingQuery属性 -->
                <property name="poolPingEnabled" value="false" />
                <!-- 这是用来配置poolPingQuery多次时间被用一次。这可以被设置匹配标准的数据库连接超时时间，来避免不必要的侦测 -->
                <property name="poolPingConnectionsNotUsedFor" value="0" />
            </dataSource>
        </environment>

        <!-- 环境配置3 -->
        <environment id="development3">
            <transactionManager type="JDBC" />
            <dataSource type="JNDI">
                <property name="data_source" value="java:comp/env/jndi/mybatis" />
                <property name="env.encoding" value="UTF8" />
                <!-- <property name="initial_context" value=""/> <property name="env.encoding" 
                    value="UTF8"/> -->
            </dataSource>
        </environment>
    </environments>

    <!-- 映射文件，mapper的配置文件 -->
    <mappers>
        <!--直接映射到相应的mapper文件 -->
        <mapper resource="classpath:mapper/*Mapper.xml" />
    </mappers>

</configuration>  
```

这个是很全的一个配置文件展示，从整体来看，配置文件被分为7部分，分别是`properties`、`settings`、`typeAliases`、`typeHandlers`、`plugins`、`environments`、`mappers`。从这7个部分可以看的出来，我们常用的部分也就是`settings`、`typeAliases`、`plugins`、`environments`、`mappers`。

-  `settings`用来做一些参数的配置，比如说驼峰规则配置，在数据库中字段的标准规则是两个字母间用下划线连接，但是对应到Java里面的实体类，就是驼峰规则，为了将两者对应起来，可以使用别名、也可以使用`resultMap`标签，最常用的还是直接在`settings`下配置驼峰自动映射关系。再如缓存、懒加载、一些策略等。
-  `typeAliases`这个标签用来配置实体类基础包的，从字面上来说是别名。用到的地方就是在`resultType`、`paramterType`上，如果不设置这个别名，就需要写全POJO的全路径名。这个让我想起我们自己在写代码的时候，明明是配置了这个别名，但是还是会用全路径名，说实话有时候虽然配置了，但不知道如何很好的利用，悲哉啊。
-  `plugins`插件配置，这里常用的插件就是分页插件`pageHelper`。
-  `environments`环境配置，就是做数据源、事务管理器的配置。
-  `mappers`指定配置文件`mapper.xml`的位置，这里有很多种配置方式，不过一般使用较多的就是直接配置到配置文件的具体位置，配合通配符。如`classpath:mapper/*Mapper.xml`。
-  `properties`下直接配置参数见的不多，但是用来加载配置文件的却挺多，如将数据库的用户名、密码、连接信息放在一个`jdbc.properties`配置文件中，然后将这个配置文件加载，直接用`${jdbc.username}`操作导入。后期mybatis和spring整合，这个读取的过程就交给spring，渐渐的这个标签就被弱化了。
-  `typeHandlers`自定义处理器，用的很少。那平时用在哪里呢。如现在实体类中有个字段是枚举类，如果需要将查询到的值映射到枚举类中，那就需要自定义处理器来实现。

##### 挑几个常用的配置说说

关于Mybatis的配置真的很多，但是真的需要手动配置的却不是很多，大部分配置都是使用默认的即可。下面我们摘几个常用的来说说。

-  `cacheEnabled`:该配置影响的所有映射器中配置的缓存的全局开关。默认是打开的。
-  `lazyLoadingEnabled`:延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联 关系中可通过设置fetchType属性来覆盖该项的开关状态 。默认是关闭的。
-  `aggressiveLazyLoading`:当启用时，对任意延迟属性的调用会使带有延迟加载属性的对象完整加载; 反之，每种属性将会按需加载。 默认是打开的。
-  `mapUnderscoreToCamelCase`:是否开启自动驼峰命名规则(camel case)映射，即从经典数据库 列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射。默认是关闭的。
-  `logPrefix`：指定 MyBatis 增加到日志名称的前缀。 默认未设置。
-  `logImpl`:指定 MyBatis 所用日志的具体实现，未指定时将自动查找。 可选项有很多，如slf4j、log4j、jdk_logging、common_logging等。如果同时都有那mybatis优先选谁呢。有兴趣可以看一下源码，我记得是slf4j。
-  `proxyFactory`:代理方式，指定 Mybatis 创建具有延迟加载能力的对象所用到的代理工具 。选项有两个分别是CGLIB和JAVASSIST，在mybatis版本3.3.0以上，默认使用的JAVASSIST。