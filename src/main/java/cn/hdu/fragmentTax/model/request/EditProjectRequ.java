package cn.hdu.fragmentTax.model.request;

public class EditProjectRequ {
    private Integer id;
    private String stuId;
    private String proName;
    private String proClass;
    private String proType;
    private String proLevel;
    private Integer ranking;
    private Integer totalNumber;
    private String proState;
    private String proResult;
    private String proTime;
    private String proTeacher;
    private String proofMaterialId;

    public EditProjectRequ() {
    }

    public EditProjectRequ(Integer id, String stuId, String proName, String proClass, String proType, String proLevel, Integer ranking, Integer totalNumber, String proState, String proResult, String proTime, String proTeacher, String proofMaterialId) {
        this.id = id;
        this.stuId = stuId;
        this.proName = proName;
        this.proClass = proClass;
        this.proType = proType;
        this.proLevel = proLevel;
        this.ranking = ranking;
        this.totalNumber = totalNumber;
        this.proState = proState;
        this.proResult = proResult;
        this.proTime = proTime;
        this.proTeacher = proTeacher;
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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
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

    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    public String getProResult() {
        return proResult;
    }

    public void setProResult(String proResult) {
        this.proResult = proResult;
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

    public String getProofMaterialId() {
        return proofMaterialId;
    }

    public void setProofMaterialId(String proofMaterialId) {
        this.proofMaterialId = proofMaterialId;
    }
}
