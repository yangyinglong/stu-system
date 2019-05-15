package cn.hdu.fragmentTax.service.impl.model;

import cn.hdu.fragmentTax.dao.entity.*;
import cn.hdu.fragmentTax.model.request.*;
import cn.hdu.fragmentTax.model.response.*;

import java.text.ParseException;

public interface IPrizeModel {
    HonorEntity createHonorEntity(EditHonorResp editHonorResp) throws ParseException;

    GetHonorResp createGetHonorResp(HonorEntity honorEntity);

    GetPrizesResp createGetPrizesResp(AllPrizeEntity allPrizeEntity);

    PaperEntity createPaperEntity(EditPaperRequ editPaperRequ) throws ParseException;

    GetPaperResp createGetPaperResp(PaperEntity paperEntity);

    PatentEntity createPatentEntity(EditPatentRequ editPatentRequ) throws ParseException;

    GetPatentResp createGetPatentResp(PatentEntity patentResp);

    CompetitionEntity createCompetitionEntity(EditCompetitionRequ editCompetitionRequ) throws ParseException;

    GetCompetitionResp createGetCompetitionResp(CompetitionEntity competitionEntity);

    InnovativeProEntity createInnoProEntity(EditInnoProRequ editInnoProRequ) throws ParseException;

    GetInnoProResp createGetInnoProResp(InnovativeProEntity innovativeProEntity);

    EntrepreneurialProEntity createEntrProEntity(EditInnoProRequ editInnoProRequ) throws ParseException;

    GetInnoProResp createGetInnoProResp(EntrepreneurialProEntity entrepreneurialProEntity);

    EngineeringProEntity createEngiProEntity(EditEngiProRequ editEngiProRequ) throws ParseException;

    GetEngiProResp createGetEngiProResp(EngineeringProEntity engineeringProEntity);

    AcademicExchangeEntity createAcadExchEntity(EditAcadExchRequ editAcadExchRequ) throws ParseException;

    GetAcadExchResp createGetAcadExchResp(AcademicExchangeEntity academicExchangeEntity);

    WorkEntity createdWorkEntity(EditWorkRequ editWorkRequ) throws ParseException;

    GetWorkResp createGetWorkResp(WorkEntity workEntity);

    MasterPaperEntity createMasterPaperEntity(EditMasterPaperRequ editMasterPaperRequ) throws ParseException;

    GetMasterPaperResp createGetMasterPaperResp(MasterPaperEntity masterPaperEntity);

    GetPrizeForTeacherResp createGetPrizeResp(AllPrizeEntity allPrizeEntity, Integer allStuNum);

    ProjectsEntity createProjectEntity(EditProjectRequ editProjectRequ) throws ParseException;

    GetProjectResp createGetProjectResp(ProjectsEntity projectsEntity);
}
