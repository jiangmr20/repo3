package com.cn21.opmm.domain.gradeCenter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GradeModelDetail implements Serializable {
    private static final long serialVersionUID = -5876558980060671106L;

    private int id;
    private int modelId;
    private String direction;
    private String title;
    private String description;
    private BigDecimal weight;
    /**
     * 评分结果
     */
    private List<Grade> gradeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public GradeModelDetail(){

    }

    public GradeModelDetail(int modelId,
                            String direction,
                            String title,
                            String description,
                            BigDecimal weight) {
        this.modelId = modelId;
        this.direction = direction;
        this.title = title;
        this.description = description;
        this.weight = weight;
    }
}
