package cn.hdu.fragmentTax.controller;


import cn.hdu.fragmentTax.model.request.AdminExamRequ;
import cn.hdu.fragmentTax.model.request.AdminQueryRequ;
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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
     * @param adminQueryRequ
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

    /**
     * 管理员或者导师查看学生基本信息
     * @param adminQueryRequ
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
     * @param adminQueryRequ
     * @return
     */
    @Path("/showAllPrizeForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showAllPrizeForTeacher(QueryRequ adminQueryRequ){
        Map<String, Object> resp = adminService.showAllPrizeForTeacher(adminQueryRequ);
        return resp;
    }

    @Path("/showScoresForTeacher")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showScoresForTeacher(QueryRequ queryRequ){
        Map<String, Object> resp = adminService.showScoresForTeacher(queryRequ);
        return resp;
    }
}
