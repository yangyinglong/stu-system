package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.StuBaseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IStuBaseMapper {
    @Select("SELECT `id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary` FROM `stu_base`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "uSchool", column = "u_school"),
            @Result(property = "uMajor", column = "u_major"),
            @Result(property = "counsellorId", column = "counsellor_id"),
            @Result(property = "tutorId", column = "tutor_id"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "masterMajor", column = "master_major"),
            @Result(property = "politicalOutlook", column = "political_outlook"),
            @Result(property = "biogenicLand", column = "biogenic_land"),
            @Result(property = "masterDirection", column = "master_direction"),
            @Result(property = "eMail", column = "e_mail"),
            @Result(property = "emergencyContact", column = "emergency_contact"),
            @Result(property = "emergencyPhone", column = "emergency_phone"),
            @Result(property = "secretary", column = "secretary")
    })
    List<StuBaseEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary` FROM `stu_base` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "uSchool", column = "u_school"),
            @Result(property = "uMajor", column = "u_major"),
            @Result(property = "counsellorId", column = "counsellor_id"),
            @Result(property = "tutorId", column = "tutor_id"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "masterMajor", column = "master_major"),
            @Result(property = "politicalOutlook", column = "political_outlook"),
            @Result(property = "biogenicLand", column = "biogenic_land"),
            @Result(property = "masterDirection", column = "master_direction"),
            @Result(property = "eMail", column = "e_mail"),
            @Result(property = "emergencyContact", column = "emergency_contact"),
            @Result(property = "emergencyPhone", column = "emergency_phone"),
            @Result(property = "secretary", column = "secretary")
    })
    StuBaseEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `stu_base`(`id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary`) VALUES(#{id}, #{stuId}, #{name}, #{phone}, #{sex}, #{uSchool}, #{uMajor}, #{counsellorId}, #{tutorId}, #{state}, #{createdTime}, #{changedTime}, #{idCard}, #{masterMajor}, #{politicalOutlook}, #{biogenicLand}, #{masterDirection}, #{eMail}, #{emergencyContact}, #{emergencyPhone}, #{secretary})")
    void insert(StuBaseEntity stu_baseEntity);

    @Update("UPDATE `stu_base` SET id=#{id}, stu_id=#{stuId}, name=#{name}, phone=#{phone}, sex=#{sex}, u_school=#{uSchool}, u_major=#{uMajor}, counsellor_id=#{counsellorId}, tutor_id=#{tutorId}, state=#{state}, created_time=#{createdTime}, changed_time=#{changedTime}, id_card=#{idCard}, master_major=#{masterMajor}, political_outlook=#{politicalOutlook}, biogenic_land=#{biogenicLand}, master_direction=#{masterDirection}, e_mail=#{eMail}, emergency_contact=#{emergencyContact}, emergency_phone=#{emergencyPhone}, secretary=#{secretary} WHERE `id` = #{id}")
    void update(StuBaseEntity stu_baseEntity);

    @Delete("DELETE FROM `stu_base` WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);


    @Select("SELECT `id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary` FROM `stu_base` WHERE `stu_id` = #{stuId} and `state` = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "uSchool", column = "u_school"),
            @Result(property = "uMajor", column = "u_major"),
            @Result(property = "counsellorId", column = "counsellor_id"),
            @Result(property = "tutorId", column = "tutor_id"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "masterMajor", column = "master_major"),
            @Result(property = "politicalOutlook", column = "political_outlook"),
            @Result(property = "biogenicLand", column = "biogenic_land"),
            @Result(property = "masterDirection", column = "master_direction"),
            @Result(property = "eMail", column = "e_mail"),
            @Result(property = "emergencyContact", column = "emergency_contact"),
            @Result(property = "emergencyPhone", column = "emergency_phone"),
            @Result(property = "secretary", column = "secretary")
    })
    StuBaseEntity queryByStuId(@Param("stuId") String stuId);

    @Insert("INSERT INTO `stu_base`(`stu_id`, `name`, `phone`, `sex`, `created_time`) VALUES(#{stuId}, #{name}, #{phone}, #{sex}, #{createdTime})")
    void insertBaseInfo(StuBaseEntity stuBaseEntity);

    @Update("UPDATE `stu_base` SET name=#{name}, phone=#{phone}, sex=#{sex} WHERE `stu_id` = #{stuId}")
    void editBaseInfo(@Param("stuId") String stuId, @Param("name") String name, @Param("phone") String phone, @Param("sex") Integer sex);

    @Update("UPDATE `stu_base` SET u_school=#{uSchool}, u_major=#{uMajor}, id_card=#{idCard}, master_major=#{masterMajor}, political_outlook=#{politicalOutlook}, biogenic_land=#{biogenicLand}, master_direction=#{masterDirection}, e_mail=#{eMail}, emergency_contact=#{emergencyContact}, emergency_phone=#{emergencyPhone} WHERE `stu_id` = #{stuId}")
    void updateUSchool(@Param("stuId") String stuId, @Param("uSchool") String uSchool,
                       @Param("uMajor") String uMajor, @Param("idCard") String idCard, @Param("masterMajor") String masterMajor,
                       @Param("masterDirection") String masterDirection, @Param("politicalOutlook") String politicalOutlook,
                       @Param("biogenicLand") String biogenicLand, @Param("eMail") String eMail,
                       @Param("emergencyContact") String emergencyContact, @Param("emergencyPhone") String emergencyPhone);

    //    TODO 增加研究生秘书
    @Update("UPDATE `stu_base` SET counsellor_id=#{counsellorId}, tutor_id=#{tutorId}, secretary=#{secretary} WHERE `stu_id` = #{stuId}")
    void updateTuCoer(@Param("stuId") String stuId, @Param("tutorId") String tutorId, @Param("counsellorId") String counsellorId, @Param("secretary") String secretary);

    @Select("SELECT `id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary` FROM `stu_base` WHERE `tutor_id` = #{tutorId} and `state` = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "uSchool", column = "u_school"),
            @Result(property = "uMajor", column = "u_major"),
            @Result(property = "counsellorId", column = "counsellor_id"),
            @Result(property = "tutorId", column = "tutor_id"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "masterMajor", column = "master_major"),
            @Result(property = "politicalOutlook", column = "political_outlook"),
            @Result(property = "biogenicLand", column = "biogenic_land"),
            @Result(property = "masterDirection", column = "master_direction"),
            @Result(property = "eMail", column = "e_mail"),
            @Result(property = "emergencyContact", column = "emergency_contact"),
            @Result(property = "emergencyPhone", column = "emergency_phone"),
            @Result(property = "secretary", column = "secretary")
    })
    List<StuBaseEntity> queryByTutorId(@Param("tutorId") String tutorId);

    @Select("SELECT count(*) FROM `stu_base` WHERE  `state` = 1")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCount();

    @Select("SELECT `id`, `stu_id`, `name`, `phone`, `sex`, `u_school`, `u_major`, `counsellor_id`, `tutor_id`, `state`, `created_time`, `changed_time`, `id_card`, `master_major`, `political_outlook`, `biogenic_land`, `master_direction`, `e_mail`, `emergency_contact`, `emergency_phone`, `secretary` FROM `stu_base` WHERE `stu_id` like #{stuId} and `name` like #{stuName} and `state` = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "uSchool", column = "u_school"),
            @Result(property = "uMajor", column = "u_major"),
            @Result(property = "counsellorId", column = "counsellor_id"),
            @Result(property = "tutorId", column = "tutor_id"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "masterMajor", column = "master_major"),
            @Result(property = "politicalOutlook", column = "political_outlook"),
            @Result(property = "biogenicLand", column = "biogenic_land"),
            @Result(property = "masterDirection", column = "master_direction"),
            @Result(property = "eMail", column = "e_mail"),
            @Result(property = "emergencyContact", column = "emergency_contact"),
            @Result(property = "emergencyPhone", column = "emergency_phone"),
            @Result(property = "secretary", column = "secretary")
    })
    List<StuBaseEntity> queryForCouner(@Param("stuId") String stuId, @Param("stuName") String stuName);
}