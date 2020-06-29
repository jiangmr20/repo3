https://www.jianshu.com/p/c919073930fb



1、几乎在所有环境中，您都可以通过以下调用获取当前正在执行的用户：

Subject currentUser =SecurityUtils.getSubject();

使用SecurityUtils.getSubject()，我们可以获得当前正在执行的Subject。主体只是应用程序用户的特定安全"视图"。**我们实际上想称它为'User(用户)'，因为这"有道理"，但我们决定不这么干**：太多的应用程序都有现存的API，它们已经拥有自己的User类/框架，我们不想与这些API冲突。另外，**在安全领域，术语Subject实际上是公认的命名法**。

