https://www.w3school.com.cn/sql/sql_join_inner.asp

最普通的笛卡尔积，返回笛卡尔积的全部，每一条非空的链接都会返回

与以下写法效果完全相同

```sql
select t.id userId,t1.*
         from tb_new_rel_user_department t ,tb_new_user t1
        where t.id = #{userId} and t1.user_id = t.user_id and t.status=1
```



使用innerjoin时，如果on里面用主键id去链接，则笛卡尔积不会变大，如果用可重复的字段去链接，查出来的数据会增大很多