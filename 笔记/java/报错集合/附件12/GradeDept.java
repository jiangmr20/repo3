package com.cn21.opmm.domain.gradeCenter;

/**
 * 公开评分单位
 *
 * @author Han Yun
 * @create 2019/8/29 9:50 AM
 */
public class GradeDept {

    private Integer id;

    /**
     * 项目ID
     */
    private Integer objId;

    /**
     * 虚拟单位ID
     */
    private Integer deptId;

    /**
     * 最少评分人数
     */
    private Integer minNum;

    /**
     * 最多评分人数
     */
    private Integer maxNum;

    /**
     * 虚拟单位名称
     */
    private String deptName;

    /**
     * 已评分人数
     */
    private Integer gradeCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getGradeCount() {
        return gradeCount;
    }

    public void setGradeCount(Integer gradeCount) {
        this.gradeCount = gradeCount;
    }

    public GradeDept() {

    }

    public GradeDept(Integer id,
                     Integer objId,
                     Integer deptId,
                     Integer minNum,
                     Integer maxNum) {
        this.id = id;
        this.objId = objId;
        this.deptId = deptId;
        this.minNum = minNum;
        this.maxNum = maxNum;
    }
}
