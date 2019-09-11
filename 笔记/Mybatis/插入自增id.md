使用insert语句插入时，有时业务需求是插入信息后，主键id自增，以下分为两种情况：

1.单条数据插入可以使用：

```xml
<!--评分对象-->
    <insert id="insertGradeObject" parameterType="com.cn21.opmm.domain.gradeCenter.GradeObject">
        <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
            select LAST_INSERT_ID()
        </selectKey>
        insert into tb_grade_object
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="name != null">
                name,
            </if>
            <if test="userDeptId != null">
                user_dept_id,
            </if>
            <if test="modelId != null">
                model_id,
            </if>
            <if test="startTime != null">
                start_time,
            </if>
            <if test="endTime != null">
                end_time,
            </if>
            <if test="status != null">
                status,
            </if>
            <if test="projectId != null">
                project_id,
            </if>
            <if test="method != null">
                method,
            </if>
            <if test="hasViewScore != null">
                is_view_score,
            </if>
            <if test="hasViewReason != null">
                is_view_reason,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="name != null">
                #{name,jdbcType=VARCHAR},
            </if>
            <if test="userDeptId != null">
                #{userDeptId,jdbcType=INTEGER},
            </if>
            <if test="modelId != null">
                #{modelId,jdbcType=INTEGER},
            </if>
            <if test="startTime != null">
                #{startTime,jdbcType=TIMESTAMP},
            </if>
            <if test="endTime != null">
                #{endTime,jdbcType=TIMESTAMP},
            </if>
            <if test="status != null">
                #{status,jdbcType=TINYINT},
            </if>
            <if test="projectId != null">
                #{projectId,jdbcType=INTEGER},
            </if>
            <if test="method != null">
                #{method,jdbcType=TINYINT},
            </if>
            <if test="hasViewScore != null">
                #{hasViewScore,jdbcType=TINYINT},
            </if>
            <if test="hasViewReason != null">
                #{hasViewReason,jdbcType=TINYINT},
            </if>
        </trim>
    </insert>
```

插入多条语句时使用：

```xml
 <insert id="insertGrade" parameterType="com.cn21.opmm.domain.gradeCenter.Grade" useGeneratedKeys="true" keyProperty="id">
        <!--<selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">-->
        <!--select LAST_INSERT_ID()/* 插入自增id */-->
        <!--</selectKey>-->
        insert into tb_grade(user_dept_id, grade_dept_id, grade, reason, model_detail_id, obj_id, submit_time)
        values
        <foreach collection="list" item="item" index="index" separator=",">
		   (#{item.userDeptId},#{item.gradeDeptId},#{item.grade},#{item.reason},#{item.modelDetailId},#{item.objId},#{item.submitTime})
        </foreach>
    </insert>
```

