package cn.hdu.fragmentTax.service.impl;

import cn.hdu.fragmentTax.dao.entity.*;
import cn.hdu.fragmentTax.dao.mapper.*;
import cn.hdu.fragmentTax.model.request.*;
import cn.hdu.fragmentTax.model.response.*;
import cn.hdu.fragmentTax.service.IPrizeService;
import cn.hdu.fragmentTax.service.impl.model.IPrizeModel;
import cn.hdu.fragmentTax.utils.DateUtil;
import cn.hdu.fragmentTax.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrizeServiceImpl implements IPrizeService {

    @Autowired
    private IPrizeModel prizeModel;

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
    private IStuBaseMapper stuBaseMapper;

    @Autowired
    private IProjectsMapper projectsMapper;


    @Override
    public Map<String, Object> editHonor(EditHonorResp editHonorResp) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editHonorResp.getId())) {
            // 更新
            try {
                HonorEntity honorEntity = prizeModel.createHonorEntity(editHonorResp);
                honorEntity.setId(editHonorResp.getId());
                honorMapper.update(honorEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                HonorEntity honorEntity = prizeModel.createHonorEntity(editHonorResp);
                honorMapper.insert(honorEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getHonors(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<HonorEntity> honorEntities = honorMapper.queryStuId(stuId);
        List<GetHonorResp> getHonorResps = new ArrayList<GetHonorResp>();
        for (HonorEntity honorEntity : honorEntities) {
            GetHonorResp getHonorResp = prizeModel.createGetHonorResp(honorEntity);
            getHonorResps.add(getHonorResp);
        }
        resp.put("c", 200);
        resp.put("r", getHonorResps);
        return resp;
    }

    @Override
    public Map<String, Object> getPrizes(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        AllPrizeEntity allPrizeEntity = allPrizeMapper.queryByStuId(stuId);
//        if (FormatUtil.isEmpty(allPrizeEntity)) {
//            allPrizeMapper.insertFirst(stuId, stuNumber, DateUtil.getCurrentDatetime());
//            allPrizeEntity = new AllPrizeEntity();
//            allPrizeEntity.setHonorNum(0);
//            allPrizeEntity.setHonorScore(0);
//            allPrizeEntity.setPaperNum(0);
//            allPrizeEntity.setPaperSocre(0);
//            allPrizeEntity.setPatentNum(0);
//            allPrizeEntity.setPatentScore(0);
//        }
//        GetPrizesResp getPrizesResp = prizeModel.createGetPrizesResp(allPrizeEntity);
        Integer allStuNum = stuBaseMapper.queryCount();
        GetPrizeForTeacherResp getPrizeForTeacherResp = prizeModel.createGetPrizeResp(allPrizeEntity, allStuNum);
        resp.put("c", 200);
        resp.put("r", getPrizeForTeacherResp);
        return resp;
    }

    @Override
    public Map<String, Object> editPaper(EditPaperRequ editPaperRequ){
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editPaperRequ.getId())) {
            // 更新

            try {
                PaperEntity paperEntity = prizeModel.createPaperEntity(editPaperRequ);
                paperEntity.setId(editPaperRequ.getId());
                paperMapper.update(paperEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                PaperEntity paperEntity = prizeModel.createPaperEntity(editPaperRequ);
                paperMapper.insert(paperEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getPapers(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<PaperEntity> paperEntities = paperMapper.queryStuId(stuId);
        List<GetPaperResp> getPaperResps = new ArrayList<GetPaperResp>();
        for (PaperEntity paperEntity : paperEntities) {
            GetPaperResp getPaperResp = prizeModel.createGetPaperResp(paperEntity);
            getPaperResps.add(getPaperResp);
        }
        resp.put("c", 200);
        resp.put("r", getPaperResps);
        return resp;
    }

    @Override
    public Map<String, Object> editPatent(EditPatentRequ editPatentRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editPatentRequ.getId())) {
            // 更新

            try {
                PatentEntity patentEntity = prizeModel.createPatentEntity(editPatentRequ);
                patentEntity.setId(editPatentRequ.getId());
                patentMapper.update(patentEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                PatentEntity patentEntity = prizeModel.createPatentEntity(editPatentRequ);
                patentMapper.insert(patentEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getPatents(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<PatentEntity> patentEntities = patentMapper.queryStuId(stuId);
        List<GetPatentResp> getPatentResps = new ArrayList<GetPatentResp>();
        for (PatentEntity patentResp : patentEntities) {
            GetPatentResp getPatentResp = prizeModel.createGetPatentResp(patentResp);
            getPatentResps.add(getPatentResp);
        }
        resp.put("c", 200);
        resp.put("r", getPatentResps);
        return resp;
    }

    @Override
    public Map<String, Object> editCompetition(EditCompetitionRequ editCompetitionRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editCompetitionRequ.getId())) {
            // 更新
            try {
                CompetitionEntity competitionEntity = prizeModel.createCompetitionEntity(editCompetitionRequ);
                competitionEntity.setId(editCompetitionRequ.getId());
                competitionMapper.update(competitionEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                CompetitionEntity competitionEntity = prizeModel.createCompetitionEntity(editCompetitionRequ);
                competitionMapper.insert(competitionEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getCompetitions(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<CompetitionEntity> competitionEntities = competitionMapper.queryStuId(stuId);
        List<GetCompetitionResp> getCompetitionResps = new ArrayList<GetCompetitionResp>();
        for (CompetitionEntity competitionEntity : competitionEntities) {
            GetCompetitionResp getCompetitionResp = prizeModel.createGetCompetitionResp(competitionEntity);
            getCompetitionResps.add(getCompetitionResp);
        }
        resp.put("c", 200);
        resp.put("r", getCompetitionResps);
        return resp;
    }

    @Override
    public Map<String, Object> editInnoPro(EditInnoProRequ editInnoProRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editInnoProRequ.getId())) {
            // 更新
            try {
                InnovativeProEntity innovativeProEntity = prizeModel.createInnoProEntity(editInnoProRequ);
                innovativeProEntity.setId(editInnoProRequ.getId());
                innovativeProMapper.update(innovativeProEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                InnovativeProEntity innovativeProEntity = prizeModel.createInnoProEntity(editInnoProRequ);
                innovativeProMapper.insert(innovativeProEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getInnoPros(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<InnovativeProEntity> innovativeProEntities = innovativeProMapper.queryStuId(stuId);
        List<GetInnoProResp> getInnoProResps = new ArrayList<GetInnoProResp>();
        for (InnovativeProEntity innovativeProEntity : innovativeProEntities) {
            GetInnoProResp getInnoProResp =  prizeModel.createGetInnoProResp(innovativeProEntity);
            getInnoProResps.add(getInnoProResp);
        }
        resp.put("c", 200);
        resp.put("r", getInnoProResps);
        return resp;
    }

    @Override
    public Map<String, Object> editEntrPro(EditInnoProRequ editInnoProRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editInnoProRequ.getId())) {
            // 更新
            try {
                EntrepreneurialProEntity entrepreneurialProEntity = prizeModel.createEntrProEntity(editInnoProRequ);
                entrepreneurialProEntity.setId(editInnoProRequ.getId());
                entrepreneurialProMapper.update(entrepreneurialProEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                EntrepreneurialProEntity entrepreneurialProEntity = prizeModel.createEntrProEntity(editInnoProRequ);
                entrepreneurialProMapper.insert(entrepreneurialProEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getEntrPros(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<EntrepreneurialProEntity> entrepreneurialProEntities = entrepreneurialProMapper.queryStuId(stuId);
        List<GetInnoProResp> getInnoProResps = new ArrayList<GetInnoProResp>();
        for (EntrepreneurialProEntity entrepreneurialProEntity : entrepreneurialProEntities) {
            GetInnoProResp getInnoProResp =  prizeModel.createGetInnoProResp(entrepreneurialProEntity);
            getInnoProResps.add(getInnoProResp);
        }
        resp.put("c", 200);
        resp.put("r", getInnoProResps);
        return resp;
    }

    @Override
    public Map<String, Object> editEngiPro(EditEngiProRequ editEngiProRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editEngiProRequ.getId())) {
            // 更新
            try {
                EngineeringProEntity engineeringProEntity = prizeModel.createEngiProEntity(editEngiProRequ);
                engineeringProEntity.setId(editEngiProRequ.getId());
                engineeringProMapper.update(engineeringProEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                EngineeringProEntity engineeringProEntity = prizeModel.createEngiProEntity(editEngiProRequ);
                engineeringProMapper.insert(engineeringProEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getEngiPros(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<EngineeringProEntity> engineeringProEntities = engineeringProMapper.queryStuId(stuId);
        List<GetEngiProResp> getEngiProResps = new ArrayList<GetEngiProResp>();
        for (EngineeringProEntity engineeringProEntity : engineeringProEntities) {
            GetEngiProResp getEngiProResp =  prizeModel.createGetEngiProResp(engineeringProEntity);
            getEngiProResps.add(getEngiProResp);
        }
        resp.put("c", 200);
        resp.put("r", getEngiProResps);
        return resp;
    }

    @Override
    public Map<String, Object> editAcadExch(EditAcadExchRequ editAcadExchRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editAcadExchRequ.getId())) {
            // 更新
            try {
                AcademicExchangeEntity academicExchangeEntity = prizeModel.createAcadExchEntity(editAcadExchRequ);
                academicExchangeEntity.setId(editAcadExchRequ.getId());
                academicExchangeMapper.update(academicExchangeEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                AcademicExchangeEntity academicExchangeEntity = prizeModel.createAcadExchEntity(editAcadExchRequ);
                academicExchangeMapper.insert(academicExchangeEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getAcadExchs(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<AcademicExchangeEntity> academicExchangeEntities = academicExchangeMapper.queryStuId(stuId);
        List<GetAcadExchResp> getAcadExchResps = new ArrayList<GetAcadExchResp>();
        for (AcademicExchangeEntity academicExchangeEntity : academicExchangeEntities) {
            GetAcadExchResp getAcadExchResp =  prizeModel.createGetAcadExchResp(academicExchangeEntity);
            getAcadExchResps.add(getAcadExchResp);
        }
        resp.put("c", 200);
        resp.put("r", getAcadExchResps);
        return resp;
    }

    @Override
    public Map<String, Object> editWork(EditWorkRequ editWorkRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editWorkRequ.getId())) {
            // 更新
            try {
                WorkEntity workEntity = prizeModel.createdWorkEntity(editWorkRequ);
                workEntity.setId(editWorkRequ.getId());
                workMapper.update(workEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                WorkEntity workEntity = prizeModel.createdWorkEntity(editWorkRequ);
                workMapper.insert(workEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getWorks(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<WorkEntity> workEntities = workMapper.queryStuId(stuId);
        List<GetWorkResp> getWorkResps = new ArrayList<GetWorkResp>();
        for (WorkEntity workEntity : workEntities) {
            GetWorkResp getWorkResp =  prizeModel.createGetWorkResp(workEntity);
            getWorkResps.add(getWorkResp);
        }
        resp.put("c", 200);
        resp.put("r", getWorkResps);
        return resp;
    }

    @Override
    public Map<String, Object> editMasterPaper(EditMasterPaperRequ editMasterPaperRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editMasterPaperRequ.getId())) {
            // 更新
            try {
                MasterPaperEntity masterPaperEntity = prizeModel.createMasterPaperEntity(editMasterPaperRequ);
                masterPaperEntity.setId(editMasterPaperRequ.getId());
                masterPaperMapper.update(masterPaperEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                MasterPaperEntity masterPaperEntity = prizeModel.createMasterPaperEntity(editMasterPaperRequ);
                masterPaperMapper.insert(masterPaperEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getMasterPapers(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<MasterPaperEntity> masterPaperEntities = masterPaperMapper.queryStuId(stuId);
        List<GetMasterPaperResp> getMasterPaperResps = new ArrayList<GetMasterPaperResp>();
        for (MasterPaperEntity masterPaperEntity : masterPaperEntities) {
            GetMasterPaperResp getMasterPaperResp =  prizeModel.createGetMasterPaperResp(masterPaperEntity);
            getMasterPaperResps.add(getMasterPaperResp);
        }
        resp.put("c", 200);
        resp.put("r", getMasterPaperResps);
        return resp;
    }

    @Override
    public Map<String, Object> deleHonor(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            honorMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> delePaper(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            paperMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> delePatent(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            patentMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleCompetition(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            competitionMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleInnoPro(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            innovativeProMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleEntrPro(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            entrepreneurialProMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleEngiPro(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            engineeringProMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleAcadExch(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            academicExchangeMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleWork(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            workMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> deleMasterPaper(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            masterPaperMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

    @Override
    public Map<String, Object> editProject(EditProjectRequ editProjectRequ) {
        Map<String, Object> resp = new HashMap<>();
        if (!FormatUtil.isEmpty(editProjectRequ.getId())) {
            // 更新

            try {
                ProjectsEntity projectsEntity = prizeModel.createProjectEntity(editProjectRequ);
                projectsEntity.setId(editProjectRequ.getId());
                projectsMapper.update(projectsEntity);
                resp.put("c", 200);
                resp.put("r", "修改成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        } else {
            // 插入
            try {
                ProjectsEntity projectsEntity = prizeModel.createProjectEntity(editProjectRequ);
                projectsMapper.insert(projectsEntity);
                resp.put("c", 200);
                resp.put("r", "插入成功");
            } catch (Exception e) {
                resp.put("c", 401);
                resp.put("r", "数据库错误");
            }
        }
        return resp;
    }

    @Override
    public Map<String, Object> getProjects(String stuId) {
        Map<String, Object> resp = new HashMap<>();
        List<ProjectsEntity> projectsEntities = projectsMapper.queryStuId(stuId);
        List<GetProjectResp> getProjectResps = new ArrayList<GetProjectResp>();
        for (ProjectsEntity projectsEntity : projectsEntities) {
            GetProjectResp getProjectResp =  prizeModel.createGetProjectResp(projectsEntity);
            getProjectResps.add(getProjectResp);
        }
        resp.put("c", 200);
        resp.put("r", getProjectResps);
        return resp;
    }

    @Override
    public Map<String, Object> deleProject(Integer id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            projectsMapper.delete(id);
            resp.put("c", 200);
            resp.put("r", "删除成功");
        } catch (Exception e) {
            resp.put("c", 410);
            resp.put("r", "删除失败");
        }
        return resp;
    }

}
