package com.cn21.opmm.domain.gradeCenter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GradeModel implements Serializable {
    private static final long serialVersionUID = -4560987925214196749L;

    private int id;
    private int userDeptId;
    private Date createTime;
    private Date updateTime;
    private String name;
    private Integer modelType;
    private Integer status;
    private List<GradeModelDetail> detailList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(int userDeptId) {
        this.userDeptId = userDeptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GradeModelDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<GradeModelDetail> detailList) {
        this.detailList = detailList;
    }

    public GradeModel() {

    }

    public GradeModel(Integer id, Date updateTime, Integer status) {
        this.id = id.intValue();
        this.updateTime = updateTime;
        this.status = status;
    }
}
