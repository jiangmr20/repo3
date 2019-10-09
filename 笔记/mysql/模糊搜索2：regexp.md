regexp是正则匹配，使用方法如下：

^，匹配字符串开始位置，还是模糊查询1的例子，查询所有姓王的人名：

```sql
select name from 表名 where name regexp '^王';
```

$，匹配字符串结束位置，如查询所有姓名末尾是“明”的人名

```sql
select name from 表名 where name regexp '明$';
```

.，匹配除\n之外的任意单个字符，类似于_，就不写sql语句了

[……]，匹配[]中包含的任何一个字符，abcdef……xyz可以简写为[a-z]，0123456789简写成[0-9]，如查询出w／z／s开头的的人名

```sql
select name from 表名 where name regexp '^[wzs]';
```

等等：https://www.cnblogs.com/wangmeijian/p/5392954.html

**需要注意的一点**是：这两种模式不要混着用，like模式是不支持正则表达式的，REGEXP模式也不认识_和%

https://www.2cto.com/database/201704/633263.html



用正则匹配，还能查询多值匹配情况：https://www.cnblogs.com/spring1024/p/7986453.html

当一个字段想模糊查询出多个字段的时候，正常情况下一般会这么作

```sql
select * from a where name like 'a%' or name like 'b%' ....or ...;
```

但是上面的情况只能对应少量的模糊查询值，过多之后再后台开发的时候会出现非常麻烦的sql语句拼接

这时我们可以采用正则表达式进行匹配：

```sql
select * from a where name regexp'a|b|...';
```

