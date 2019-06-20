package cn.hdu.fragmentTax.model.request;

public class QueryRequ {
    private String userId;
    private Integer state;
    private String[] status;
    private String stuId;
    private String stuName;

    private String honorType;

    private String paperGrade;

    private String patentType;
    private String patentState;

    private String competitionType;
    private String competitionLevel;

    private String proClass;
    private String proType;

    private String exchangeType;

    private String workType;

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
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

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }

    public String getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(String competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public QueryRequ() {
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentState() {
        return patentState;
    }

    public void setPatentState(String patentState) {
        this.patentState = patentState;
    }

    public String getHonorType() {
        return honorType;
    }

    public String getPaperGrade() {
        return paperGrade;
    }

    public void setPaperGrade(String paperGrade) {
        this.paperGrade = paperGrade;
    }

    public void setHonorType(String honorType) {
        this.honorType = honorType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
