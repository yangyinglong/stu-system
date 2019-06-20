package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.WorkEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IWorkMapper {
    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    WorkEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `work`(`stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id`) VALUES(#{stuId}, #{workType}, #{companyName}, #{isCmp}, #{companyType}, #{workClass}, #{address}, #{score}, #{state}, #{createdTime}, #{proofMaterialId})")
    void insert(WorkEntity workEntity);

    @Update("UPDATE `work` SET stu_id=#{stuId}, work_type=#{workType}, company_name=#{companyName}, is_cmp=#{isCmp}, company_type=#{companyType}, work_class=#{workClass}, address=#{address}, score=#{score}, state=#{state}, created_time=#{createdTime}, proof_material_id=#{proofMaterialId} WHERE `id` = #{id}")
    void update(WorkEntity workEntity);

    @Update("UPDATE `work` SET state=0 WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);

    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `stu_id` = #{stuId} and `state` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryStuId(@Param("stuId") String stuId);

    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `state` in (${states})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryForAdmin(@Param("states") String status);


    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `work_type` like #{workType} order by `stu_id` desc limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("workType") String workType, @Param("start") int start);


    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `work_type` like #{workType} order by `stu_id` desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryAllForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("workType") String workType);


    @Update("UPDATE `work` SET score=#{score}, state=#{state} WHERE `id` = #{id}")
    void updateScore(@Param("id") String id, @Param("score") Float score, @Param("state") Integer state);


    @Select("SELECT `id`, `stu_id`, `work_type`, `company_name`, `is_cmp`, `company_type`, `work_class`, `address`, `score`, `state`, `created_time`, `proof_material_id` FROM `work` WHERE `state` = #{state} and `stu_id` = #{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "workType", column = "work_type"),
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "isCmp", column = "is_cmp"),
            @Result(property = "companyType", column = "company_type"),
            @Result(property = "workClass", column = "work_class"),
            @Result(property = "address", column = "address"),
            @Result(property = "score", column = "score"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "proofMaterialId", column = "proof_material_id")
    })
    List<WorkEntity> queryByStuId(@Param("stuId") String stuId, @Param("state") Integer state);


    @Select("SELECT count(*) FROM `work` WHERE `state` in (${states}) and `stu_id` in (${stuIds}) and `work_type` like #{workType}")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountForTutor(@Param("states") String status, @Param("stuIds") String stuIds, @Param("workType") String workType);

}