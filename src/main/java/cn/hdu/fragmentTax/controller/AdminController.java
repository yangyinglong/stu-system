package cn.hdu.fragmentTax.controller;


import cn.hdu.fragmentTax.model.request.AdminExamRequ;
import cn.hdu.fragmentTax.model.request.QueryRequ;
import cn.hdu.fragmentTax.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Component
@Path("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * 管理员或导师查看荣誉与奖项
     * @param queryRequ
     * @return
     */
    @Path("/showHonorsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showHonorsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showHonorsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核荣誉与奖项
     * @param adminExamRequ
     * @return
     */
    @Path("/examHonor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examHonor(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examHonor(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看学术论文
     * @param queryRequ
     * @return
     */
    @Path("/showPapersForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPapersForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showPapersForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核学术论文
     * @param adminExamRequ
     * @return
     */
    @Path("/examPaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examPaper(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examPaper(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看发明专利
     * @param queryRequ
     * @return
     */
    @Path("/showPatentsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showPatentsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showPatentsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核发明专利
     * @param adminExamRequ
     * @return
     */
    @Path("/examPatent")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examPatent(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examPatent(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看竞赛
     * @param queryRequ
     * @return
     */
    @Path("/showCompetitionsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showCompetitionsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showCompetitionsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 审核学科竞赛
     * @param adminExamRequ
     * @return
     */
    @Path("/examCompetition")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examCompetition(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examCompetition(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看创业项目
     * @param queryRequ
     * @return
     */
    @Path("/showEntrProsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showEntrProsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showEntrProsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核创业项目
     * @param adminExamRequ
     * @return
     */
    @Path("/examEntrPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examEntrPro(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examEntrPro(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看创新项目
     * @param queryRequ
     * @return
     */
    @Path("/showInnoProsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showInnoProsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showInnoProsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核创新项目
     * @param adminExamRequ
     * @return
     */
    @Path("/examInnoPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examInnoPro(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examInnoPro(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看创业项目
     * @param queryRequ
     * @return
     */
    @Path("/showEngiProsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showEngiProsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showEngiProsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核工程项目
     * @param adminExamRequ
     * @return
     */
    @Path("/examEngiPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examEngiPro(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examEngiPro(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看学术交流
     * @param queryRequ
     * @return
     */
    @Path("/showAcadExchsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showAcadExchsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showAcadExchsForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核学术交流
     * @param adminExamRequ
     * @return
     */
    @Path("/examAcadExch")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examAcadExch(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examAcadExch(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看硕士论文
     * @param queryRequ
     * @return
     */
    @Path("/showMasterPapersForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showMasterPapersForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showMasterPapersForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核硕士论文
     * @param adminExamRequ
     * @return
     */
    @Path("/examMasterPaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examMasterPaper(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examMasterPaper(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看就业深造
     * @param queryRequ
     * @return
     */
    @Path("/showWorksForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showWorksForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showWorksForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员审核就业深造
     * @param adminExamRequ
     * @return
     */
    @Path("/examWork")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examWork(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examWork(adminExamRequ);
        return resp;
    }

    @Path("/showProjectsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showProjectsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showProjectsForTeacher(queryRequ);
        return resp;
    }

    @Path("/examProject")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> examProject(AdminExamRequ adminExamRequ){
        Map<String, Object> resp = adminService.examProject(adminExamRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看学生基本信息
     * @param queryRequ
     * @return
     */
    @Path("/showStusForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStusForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStusForTeacher(queryRequ);
        return resp;
    }

    /**
     * 管理员或者导师查看学生的综合素质
     * @param queryRequ
     * @return
     */
    @Path("/showAllPrizeForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showAllPrizeForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showAllPrizeForTeacher(queryRequ);
        return resp;
    }

    @Path("/showScoresForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showScoresForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showScoresForTeacher(queryRequ);
        return resp;
    }

    @Path("/downStusForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downStusForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downStusForTeacher(queryRequ);
        return resp;
    }



    @Path("/showstubasenum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuBaseNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuBaseNum(queryRequ);
        return resp;
    }

    @Path("/showstuscorenum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuScoreNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuScoreNum(queryRequ);
        return resp;
    }


    @Path("/showstuprizenum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuPrizeNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuPrizeNum(queryRequ);
        return resp;
    }

    @Path("/showstuhonornum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuHonorNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuHonorNum(queryRequ);
        return resp;
    }

    @Path("/showstupapernum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuPaperNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuPaperNum(queryRequ);
        return resp;
    }

    @Path("/showstupatentnum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuPatentNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuPatentNum(queryRequ);
        return resp;
    }


    @Path("/showstucompetitionnum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuCompetitionNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuCompetitionNum(queryRequ);
        return resp;
    }

    @Path("/showstuprojectnum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuProjectNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuProjectNum(queryRequ);
        return resp;
    }

    @Path("/showstuacadexchnum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuAcadExchNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuAcadExchNum(queryRequ);
        return resp;
    }

    @Path("/showstuworknum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuWorkNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuWorkNum(queryRequ);
        return resp;
    }


    @Path("/showstumasterpapernum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showStuMasterPaperNum(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showStuMasterPaperNum(queryRequ);
        return resp;
    }


    @Path("/downHonorsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downHonorsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downHonorsForTeacher(queryRequ);
        return resp;
    }

    @Path("/downPapersForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downPapersForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downPapersForTeacher(queryRequ);
        return resp;
    }

    @Path("/downPatentsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downPatentsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downPatentsForTeacher(queryRequ);
        return resp;
    }

    @Path("/downCompesForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downCompesForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downCompesForTeacher(queryRequ);
        return resp;
    }

    @Path("/downProjectsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downProjectsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downProjectsForTeacher(queryRequ);
        return resp;
    }

    @Path("/downAcadExchsForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downAcadExchsForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downAcadExchsForTeacher(queryRequ);
        return resp;
    }

    @Path("/downWorksForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downWorksForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downWorksForTeacher(queryRequ);
        return resp;
    }

    @Path("/downMasterPapersForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> downMasterPapersForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.downMasterPapersForTeacher(queryRequ);
        return resp;
    }
}
