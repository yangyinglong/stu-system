package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.AcademicExchangeEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IAcademicExchangeMapper {
    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    AcademicExchangeEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `academic_exchange`(`stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state`) VALUES(#{stuId}, #{exchangeType}, #{organization}, #{conferenceName}, #{startTime}, #{endTime}, #{level}, #{result}, #{proofMaterialId}, #{score}, #{state})")
    void insert(AcademicExchangeEntity academic_exchangeEntity);

    @Update("UPDATE `academic_exchange` SET stu_id=#{stuId}, exchange_type=#{exchangeType}, organization=#{organization}, conference_name=#{conferenceName}, start_time=#{startTime}, end_time=#{endTime}, level=#{level}, result=#{result}, proof_material_id=#{proofMaterialId}, score=#{score}, state=#{state} WHERE `id` = #{id}")
    void update(AcademicExchangeEntity academic_exchangeEntity);

    @Update("UPDATE `academic_exchange` SET state=0 WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `stu_id` = #{stuId} and `state` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryStuId(@Param("stuId") String stuId);

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `state` in (${states})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryForAdmin(@Param("states") String status);

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `exchange_type` like #{exchangeType} order by `stu_id` desc limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("exchangeType") String exchangeType, @Param("start") int start);

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `exchange_type` like #{exchangeType} order by `stu_id` desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryAllForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("exchangeType") String exchangeType);


    @Update("UPDATE `academic_exchange` SET score=#{score}, state=#{state} WHERE `id` = #{id}")
    void updateScore(@Param("id") String id, @Param("score") Float score, @Param("state") Integer state);

    @Select("SELECT `id`, `stu_id`, `exchange_type`, `organization`, `conference_name`, `start_time`, `end_time`, `level`, `result`, `proof_material_id`, `score`, `state` FROM `academic_exchange` WHERE `state` = #{state} and `stu_id` = #{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "exchangeType", column = "exchange_type"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "conferenceName", column = "conference_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state")
    })
    List<AcademicExchangeEntity> queryByStuId(@Param("stuId") String stuId, @Param("state") Integer state);

    @Select("SELECT count(*) FROM `academic_exchange` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `exchange_type` like #{exchangeType}")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("exchangeType") String exchangeType);

}