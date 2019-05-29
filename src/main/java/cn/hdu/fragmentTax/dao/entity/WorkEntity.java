package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class WorkEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String stuId;
    @Column
    private String workType;
    @Column
    private String companyName;
    @Column
    private String isCmp;
    @Column
    private String companyType;
    @Column
    private String workClass;
    @Column
    private String address;
    @Column
    private float score;
    @Column
    private Integer state;
    @Column
    private String createdTime;
    @Column
    private String proofMaterialId;

    public WorkEntity() {
    }

    public WorkEntity(Integer id, String stuId, String workType, String companyName, String isCmp, String companyType, String workClass, String address, float score, Integer state, String createdTime, String proofMaterialId) {
        this.id = id;
        this.stuId = stuId;
        this.workType = workType;
        this.companyName = companyName;
        this.isCmp = isCmp;
        this.companyType = companyType;
        this.workClass = workClass;
        this.address = address;
        this.score = score;
        this.state = state;
        this.createdTime = createdTime;
        this.proofMaterialId = proofMaterialId;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIsCmp() {
        return isCmp;
    }

    public void setIsCmp(String isCmp) {
        this.isCmp = isCmp;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWorkClass() {
        return workClass;
    }

    public void setWorkClass(String workClass) {
        this.workClass = workClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    public String getProofMaterialId() {
        return proofMaterialId;
    }

    public void setProofMaterialId(String proofMaterialId) {
        this.proofMaterialId = proofMaterialId;
    }

}