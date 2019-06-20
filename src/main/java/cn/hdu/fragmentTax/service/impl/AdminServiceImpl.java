package cn.hdu.fragmentTax.service.impl;

import cn.hdu.fragmentTax.dao.entity.*;
import cn.hdu.fragmentTax.dao.mapper.*;
import cn.hdu.fragmentTax.model.request.AdminExamRequ;
import cn.hdu.fragmentTax.model.request.QueryRequ;
import cn.hdu.fragmentTax.model.response.*;
import cn.hdu.fragmentTax.service.IAdminService;
import cn.hdu.fragmentTax.service.impl.model.IAdminModel;
import cn.hdu.fragmentTax.utils.DateUtil;
import cn.hdu.fragmentTax.utils.ExcelUtil;
import cn.hdu.fragmentTax.utils.FormatUtil;
import cn.hdu.fragmentTax.utils.PropertiesUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements IAdminService {


    @Autowired
    private IHonorMapper honorMapper;

    @Autowired
    private IPaperMapper paperMapper;

    @Autowired
    private IAllPrizeMapper allPrizeMapper;

    @Autowired
    private IPatentMapper patentMapper;

    @Autowired
    private ICompetitionMapper competitionMapper;

    @Autowired
    private IInnovativeProMapper innovativeProMapper;

    @Autowired
    private IEntrepreneurialProMapper entrepreneurialProMapper;

    @Autowired
    private IAcademicExchangeMapper academicExchangeMapper;

    @Autowired
    private IEngineeringProMapper engineeringProMapper;

    @Autowired
    private IWorkMapper workMapper;

    @Autowired
    private IMasterPaperMapper masterPaperMapper;

    @Autowired
    private IAdminModel adminModel;

    @Autowired
    private IStuBaseMapper stuBaseMapper;

    @Autowired
    private ITutorsMapper tutorsMapper;

    @Autowired
    private ICounsellorsMapper counsellorsMapper;

    @Autowired
    private IScoreEntranceMapper scoreEntranceMapper;

    @Autowired
    private IScoreAllMapper scoreAllMapper;

    @Autowired
    private IScoreAverageMapper scoreAverageMapper;

    @Autowired
    private IProjectsMapper projectsMapper;

    @Override
    public Map<String, Object> showHonorsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<HonorEntity> honorEntities = null;
        List<GetHonorResp> getHonorResps = new LinkedList<GetHonorResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getHonorResps);
            return resp;
        }
        honorEntities = honorMapper.queryForTutor(status, stuIds, queryRequ.getHonorType(), (queryRequ.getPage()-1)*10);
        for (HonorEntity honorEntity : honorEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(honorEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetHonorResp getHonorResp = adminModel.createGetHonorResp(honorEntity, stuBaseEntity);
            getHonorResps.add(getHonorResp);
        }
        resp.put("c", 200);
        resp.put("r", getHonorResps);
        return resp;
    }

    @Override
    public Map<String, Object> examHonor(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            honorMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allHonorScore = 0.0f;
            List<HonorEntity> honorEntities = honorMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (HonorEntity honorEntity : honorEntities) {
                allHonorScore = allHonorScore + honorEntity.getScore();
            }
            allPrizeMapper.updateHonorScore(adminExamRequ.getStuId(), allHonorScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByHonor();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateHonorNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showPapersForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PaperEntity> paperEntities = null;
        List<GetPaperResp> getPaperResps = new LinkedList<GetPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getPaperResps);
            return resp;
        }
        paperEntities = paperMapper.queryForTutor(status, stuIds, queryRequ.getPaperGrade(), (queryRequ.getPage()-1)*10);
        for (PaperEntity paperEntity : paperEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(paperEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetPaperResp getPaperResp = adminModel.createGetPaperResp(paperEntity, stuBaseEntity);
            getPaperResps.add(getPaperResp);
        }
        resp.put("c", 200);
        resp.put("r", getPaperResps);
        return resp;
    }

    @Override
    public Map<String, Object> examPaper(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            paperMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allPaperScore = 0.0f;
            List<PaperEntity> paperEntities = paperMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (PaperEntity paperEntity : paperEntities) {
                allPaperScore = allPaperScore + paperEntity.getScore();
            }
            allPrizeMapper.updatePaperScore(adminExamRequ.getStuId(), allPaperScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByPaper();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updatePaperNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showPatentsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PatentEntity> patentEntities = null;
        List<GetPatentResp> getPatentResps = new LinkedList<GetPatentResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getPatentResps);
            return resp;
        }
        patentEntities = patentMapper.queryForTutor(status, stuIds, queryRequ.getPatentType(), queryRequ.getPatentState(), (queryRequ.getPage()-1)*10);
        for (PatentEntity patentEntity : patentEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(patentEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetPatentResp getPatentResp = adminModel.createGetPatentResp(patentEntity, stuBaseEntity);
            getPatentResps.add(getPatentResp);
        }
        resp.put("c", 200);
        resp.put("r", getPatentResps);
        return resp;
    }

    @Override
    public Map<String, Object> examPatent(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            patentMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allPatentScore = 0.0f;
            List<PatentEntity> patentEntities = patentMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (PatentEntity patentEntity : patentEntities) {
                allPatentScore = allPatentScore + patentEntity.getScore();
            }
            allPrizeMapper.updatePatentScore(adminExamRequ.getStuId(), allPatentScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByPatent();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updatePatentNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showCompetitionsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<CompetitionEntity> competitionEntities = null;
        List<GetCompetitionResp> getCompetitionResps = new LinkedList<GetCompetitionResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getCompetitionResps);
            return resp;
        }
        competitionEntities = competitionMapper.queryForTutor(status, stuIds, queryRequ.getCompetitionType(), queryRequ.getCompetitionLevel(), (queryRequ.getPage()-1)*10);
        for (CompetitionEntity competitionEntity : competitionEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(competitionEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetCompetitionResp getCompetitionResp = adminModel.createGetCompetitionResp(competitionEntity, stuBaseEntity);
            getCompetitionResps.add(getCompetitionResp);
        }
        resp.put("c", 200);
        resp.put("r", getCompetitionResps);
        return resp;
    }

    @Override
    public Map<String, Object> examCompetition(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            competitionMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allCompetitionScore = 0.0f;
            List<CompetitionEntity> competitionEntities = competitionMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (CompetitionEntity competitionEntity : competitionEntities) {
                allCompetitionScore = allCompetitionScore + competitionEntity.getScore();
            }
            allPrizeMapper.updateCompetitionScore(adminExamRequ.getStuId(), allCompetitionScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByCompetition();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateCompetitionNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showEntrProsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<EntrepreneurialProEntity> entrepreneurialProEntities = null;
        List<GetInnoProResp> getInnoProResps = new LinkedList<GetInnoProResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getInnoProResps);
            return resp;
        }
        entrepreneurialProEntities = entrepreneurialProMapper.queryForTutor(status, stuIds);
        for (EntrepreneurialProEntity entrepreneurialProEntity : entrepreneurialProEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(entrepreneurialProEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetInnoProResp getInnoProResp = adminModel.createGetInnoProResp(entrepreneurialProEntity, stuBaseEntity);
            getInnoProResps.add(getInnoProResp);
        }
        resp.put("c", 200);
        resp.put("r", getInnoProResps);
        return resp;
    }

    @Override
    public Map<String, Object> examEntrPro(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            entrepreneurialProMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allEntrProScore = 0.0f;
            List<EntrepreneurialProEntity> entrepreneurialProEntities = entrepreneurialProMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (EntrepreneurialProEntity entrepreneurialProEntity : entrepreneurialProEntities) {
                allEntrProScore = allEntrProScore + entrepreneurialProEntity.getScore();
            }
            allPrizeMapper.updateEntrProScore(adminExamRequ.getStuId(), allEntrProScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByEntrPro();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateEntrProNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showInnoProsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<InnovativeProEntity> innovativeProEntities = null;
        List<GetInnoProResp> getInnoProResps = new LinkedList<GetInnoProResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getInnoProResps);
            return resp;
        }
        innovativeProEntities = innovativeProMapper.queryForTutor(status, stuIds);
        for (InnovativeProEntity innovativeProEntity : innovativeProEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(innovativeProEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetInnoProResp getInnoProResp = adminModel.createGetInnoProResp(innovativeProEntity, stuBaseEntity);
            getInnoProResps.add(getInnoProResp);
        }
        resp.put("c", 200);
        resp.put("r", getInnoProResps);
        return resp;
    }

    @Override
    public Map<String, Object> examInnoPro(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            innovativeProMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allInnoProScore = 0.0f;
            List<InnovativeProEntity> innovativeProEntities = innovativeProMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (InnovativeProEntity innovativeProEntity : innovativeProEntities) {
                allInnoProScore = allInnoProScore + innovativeProEntity.getScore();
            }
            allPrizeMapper.updateInnoProScore(adminExamRequ.getStuId(), allInnoProScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByInnoPro();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateInnoProNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showEngiProsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<EngineeringProEntity> engineeringProEntities = null;
        List<GetEngiProResp> getEngiProResps = new LinkedList<GetEngiProResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getEngiProResps);
            return resp;
        }
        engineeringProEntities = engineeringProMapper.queryForTutor(status, stuIds);
        for (EngineeringProEntity engineeringProEntity : engineeringProEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(engineeringProEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetEngiProResp getEngiProResp = adminModel.createGetEngiProResp(engineeringProEntity, stuBaseEntity);
            getEngiProResps.add(getEngiProResp);
        }
        resp.put("c", 200);
        resp.put("r", getEngiProResps);
        return resp;
    }

    @Override
    public Map<String, Object> examEngiPro(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            engineeringProMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allEngiProScore = 0.0f;
            List<EngineeringProEntity> engineeringProEntities = engineeringProMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (EngineeringProEntity engineeringProEntity : engineeringProEntities) {
                allEngiProScore = allEngiProScore + engineeringProEntity.getScore();
            }
            allPrizeMapper.updateEngiProScore(adminExamRequ.getStuId(), allEngiProScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByEngiPro();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateEngiProNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showAcadExchsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<AcademicExchangeEntity> academicExchangeEntities = null;
        List<GetAcadExchResp> getAcadExchResps = new LinkedList<GetAcadExchResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getAcadExchResps);
            return resp;
        }
        academicExchangeEntities = academicExchangeMapper.queryForTutor(status, stuIds, queryRequ.getExchangeType(), (queryRequ.getPage()-1)*10);
        for (AcademicExchangeEntity academicExchangeEntity : academicExchangeEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(academicExchangeEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetAcadExchResp getAcadExchResp = adminModel.createGetAcadExchResp(academicExchangeEntity, stuBaseEntity);
            getAcadExchResps.add(getAcadExchResp);
        }
        resp.put("c", 200);
        resp.put("r", getAcadExchResps);
        return resp;
    }

    @Override
    public Map<String, Object> examAcadExch(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            academicExchangeMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allAcadExchScore = 0.0f;
            List<AcademicExchangeEntity> academicExchangeEntities = academicExchangeMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (AcademicExchangeEntity academicExchangeEntity : academicExchangeEntities) {
                allAcadExchScore = allAcadExchScore + academicExchangeEntity.getScore();
            }
            allPrizeMapper.updateAcadExchScore(adminExamRequ.getStuId(), allAcadExchScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByAcadExch();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateAcadExchNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showMasterPapersForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<MasterPaperEntity> masterPaperEntities = null;
        List<GetMasterPaperResp> getMasterPaperResps = new LinkedList<GetMasterPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getMasterPaperResps);
            return resp;
        }
        masterPaperEntities = masterPaperMapper.queryForTutor(status, stuIds, (queryRequ.getPage()-1)*10);
        for (MasterPaperEntity masterPaperEntity : masterPaperEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(masterPaperEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetMasterPaperResp getMasterPaperResp = adminModel.createGetMasterPaperResp(masterPaperEntity, stuBaseEntity);
            getMasterPaperResps.add(getMasterPaperResp);
        }
        resp.put("c", 200);
        resp.put("r", getMasterPaperResps);
        return resp;
    }

    @Override
    public Map<String, Object> examMasterPaper(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            masterPaperMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allMasterPaperScore = 0.0f;
            List<MasterPaperEntity> masterPaperEntities = masterPaperMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (MasterPaperEntity masterPaperEntity : masterPaperEntities) {
                allMasterPaperScore = allMasterPaperScore + masterPaperEntity.getScore();
            }
            allPrizeMapper.updateMasterPaperScore(adminExamRequ.getStuId(), allMasterPaperScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByMasterPaper();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateMasterPaperNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showWorksForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<WorkEntity> workEntities = null;
        List<GetWorkResp> getWorkResps = new LinkedList<GetWorkResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getWorkResps);
            return resp;
        }
        workEntities = workMapper.queryForTutor(status, stuIds, queryRequ.getWorkType(), (queryRequ.getPage()-1)*10);
        for (WorkEntity workEntity : workEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(workEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetWorkResp getWorkResp = adminModel.createGetWorkResp(workEntity, stuBaseEntity);
            getWorkResps.add(getWorkResp);
        }
        resp.put("c", 200);
        resp.put("r", getWorkResps);
        return resp;
    }

    @Override
    public Map<String, Object> examWork(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
            workMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allWorkScore = 0.0f;
            List<WorkEntity> workEntities = workMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (WorkEntity workEntity : workEntities) {
                allWorkScore = allWorkScore + workEntity.getScore();
            }
            allPrizeMapper.updateWorkScore(adminExamRequ.getStuId(), allWorkScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByWork();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateWorkNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showStusForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetStuForTeacherResp> getStuForTeacherResps = new LinkedList<GetStuForTeacherResp>();
        if (queryRequ.getState() == 1) {
//            辅导员查询
//            stuBaseEntities = stuBaseMapper.queryAll();
            stuBaseEntities = stuBaseMapper.queryForCounerWithPage(queryRequ.getStuId(), queryRequ.getStuName(), (queryRequ.getPage()-1)*10);
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorIdWithPage(queryRequ.getUserId(), (queryRequ.getPage()-1)*10);
        }
        for (StuBaseEntity stuBaseEntity : stuBaseEntities) {
            TutorsEntity tutorsEntity = tutorsMapper.queryByTuId(stuBaseEntity.getTutorId());
            CounsellorsEntity counsellorsEntity = counsellorsMapper.queryByCoId(stuBaseEntity.getCounsellorId());
            ScoreEntranceEntity scoreEntranceEntity = scoreEntranceMapper.queryByStuId(stuBaseEntity.getStuId());
            ScoreAverageEntity scoreAverageEntity = scoreAverageMapper.queryByStuId(stuBaseEntity.getStuId());
            GetStuForTeacherResp getStuForTeacherResp = adminModel.createGetStuForTeacherResp(stuBaseEntity, tutorsEntity, counsellorsEntity, scoreEntranceEntity, scoreAverageEntity);
            getStuForTeacherResps.add(getStuForTeacherResp);
        }
        resp.put("c", 200);
        resp.put("r", getStuForTeacherResps);
        return resp;
    }

    @Override
    public Map<String, Object> showAllPrizeForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<AllPrizeEntity> allPrizeEntities = null;
        List<GetPrizeForTeacherResp> getPrizeForTeacherResps = new LinkedList<GetPrizeForTeacherResp>();
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        allPrizeEntities = allPrizeMapper.queryByStuIdWithPage(stuIds, (queryRequ.getPage()-1)*10);
        Integer allStuNum = stuBaseMapper.queryCount();
        for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(allPrizeEntity.getStuId());
            GetPrizeForTeacherResp getPrizeForTeacherResp = adminModel.createGetPrizeForTeacherResp(allPrizeEntity, stuBaseEntity, allStuNum);
            getPrizeForTeacherResps.add(getPrizeForTeacherResp);
        }
//        for (StuBaseEntity stuBaseEntity : stuBaseEntities) {
//            AllPrizeEntity allPrizeEntity = allPrizeMapper.queryByStuId(stuBaseEntity.getStuId());
//            GetPrizeForTeacherResp getPrizeForTeacherResp = adminModel.createGetPrizeForTeacherResp(allPrizeEntity, stuBaseEntity, allStuNum);
//            getPrizeForTeacherResps.add(getPrizeForTeacherResp);
//        }
        resp.put("c", 200);
        resp.put("r", getPrizeForTeacherResps);
        return resp;
    }

    @Override
    public Map<String, Object> showScoresForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetAllScoreResp> getAllScoreResps = new LinkedList<GetAllScoreResp>();
        List<ScoreAllEntity> scoreAllEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        scoreAllEntities = scoreAllMapper.queryByStuIdWithPage(stuIds, (queryRequ.getPage()-1)*10);
        for (ScoreAllEntity scoreAllEntity: scoreAllEntities) {
            ScoreAverageEntity scoreAverageEntity = scoreAverageMapper.queryByStuId(scoreAllEntity.getStuId());
            if (FormatUtil.isEmpty(scoreAllEntity)) {
                continue;
            }
            GetAllScoreResp getAllScoreResp = adminModel.createGetAllScoreResp(scoreAllEntity);
            getAllScoreResp.setStuId(scoreAllEntity.getStuId());
            getAllScoreResp.setName(stuBaseMapper.queryByStuId(scoreAllEntity.getStuId()).getName());
            getAllScoreResp.setCurrNumber(scoreAverageEntity.getCurrNumber());
            getAllScoreResp.setAverageScore(scoreAverageEntity.getAverageScore());
            getAllScoreResp.setWeightedAverageScore(scoreAverageEntity.getWeightedAverageScore());
            getAllScoreResp.setHadCredit(scoreAverageEntity.getHadCredit());
            getAllScoreResps.add(getAllScoreResp);
        }


//        for (StuBaseEntity stuBaseEntity : stuBaseEntities) {
//            ScoreAllEntity scoreAllEntity = scoreAllMapper.queryByStuId(stuBaseEntity.getStuId());
//            ScoreAverageEntity scoreAverageEntity = scoreAverageMapper.queryByStuId(stuBaseEntity.getStuId());
//            if (FormatUtil.isEmpty(scoreAllEntity)) {
//                continue;
//            }
//            GetAllScoreResp getAllScoreResp = adminModel.createGetAllScoreResp(scoreAllEntity);
//            getAllScoreResp.setStuId(stuBaseEntity.getStuId());
//            getAllScoreResp.setName(stuBaseEntity.getName());
//            getAllScoreResp.setCurrNumber(scoreAverageEntity.getCurrNumber());
//            getAllScoreResp.setAverageScore(scoreAverageEntity.getAverageScore());
//            getAllScoreResp.setWeightedAverageScore(scoreAverageEntity.getWeightedAverageScore());
//            getAllScoreResp.setHadCredit(scoreAverageEntity.getHadCredit());
//            getAllScoreResps.add(getAllScoreResp);
//        }
        resp.put("c", 200);
        resp.put("r", getAllScoreResps);
        return resp;
    }

    @Override
    public Map<String, Object> downStusForTeacher(QueryRequ queryRequ) {
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetStuForTeacherResp> getStuForTeacherResps = new LinkedList<GetStuForTeacherResp>();
        if (queryRequ.getState() == 1) {
//            辅导员查询
//            stuBaseEntities = stuBaseMapper.queryAll();
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        for (StuBaseEntity stuBaseEntity : stuBaseEntities) {
            TutorsEntity tutorsEntity = tutorsMapper.queryByTuId(stuBaseEntity.getTutorId());
            CounsellorsEntity counsellorsEntity = counsellorsMapper.queryByCoId(stuBaseEntity.getCounsellorId());
            ScoreEntranceEntity scoreEntranceEntity = scoreEntranceMapper.queryByStuId(stuBaseEntity.getStuId());
            ScoreAverageEntity scoreAverageEntity = scoreAverageMapper.queryByStuId(stuBaseEntity.getStuId());
            GetStuForTeacherResp getStuForTeacherResp = adminModel.createGetStuForTeacherResp(stuBaseEntity, tutorsEntity, counsellorsEntity, scoreEntranceEntity, scoreAverageEntity);
            getStuForTeacherResps.add(getStuForTeacherResp);
        }
        Map<String, Object> resp = new HashMap<>();
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path"));
            int index = 1;
            for (GetStuForTeacherResp getStuForTeacherResp : getStuForTeacherResps) {
                adminModel.writeStuBaseInfoIntoExcel(workbook, getStuForTeacherResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> showProjectsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<ProjectsEntity> projectsEntities = null;
        List<GetProjectResp> getProjectResps = new LinkedList<GetProjectResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getProjectResps);
            return resp;
        }
        projectsEntities = projectsMapper.queryForTutor(status, stuIds, queryRequ.getProClass(), queryRequ.getProType(), (queryRequ.getPage()-1)*10);
        for (ProjectsEntity projectsEntity : projectsEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(projectsEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetProjectResp getProjectResp = adminModel.createGetProjectResp(projectsEntity, stuBaseEntity);
            getProjectResps.add(getProjectResp);
        }
        resp.put("c", 200);
        resp.put("r", getProjectResps);
        return resp;
    }

    @Override
    public Map<String, Object> examProject(AdminExamRequ adminExamRequ) {
        Map<String, Object> resp = new HashMap<>();
        try {
//            masterPaperMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            projectsMapper.updateScore(adminExamRequ.getId(), adminExamRequ.getScore(), 2);
            // 更新分数
            Float allMasterPaperScore = 0.0f;
            List<ProjectsEntity> projectsEntities = projectsMapper.queryByStuId(adminExamRequ.getStuId(), 2);
            for (ProjectsEntity projectsEntity : projectsEntities) {
                allMasterPaperScore = allMasterPaperScore + projectsEntity.getScore();
            }
            allPrizeMapper.updateEngiProScore(adminExamRequ.getStuId(), allMasterPaperScore);
            // 更新排名
            Integer order = 1;
            List<AllPrizeEntity> allPrizeEntities = allPrizeMapper.orderByEngiPro();
            for (AllPrizeEntity allPrizeEntity : allPrizeEntities) {
                allPrizeMapper.updateEngiProNum(allPrizeEntity.getId(), order);
                order = order + 1;
            }
            resp.put("c", 200);
            resp.put("r", "审核成功");
        } catch (Exception e) {
            resp.put("c", 401);
            resp.put("r", "数据库错误");
        }

        return  resp;
    }

    @Override
    public Map<String, Object> showStuBaseNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetStuForTeacherResp> getStuForTeacherResps = new LinkedList<GetStuForTeacherResp>();
        int stuBaseNum = 0;
        if (queryRequ.getState() == 1) {
//            辅导员查询
//            stuBaseEntities = stuBaseMapper.queryAll();
            stuBaseNum = stuBaseMapper.queryNumForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseNum = stuBaseMapper.queryNumByTutorId(queryRequ.getUserId());
        }
        resp.put("c", 200);
        resp.put("r", stuBaseNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuScoreNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetAllScoreResp> getAllScoreResps = new LinkedList<GetAllScoreResp>();
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        int stuScoreNum = 0;
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", 0);
            return resp;
        }
        stuScoreNum = scoreAllMapper.queryCountByStuIds(stuIds);
        resp.put("c", 200);
        resp.put("r", stuScoreNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuPrizeNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        List<StuBaseEntity> stuBaseEntities = null;
        List<GetAllScoreResp> getAllScoreResps = new LinkedList<GetAllScoreResp>();
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());
        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        int stuScoreNum = 0;
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", 0);
            return resp;
        }
        stuScoreNum = allPrizeMapper.queryCountByStuIds(stuIds);
        resp.put("c", 200);
        resp.put("r", stuScoreNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuHonorNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<HonorEntity> honorEntities = null;
        List<GetHonorResp> getHonorResps = new LinkedList<GetHonorResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuHonorNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", 0);
            return resp;
        }
        stuHonorNum = honorMapper.queryCountForTutor(status, stuIds, queryRequ.getHonorType());
        resp.put("c", 200);
        resp.put("r", stuHonorNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuPaperNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PaperEntity> paperEntities = null;
        List<GetPaperResp> getPaperResps = new LinkedList<GetPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuPaperNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", 0);
            return resp;
        }
        stuPaperNum = paperMapper.queryCountForTutor(status, stuIds, queryRequ.getPaperGrade());
        resp.put("c", 200);
        resp.put("r", stuPaperNum);
        return  resp;
    }

    @Override
    public Map<String, Object> showStuPatentNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PatentEntity> patentEntities = null;
        List<GetPatentResp> getPatentResps = new LinkedList<GetPatentResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuPatentNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuPatentNum);
            return resp;
        }
        stuPatentNum = patentMapper.queryCountForTutor(status, stuIds, queryRequ.getPatentType(), queryRequ.getPatentState());

        resp.put("c", 200);
        resp.put("r", stuPatentNum);
        return resp;

    }

    @Override
    public Map<String, Object> showStuCompetitionNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<CompetitionEntity> competitionEntities = null;
        List<GetCompetitionResp> getCompetitionResps = new LinkedList<GetCompetitionResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuCompetitionNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuCompetitionNum);
            return resp;
        }
        stuCompetitionNum = competitionMapper.queryCountForTutor(status, stuIds, queryRequ.getCompetitionType(), queryRequ.getCompetitionLevel());
        resp.put("c", 200);
        resp.put("r", stuCompetitionNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuProjectNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<ProjectsEntity> projectsEntities = null;
        List<GetProjectResp> getProjectResps = new LinkedList<GetProjectResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuProjectNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuProjectNum);
            return resp;
        }
        stuProjectNum = projectsMapper.queryCountForTutor(status, stuIds, queryRequ.getProClass(), queryRequ.getProType());
        resp.put("c", 200);
        resp.put("r", stuProjectNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuAcadExchNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<AcademicExchangeEntity> academicExchangeEntities = null;
        List<GetAcadExchResp> getAcadExchResps = new LinkedList<GetAcadExchResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        int stuAcadExchNum = 0;
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuAcadExchNum);
            return resp;
        }
        stuAcadExchNum = academicExchangeMapper.queryCountForTutor(status, stuIds, queryRequ.getExchangeType());
        resp.put("c", 200);
        resp.put("r", stuAcadExchNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuWorkNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<WorkEntity> workEntities = null;
        List<GetWorkResp> getWorkResps = new LinkedList<GetWorkResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        int stuWorkNum = 0;
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuWorkNum);
            return resp;
        }
        stuWorkNum = workMapper.queryCountForTutor(status, stuIds, queryRequ.getWorkType());
        resp.put("c", 200);
        resp.put("r", stuWorkNum);
        return resp;
    }

    @Override
    public Map<String, Object> showStuMasterPaperNum(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<MasterPaperEntity> masterPaperEntities = null;
        List<GetMasterPaperResp> getMasterPaperResps = new LinkedList<GetMasterPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        int stuMasterPaperNum = 0;
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", stuMasterPaperNum);
            return resp;
        }
        stuMasterPaperNum = masterPaperMapper.queryCountForTutor(status, stuIds);
        resp.put("c", 200);
        resp.put("r", stuMasterPaperNum);
        return resp;
    }

    @Override
    public Map<String, Object> downHonorsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<HonorEntity> honorEntities = null;
        List<GetHonorResp> getHonorResps = new LinkedList<GetHonorResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getHonorResps);
            return resp;
        }
        honorEntities = honorMapper.queryAllForTutor(status, stuIds, queryRequ.getHonorType());
        for (HonorEntity honorEntity : honorEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(honorEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetHonorResp getHonorResp = adminModel.createGetHonorResp(honorEntity, stuBaseEntity);
            getHonorResps.add(getHonorResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_honor"));
            int index = 1;
            for (GetHonorResp getHonorResp : getHonorResps) {
                adminModel.writeHonorIntoExcel(workbook, getHonorResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_honor" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downPapersForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PaperEntity> paperEntities = null;
        List<GetPaperResp> getPaperResps = new LinkedList<GetPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getPaperResps);
            return resp;
        }
        paperEntities = paperMapper.queryAllForTutor(status, stuIds, queryRequ.getPaperGrade());
        for (PaperEntity paperEntity : paperEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(paperEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetPaperResp getPaperResp = adminModel.createGetPaperResp(paperEntity, stuBaseEntity);
            getPaperResps.add(getPaperResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_paper"));
            int index = 1;
            for (GetPaperResp getPaperResp : getPaperResps) {
                adminModel.writePaperIntoExcel(workbook, getPaperResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_paper" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downPatentsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<PatentEntity> patentEntities = null;
        List<GetPatentResp> getPatentResps = new LinkedList<GetPatentResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getPatentResps);
            return resp;
        }
        patentEntities = patentMapper.queryAllForTutor(status, stuIds, queryRequ.getPatentType(), queryRequ.getPatentState());
        for (PatentEntity patentEntity : patentEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(patentEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetPatentResp getPatentResp = adminModel.createGetPatentResp(patentEntity, stuBaseEntity);
            getPatentResps.add(getPatentResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_patent"));
            int index = 1;
            for (GetPatentResp getPatentResp : getPatentResps) {
                adminModel.writePatentIntoExcel(workbook, getPatentResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_patent" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downCompesForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<CompetitionEntity> competitionEntities = null;
        List<GetCompetitionResp> getCompetitionResps = new LinkedList<GetCompetitionResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getCompetitionResps);
            return resp;
        }
        competitionEntities = competitionMapper.queryAllForTutor(status, stuIds, queryRequ.getCompetitionType(), queryRequ.getCompetitionLevel());
        for (CompetitionEntity competitionEntity : competitionEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(competitionEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetCompetitionResp getCompetitionResp = adminModel.createGetCompetitionResp(competitionEntity, stuBaseEntity);
            getCompetitionResps.add(getCompetitionResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_competition"));
            int index = 1;
            for ( GetCompetitionResp getCompetitionResp : getCompetitionResps) {
                adminModel.writeCompetitionIntoExcel(workbook, getCompetitionResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_competition" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downProjectsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<ProjectsEntity> projectsEntities = null;
        List<GetProjectResp> getProjectResps = new LinkedList<GetProjectResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getProjectResps);
            return resp;
        }
        projectsEntities = projectsMapper.queryAllForTutor(status, stuIds, queryRequ.getProClass(), queryRequ.getProType());
        for (ProjectsEntity projectsEntity : projectsEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(projectsEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetProjectResp getProjectResp = adminModel.createGetProjectResp(projectsEntity, stuBaseEntity);
            getProjectResps.add(getProjectResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_project"));
            int index = 1;
            for (GetProjectResp getProjectResp : getProjectResps) {
                adminModel.writeProjectIntoExcel(workbook, getProjectResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_project" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downAcadExchsForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<AcademicExchangeEntity> academicExchangeEntities = null;
        List<GetAcadExchResp> getAcadExchResps = new LinkedList<GetAcadExchResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getAcadExchResps);
            return resp;
        }
        academicExchangeEntities = academicExchangeMapper.queryAllForTutor(status, stuIds, queryRequ.getExchangeType());
        for (AcademicExchangeEntity academicExchangeEntity : academicExchangeEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(academicExchangeEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetAcadExchResp getAcadExchResp = adminModel.createGetAcadExchResp(academicExchangeEntity, stuBaseEntity);
            getAcadExchResps.add(getAcadExchResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_acad_exch"));
            int index = 1;
            for (GetAcadExchResp getAcadExchResp : getAcadExchResps) {
                adminModel.writeAcadExchExcel(workbook, getAcadExchResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_acad_exch" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downWorksForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<WorkEntity> workEntities = null;
        List<GetWorkResp> getWorkResps = new LinkedList<GetWorkResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getWorkResps);
            return resp;
        }
        workEntities = workMapper.queryAllForTutor(status, stuIds, queryRequ.getWorkType());
        for (WorkEntity workEntity : workEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(workEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetWorkResp getWorkResp = adminModel.createGetWorkResp(workEntity, stuBaseEntity);
            getWorkResps.add(getWorkResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_work"));
            int index = 1;
            for (GetWorkResp getWorkResp : getWorkResps) {
                adminModel.writeWorkIntoExcel(workbook, getWorkResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_work" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }

    @Override
    public Map<String, Object> downMasterPapersForTeacher(QueryRequ queryRequ) {
        Map<String, Object> resp = new HashMap<>();
        String status = FormatUtil.strings2String(getIntAuditStatus(queryRequ.getStatus()));
        List<MasterPaperEntity> masterPaperEntities = null;
        List<GetMasterPaperResp> getMasterPaperResps = new LinkedList<GetMasterPaperResp>();
        List<StuBaseEntity> stuBaseEntities = null;
        if (queryRequ.getState() == 1) {
//            辅导员查询
            stuBaseEntities = stuBaseMapper.queryForCouner(queryRequ.getStuId(), queryRequ.getStuName());

        } else {
//            导师查询
            stuBaseEntities = stuBaseMapper.queryByTutorId(queryRequ.getUserId());
        }
        String stuIds = FormatUtil.strings2String(getStuIds(stuBaseEntities));
        if (stuIds.equals("")){
            resp.put("c", 200);
            resp.put("r", getMasterPaperResps);
            return resp;
        }
        masterPaperEntities = masterPaperMapper.queryAllForTutor(status, stuIds);
        for (MasterPaperEntity masterPaperEntity : masterPaperEntities) {
            StuBaseEntity stuBaseEntity = stuBaseMapper.queryByStuId(masterPaperEntity.getStuId());
            if (FormatUtil.isEmpty(stuBaseEntity)) {
                continue;
            }
            GetMasterPaperResp getMasterPaperResp = adminModel.createGetMasterPaperResp(masterPaperEntity, stuBaseEntity);
            getMasterPaperResps.add(getMasterPaperResp);
        }
        try {
            Workbook workbook = ExcelUtil.copyFile(PropertiesUtil.prop("template_path_master_paper"));
            int index = 1;
            for (GetMasterPaperResp getMasterPaperResp : getMasterPaperResps) {
                adminModel.writeMasterPaperIntoExcel(workbook, getMasterPaperResp, index);
                index = index + 1;
            }
            String fileName = DateUtil.getCurrentDatetime().split(" ")[0] + "_master_paper" + ".xlsx";
            ExcelUtil.save(workbook, PropertiesUtil.prop("file_path") + fileName);
            resp.put("c", 200);
            resp.put("r", fileName);
        } catch (IOException e) {
            resp.put("c", 311);
            resp.put("r", "文件创建错误");
        }
        return resp;
    }


    private String[] getIntAuditStatus(String[] auditStatus) {
        for (int i = 0; i < auditStatus.length; i++) {
            if (auditStatus[i].equals("已删除")) {
                auditStatus[i] = "0";
            } else if (auditStatus[i].equals("待审核")) {
                auditStatus[i] = "1";
            } else if (auditStatus[i].equals("已通过")) {
                auditStatus[i] = "2";
            }
        }
        return auditStatus;
    }

    private String[] getStuIds(List<StuBaseEntity> stuBaseEntities) {
        String stuIds[] = new String[stuBaseEntities.size()];
        int i = 0;
        for (StuBaseEntity stuBaseEntity : stuBaseEntities) {
            stuIds[i] = stuBaseEntity.getStuId();
            i = i + 1;
        }
        return stuIds;
    }
}
