package cn.hdu.fragmentTax.model.request;

public class AdminExamRequ {
    private String stuId;
    private String id;
    private Float score;

    public AdminExamRequ() {
    }

    public AdminExamRequ(String stuId, String id, Float score) {
        this.stuId = stuId;
        this.id = id;
        this.score = score;
    }


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
