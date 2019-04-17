package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.ScoreAverageEntity;
import cn.hdu.fragmentTax.dao.entity.StuBaseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IScoreAverageMapper {
    @Select("SELECT `id`, `stu_id`, `average_score`, `curr_number`, `languages_types`, `languages_score`, `state`, `created_time`, `changed_tiem` FROM `score_average`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "averageScore", column = "average_score"),
            @Result(property = "currNumber", column = "curr_number"),
            @Result(property = "languagesTypes", column = "languages_types"),
            @Result(property = "languagesScore", column = "languages_score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTiem", column = "changed_tiem")
    })
    List<ScoreAverageEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `average_score`, `curr_number`, `languages_types`, `languages_score`, `state`, `created_time`, `changed_tiem` FROM `score_average` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "averageScore", column = "average_score"),
            @Result(property = "currNumber", column = "curr_number"),
            @Result(property = "languagesTypes", column = "languages_types"),
            @Result(property = "languagesScore", column = "languages_score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTiem", column = "changed_tiem")
    })
    ScoreAverageEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `score_average`(`id`, `stu_id`, `average_score`, `curr_number`, `languages_types`, `languages_score`, `state`, `created_time`, `changed_tiem`) VALUES(#{id}, #{stuId}, #{averageScore}, #{currNumber}, #{languagesTypes}, #{languagesScore}, #{state}, #{createdTime}, #{changedTiem})")
    void insert(ScoreAverageEntity score_averageEntity);

    @Update("UPDATE `score_average` SET id=#{id}, stu_id=#{stuId}, average_score=#{averageScore}, curr_number=#{currNumber}, languages_types=#{languagesTypes}, languages_score=#{languagesScore}, state=#{state}, created_time=#{createdTime}, changed_tiem=#{changedTiem} WHERE `id` = #{id}")
    void update(ScoreAverageEntity score_averageEntity);

    @Delete("DELETE FROM `score_average` WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Insert("INSERT INTO `score_average`(`stu_id`, `languages_types`, `languages_score`) VALUES(#{stuId}, #{languagesTypes}, #{languagesScore}) ON DUPLICATE KEY UPDATE `languages_types` = #{languagesTypes}, `languages_score` = #{languagesScore}")
    void insertLanguage(@Param("stuId") String stuId, @Param("languagesTypes") String languagesTypes, @Param("languagesScore") Float languagesScore);

    @Select("SELECT `id`, `stu_id`, `average_score`, `curr_number`, `languages_types`, `languages_score`, `state`, `created_time`, `changed_tiem` FROM `score_average` WHERE `stu_id` = #{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "averageScore", column = "average_score"),
            @Result(property = "currNumber", column = "curr_number"),
            @Result(property = "languagesTypes", column = "languages_types"),
            @Result(property = "languagesScore", column = "languages_score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTiem", column = "changed_tiem")
    })
    ScoreAverageEntity queryByStuId(@Param("stuId") String stuId);

    @Update("UPDATE `score_average` SET average_score=#{averageScore}, curr_number=#{currNumber} WHERE `stu_id` = #{stuId}")
    void updateAverageScore(@Param("stuId") String stuId, @Param("averageScore") Float averageScore, @Param("currNumber") Integer currNumber);
}