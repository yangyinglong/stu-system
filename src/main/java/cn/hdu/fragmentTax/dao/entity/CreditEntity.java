package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class CreditEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private float engineeringMathematics;
    @Column
    private float firstForeignLanguage;
    @Column
    private float characteristicSocialism;
    @Column
    private float numericalAnalysis;
    @Column
    private float jixiejiaozuo;
    @Column
    private float jisuanyingyong;
    @Column
    private float jidianxue;
    @Column
    private float nami;
    @Column
    private float jixiejiagong;
    @Column
    private float jixiezhizao;
    @Column
    private float dianyingyantao;
    @Column
    private float jisuanjichu;
    @Column
    private float xiandaililun;

    public CreditEntity() {
    }

    public CreditEntity(Integer id, float engineeringMathematics, float firstForeignLanguage, float characteristicSocialism, float numericalAnalysis, float jixiejiaozuo, float jisuanyingyong, float jidianxue, float nami, float jixiejiagong, float jixiezhizao, float dianyingyantao, float jisuanjichu, float xiandaililun) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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