```xml
<select id="selectDirectionsById" resultType="java.lang.String">
        SELECT
        a.title
        FROM
        tb_grade_model_detail a
        WHERE
        a.model_id = #{id}
        and
        a.direction = #{direction}
    </select>
```

注意用resultType，当取出多条title时，mybatis会自动返回list。

当然你可以用String接收，不过当返回多条时则会报错。