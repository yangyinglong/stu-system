package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.HonorEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IHonorMapper {
    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<HonorEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    HonorEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `honor`(`stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`) VALUES(#{stuId}, #{honorType}, #{honorLevel}, #{honorGrade}, #{proofMaterialId}, #{score}, #{state}, #{createdTime})")
    void insert(HonorEntity honorEntity);

    @Update("UPDATE `honor` SET honor_type=#{honorType}, honor_level=#{honorLevel}, proof_material_id=#{proofMaterialId}, honor_grade=#{honorGrade}, score=#{score}, state=#{state} WHERE `id` = #{id}")
    void update(HonorEntity honorEntity);

    @Update("UPDATE `honor` SET state=0 WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor` where `stu_id` = #{stuId} and `state` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<HonorEntity> queryStuId(@Param("stuId") String stuId);

    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor` where `state` in (${state})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<HonorEntity> queryForAdmin(@Param("state") String status);

    @Update("UPDATE `honor` SET score=#{score}, state=#{state} WHERE `id` = #{id}")
    void updateScore(@Param("id") String id, @Param("score") Float score, @Param("state") Integer state);

    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor` where `stu_id` = #{stuId} and `state` = #{state}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<HonorEntity> queryByStuId(@Param("stuId") String stuId, @Param("state") Integer state);


    @Select("SELECT `id`, `stu_id`, `honor_type`, `honor_level`, `honor_grade`, `proof_material_id`, `score`, `state`, `created_time`, `changed_time` FROM `honor` where `state` in (${state}) and `stu_id` in (${stuIds}) and `honor_type` like #{honorType}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorType", column = "honor_type"),
            @Result(property = "honorLevel", column = "honor_level"),
            @Result(property = "honorGrade", column = "honor_grade"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<HonorEntity> queryForTutor(@Param("state") String status, @Param("stuIds") String stuIds,  @Param("honorType") String honorType);
}