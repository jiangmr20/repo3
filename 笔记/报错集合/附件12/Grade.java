package com.cn21.opmm.domain.gradeCenter;

import java.util.Date;

/**
 * 评分
 *
 * @author Han Yun
 * @create 2019/8/29 9:43 AM
 */
public class Grade {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer userDeptId;

    /**
     * 评分单位ID
     */
    private Integer gradeDeptId;

    /**
     * 评分
     */
    private Integer grade;

    /**
     * 评分理由
     */
    private String reason;

    /**
     * 对应的模型细节ID
     */
    private Integer modelDetailId;

    /**
     * 项目ID
     */
    private Integer objId;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 评分人的真实用户ID
     * 仅在指派时填充
     */
    private Integer positionId;

    private String deptCode;

    private String userName;

    private String email;

    private String mobile;

    /**
     * 是否已评分
     */
    private Boolean hasGrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(Integer userDeptId) {
        this.userDeptId = userDeptId;
    }

    public Integer getGradeDeptId() {
        return gradeDeptId;
    }

    public void setGradeDeptId(Integer gradeDeptId) {
        this.gradeDeptId = gradeDeptId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getModelDetailId() {
        return modelDetailId;
    }

    public void setModelDetailId(Integer modelDetailId) {
        this.modelDetailId = modelDetailId;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHasGrade() {
        return hasGrade;
    }

    public void setHasGrade(Boolean hasGrade) {
        this.hasGrade = hasGrade;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Grade() {

    }

    public Grade(Integer userDeptId,
                 Integer modelDetailId,
                 Integer objId,
                 Integer positionId) {
        this.userDeptId = userDeptId;
        this.modelDetailId = modelDetailId;
        this.objId = objId;
        this.positionId = positionId;
    }

    public Grade(Integer id,
                 Integer userDeptId,
                 Integer gradeDeptId,
                 Integer grade,
                 String reason,
                 Integer modelDetailId,
                 Integer objId,
                 Date submitTime,
                 Integer positionId) {
        this.id = id;
        this.userDeptId = userDeptId;
        this.gradeDeptId = gradeDeptId;
        this.grade = grade;
        this.reason = reason;
        this.modelDetailId = modelDetailId;
        this.objId = objId;
        this.submitTime = submitTime;
        this.positionId = positionId;
    }

}
