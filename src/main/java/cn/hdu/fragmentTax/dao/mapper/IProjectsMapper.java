package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.ProjectsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IProjectsMapper {
    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    List<ProjectsEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    ProjectsEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `projects`(`stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state`) VALUES(#{stuId}, #{proName}, #{proType}, #{proLevel}, #{ranking}, #{totalNumber}, #{proTime}, #{proTeacher}, #{proResult}, #{score}, #{proClass}, #{proofMaterialId}, #{proState}, #{state})")
    void insert(ProjectsEntity projectsEntity);

    @Update("UPDATE `projects` SET stu_id=#{stuId}, pro_name=#{proName}, pro_type=#{proType}, pro_level=#{proLevel}, ranking=#{ranking}, total_number=#{totalNumber}, pro_time=#{proTime}, pro_teacher=#{proTeacher}, pro_result=#{proResult}, score=#{score}, pro_class=#{proClass}, proof_material_id=#{proofMaterialId}, pro_state=#{proState}, state=#{state} WHERE `id` = #{id}")
    void update(ProjectsEntity projectsEntity);

    @Update("UPDATE `projects` SET state=0 WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects` WHERE `stu_id` = #{stuId} and `state` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    List<ProjectsEntity> queryStuId(@Param("stuId") String stuId);

    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects` WHERE `stu_id` in (${stuIds}) and `state` in (${states}) and `pro_class` like #{proClass} and `pro_type` like #{proType} order by `stu_id` desc limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    List<ProjectsEntity> queryForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("proClass") String proClass, @Param("proType") String proType, @Param("start") int start);

    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects` WHERE `stu_id` in (${stuIds}) and `state` in (${states}) and `pro_class` like #{proClass} and `pro_type` like #{proType} order by `stu_id` desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    List<ProjectsEntity> queryAllForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("proClass") String proClass, @Param("proType") String proType);


    @Update("UPDATE `projects` SET score=#{score}, state=#{state} WHERE `id` = #{id}")
    void updateScore(@Param("id") String id, @Param("score") Float score, @Param("state") Integer state);

    @Select("SELECT `id`, `stu_id`, `pro_name`, `pro_type`, `pro_level`, `ranking`, `total_number`, `pro_time`, `pro_teacher`, `pro_result`, `score`, `pro_class`, `proof_material_id`, `pro_state`, `state` FROM `projects` WHERE `stu_id`=#{stuId} and `state`=#{state}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "proName", column = "pro_name"),
            @Result(property = "proType", column = "pro_type"),
            @Result(property = "proLevel", column = "pro_level"),
            @Result(property = "ranking", column = "ranking"),
            @Result(property = "totalNumber", column = "total_number"),
            @Result(property = "proTime", column = "pro_time"),
            @Result(property = "proTeacher", column = "pro_teacher"),
            @Result(property = "proResult", column = "pro_result"),
            @Result(property = "score", column = "score"),
            @Result(property = "proClass", column = "pro_class"),
            @Result(property = "proofMaterialId", column = "proof_material_id"),
            @Result(property = "proState", column = "pro_state"),
            @Result(property = "state", column = "state")
    })
    List<ProjectsEntity> queryByStuId(@Param("stuId") String stuId, @Param("state") Integer state);

    @Select("SELECT count(*) FROM `projects` WHERE `stu_id` in (${stuIds}) and `state` in (${states}) and `pro_class` like #{proClass} and `pro_type` like #{proType}")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("proClass") String proClass, @Param("proType") String proType);
}