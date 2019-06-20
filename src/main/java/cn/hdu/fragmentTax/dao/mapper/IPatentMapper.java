package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.PatentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IPatentMapper {
    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    PatentEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `patent`(`stu_id`, `patent_type`, `patent_name`, `patent_state`, `ranking`, `total_number`, `score`, `state`, `created_time`, `proof_material_id`) VALUES(#{stuId}, #{patentType}, #{patentName}, #{patentState}, #{ranking}, #{totalNumber}, #{score}, #{state}, #{createdTime}, #{proofMaterialId})")
    void insert(PatentEntity patentEntity);

    @Update("UPDATE `patent` SET stu_id=#{stuId}, patent_type=#{patentType}, patent_name=#{patentName}, patent_state=#{patentState}, ranking=#{ranking}, total_number=#{totalNumber}, score=#{score}, state=#{state}, created_time=#{createdTime}, proof_material_id=#{proofMaterialId} WHERE `id` = #{id}")
    void update(PatentEntity patentEntity);

    @Update("UPDATE `patent` SET state=0 WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` WHERE `stu_id` = #{stuId} and `state` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryStuId(@Param("stuId") String stuId);

    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` where `state` in (${state})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryForAdmin(@Param("state") String status);

    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` where `state` in (${state}) and `stu_id` in (${stuIds}) and `patent_type` like #{patentType} and `patent_state` like #{patentState} order by `stu_id` desc limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryForTutor(@Param("state") String status, @Param("stuIds") String stuIds, @Param("patentType") String patentType, @Param("patentState") String patentState, @Param("start") int start);


    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` where `state` in (${state}) and `stu_id` in (${stuIds}) and `patent_type` like #{patentType} and `patent_state` like #{patentState} order by `stu_id` desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryAllForTutor(@Param("state") String status, @Param("stuIds") String stuIds, @Param("patentType") String patentType, @Param("patentState") String patentState);


    @Update("UPDATE `patent` SET score=#{score}, state=#{state} WHERE `id` = #{id}")
    void updateScore(@Param("id") String id, @Param("score") Float score, @Param("state") Integer state);

    @Select("SELECT `id`, `stu_id`, `patent_type`, `patent_name`, `patent_state`, `proof_material_id`, `ranking`, `total_number`, `score`, `state`, `created_time`, `changed_time` FROM `patent` where `state`=#{state} and `stu_id`=#{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "patentType", column = "patent_type"),
            @Result(property = "patentName", column = "patent_name"),
            @Result(property = "patentState", column = "patent_state"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<PatentEntity> queryByStuId(@Param("stuId") String stuId, @Param("state") Integer state);

    @Select("SELECT count(*) FROM `patent` where `state` in (${state}) and `stu_id` in (${stuIds}) and `patent_type` like #{patentType} and `patent_state` like #{patentState}")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountForTutor(@Param("state") String status, @Param("stuIds") String stuIds, @Param("patentType") String patentType, @Param("patentState") String patentState);
}