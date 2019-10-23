https://www.cnblogs.com/kevinGao/archive/2012/09/17/2776041.html

https://www.cnblogs.com/lihongda/p/9053678.html

https://blog.csdn.net/weixin_38972910/article/details/83580303



但是where子句的顺序则不会影响：因为，=和in可以乱序，比如a = 1 and b = 2 and c = 3 
建立(a,b,c)索引可以任意顺序，mysql的查询优化器会帮你优化成索引可以识别的形式