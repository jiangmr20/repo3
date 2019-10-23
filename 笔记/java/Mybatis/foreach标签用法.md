https://blog.csdn.net/qq_29072049/article/details/81384795

https://www.cnblogs.com/fangyu19900812/p/6046209.html

例子

```xml
<insert id="insertGrade" parameterType="com.cn21.opmm.domain.gradeCenter.Grade" useGeneratedKeys="true" keyProperty="id">
        insert into tb_grade(user_dept_id, grade_dept_id, grade, reason, model_detail_id, obj_id, submit_time)
        values
        <foreach collection="list" item="item" index="index" separator=",">
		   (#{item.userDeptId},#{item.gradeDeptId},#{item.grade},#{item.reason},#{item.modelDetailId},#{item.objId},#{item.submitTime})
        </foreach>
    </insert>
```

深入看属性：先在举个实例：

```xml
<delete id="deleteByIds" parameterType="java.lang.String">
		DELETE FROM user where id in
		<foreach item="idItem" collection="array" open="(" separator="," close=")">
		#{idItem}
		</foreach>
	</delete>
```

说明:

1.这里parameterType采用"java.lang.String"，不需采用array或list类型。mybatis会自动识别list或array，只需要匹配list里面的String就好。

2.array传过来的数组或list集合,在java中map调用时传参，示例array为[1,2,3,4,5,6]

3.idItem临时变量，指循环时的当前参数

4.自己感觉MyBatis中in语句的值需要使用foreach填充,在原本sql中采用的是(ids),那么在查询或更新的in语句后面应该也可以使用foreach进行填充,有需要的可以试下

![1569321695639](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1569321695639.png)

https://www.cnblogs.com/ChromeT/p/10729936.html