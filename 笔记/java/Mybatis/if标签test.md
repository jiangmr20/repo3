test属性用法：

https://blog.csdn.net/john1337/article/details/81083694

test的坑点：https://blog.csdn.net/john1337/article/details/81083694

常用方式有：

```xml
<if test="id != null and id !=''">
            and id != #{id}     
        </if>   
```

但是在实际使用过程中可能会需要对某个输入的值做具体判断，然后根据输入参数的值进行分支处理：

```xml
<choose>
               <when test="hasAttach.toString() == '1'.toString()">
                   having  attachCount &gt;= #{hasAttach}
               </when>
               <otherwise>
                   having  attachCount = #{hasAttach}
               </otherwise>
           </choose>

```

鉴于这个mapper查询接口传入的参数为Map<String,Object>类型，如果不进行toString的转换的话默认是对对象地址的对比，因此就无法达到预期的比较字符串的效果。

https://blog.csdn.net/qq_34627002/article/details/80734989