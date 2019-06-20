package cn.hdu.fragmentTax.service;

import cn.hdu.fragmentTax.model.request.AdminExamRequ;
import cn.hdu.fragmentTax.model.request.AdminQueryRequ;
import cn.hdu.fragmentTax.model.request.QueryRequ;

import java.util.Map;

public interface IAdminService {
    Map<String,Object> showHonorsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examHonor(AdminExamRequ adminExamRequ);

    Map<String,Object> showPapersForTeacher(QueryRequ queryRequ);

    Map<String,Object> examPaper(AdminExamRequ adminExamRequ);

    Map<String,Object> showPatentsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examPatent(AdminExamRequ adminExamRequ);

    Map<String,Object> showCompetitionsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examCompetition(AdminExamRequ adminExamRequ);

    Map<String,Object> showEntrProsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examEntrPro(AdminExamRequ adminExamRequ);

    Map<String,Object> showInnoProsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examInnoPro(AdminExamRequ adminExamRequ);

    Map<String,Object> showEngiProsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examEngiPro(AdminExamRequ adminExamRequ);

    Map<String,Object> showAcadExchsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examAcadExch(AdminExamRequ adminExamRequ);

    Map<String,Object> showMasterPapersForTeacher(QueryRequ queryRequ);

    Map<String,Object> examMasterPaper(AdminExamRequ adminExamRequ);

    Map<String,Object> showWorksForTeacher(QueryRequ queryRequ);

    Map<String,Object> examWork(AdminExamRequ adminExamRequ);

    Map<String,Object> showStusForTeacher(QueryRequ queryRequ);

    Map<String,Object> showAllPrizeForTeacher(QueryRequ adminQueryRequ);

    Map<String,Object> showScoresForTeacher(QueryRequ queryRequ);

    Map<String,Object> downStusForTeacher(QueryRequ queryRequ);

    Map<String,Object> showProjectsForTeacher(QueryRequ queryRequ);

    Map<String,Object> examProject(AdminExamRequ adminExamRequ);

    Map<String,Object> showStuBaseNum(QueryRequ queryRequ);

    Map<String,Object> showStuScoreNum(QueryRequ queryRequ);

    Map<String,Object> showStuPrizeNum(QueryRequ queryRequ);

    Map<String,Object> showStuHonorNum(QueryRequ queryRequ);

    Map<String,Object> showStuPaperNum(QueryRequ queryRequ);

    Map<String,Object> showStuPatentNum(QueryRequ queryRequ);

    Map<String,Object> showStuCompetitionNum(QueryRequ queryRequ);

    Map<String,Object> showStuProjectNum(QueryRequ queryRequ);

    Map<String,Object> showStuAcadExchNum(QueryRequ queryRequ);

    Map<String,Object> showStuWorkNum(QueryRequ queryRequ);

    Map<String,Object> showStuMasterPaperNum(QueryRequ queryRequ);

    Map<String,Object> downHonorsForTeacher(QueryRequ queryRequ);

    Map<String,Object> downPapersForTeacher(QueryRequ queryRequ);

    Map<String,Object> downPatentsForTeacher(QueryRequ queryRequ);

    Map<String,Object> downCompesForTeacher(QueryRequ queryRequ);

    Map<String,Object> downProjectsForTeacher(QueryRequ queryRequ);

    Map<String,Object> downAcadExchsForTeacher(QueryRequ queryRequ);

    Map<String,Object> downWorksForTeacher(QueryRequ queryRequ);

    Map<String,Object> downMasterPapersForTeacher(QueryRequ queryRequ);
}
