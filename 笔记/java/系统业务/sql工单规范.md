规范：

```sql
CREATE TABLE `tb_business_modify_apply`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_dept_id` int(20) NOT NULL COMMENT '申请人id',
  `apply_time` datetime(0) NOT NULL COMMENT '申请时间',
  `reason` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `hd_business_id` int(20) NOT NULL COMMENT '合作报备业务 id',
  `advice` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审批意见',
  `type_id` tinyint(4) NULL DEFAULT NULL COMMENT '审批类型：1、批准；2、否决',
  `apply_user_dept_id` int(20) NULL DEFAULT NULL COMMENT '审批人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '天翼高清合作信息修改申请表' ROW_FORMAT = Dynamic;

CREATE TABLE `tb_load_manage_list`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_dept_id` int(20) NOT NULL COMMENT '导出人id',
  `reason` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '导出原因',
  `load_time` datetime(0) NULL DEFAULT NULL COMMENT '导出时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '天翼高清管理列表导出记录表' ROW_FORMAT = Dynamic;

CREATE TABLE `tb_business_modify_apply`  (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_dept_id` int(20) NOT NULL COMMENT '申请人id',
  `apply_time` datetime(0) NOT NULL COMMENT '申请时间',
  `reason` varchar(1000) NULL DEFAULT NULL COMMENT '申请原因',
  `hd_business_id` int(20) NOT NULL COMMENT '合作报备业务 id',
  `advice` varchar(1000) NULL DEFAULT NULL COMMENT '审批意见',
  `type_id` tinyint(4) NULL DEFAULT NULL COMMENT '审批类型：1、批准；2、否决',
  `apply_user_dept_id` int(20) NULL DEFAULT NULL COMMENT '审批人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '天翼高清合作信息修改申请表' ROW_FORMAT = Dynamic;

CREATE TABLE `tb_load_manage_list`  (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_dept_id` int(20) NOT NULL COMMENT '导出人id',
  `reason` varchar(1000) NULL DEFAULT NULL COMMENT '导出原因',
  `load_time` datetime(0) NULL DEFAULT NULL COMMENT '导出时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '天翼高清管理列表导出记录表' ROW_FORMAT = Dynamic;
```

上面两条是不通过规范的，下面两条是通过规范的。区别：

1、主键要unsigned；

2、单个字段不能设编码，要在总表设

