1.找出拖慢Redis的罪魁祸首

由于Redis没有非常详细的日志，要想知道在Redis实例内部都做了些什么是非常困难的，幸运的是Redis提供了下面这样的命令统计工具,操作如图所示：

![img](https://img-blog.csdn.net/20171019133056170?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvRGFubnlJc0NvZGVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

通过上面的指令我们就可以查到所有命令的快照，比如命令执行了多少次，执行命令所耗费的时间

(每个命令的总时间和平均时间)。


https://blog.csdn.net/dannyiscoder/article/details/78281896



2.将Redis-Benchmark结果作为参考，而不要一概而论

Redis之父Salvatore 就说过：通过执行GET/SET命令来测试Redis就像在雨天检测法拉利的雨刷清洁镜子的效果。很多时候人们想知道为什么自己的Redis-Benchmark统计的结果低于最优结果。但我们必须要把各种不同的真实情况考虑进来，例如：

1)可能受到哪些客户端运行环境的限制？

2)是相同的版本吗？

3)测试环境中的表现与应用将要运行的环境是否一致?

Redis-Benchark的测试结果提供了一个保证你的Redis-Server不会运行在非正常状态的基准点，但是你永远不要把它作为一个真实的压力测试，压力测试需要正常反映出应用的运行方式，并且需要一个尽可能的和生产相似的环境。
 

3.Hashes是你的最佳选择

以一种优雅的方式引入hashes吧。hashes将会带给你一种前所未有的体验，之前我曾看到过许多类似于下面这样的key结构:

foo:first_name

foo:last_name

foo:address

上面的例子中，foo可能是一个用户的用户名，其中的每一项都是一个独立的key。这就增加了犯错的空间，和一些不必要的key。使用hash代替吧，你会惊奇的发现竟然只需要

一个key,如下图:
![img](https://img-blog.csdn.net/20171019140612096?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvRGFubnlJc0NvZGVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

