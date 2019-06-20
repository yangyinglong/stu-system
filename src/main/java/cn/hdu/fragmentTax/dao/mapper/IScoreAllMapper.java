package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.ScoreAllEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IScoreAllMapper {
    @Select("SELECT `id`, `stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `state`, `created_time`, `changed_time`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `score_all`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
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
    List<ScoreAllEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `state`, `created_time`, `changed_time`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `score_all` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
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
    ScoreAllEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `score_all`(`id`, `stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `state`, `created_time`, `changed_time`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun`) VALUES(#{id}, #{stuId}, #{engineeringMathematics}, #{firstForeignLanguage}, #{characteristicSocialism}, #{numericalAnalysis}, #{state}, #{createdTime}, #{changedTime}, #{jixiejiaozuo}, #{jisuanyingyong}, #{jidianxue}, #{nami}, #{jixiejiagong}, #{jixiezhizao}, #{dianyingyantao}, #{jisuanjichu}, #{xiandaililun})")
    void insert(ScoreAllEntity score_allEntity);

    @Update("UPDATE `score_all` SET id=#{id}, stu_id=#{stuId}, engineering_mathematics=#{engineeringMathematics}, first_foreign_language=#{firstForeignLanguage}, characteristic_socialism=#{characteristicSocialism}, numerical_analysis=#{numericalAnalysis}, state=#{state}, created_time=#{createdTime}, changed_time=#{changedTime}, jixiejiaozuo=#{jixiejiaozuo}, jisuanyingyong=#{jisuanyingyong}, jidianxue=#{jidianxue}, nami=#{nami}, jixiejiagong=#{jixiejiagong}, jixiezhizao=#{jixiezhizao}, dianyingyantao=#{dianyingyantao}, jisuanjichu=#{jisuanjichu}, xiandaililun=#{xiandaililun} WHERE `id` = #{id}")
    void update(ScoreAllEntity score_allEntity);

    @Delete("DELETE FROM `score_all` WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Insert("INSERT INTO `score_all`(`stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun`) VALUES(#{stuId}, #{engineeringMathematics}, #{firstForeignLanguage}, #{characteristicSocialism}, #{numericalAnalysis}, #{jixiejiaozuo}, #{jisuanyingyong}, #{jidianxue}, #{nami}, #{jixiejiagong}, #{jixiezhizao}, #{dianyingyantao}, #{jisuanjichu}, #{xiandaililun}) ON DUPLICATE KEY UPDATE engineering_mathematics=#{engineeringMathematics}, first_foreign_language=#{firstForeignLanguage}, characteristic_socialism=#{characteristicSocialism}, numerical_analysis=#{numericalAnalysis}, jixiejiaozuo=#{jixiejiaozuo}, jisuanyingyong=#{jisuanyingyong}, jidianxue=#{jidianxue}, nami=#{nami}, jixiejiagong=#{jixiejiagong}, jixiezhizao=#{jixiezhizao}, dianyingyantao=#{dianyingyantao}, jisuanjichu=#{jisuanjichu}, xiandaililun=#{xiandaililun}")
    void updateScore(ScoreAllEntity scoreAllEntity);

    @Select("SELECT `id`, `stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `state`, `created_time`, `changed_time`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `score_all` WHERE `stu_id` = #{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
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
    ScoreAllEntity queryByStuId(@Param("stuId") String stuId);

    @Insert("INSERT INTO `score_all`(`stu_id`, `created_time`) VALUES(#{stuId}, #{createdTime})")
    void insertFirst(@Param("stuId") String stuId, @Param("createdTime") String currentDatetime);

    @Select("SELECT count(*) FROM `score_all` WHERE  `state` = 1 and `stu_id` in (${stuIds})")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountByStuIds(@Param("stuIds") String stuIds);


    @Select("SELECT `id`, `stu_id`, `engineering_mathematics`, `first_foreign_language`, `characteristic_socialism`, `numerical_analysis`, `state`, `created_time`, `changed_time`, `jixiejiaozuo`, `jisuanyingyong`, `jidianxue`, `nami`, `jixiejiagong`, `jixiezhizao`, `dianyingyantao`, `jisuanjichu`, `xiandaililun` FROM `score_all` where `state` <> 0 and `stu_id` in (${stuIds}) order by `stu_id` desc limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "engineeringMathematics", column = "engineering_mathematics"),
            @Result(property = "firstForeignLanguage", column = "first_foreign_language"),
            @Result(property = "characteristicSocialism", column = "characteristic_socialism"),
            @Result(property = "numericalAnalysis", column = "numerical_analysis"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
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
    List<ScoreAllEntity> queryByStuIdWithPage(@Param("stuIds") String stuIds, @Param("start") int page);
}