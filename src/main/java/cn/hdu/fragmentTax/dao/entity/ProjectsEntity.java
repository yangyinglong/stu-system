package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class ProjectsEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String stuId;
    @Column
    private String proName;
    @Column
    private String proType;
    @Column
    private String proLevel;  // 项目级别
    @Column
    private Integer ranking;  // 参与排名
    @Column
    private Integer totalNumber;
    @Column
    private String proTime;
    @Column
    private String proTeacher;
    @Column
    private String proResult;
    @Column
    private float score;
    @Column
    private String proClass;
    @Column
    private String proofMaterialId;
    @Column
    private String proState;
    @Column
    private Integer state;

    public ProjectsEntity() {
    }

    public ProjectsEntity(Integer id, String stuId, String proName, String proType, String proLevel, Integer ranking, Integer totalNumber, String proTime, String proTeacher, String proResult, float score, String proClass, String proofMaterialId, String proState, Integer state) {
        this.id = id;
        this.stuId = stuId;
        this.proName = proName;
        this.proType = proType;
        this.proLevel = proLevel;
        this.ranking = ranking;
        this.totalNumber = totalNumber;
        this.proTime = proTime;
        this.proTeacher = proTeacher;
        this.proResult = proResult;
        this.score = score;
        this.proClass = proClass;
        this.proofMaterialId = proofMaterialId;
        this.proState = proState;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getProTime() {
        return proTime;
    }

    public void setProTime(String proTime) {
        this.proTime = proTime;
    }

    public String getProTeacher() {
        return proTeacher;
    }

    public void setProTeacher(String proTeacher) {
        this.proTeacher = proTeacher;
    }

    public String getProResult() {
        return proResult;
    }

    public void setProResult(String proResult) {
        this.proResult = proResult;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
    }

    public String getProofMaterialId() {
        return proofMaterialId;
    }

    public void setProofMaterialId(String proofMaterialId) {
        this.proofMaterialId = proofMaterialId;
    }

    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}