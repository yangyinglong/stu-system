package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.AllPrizeEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IAllPrizeMapper {
    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> queryAll();

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    AllPrizeEntity queryByKey(@Param("id") Integer id);

    @Insert("INSERT INTO `all_prize`(`id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count`) VALUES(#{id}, #{stuId}, #{honorScore}, #{honorNum}, #{paperSocre}, #{paperNum}, #{patentScore}, #{patentNum}, #{state}, #{createdTime}, #{changedTime}, #{competitionScore}, #{competitionNum}, #{engiScore}, #{engiNum}, #{entrScore}, #{entrNum}, #{innoScore}, #{innoNum}, #{exchScore}, #{exchNum}, #{workScore}, #{workNum}, #{masterScore}, #{masterNum}, #{allScore}, #{allNum}, #{totalCount})")
    void insert(AllPrizeEntity all_prizeEntity);

    @Update("UPDATE `all_prize` SET id=#{id}, stu_id=#{stuId}, honor_score=#{honorScore}, honor_num=#{honorNum}, paper_socre=#{paperSocre}, paper_num=#{paperNum}, patent_score=#{patentScore}, patent_num=#{patentNum}, state=#{state}, created_time=#{createdTime}, changed_time=#{changedTime}, competition_score=#{competitionScore}, competition_num=#{competitionNum}, engi_score=#{engiScore}, engi_num=#{engiNum}, entr_score=#{entrScore}, entr_num=#{entrNum}, inno_score=#{innoScore}, inno_num=#{innoNum}, exch_score=#{exchScore}, exch_num=#{exchNum}, work_score=#{workScore}, work_num=#{workNum}, master_score=#{masterScore}, master_num=#{masterNum}, all_score=#{allScore}, all_num=#{allNum}, total_count=#{totalCount} WHERE `id` = #{id}")
    void update(AllPrizeEntity all_prizeEntity);

    @Delete("DELETE FROM `all_prize` WHERE `id` = #{id}")
    void delete(@Param("id") Integer id);



    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` WHERE `stu_id` = #{stuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    AllPrizeEntity queryByStuId(@Param("stuId") String stuId);

    @Insert("INSERT INTO `all_prize`(`stu_id`, `created_time`, `honor_num`, `paper_num`, `patent_num`, `competition_num`, `engi_num`, `entr_num`, `inno_num`, `exch_num`, `work_num`, `master_num` ) VALUES(#{stuId}, #{createdTime}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}, #{stuNum}) ON DUPLICATE KEY UPDATE `created_time` = #{createdTime}")
    void insertFirst(@Param("stuId") String stuId, @Param("stuNum") int stuNumber, @Param("createdTime") String currentDatetime);

    @Update("UPDATE `all_prize` SET honor_score=#{honorScore} WHERE `stu_id` = #{stuId}")
    void updateHonorScore(@Param("stuId") String stuId, @Param("honorScore") Float allHonorScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `honor_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByHonor();

    @Update("UPDATE `all_prize` SET honor_num=#{honorNum} WHERE `id` = #{id}")
    void updateHonorNum(@Param("id") Integer id, @Param("honorNum") Integer order);

    @Update("UPDATE `all_prize` SET paper_socre=#{paperScore} WHERE `stu_id` = #{stuId}")
    void updatePaperScore(@Param("stuId") String stuId, @Param("paperScore") Float allPaperScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `paper_socre` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByPaper();

    @Update("UPDATE `all_prize` SET paper_num=#{paperNum} WHERE `id` = #{id}")
    void updatePaperNum(@Param("id") Integer id, @Param("paperNum") Integer order);

    @Update("UPDATE `all_prize` SET patent_score=#{patentScore} WHERE `stu_id` = #{stuId}")
    void updatePatentScore(@Param("stuId") String stuId, @Param("patentScore") Float allPatentScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `patent_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByPatent();

    @Update("UPDATE `all_prize` SET patent_num=#{patentNum} WHERE `id` = #{id}")
    void updatePatentNum(@Param("id") Integer id, @Param("patentNum") Integer order);

    @Update("UPDATE `all_prize` SET competition_score=#{competitionScore} WHERE `stu_id` = #{stuId}")
    void updateCompetitionScore(@Param("stuId") String stuId, @Param("competitionScore") Float allCompetitionScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `competition_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByCompetition();

    @Update("UPDATE `all_prize` SET competition_num=#{competitionNum} WHERE `id` = #{id}")
    void updateCompetitionNum(@Param("id") Integer id, @Param("competitionNum")  Integer order);

    @Update("UPDATE `all_prize` SET entr_score=#{entrProScore} WHERE `stu_id` = #{stuId}")
    void updateEntrProScore(@Param("stuId") String stuId, @Param("entrProScore") Float allEntrProScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `entr_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByEntrPro();

    @Update("UPDATE `all_prize` SET entr_num=#{entrProNum} WHERE `id` = #{id}")
    void updateEntrProNum(@Param("id") Integer id, @Param("entrProNum") Integer order);

    @Update("UPDATE `all_prize` SET inno_score=#{innoScore} WHERE `stu_id` = #{stuId}")
    void updateInnoProScore(@Param("stuId") String stuId, @Param("innoScore") Float allInnoProScore);

    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` order by `inno_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> orderByInnoPro();

    @Update("UPDATE `all_prize` SET inno_num=#{innoNum} WHERE `id` = #{id}")
    void updateInnoProNum(@Param("id") Integer id, @Param("innoNum") Integer order);

    @Update("UPDATE `all_prize` SET engi_score=#{engiScore} WHERE `stu_id` = #{stuId}")
    void updateEngiProScore(@Param("stuId") String stuId, @Param("engiScore") Float allEngiProScore);

    @Select("SELECT `id`, `engi_num` FROM `all_prize` order by `engi_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "engiNum", column = "engi_num")
    })
    List<AllPrizeEntity> orderByEngiPro();

    @Update("UPDATE `all_prize` SET engi_num=#{engiNum} WHERE `id` = #{id}")
    void updateEngiProNum(@Param("id") Integer id, @Param("engiNum") Integer order);

    @Update("UPDATE `all_prize` SET exch_score=#{exchScore} WHERE `stu_id` = #{stuId}")
    void updateAcadExchScore(@Param("stuId") String stuId, @Param("exchScore") Float allAcadExchScore);

    @Select("SELECT `id`, `exch_num` FROM `all_prize` order by `exch_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "exchNum", column = "exch_num")
    })
    List<AllPrizeEntity> orderByAcadExch();

    @Update("UPDATE `all_prize` SET exch_num=#{exchNum} WHERE `id` = #{id}")
    void updateAcadExchNum(@Param("id") Integer id, @Param("exchNum") Integer order);

    @Update("UPDATE `all_prize` SET master_score=#{masterScore} WHERE `stu_id` = #{stuId}")
    void updateMasterPaperScore(@Param("stuId") String stuId, @Param("masterScore") Float allMasterPaperScore);

    @Select("SELECT `id`, `master_num` FROM `all_prize` order by `master_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "masterNum", column = "master_num")
    })
    List<AllPrizeEntity> orderByMasterPaper();

    @Update("UPDATE `all_prize` SET master_num=#{masterNum} WHERE `id` = #{id}")
    void updateMasterPaperNum(@Param("id") Integer id, @Param("masterNum") Integer order);

    @Update("UPDATE `all_prize` SET work_score=#{workScore} WHERE `stu_id` = #{stuId}")
    void updateWorkScore(@Param("stuId") String stuId, @Param("workScore") Float allWorkScore);

    @Select("SELECT `id`, `work_num` FROM `all_prize` order by `work_score` DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "workNum", column = "work_num")
    })
    List<AllPrizeEntity> orderByWork();

    @Update("UPDATE `all_prize` SET work_num=#{workNum} WHERE `id` = #{id}")
    void updateWorkNum(@Param("id") Integer id, @Param("workNum") Integer order);

    @Select("SELECT count(*) FROM `all_prize` WHERE  `state` = 1 and `stu_id` in (${stuIds})")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryCountByStuIds(@Param("stuIds") String stuIds);


    @Select("SELECT `id`, `stu_id`, `honor_score`, `honor_num`, `paper_socre`, `paper_num`, `patent_score`, `patent_num`, `state`, `created_time`, `changed_time`, `competition_score`, `competition_num`, `engi_score`, `engi_num`, `entr_score`, `entr_num`, `inno_score`, `inno_num`, `exch_score`, `exch_num`, `work_score`, `work_num`, `master_score`, `master_num`, `all_score`, `all_num`, `total_count` FROM `all_prize` where `stu_id` in (${stuIds}) and `state` <> 0 order by `stu_id` DESC limit #{start}, 10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stuId", column = "stu_id"),
            @Result(property = "honorScore", column = "honor_score"),
            @Result(property = "honorNum", column = "honor_num"),
            @Result(property = "paperSocre", column = "paper_socre"),
            @Result(property = "paperNum", column = "paper_num"),
            @Result(property = "patentScore", column = "patent_score"),
            @Result(property = "patentNum", column = "patent_num"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "competitionScore", column = "competition_score"),
            @Result(property = "competitionNum", column = "competition_num"),
            @Result(property = "engiScore", column = "engi_score"),
            @Result(property = "engiNum", column = "engi_num"),
            @Result(property = "entrScore", column = "entr_score"),
            @Result(property = "entrNum", column = "entr_num"),
            @Result(property = "innoScore", column = "inno_score"),
            @Result(property = "innoNum", column = "inno_num"),
            @Result(property = "exchScore", column = "exch_score"),
            @Result(property = "exchNum", column = "exch_num"),
            @Result(property = "workScore", column = "work_score"),
            @Result(property = "workNum", column = "work_num"),
            @Result(property = "masterScore", column = "master_score"),
            @Result(property = "masterNum", column = "master_num"),
            @Result(property = "allScore", column = "all_score"),
            @Result(property = "allNum", column = "all_num"),
            @Result(property = "totalCount", column = "total_count")
    })
    List<AllPrizeEntity> queryByStuIdWithPage(@Param("stuIds") String stuIds, @Param("start") int start);

    @Update("UPDATE `all_prize` SET paper_socre=`paper_socre`- #{paperScore} WHERE `stu_id` = #{stuId}")
    void deletePaperScore(@Param("stuId") String stuId, @Param("paperScore") Float paperScore);

    @Update("UPDATE `all_prize` SET patent_score=`patent_score`- #{patentScore} WHERE `stu_id` = #{stuId}")
    void deletePatentScore(@Param("stuId") String stuId, @Param("patentScore") Float patentScore);

    @Update("UPDATE `all_prize` SET competition_score=`competition_score`- #{competitionScore} WHERE `stu_id` = #{stuId}")
    void deleteCompetitionScore(@Param("stuId") String stuId, @Param("competitionScore") Float competitionScore);

    @Update("UPDATE `all_prize` SET engi_score=`engi_score`- #{projectScore} WHERE `stu_id` = #{stuId}")
    void deleteProjectScore(@Param("stuId") String stuId, @Param("projectScore") Float projectScore);
}