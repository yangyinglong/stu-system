package cn.hdu.fragmentTax.service;

import cn.hdu.fragmentTax.model.request.*;

import java.text.ParseException;
import java.util.Map;

public interface IPrizeService {
    Map<String,Object> editHonor(EditHonorResp editHonorResp);

    Map<String,Object> getHonors(String stuId);

    Map<String,Object> getPrizes(String stuId);

    Map<String,Object> editPaper(EditPaperRequ editPaperRequ);

    Map<String,Object> getPapers(String stuId);

    Map<String,Object> editPatent(EditPatentRequ editPatentRequ);

    Map<String,Object> getPatents(String stuId);

    Map<String,Object> editCompetition(EditCompetitionRequ editCompetitionRequ);

    Map<String,Object> getCompetitions(String stuId);

    Map<String,Object> editInnoPro(EditInnoProRequ editInnoProRequ);

    Map<String,Object> getInnoPros(String stuId);

    Map<String,Object> editEntrPro(EditInnoProRequ editInnoProRequ);

    Map<String,Object> getEntrPros(String stuId);

    Map<String,Object> editEngiPro(EditEngiProRequ editEngiProRequ);

    Map<String,Object> getEngiPros(String stuId);

    Map<String,Object> editAcadExch(EditAcadExchRequ editAcadExchRequ);

    Map<String,Object> getAcadExchs(String stuId);

    Map<String,Object> editWork(EditWorkRequ editWorkRequ);

    Map<String,Object> getWorks(String stuId);

    Map<String,Object> editMasterPaper(EditMasterPaperRequ editMasterPaperRequ);

    Map<String,Object> getMasterPapers(String stuId);

    Map<String,Object> deleHonor(Integer id);

    Map<String,Object> delePaper(Integer id);

    Map<String,Object> delePatent(Integer id);

    Map<String,Object> deleCompetition(Integer id);

    Map<String,Object> deleInnoPro(Integer id);

    Map<String,Object> deleEntrPro(Integer id);

    Map<String,Object> deleEngiPro(Integer id);

    Map<String,Object> deleAcadExch(Integer id);

    Map<String,Object> deleWork(Integer id);

    Map<String,Object> deleMasterPaper(Integer id);

    Map<String,Object> editProject(EditProjectRequ editProjectRequ);

    Map<String,Object> getProjects(String stuId);

    Map<String,Object> deleProject(Integer id);
}
