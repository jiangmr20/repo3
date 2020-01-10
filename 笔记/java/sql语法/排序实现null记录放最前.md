https://blog.csdn.net/wenqiangluyao/article/details/94432665

或自己在sql中：

```sql
select tgp.*,tnu.user_name, tgo.id as objId, tgo.name as objName, tgo.user_dept_id as objUserDeptId,
        tgo.model_id, tgo.start_time, tgo.end_time, tgo.status, tgo.project_id, tgo.method, tgo.is_view_score,
        tgo.is_view_reason, tgo.position_id, tnup.user_name as objUserName, tgm.name as modelName, tnup.dept_code
        from tb_grade_project tgp
        left join tb_new_rel_user_department tnrud on tnrud.id = tgp.user_dept_id
        left join tb_new_user tnu on tnrud.user_id = tnu.user_id
        left join tb_grade_object tgo on tgp.id = tgo.project_id
        left join tb_grade_model tgm on tgo.model_id = tgm.id
        left join tb_new_user_position tnup on tgo.position_id = tnup.id
        where 1 = 1
        <if test="keyword != null">
            and instr(tgp.name, #{keyword}) > 0
        </if>
        <if test="userDeptId != null">
            and tgp.user_dept_id = #{userDeptId,jdbcType=INTEGER}
        </if>
        <if test="id != null">
            and tgp.id = #{id,jdbcType=INTEGER}
        </if>
        <if test="userId != null">
            and (tgp.user_dept_id = #{userId,jdbcType=INTEGER} or (tgo.user_dept_id = #{userId,jdbcType=INTEGER} and tgp.is_submit = 1))
        </if>
        <if test="sort != null and order.equals('desc')">
            ORDER BY CASE WHEN ${sort} IS NULL THEN 0 ELSE 1 END, ${sort} DESC
        </if>
        <if test="sort != null and order.equals('asc')">
            ORDER BY CASE WHEN ${sort} IS NULL THEN 1 ELSE 0 END, ${sort} ASC
        </if>
```

