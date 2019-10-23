```sql
SELECT distinct
        a.direction
        FROM
        tb_grade_model_detail a
        WHERE
        a.model_id = #{id}
```

select后使用distinct关键字