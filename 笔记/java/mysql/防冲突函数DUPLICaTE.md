**ON DUPLICATE KEY UPDATE为Mysql特有语法，这是个坑** 

语句的作用，当insert已经存在的记录时，执行Update，在很多业务中都会用到。

https://blog.csdn.net/qq_22771739/article/details/84668620

结合唯一索引使用（可以是联合唯一索引）：https://blog.csdn.net/u011066470/article/details/88723394

实际使用（在系统业务的业务工作经验文件中有）：

```sql
on duplicate key update
        grade = values(grade),
        reason = values(reason),
        submit_time = values(submit_time)
```

