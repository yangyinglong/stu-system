package cn.hdu.fragmentTax.model.response;

public class GetAllScoreResp {
    private Integer currNumber;
    private Float averageScore;
    private String name;
    private String stuId;

    private float engineeringMathematics;  // 工程数学
    private float firstForeignLanguage;  // 第一外国语
    private float characteristicSocialism;  // 中国特色社会主义理论与实践研究
    private float numericalAnalysis;  // 数值分析
    private float jixiejiaozuo;  // 机械工程学科发展前沿专题讲座
    private float jisuanyingyong;  // 计算流体力学软件及工程应用
    private float jidianxue;  // 机电系统动力学
    private float nami;  // 纳米技术与应用
    private float jixiejiagong;  // 机械加工精度理论与机械制造装备技术
    private float jixiezhizao;  // 机械制造方法理论与技术
    private float dianyingyantao;  // 典型企业制造案例研讨
    private float jisuanjichu;  // 计算流体力学基础
    private float xiandaililun;  // 现代控制理论
    private float weightedAverageScore;
    private float hadCredit;

    public GetAllScoreResp() {
    }

    public float getHadCredit() {
        return hadCredit;
    }

    public void setHadCredit(float hadCredit) {
        this.hadCredit = hadCredit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public float getWeightedAverageScore() {
        return weightedAverageScore;
    }

    public void setWeightedAverageScore(float weightedAverageScore) {
        this.weightedAverageScore = weightedAverageScore;
    }

    public GetAllScoreResp(Integer currNumber, Float averageScore, float engineeringMathematics, float firstForeignLanguage, float characteristicSocialism, float numericalAnalysis, float jixiejiaozuo, float jisuanyingyong, float jidianxue, float nami, float jixiejiagong, float jixiezhizao, float dianyingyantao, float jisuanjichu, float xiandaililun) {
        this.currNumber = currNumber;
        this.averageScore = averageScore;
        this.engineeringMathematics = engineeringMathematics;
        this.firstForeignLanguage = firstForeignLanguage;
        this.characteristicSocialism = characteristicSocialism;
        this.numericalAnalysis = numericalAnalysis;
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

    public void setEngineeringMathematics(float engineeringMathematics) {
        this.engineeringMathematics = engineeringMathematics;
    }

    public void setFirstForeignLanguage(float firstForeignLanguage) {
        this.firstForeignLanguage = firstForeignLanguage;
    }

    public void setCharacteristicSocialism(float characteristicSocialism) {
        this.characteristicSocialism = characteristicSocialism;
    }

    public void setNumericalAnalysis(float numericalAnalysis) {
        this.numericalAnalysis = numericalAnalysis;
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

    public Integer getCurrNumber() {
        return currNumber;
    }

    public void setCurrNumber(Integer currNumber) {
        this.currNumber = currNumber;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Float getEngineeringMathematics() {
        return engineeringMathematics;
    }

    public void setEngineeringMathematics(Float engineeringMathematics) {
        this.engineeringMathematics = engineeringMathematics;
    }

    public Float getFirstForeignLanguage() {
        return firstForeignLanguage;
    }

    public void setFirstForeignLanguage(Float firstForeignLanguage) {
        this.firstForeignLanguage = firstForeignLanguage;
    }

    public Float getCharacteristicSocialism() {
        return characteristicSocialism;
    }

    public void setCharacteristicSocialism(Float characteristicSocialism) {
        this.characteristicSocialism = characteristicSocialism;
    }

    public Float getNumericalAnalysis() {
        return numericalAnalysis;
    }

    public void setNumericalAnalysis(Float numericalAnalysis) {
        this.numericalAnalysis = numericalAnalysis;
    }
}
