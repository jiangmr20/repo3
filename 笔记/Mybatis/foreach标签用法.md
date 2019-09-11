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

