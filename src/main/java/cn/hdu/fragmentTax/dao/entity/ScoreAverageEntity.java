package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class ScoreAverageEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String stuId;
    @Column
    private float averageScore;
    @Column
    private Integer currNumber;
    @Column
    private String languagesTypes;
    @Column
    private float languagesScore;
    @Column
    private Integer state;  // 0-无效，1-有效
    @Column
    private String createdTime;
    @Column
    private String changedTiem;
    @Column
    private float weightedAverageScore;
    @Column
    private float hadCredit;

    public ScoreAverageEntity() {
    }

    public ScoreAverageEntity(Integer id, String stuId, float averageScore, Integer currNumber, String languagesTypes, float languagesScore, Integer state, String createdTime, String changedTiem, float weightedAverageScore, float hadCredit) {
        this.id = id;
        this.stuId = stuId;
        this.averageScore = averageScore;
        this.currNumber = currNumber;
        this.languagesTypes = languagesTypes;
        this.languagesScore = languagesScore;
        this.state = state;
        this.createdTime = createdTime;
        this.changedTiem = changedTiem;
        this.weightedAverageScore = weightedAverageScore;
        this.hadCredit = hadCredit;
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

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getCurrNumber() {
        return currNumber;
    }

    public void setCurrNumber(Integer currNumber) {
        this.currNumber = currNumber;
    }

    public String getLanguagesTypes() {
        return languagesTypes;
    }

    public void setLanguagesTypes(String languagesTypes) {
        this.languagesTypes = languagesTypes;
    }

    public float getLanguagesScore() {
        return languagesScore;
    }

    public void setLanguagesScore(float languagesScore) {
        this.languagesScore = languagesScore;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getChangedTiem() {
        return changedTiem;
    }

    public void setChangedTiem(String changedTiem) {
        this.changedTiem = changedTiem;
    }

    public float getWeightedAverageScore() {
        return weightedAverageScore;
    }

    public void setWeightedAverageScore(float weightedAverageScore) {
        this.weightedAverageScore = weightedAverageScore;
    }

    public float getHadCredit() {
        return hadCredit;
    }

    public void setHadCredit(float hadCredit) {
        this.hadCredit = hadCredit;
    }

}