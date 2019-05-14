package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Entity
public class ScoreAllEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String stuId;
    @Column
    private float engineeringMathematics;  // 工程数学
    @Column
    private float firstForeignLanguage;  // 第一外国语
    @Column
    private float characteristicSocialism;  // 中国特色社会主义理论与实践研究
    @Column
    private float numericalAnalysis;  // 数值分析
    @Column
    private Integer state;  // 0-无效，1-有效
    @Column
    private String createdTime;
    @Column
    private String changedTime;
    @Column
    private float jixiejiaozuo;  // 机械工程学科发展前沿专题讲座
    @Column
    private float jisuanyingyong;  // 计算流体力学软件及工程应用
    @Column
    private float jidianxue;  // 机电系统动力学
    @Column
    private float nami;  // 纳米技术与应用
    @Column
    private float jixiejiagong;  // 机械加工精度理论与机械制造装备技术
    @Column
    private float jixiezhizao;  // 机械制造方法理论与技术
    @Column
    private float dianyingyantao;  // 典型企业制造案例研讨
    @Column
    private float jisuanjichu;  // 计算流体力学基础
    @Column
    private float xiandaililun;  // 现代控制理论

    public ScoreAllEntity() {
    }

    public ScoreAllEntity(Integer id, String stuId, float engineeringMathematics, float firstForeignLanguage, float characteristicSocialism, float numericalAnalysis, Integer state, String createdTime, String changedTime, float jixiejiaozuo, float jisuanyingyong, float jidianxue, float nami, float jixiejiagong, float jixiezhizao, float dianyingyantao, float jisuanjichu, float xiandaililun) {
        this.id = id;
        this.stuId = stuId;
        this.engineeringMathematics = engineeringMathematics;
        this.firstForeignLanguage = firstForeignLanguage;
        this.characteristicSocialism = characteristicSocialism;
        this.numericalAnalysis = numericalAnalysis;
        this.state = state;
        this.createdTime = createdTime;
        this.changedTime = changedTime;
        this.jixiejiaozuo = jixiejiaozuo;
        this.jisuanyingyong = jisuanyingyong;
        this.jidianxue = jidianxue;
        this.nami = nami;
        this.jixiejiagong = jixiejiagong;
        this.jixiezhizao = jixiezhizao;
        this.dianyingyantao = dianyingyantao;
        this.jisuanjichu = jisuanjichu;
        this.xiandaililun = xiandaililun;
    }

    public static Map<String, Object> getAverageScore(CreditEntity creditEntity, ScoreAllEntity scoreAllEntity) {
        Map<String, Object> score = new HashMap<String, Object>();
        float allScores = 0;
        float averageScore = 0;
        float creditScore = 0;
        int currNumber = 0;
        float allCredit = 0;

        if (-1 != scoreAllEntity.getNami()) {
            allScores = allScores + scoreAllEntity.getNami();
            creditScore = creditScore + creditEntity.getNami() * scoreAllEntity.getNami();
            allCredit = allCredit + creditEntity.getNami();
            currNumber = currNumber + 1;
        }

        if (-1 != scoreAllEntity.getEngineeringMathematics()) {
            allScores = allScores + scoreAllEntity.getEngineeringMathematics();
            creditScore = creditScore + creditEntity.getEngineeringMathematics() * scoreAllEntity.getEngineeringMathematics();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getEngineeringMathematics();
        }
        if (-1 != scoreAllEntity.getFirstForeignLanguage()) {
            allScores = allScores + scoreAllEntity.getFirstForeignLanguage();
            creditScore = creditScore + creditEntity.getFirstForeignLanguage() * scoreAllEntity.getFirstForeignLanguage();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getFirstForeignLanguage();
        }
        if (-1 != scoreAllEntity.getCharacteristicSocialism()) {
            allScores = allScores + scoreAllEntity.getCharacteristicSocialism();
            creditScore = creditScore + creditEntity.getCharacteristicSocialism() * scoreAllEntity.getFirstForeignLanguage();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getCharacteristicSocialism();
        }
        if (-1 != scoreAllEntity.getNumericalAnalysis()) {
            allScores = allScores + scoreAllEntity.getNumericalAnalysis();
            creditScore = creditScore + creditEntity.getNumericalAnalysis() * scoreAllEntity.getNumericalAnalysis();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getNumericalAnalysis();
        }
        if (-1 != scoreAllEntity.getDianyingyantao()) {
            allScores = allScores + scoreAllEntity.getDianyingyantao();
            creditScore = creditScore + creditEntity.getDianyingyantao() * scoreAllEntity.getDianyingyantao();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getDianyingyantao();
        }

        if (-1 != scoreAllEntity.getJidianxue()) {
            allScores = allScores + scoreAllEntity.getJidianxue();
            creditScore = creditScore + creditEntity.getJidianxue() * scoreAllEntity.getJidianxue();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJidianxue();
        }

        if (-1 != scoreAllEntity.getJisuanjichu()) {
            allScores = allScores + scoreAllEntity.getJisuanjichu();
            creditScore = creditScore + creditEntity.getJisuanjichu() * scoreAllEntity.getJisuanjichu();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJisuanjichu();
        }

        if (-1 != scoreAllEntity.getJisuanyingyong()) {
            allScores = allScores + scoreAllEntity.getJisuanyingyong();
            creditScore = creditScore + creditEntity.getJisuanyingyong() * scoreAllEntity.getJisuanyingyong();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJisuanyingyong();
        }

        if (-1 != scoreAllEntity.getJixiejiagong()) {
            allScores = allScores + scoreAllEntity.getJixiejiagong();
            creditScore = creditScore + creditEntity.getJixiejiagong() * scoreAllEntity.getJixiejiagong();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJixiejiagong();
        }

        if (-1 != scoreAllEntity.getJixiejiaozuo()) {
            allScores = allScores + scoreAllEntity.getJixiejiaozuo();
            creditScore = creditScore + creditEntity.getJixiejiaozuo() * scoreAllEntity.getJixiejiaozuo();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJixiejiaozuo();
        }

        if (-1 != scoreAllEntity.getJixiezhizao()) {
            allScores = allScores + scoreAllEntity.getJixiezhizao();
            creditScore = creditScore + creditEntity.getJixiezhizao() * scoreAllEntity.getJixiezhizao();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getJixiezhizao();
        }

        if (-1 != scoreAllEntity.getXiandaililun()) {
            allScores = allScores + scoreAllEntity.getXiandaililun();
            creditScore = creditScore + creditEntity.getXiandaililun() * scoreAllEntity.getXiandaililun();
            currNumber = currNumber + 1;
            allCredit = allCredit + creditEntity.getXiandaililun();
        }
        score.put("currNumber", currNumber);
        score.put("credit", allCredit);
        if (currNumber == 0) {
            currNumber = 1;
            allCredit = 1;
        }
        averageScore = allScores / currNumber;
        creditScore = creditScore / allCredit;
        score.put("averageScore", averageScore);
        score.put("creditScore", creditScore);
        return score;
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

    public float getEngineeringMathematics() {
        return engineeringMathematics;
    }

    public void setEngineeringMathematics(float engineeringMathematics) {
        this.engineeringMathematics = engineeringMathematics;
    }

    public float getFirstForeignLanguage() {
        return firstForeignLanguage;
    }

    public void setFirstForeignLanguage(float firstForeignLanguage) {
        this.firstForeignLanguage = firstForeignLanguage;
    }

    public float getCharacteristicSocialism() {
        return characteristicSocialism;
    }

    public void setCharacteristicSocialism(float characteristicSocialism) {
        this.characteristicSocialism = characteristicSocialism;
    }

    public float getNumericalAnalysis() {
        return numericalAnalysis;
    }

    public void setNumericalAnalysis(float numericalAnalysis) {
        this.numericalAnalysis = numericalAnalysis;
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

    public String getChangedTime() {
        return changedTime;
    }

    public void setChangedTime(String changedTime) {
        this.changedTime = changedTime;
    }

    public float getJixiejiaozuo() {
        return jixiejiaozuo;
    }

    public void setJixiejiaozuo(float jixiejiaozuo) {
        this.jixiejiaozuo = jixiejiaozuo;
    }

    public float getJisuanyingyong() {
        return jisuanyingyong;
    }

    public void setJisuanyingyong(float jisuanyingyong) {
        this.jisuanyingyong = jisuanyingyong;
    }

    public float getJidianxue() {
        return jidianxue;
    }

    public void setJidianxue(float jidianxue) {
        this.jidianxue = jidianxue;
    }

    public float getNami() {
        return nami;
    }

    public void setNami(float nami) {
        this.nami = nami;
    }

    public float getJixiejiagong() {
        return jixiejiagong;
    }

    public void setJixiejiagong(float jixiejiagong) {
        this.jixiejiagong = jixiejiagong;
    }

    public float getJixiezhizao() {
        return jixiezhizao;
    }

    public void setJixiezhizao(float jixiezhizao) {
        this.jixiezhizao = jixiezhizao;
    }

    public float getDianyingyantao() {
        return dianyingyantao;
    }

    public void setDianyingyantao(float dianyingyantao) {
        this.dianyingyantao = dianyingyantao;
    }

    public float getJisuanjichu() {
        return jisuanjichu;
    }

    public void setJisuanjichu(float jisuanjichu) {
        this.jisuanjichu = jisuanjichu;
    }

    public float getXiandaililun() {
        return xiandaililun;
    }

    public void setXiandaililun(float xiandaililun) {
        this.xiandaililun = xiandaililun;
    }

}