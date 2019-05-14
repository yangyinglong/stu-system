package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.CreditEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ICreditMapper {
    @Select("SELECT `id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `credit`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "jixiejiaozuo", column = "jixiejiaozuo"),
            @Result(property = "jisuanyingyong", column = "jisuanyingyong"),
            @Result(property = "jidianxue", column = "jidianxue"),
            @Result(property = "nami", column = "nami"),
            @Result(property = "jixiejiagong", column = "jixiejiagong"),
            @Result(property = "jixiezhizao", column = "jixiezhizao"),
            @Result(property = "dianyingyantao", column = "dianyingyantao"),
            @Result(property = "jisuanjichu", column = "jisuanjichu"),
            @Result(property = "xiandaililun", column = "xiandaililun")
    })
    List<CreditEntity> queryAll();

    @Select("SELECT `id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `credit` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "jixiejiaozuo", column = "jixiejiaozuo"),
            @Result(property = "jisuanyingyong", column = "jisuanyingyong"),
            @Result(property = "jidianxue", column = "jidianxue"),
            @Result(property = "nami", column = "nami"),
            @Result(property = "jixiejiagong", column = "jixiejiagong"),
            @Result(property = "jixiezhizao", column = "jixiezhizao"),
            @Result(property = "dianyingyantao", column = "dianyingyantao"),
            @Result(property = "jisuanjichu", column = "jisuanjichu"),
            @Result(property = "xiandaililun", column = "xiandaililun")
    })
    CreditEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `credit`(`id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun`) VALUES(#{id}, #{engineeringMathematics}, #{firstForeignLanguage}, #{characteristicSocialism}, #{numericalAnalysis}, #{jixiejiaozuo}, #{jisuanyingyong}, #{jidianxue}, #{nami}, #{jixiejiagong}, #{jixiezhizao}, #{dianyingyantao}, #{jisuanjichu}, #{xiandaililun})")
    void insert(CreditEntity creditEntity);

    @Update("UPDATE `credit` SET id=#{id}, engineering_mathematics=#{engineeringMathematics}, first_foreign_language=#{firstForeignLanguage}, characteristic_socialism=#{characteristicSocialism}, numerical_analysis=#{numericalAnalysis}, jixiejiaozuo=#{jixiejiaozuo}, jisuanyingyong=#{jisuanyingyong}, jidianxue=#{jidianxue}, nami=#{nami}, jixiejiagong=#{jixiejiagong}, jixiezhizao=#{jixiezhizao}, dianyingyantao=#{dianyingyantao}, jisuanjichu=#{jisuanjichu}, xiandaililun=#{xiandaililun} WHERE `id` = #{id}")
    void update(CreditEntity creditEntity);

    @Delete("DELETE FROM `credit` WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

}