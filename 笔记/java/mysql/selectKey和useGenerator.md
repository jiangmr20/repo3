```xml
<selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">    SELECT LAST_INSERT_ID()</selectKey>
```

```xml
<insert id="insertRecord" useGeneratedKeys="true" keyProperty="id">
```

 https://blog.csdn.net/iCopper_/article/details/81430223 

