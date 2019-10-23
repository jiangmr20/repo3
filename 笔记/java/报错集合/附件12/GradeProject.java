package com.cn21.opmm.domain.gradeCenter;

import java.util.Date;
import java.util.List;

/**
 * 评分项目管理实体
 *
 * @author Han Yun
 * @create 2019/8/28 5:05 PM
 */
public class GradeProject {

    private Integer id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 用户ID
     */
    private Integer userDeptId;

    /**
     * 发起部门
     */
    private String deptName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 发起时间
     */
    private Date initiationTime;

    /**
     * 项目说明
     */
    private String description;

    /**
     * 评分要求
     */
    private String requirement;

    /**
     * 附件ID
     */
    private String attachment;

    /**
     * 是否已提交
     */
    private Boolean hasSubmit;

    /**
     * 评分区间
     */
    private String gradeRange;

    private String userName;

    private List<GradeObject> gradeObjectList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(Integer userDeptId) {
        this.userDeptId = userDeptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(Date initiationTime) {
        this.initiationTime = initiationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Boolean getHasSubmit() {
        return hasSubmit;
    }

    public void setHasSubmit(Boolean hasSubmit) {
        this.hasSubmit = hasSubmit;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<GradeObject> getGradeObjectList() {
        return gradeObjectList;
    }

    public void setGradeObjectList(List<GradeObject> gradeObjectList) {
        this.gradeObjectList = gradeObjectList;
    }

    public GradeProject() {

    }

    public GradeProject(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.userDeptId = builder.userDeptId;
        this.deptName = builder.deptName;
        this.createTime = builder.createTime;
        this.initiationTime = builder.initiationTime;
        this.description = builder.description;
        this.requirement = builder.requirement;
        this.attachment = builder.attachment;
        this.hasSubmit = builder.hasSubmit;
        this.gradeRange = builder.gradeRange;
    }

    public static class Builder {
        private Integer id;

        private String name;

        private Integer userDeptId;

        private String deptName;

        private Date createTime;

        private Date initiationTime;

        private String description;

        private String requirement;

        private String attachment;

        private Boolean hasSubmit;

        private String gradeRange;

        public Builder() {

        }


        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder userDeptId(Integer userDeptId) {
            this.userDeptId = userDeptId;
            return this;
        }

        public Builder deptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder initiationTime(Date initiationTime) {
            this.initiationTime = initiationTime;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder requirement(String requirement) {
            this.requirement = requirement;
            return this;
        }

        public Builder attachment(String attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder hasSubmit(Boolean hasSubmit) {
            this.hasSubmit = hasSubmit;
            return this;
        }

        public Builder gradeRange(String gradeRange) {
            this.gradeRange = gradeRange;
            return this;
        }

        public GradeProject build() {
            return new GradeProject(this);
        }
    }
}
