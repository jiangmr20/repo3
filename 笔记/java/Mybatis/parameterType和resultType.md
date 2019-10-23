[resultMap与resultType、parameterMap与 parameterType的区别](https://www.cnblogs.com/mihun-666/p/8203348.html)



parameterType：指定输入参数类型，mybatis通过ognl从输入对象中获取参数值拼接在sql中。

resultType：指定输出结果类型，mybatis将sql查询结果的一行记录数据映射为resultType指定类型的对象。如果有多条数据，则分别进行映射，并把对象放到容器List中

https://blog.csdn.net/m1234ilu/article/details/83759493