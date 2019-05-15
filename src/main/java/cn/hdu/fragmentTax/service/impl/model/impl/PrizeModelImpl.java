package cn.hdu.fragmentTax.service.impl.model.impl;

import cn.hdu.fragmentTax.dao.entity.*;
import cn.hdu.fragmentTax.model.request.*;
import cn.hdu.fragmentTax.model.response.*;
import cn.hdu.fragmentTax.service.impl.model.IPrizeModel;
import cn.hdu.fragmentTax.utils.DateUtil;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class PrizeModelImpl implements IPrizeModel {
    @Override
    public HonorEntity createHonorEntity(EditHonorResp editHonorResp) throws ParseException {
        HonorEntity honorEntity = new HonorEntity();
        honorEntity.setStuId(editHonorResp.getStuId());
        honorEntity.setHonorGrade(editHonorResp.getHonorGrade());
        honorEntity.setHonorLevel(editHonorResp.getHonorLevel());
        honorEntity.setHonorType(editHonorResp.getHonorType());
        honorEntity.setCreatedTime(DateUtil.getChinaDateTime(editHonorResp.getGetDate()).split(" ")[0]);
        honorEntity.setScore(0);
        honorEntity.setState(1);
        honorEntity.setProofMaterialId(editHonorResp.getProofMaterialId());
        return honorEntity;
    }

    @Override
    public GetHonorResp createGetHonorResp(HonorEntity honorEntity) {
        GetHonorResp getHonorResp = new GetHonorResp();
        getHonorResp.setId(honorEntity.getId());
        getHonorResp.setStuId(honorEntity.getStuId());
        getHonorResp.setScore(honorEntity.getScore());
        getHonorResp.setProofMaterialId(honorEntity.getProofMaterialId());
        if (honorEntity.getHonorType() == 1) {
            getHonorResp.setHonorType("本科生奖学金");
        } else if (honorEntity.getHonorType() == 2) {
            getHonorResp.setHonorType("研究生奖学金");
        } else if (honorEntity.getHonorType() == 3) {
            getHonorResp.setHonorType("企业奖学金");
        } else if (honorEntity.getHonorType() == 4) {
            getHonorResp.setHonorType("优秀毕业生");
        } else if (honorEntity.getHonorType() == 5) {
            getHonorResp.setHonorType("三好学生");
        } else if (honorEntity.getHonorType() == 6) {
            getHonorResp.setHonorType("优秀班干部");
        } else if (honorEntity.getHonorType() == 7) {
            getHonorResp.setHonorType("优秀党支书");
        } else if (honorEntity.getHonorType() == 8) {
            getHonorResp.setHonorType("优秀团支书");
        } else if (honorEntity.getHonorType() == 9) {
            getHonorResp.setHonorType("十佳大学生");
        } else {
            getHonorResp.setHonorType("其他");
        }

        if (honorEntity.getHonorGrade() == 1) {
            getHonorResp.setHonorGrade("一等奖");
        } else if (honorEntity.getHonorGrade() == 2) {
            getHonorResp.setHonorGrade("二等奖");
        } else {
            getHonorResp.setHonorGrade("三等奖");
        }

        if (honorEntity.getHonorLevel() == 1) {
            getHonorResp.setHonorLevel("国家级");
        } else if (honorEntity.getHonorLevel() == 2) {
            getHonorResp.setHonorLevel("省级");
        } else if (honorEntity.getHonorLevel() == 3) {
            getHonorResp.setHonorLevel("企业");
        } else {
            getHonorResp.setHonorLevel("校级");
        }
        if (honorEntity.getState() == 1) {
            getHonorResp.setStatus("待审核");
        } else {
            getHonorResp.setStatus("已通过");
        }
        getHonorResp.setGetDate(honorEntity.getCreatedTime().split(" ")[0]);
        return getHonorResp;
    }

    @Override
    public GetPrizesResp createGetPrizesResp(AllPrizeEntity allPrizeEntity) {
        GetPrizesResp getPrizesResp = new GetPrizesResp();
        getPrizesResp.setHonorScore(allPrizeEntity.getHonorScore());
        getPrizesResp.setPaperScore(allPrizeEntity.getPaperSocre());
        getPrizesResp.setPatentScore(allPrizeEntity.getPatentScore());
        return getPrizesResp;
    }

    @Override
    public PaperEntity createPaperEntity(EditPaperRequ editPaperRequ) throws ParseException {
        PaperEntity paperEntity = new PaperEntity();
        paperEntity.setStuId(editPaperRequ.getStuId());
        paperEntity.setProofMaterialId(editPaperRequ.getProofMaterialId());
        paperEntity.setJournalTitle(editPaperRequ.getJournalTitle());
        paperEntity.setPaperTitle(editPaperRequ.getPaperTitle());
        paperEntity.setPaperGrade(editPaperRequ.getPaperGrade());
        paperEntity.setPaperState(editPaperRequ.getPaperState());
        paperEntity.setRanking(editPaperRequ.getRanking());
        paperEntity.setTotalNumber(editPaperRequ.getTotalNumber());
        paperEntity.setCreatedTime(DateUtil.getChinaDateTime(editPaperRequ.getGetDate()));
        paperEntity.setScore(0);
        paperEntity.setState(1);
        return paperEntity;
    }

    @Override
    public GetPaperResp createGetPaperResp(PaperEntity paperEntity) {
        GetPaperResp getPaperResp = new GetPaperResp();
        getPaperResp.setId(paperEntity.getId());
        getPaperResp.setStuId(paperEntity.getStuId());
        getPaperResp.setPaperTitle(paperEntity.getPaperTitle());
        getPaperResp.setJournalTitle(paperEntity.getJournalTitle());
        getPaperResp.setRanking(paperEntity.getRanking());
        getPaperResp.setTotalNumber(paperEntity.getTotalNumber());
        getPaperResp.setGetDate(paperEntity.getCreatedTime().split(" ")[0]);
        getPaperResp.setScore(paperEntity.getScore());
        getPaperResp.setProofMaterialId(paperEntity.getProofMaterialId());
        if (paperEntity.getPaperGrade() == 1) {
            getPaperResp.setPaperGrade("一般");
        } else if (paperEntity.getPaperGrade() == 2) {
            getPaperResp.setPaperGrade("核心");
        } else if (paperEntity.getPaperGrade() == 3) {
            getPaperResp.setPaperGrade("一级");
        } else if (paperEntity.getPaperGrade() == 4) {
            getPaperResp.setPaperGrade("EI");
        } else if (paperEntity.getPaperGrade() == 5) {
            getPaperResp.setPaperGrade("SCI一区");
        } else if (paperEntity.getPaperGrade() == 6) {
            getPaperResp.setPaperGrade("SCI二区");
        } else if (paperEntity.getPaperGrade() == 7) {
            getPaperResp.setPaperGrade("SCI三区");
        } else {
            getPaperResp.setPaperGrade("SCI四区");
        }

        if (paperEntity.getPaperState() == 1) {
            getPaperResp.setPaperState("投稿");
        } else if (paperEntity.getPaperState() == 2) {
            getPaperResp.setPaperState("初审");
        } else if (paperEntity.getPaperState() == 3) {
            getPaperResp.setPaperState("外审");
        } else if (paperEntity.getPaperState() == 4) {
            getPaperResp.setPaperState("复审");
        } else if (paperEntity.getPaperState() == 5) {
            getPaperResp.setPaperState("录用");
        } else if (paperEntity.getPaperState() == 6) {
            getPaperResp.setPaperState("在线");
        } else if (paperEntity.getPaperState() == 7) {
            getPaperResp.setPaperState("出版");
        } else {
            getPaperResp.setPaperState("未知");
        }

        if (paperEntity.getState() == 1) {
            getPaperResp.setStatus("待审核");
        } else if (paperEntity.getState() == 2) {
            getPaperResp.setStatus("已通过");
        } else {
            getPaperResp.setStatus("已删除");
        }
        return getPaperResp;
    }

    @Override
    public PatentEntity createPatentEntity(EditPatentRequ editPatentRequ) throws ParseException {
        PatentEntity patentEntity = new PatentEntity();
        patentEntity.setStuId(editPatentRequ.getStuId());
        patentEntity.setProofMaterialId(editPatentRequ.getProofMaterialId());
        patentEntity.setPatentName(editPatentRequ.getPatentName());
        patentEntity.setPatentType(editPatentRequ.getPatentType());
        patentEntity.setPatentState(editPatentRequ.getPatentState());
        patentEntity.setRanking(editPatentRequ.getRanking());
        patentEntity.setTotalNumber(editPatentRequ.getTotalNumber());
        patentEntity.setState(1);
        patentEntity.setScore(0);
        patentEntity.setCreatedTime(DateUtil.getChinaDateTime(editPatentRequ.getGetDate()));
        return patentEntity;
    }

    @Override
    public GetPatentResp createGetPatentResp(PatentEntity patentResp) {
        GetPatentResp getPatentResp = new GetPatentResp();
        getPatentResp.setId(patentResp.getId());
        getPatentResp.setStuId(patentResp.getStuId());
        getPatentResp.setPatentName(patentResp.getPatentName());
        getPatentResp.setRanking(patentResp.getRanking());
        getPatentResp.setTotalNumber(patentResp.getTotalNumber());
        getPatentResp.setGetDate(patentResp.getCreatedTime().split(" ")[0]);
        getPatentResp.setScore(patentResp.getScore());
        getPatentResp.setProofMaterialId(patentResp.getProofMaterialId());
        if (patentResp.getState() == 1) {
            getPatentResp.setStatus("待审核");
        } else if (patentResp.getState() == 2) {
            getPatentResp.setStatus("已通过");
        } else {
            getPatentResp.setStatus("已删除");
        }
//        1-实用新型专利,2-发明专利
        if (patentResp.getPatentType() == 1) {
            getPatentResp.setPatentType("实用新型专利");
        } else {
            getPatentResp.setPatentType("发明专利");
        }
            // 专利状态：1-申请,2-受理,3-审查中,4-一审,5-二审,6-三审,7-授权
        if (patentResp.getPatentState() == 1) {
            getPatentResp.setPatentState("申请");
        } else if (patentResp.getPatentState() == 2) {
            getPatentResp.setPatentState("受理");
        } else if (patentResp.getPatentState() == 3) {
            getPatentResp.setPatentState("审查中");
        } else if (patentResp.getPatentState() == 4) {
            getPatentResp.setPatentState("一审");
        } else if (patentResp.getPatentState() == 5) {
            getPatentResp.setPatentState("二审");
        } else if (patentResp.getPatentState() == 6) {
            getPatentResp.setPatentState("三审");
        } else {
            getPatentResp.setPatentState("授权");
        }

        return getPatentResp;
    }

    @Override
    public CompetitionEntity createCompetitionEntity(EditCompetitionRequ editCompetitionRequ) throws ParseException {
        CompetitionEntity competitionEntity = new CompetitionEntity();
        competitionEntity.setStuId(editCompetitionRequ.getStuId());
        competitionEntity.setCompetitionName(editCompetitionRequ.getCompetitionName());
        competitionEntity.setCompetitionType(editCompetitionRequ.getCompetitionType());
        competitionEntity.setCompetitionLevel(editCompetitionRequ.getCompetitionLevel());
        competitionEntity.setCompetitionPrize(editCompetitionRequ.getCompetitionPrize());
        competitionEntity.setCompetitionState(editCompetitionRequ.getCompetitionState());
        competitionEntity.setCreatedTime(DateUtil.getChinaDateTime(editCompetitionRequ.getGetDate()));
        competitionEntity.setProofMaterialId(editCompetitionRequ.getProofMaterialId());
        competitionEntity.setRanking(editCompetitionRequ.getRanking());
        competitionEntity.setTotalNumber(editCompetitionRequ.getTotalNumber());
        competitionEntity.setScore(0);
        competitionEntity.setState(1);
        competitionEntity.setTeacher(editCompetitionRequ.getTeacher());
        return competitionEntity;
    }

    @Override
    public GetCompetitionResp createGetCompetitionResp(CompetitionEntity competitionEntity) {
        GetCompetitionResp getCompetitionResp = new GetCompetitionResp();
        BeanUtils.copyProperties(competitionEntity, getCompetitionResp);
        getCompetitionResp.setGetDate(competitionEntity.getCreatedTime().split(" ")[0]);
        if (competitionEntity.getState() == 1) {
            getCompetitionResp.setStatus("待审核");
        } else if (competitionEntity.getState() == 2) {
            getCompetitionResp.setStatus("已通过");
        } else {
            getCompetitionResp.setStatus("已删除");
        }
        return getCompetitionResp;
    }

    @Override
    public InnovativeProEntity createInnoProEntity(EditInnoProRequ editInnoProRequ) throws ParseException {
        InnovativeProEntity innovativeProEntity = new InnovativeProEntity();
        BeanUtils.copyProperties(editInnoProRequ, innovativeProEntity);
        innovativeProEntity.setCreatedTime(DateUtil.getChinaDateTime(editInnoProRequ.getGetDate()));
        innovativeProEntity.setScore(0);
        innovativeProEntity.setState(1);
        return innovativeProEntity;
    }

    @Override
    public GetInnoProResp createGetInnoProResp(InnovativeProEntity innovativeProEntity) {
        GetInnoProResp getInnoProResp = new GetInnoProResp();
        BeanUtils.copyProperties(innovativeProEntity, getInnoProResp);
        getInnoProResp.setGetDate(innovativeProEntity.getCreatedTime().split(" ")[0]);
        if (innovativeProEntity.getState() == 1) {
            getInnoProResp.setStatus("待审核");
        } else if (innovativeProEntity.getState() == 2) {
            getInnoProResp.setStatus("已通过");
        } else {
            getInnoProResp.setStatus("已删除");
        }
        return getInnoProResp;
    }

    @Override
    public EntrepreneurialProEntity createEntrProEntity(EditInnoProRequ editInnoProRequ) throws ParseException {
        EntrepreneurialProEntity entrepreneurialProEntity = new EntrepreneurialProEntity();
        BeanUtils.copyProperties(editInnoProRequ, entrepreneurialProEntity);
        entrepreneurialProEntity.setCreatedTime(DateUtil.getChinaDateTime(editInnoProRequ.getGetDate()));
        entrepreneurialProEntity.setScore(0);
        entrepreneurialProEntity.setState(1);
        return entrepreneurialProEntity;
    }

    @Override
    public GetInnoProResp createGetInnoProResp(EntrepreneurialProEntity entrepreneurialProEntity) {
        GetInnoProResp getInnoProResp = new GetInnoProResp();
        BeanUtils.copyProperties(entrepreneurialProEntity, getInnoProResp);
        getInnoProResp.setGetDate(entrepreneurialProEntity.getCreatedTime().split(" ")[0]);
        if (entrepreneurialProEntity.getState() == 1) {
            getInnoProResp.setStatus("待审核");
        } else if (entrepreneurialProEntity.getState() == 2) {
            getInnoProResp.setStatus("已通过");
        } else {
            getInnoProResp.setStatus("已删除");
        }
        return getInnoProResp;
    }

    @Override
    public EngineeringProEntity createEngiProEntity(EditEngiProRequ editEngiProRequ) throws ParseException {
        EngineeringProEntity engineeringProEntity = new EngineeringProEntity();
        BeanUtils.copyProperties(editEngiProRequ, engineeringProEntity);
        engineeringProEntity.setCreatedTime(DateUtil.getChinaDateTime(editEngiProRequ.getGetDate()));
        engineeringProEntity.setScore(0);
        engineeringProEntity.setState(1);
        return engineeringProEntity;
    }

    @Override
    public GetEngiProResp createGetEngiProResp(EngineeringProEntity engineeringProEntity) {
        GetEngiProResp getEngiProResp = new GetEngiProResp();
        BeanUtils.copyProperties(engineeringProEntity, getEngiProResp);
        getEngiProResp.setGetDate(engineeringProEntity.getCreatedTime().split(" ")[0]);
        if (engineeringProEntity.getState() == 1) {
            getEngiProResp.setStatus("待审核");
        } else if (engineeringProEntity.getState() == 2) {
            getEngiProResp.setStatus("已通过");
        } else {
            getEngiProResp.setStatus("已删除");
        }
        return getEngiProResp;
    }

    @Override
    public AcademicExchangeEntity createAcadExchEntity(EditAcadExchRequ editAcadExchRequ) throws ParseException {
        AcademicExchangeEntity academicExchangeEntity = new AcademicExchangeEntity();
        BeanUtils.copyProperties(editAcadExchRequ, academicExchangeEntity);
        academicExchangeEntity.setStartTime(DateUtil.getChinaDateTime(editAcadExchRequ.getStartTime()));
        academicExchangeEntity.setEndTime(DateUtil.getChinaDateTime(editAcadExchRequ.getEndTime()));
        academicExchangeEntity.setScore(0);
        academicExchangeEntity.setState(1);
        return academicExchangeEntity;
    }

    @Override
    public GetAcadExchResp createGetAcadExchResp(AcademicExchangeEntity academicExchangeEntity) {
        GetAcadExchResp getAcadExchResp = new GetAcadExchResp();
        BeanUtils.copyProperties(academicExchangeEntity, getAcadExchResp);
        getAcadExchResp.setStartTime(academicExchangeEntity.getStartTime().split(" ")[0]);
        getAcadExchResp.setEndTime(academicExchangeEntity.getEndTime().split(" ")[0]);
        if (academicExchangeEntity.getState() == 1) {
            getAcadExchResp.setStatus("待审核");
        } else if (academicExchangeEntity.getState() == 2) {
            getAcadExchResp.setStatus("已通过");
        } else {
            getAcadExchResp.setStatus("已删除");
        }
        return getAcadExchResp;
    }

    @Override
    public WorkEntity createdWorkEntity(EditWorkRequ editWorkRequ) throws ParseException {
        WorkEntity workEntity = new WorkEntity();
        BeanUtils.copyProperties(editWorkRequ, workEntity);
        workEntity.setCreatedTime(DateUtil.getChinaDateTime(editWorkRequ.getGetDate()));
        workEntity.setScore(0);
        workEntity.setState(1);
        return workEntity;
    }

    @Override
    public GetWorkResp createGetWorkResp(WorkEntity workEntity) {
        GetWorkResp getWorkResp = new GetWorkResp();
        BeanUtils.copyProperties(workEntity, getWorkResp);
       getWorkResp.setGetDate(workEntity.getCreatedTime().split(" ")[0]);
        if (workEntity.getState() == 1) {
            getWorkResp.setStatus("待审核");
        } else if (workEntity.getState() == 2) {
            getWorkResp.setStatus("已通过");
        } else {
            getWorkResp.setStatus("已删除");
        }
        return getWorkResp;
    }

    @Override
    public MasterPaperEntity createMasterPaperEntity(EditMasterPaperRequ editMasterPaperRequ) throws ParseException {
        MasterPaperEntity masterPaperEntity = new MasterPaperEntity();
        BeanUtils.copyProperties(editMasterPaperRequ, masterPaperEntity);
        masterPaperEntity.setCreatedTime(DateUtil.getChinaDateTime(editMasterPaperRequ.getGetDate()));
        masterPaperEntity.setScore(0);
        masterPaperEntity.setState(1);
        return masterPaperEntity;
    }

    @Override
    public GetMasterPaperResp createGetMasterPaperResp(MasterPaperEntity masterPaperEntity) {
        GetMasterPaperResp getMasterPaperResp = new GetMasterPaperResp();
        BeanUtils.copyProperties(masterPaperEntity, getMasterPaperResp);
        getMasterPaperResp.setGetDate(masterPaperEntity.getCreatedTime().split(" ")[0]);
        if (masterPaperEntity.getState() == 1) {
            getMasterPaperResp.setStatus("待审核");
        } else if (masterPaperEntity.getState() == 2) {
            getMasterPaperResp.setStatus("已通过");
        } else {
            getMasterPaperResp.setStatus("已删除");
        }
        return getMasterPaperResp;
    }

    @Override
    public GetPrizeForTeacherResp createGetPrizeResp(AllPrizeEntity allPrizeEntity, Integer allStuNum) {
        GetPrizeForTeacherResp getPrizeForTeacherResp = new GetPrizeForTeacherResp();
        BeanUtils.copyProperties(allPrizeEntity, getPrizeForTeacherResp);
        getPrizeForTeacherResp.setCompetitionNum(String.valueOf(allPrizeEntity.getCompetitionNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setEngiNum(String.valueOf(allPrizeEntity.getEngiNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setEntrNum(String.valueOf(allPrizeEntity.getEntrNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setExchNum(String.valueOf(allPrizeEntity.getExchNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setHonorNum(String.valueOf(allPrizeEntity.getHonorNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setInnoNum(String.valueOf(allPrizeEntity.getInnoNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setMasterNum(String.valueOf(allPrizeEntity.getMasterNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setMasterNum(String.valueOf(allPrizeEntity.getMasterNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setPaperNum(String.valueOf(allPrizeEntity.getPaperNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setPatentNum(String.valueOf(allPrizeEntity.getPatentNum())+"/"+String.valueOf(allStuNum));
        getPrizeForTeacherResp.setWorkNum(String.valueOf(allPrizeEntity.getWorkNum())+"/"+String.valueOf(allStuNum));
        return getPrizeForTeacherResp;
    }

    @Override
    public ProjectsEntity createProjectEntity(EditProjectRequ editProjectRequ) throws ParseException {
        ProjectsEntity projectsEntity = new ProjectsEntity();
        BeanUtils.copyProperties(editProjectRequ, projectsEntity);
        if ("创业项目".equals(editProjectRequ.getProClass())) {
            projectsEntity.setProType(" ");
        }
        projectsEntity.setProTime(DateUtil.getChinaDateTime(editProjectRequ.getProTime()).split(" ")[0]);
        projectsEntity.setScore(0);
        projectsEntity.setState(1);
        return projectsEntity;
    }

    @Override
    public GetProjectResp createGetProjectResp(ProjectsEntity projectsEntity) {
        GetProjectResp getProjectResp = new GetProjectResp();
        BeanUtils.copyProperties(projectsEntity, getProjectResp);
        if (projectsEntity.getState() == 1) {
            getProjectResp.setState("待审核");
        } else if (projectsEntity.getState() == 2) {
            getProjectResp.setState("已通过");
        } else {
            getProjectResp.setState("已删除");
        }
        return getProjectResp;
    }
}
