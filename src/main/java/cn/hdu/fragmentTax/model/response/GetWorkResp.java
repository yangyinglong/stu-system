package cn.hdu.fragmentTax.model.response;

public class GetWorkResp {
    private Integer id;
    private String stuId;
    private String name;
    private String workType;
    private String companyName;
    private String isCmp;
    private String companyType;
    private String workClass;
    private String address;
    private String getDate;
    private String proofMaterialId;
    private String status;
    private Float score;


    public GetWorkResp() {
    }

    public GetWorkResp(Integer id, String stuId, String name, String companyName, String companyType, String workType, String getDate, String proofMaterialId, String status, Float score) {
        this.id = id;
        this.stuId = stuId;
        this.name = name;
        this.companyName = companyName;
        this.companyType = companyType;
        this.workType = workType;
        this.getDate = getDate;
        this.proofMaterialId = proofMaterialId;
        this.status = status;
        this.score = score;
    }

    public String getIsCmp() {
        return isCmp;
    }

    public void setIsCmp(String isCmp) {
        this.isCmp = isCmp;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public String getProofMaterialId() {
        return proofMaterialId;
    }

    public void setProofMaterialId(String proofMaterialId) {
        this.proofMaterialId = proofMaterialId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
