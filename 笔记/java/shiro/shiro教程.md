https://www.jianshu.com/p/c919073930fb



1、几乎在所有环境中，您都可以通过以下调用获取当前正在执行的用户：

Subject currentUser =SecurityUtils.getSubject();

使用SecurityUtils.getSubject()，我们可以获得当前正在执行的Subject。主体只是应用程序用户的特定安全"视图"。**我们实际上想称它为'User(用户)'，因为这"有道理"，但我们决定不这么干**：太多的应用程序都有现存的API，它们已经拥有自己的User类/框架，我们不想与这些API冲突。另外，**在安全领域，术语Subject实际上是公认的命名法**。

独立应用程序中的getSubject()调用，可能会根据特定于应用程序的位置中的用户数据以及服务器环境（例如Web应用程序）返回相应Subject，并根据与当前线程或传入请求关联的用户数据而获取Subject 。

2、关于Subject currentUser，你可以用它来做很多事：

a.获取session

如果您想在应用程序的当前会话期间向用户提供可用的内容，则可以获得他们的会话：

Session session = currentUser.getSession();

session.setAttribute( "someKey", "aValue" );

 Session是一个Shiro特定的实例，它给你提供了大多数习惯的常规HttpSession实例，但有一些额外的好处和一个很大的区别：它不需要HTTP环境！ 

b.登陆

所以现在你可以获得一个Subject和他们的Session。那些真正有用的东西比如检查是否允许他们做事情，比如检查角色和权限？

那么，我们只能对已知的用户进行这些检查。上面的Subject实例代表当前用户，但谁是当前用户？其实，他们是匿名的 - 也就是说，直到他们登录至少一次。所以，让我们这样做：

```java
if ( !currentUser.isAuthenticated() ) {

    //以gui特定方式收集用户主体和凭证-principalsand credentials

    //如html表单的用户名/密码，X509证书，OpenID等。

    //我们将在这里使用用户名/密码示例，因为它是最常见的。

    //(你知道这是什么电影吗？;)

   UsernamePasswordToken token = newUsernamePasswordToken("lonestarr", "vespa");

    //this isall you have to do to support 'remember me' (no config - built in!):

         //这就是你需要做的所有事情以便来支持'记住我'（没有配置 - 内置！）

   token.setRememberMe(true);

   currentUser.login(token);

}

```

 但是，如果他们的登录尝试失败呢？你可以捕捉各种具体的例外情况，告诉你到底发生了什么，并允许你相应地处理和做出反应： 

```java
try {

   currentUser.login( token );

   //如果没有例外，就是这样，搞定！

} catch ( UnknownAccountException uae ) {

   //用户名不在系统中，如何向他们显示错误消息？

} catch ( IncorrectCredentialsException ice) {

   //密码不匹配，是否再试？

} catch ( LockedAccountException lae ) {

   //该用户名的帐户被锁定 - 无法登录。如何显示一条消息？

}

   ...更多类型的异常检查——如果你想要...

} catch ( AuthenticationException ae ) {

   //意外情况 - 怎么处理?

}

```

c.查询subject实体的信息

查看用户角色

```java
//打印他们的标识主体（在这种情况下是用户名）

log.info( "User [" +currentUser.getPrincipal() + "] logged in successfully." );

我们也可以测试它们是否具有特定的角色：

if ( currentUser.hasRole( "schwartz" ) ) {

   log.info("May the Schwartz be with you!" );

} else {

    log.info("Hello, mere mortal." );

}

```

 我们还可以看到他们是否有权对某种类型的实体采取行动: 

```java
if ( currentUser.isPermitted("lightsaber:weild" ) ) {

   log.info("You may use a lightsaber ring.  Use it wisely.");

} else {

   log.info("Sorry, lightsaber rings are for schwartz mastersonly.");

}

```

 另外，我们可以执行非常强大的实例级权限检查 - 查看用户是否有权访问特定类型实例的功能： 

```java
if ( currentUser.isPermitted("winnebago:drive:eagle5" ) ) {

   log.info("You are permitted to 'drive' the 'winnebago' with licenseplate (id) 'eagle5'.  " +

               "Here are the keys - have fun!");

} else {

   log.info("Sorry, you aren't allowed to drive the 'eagle5'winnebago!");

}

```

d.注销

最后，当用户完成使用应用程序时，他们可以注销：

currentUser.logout(); //删除所有标识信息并使其会话无效。

3、 那么，这就是在应用程序开发人员级别使用Apache Shiro的核心。虽然有一些非常复杂的东西在引擎盖下进行，使得这项工作如此优雅，但这确实是它的全部。 

但是你可能会问自己，"但是谁负责在登录时获取用户数据（用户名和密码，角色和权限等），以及谁在运行时真正执行这些安全检查？"，这么问就对了——你来做：通过实施 Shiro称之为Realm的东西，并将该Realm插入到Shiro的配置中来完成。

但是，如何配置Realm很大程度上取决于您的运行时环境。例如，如果运行独立应用程序，或者如果您有基于Web的应用程序，或基于Spring或JEE容器的应用程序或其组合，这种类型的配置不在本快速入门的范围之内，因为它的目的是让您对API和Shiro的概念感到满意。

 ![img](https://upload-images.jianshu.io/upload_images/8770487-a878d31f5a1124da.png?imageMogr2/auto-orient/strip|imageView2/2/w/691/format/webp) 