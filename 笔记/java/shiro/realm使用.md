https://blog.csdn.net/long270022471/article/details/62423286



重写realm后，realmManage继承了AuthorizingRealm对象，重写了doGetAuthenticationInfo（身份认证函数）和doGetAuthorizationInfo（权限授权函数）两个方法，然后在执行subject.login(token)方法，系统就自动调用realm中的登录验证。



==========================================

https://blog.csdn.net/u010837612/article/details/46053249

什么是Realm，我使用过之后，个人总结一下：shiro要进行身份验证，就要从realm中获取相应的身份信息来进行验证，简单来说，我们可以自行定义realm，在realm中，从数据库获取身份信息，然后和 用户输入的身份信息进行匹配。这一切都由我们自己来定义。


