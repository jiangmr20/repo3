如果是统计select count，去把同名的合并成一条数据（如报错集合的系统经验的评分系统项目grade评分部分），则使用下面链接的方法

https://zhidao.baidu.com/question/45302938.html

```sql
SELECT COUNT(DISTINCT(字段)) FROM TABLE;
```

或者用字表



而统计select普通字段，求和的，用group by

https://bbs.csdn.net/topics/390504612?page=1



拓展：DISTINCT()里面能否合并多个字段？

![1571911779828](E:\学习\笔记\picRepo\1571911779828.png)

![1571911822555](E:\学习\笔记\picRepo\1571911822555.png)

可以这样用。