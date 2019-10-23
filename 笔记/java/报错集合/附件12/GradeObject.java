package com.cn21.opmm.domain.gradeCenter;

import java.util.Date;
import java.util.List;

/**
 * 评分对象
 *
 * @author Han Yun
 * @create 2019/8/29 9:09 AM
 */
public class GradeObject {

    private Integer id;

    /**
     * 关联的项目ID
     */
    private Integer projectId;

    /**
     * 对象名称
     */
    private String name;

    /**
     * 对应的模型ID
     */
    private Integer modelId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户ID
     */
    private Integer userDeptId;

    /**
     * 发布方式
     */
    private Integer method;

    /**
     * 是否可查看分数
     */
    private Boolean hasViewScore;

    /**
     * 是否可查看理由
     */
    private Boolean hasViewReason;

    private String userName;

    private String modelName;

    private String projectName;

    /**
     * 评分项目发起人， 用于做权限的校验
     */
    private Integer projectSponsorId;

    private String gradeRange;

    /**
     * 评分指派人列表
     */
    private List<Grade> gradeList;

    /**
     * 单位公开评分列表
     */
    private List<GradeDept> gradeDeptList;

    /**
     * 评分内容
     */
    private List<GradeModelDetail> gradeModelDetailList;

    /**
     * 评分对象负责人的真实用户ID
     */
    private Integer positionId;

    private String deptCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(Integer userDeptId) {
        this.userDeptId = userDeptId;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Boolean getHasViewScore() {
        return hasViewScore;
    }

    public void setHasViewScore(Boolean hasViewScore) {
        this.hasViewScore = hasViewScore;
    }

    public Boolean getHasViewReason() {
        return hasViewReason;
    }

    public void setHasViewReason(Boolean hasViewReason) {
        this.hasViewReason = hasViewReason;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectSponsorId() {
        return projectSponsorId;
    }

    public void setProjectSponsorId(Integer projectSponsorId) {
        this.projectSponsorId = projectSponsorId;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public List<GradeDept> getGradeDeptList() {
        return gradeDeptList;
    }

    public void setGradeDeptList(List<GradeDept> gradeDeptList) {
        this.gradeDeptList = gradeDeptList;
    }

    public List<GradeModelDetail> getGradeModelDetailList() {
        return gradeModelDetailList;
    }

    public void setGradeModelDetailList(List<GradeModelDetail> gradeModelDetailList) {
        this.gradeModelDetailList = gradeModelDetailList;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public GradeObject() {

    }

    public GradeObject(Builder builder) {
        this.id = builder.id;
        this.projectId = builder.projectId;
        this.name = builder.name;
        this.modelId = builder.modelId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
        this.userDeptId = builder.userDeptId;
        this.method = builder.method;
        this.hasViewScore = builder.hasViewScore;
        this.hasViewReason = builder.hasViewReason;
        this.positionId = builder.positionId;
    }

    public static class Builder {
        private Integer id;

        private Integer projectId;

        private String name;

        private Integer modelId;

        private Date startTime;

        private Date endTime;

        private Integer status;

        private Integer userDeptId;

        private Integer method;

        private Boolean hasViewScore;

        private Boolean hasViewReason;

        private Integer positionId;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder projectId(Integer projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder modelId(Integer modelId) {
            this.modelId = modelId;
            return this;
        }

        public Builder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder userDeptId(Integer userDeptId) {
            this.userDeptId = userDeptId;
            return this;
        }

        public Builder method(Integer method) {
            this.method = method;
            return this;
        }

        public Builder hasViewScore(Boolean hasViewScore) {
            this.hasViewScore = hasViewScore;
            return this;
        }

        public Builder hasViewReason(Boolean hasViewReason) {
            this.hasViewReason = hasViewReason;
            return this;
        }

        public Builder positionId(Integer positionId) {
            this.positionId = positionId;
            return this;
        }

        public GradeObject build() {
            return new GradeObject(this);
        }
    }
}
