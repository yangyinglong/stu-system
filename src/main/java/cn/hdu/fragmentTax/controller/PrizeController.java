package cn.hdu.fragmentTax.controller;

import cn.hdu.fragmentTax.model.request.*;
import cn.hdu.fragmentTax.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Map;

@Component
@Path("/prize")
@CrossOrigin
public class PrizeController {

    @Autowired
    private IPrizeService prizeService;

    /**
     * 修改或者增加荣誉和称号
     * @param editHonorResp
     * @return
     */
    @Path("/editHonor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editHonor(EditHonorResp editHonorResp){
        Map<String, Object> resp = prizeService.editHonor(editHonorResp);
        return resp;
    }

    /**
     * 删除荣誉
     * @param id
     * @return
     */
    @Path("/deleHonor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleHonor(Integer id){
        Map<String, Object> resp = prizeService.deleHonor(id);
        return resp;
    }

    /**
     * 根据学号获取所有的荣誉和奖项
     * @param stuId
     * @return
     */
    @Path("/getHonors")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getHonors(String stuId){
        Map<String, Object> resp = prizeService.getHonors(stuId);
        return resp;
    }

    /**
     * 获取所有证书的总分
     * @param stuId
     * @return
     */
    @Path("/getPrizes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getPrizes(String stuId){
        Map<String, Object> resp = prizeService.getPrizes(stuId);
        return resp;
    }

    /**
     * 添加或者修改学术文论
     * @param editPaperRequ
     * @return
     */
    @Path("/editPaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editPaper(EditPaperRequ editPaperRequ) {
        Map<String, Object> resp = prizeService.editPaper(editPaperRequ);
        return resp;
    }

    @Path("/delePaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> delePaper(Integer id){
        Map<String, Object> resp = prizeService.delePaper(id);
        return resp;
    }
    /**
     * 根据学号获取所有的论文信息
     * @param stuId
     * @return
     */
    @Path("/getPapers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getPapers(String stuId){
        Map<String, Object> resp = prizeService.getPapers(stuId);
        return resp;
    }

    /**
     * 修改或者增加发明专利
     * @param editPatentRequ
     * @return
     */
    @Path("/editPatent")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editPatent(EditPatentRequ editPatentRequ){
        Map<String, Object> resp = prizeService.editPatent(editPatentRequ);
        return resp;
    }

    @Path("/delePatent")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> delePatent(Integer id){
        Map<String, Object> resp = prizeService.delePatent(id);
        return resp;
    }

    /**
     * 获取发明专利
     * @param stuId
     * @return
     */
    @Path("/getPatents")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getPatents(String stuId){
        Map<String, Object> resp = prizeService.getPatents(stuId);
        return resp;
    }

    /**
     * 增加或者更新学科竞赛
     * @param editCompetitionRequ
     * @return
     */
    @Path("/editCompetition")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editCompetition(EditCompetitionRequ editCompetitionRequ){
        Map<String, Object> resp = prizeService.editCompetition(editCompetitionRequ);
        return resp;
    }

    @Path("/deleCompetition")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleCompetition(Integer id){
        Map<String, Object> resp = prizeService.deleCompetition(id);
        return resp;
    }
    /**
     * 根据学号获取竞赛
     * @param stuId
     * @return
     */
    @Path("/getCompetitions")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getCompetitions(String stuId){
        Map<String, Object> resp = prizeService.getCompetitions(stuId);
        return resp;
    }

    /**
     * 修改或者插入创新项目
     * @param editInnoProRequ
     * @return
     */
    @Path("/editInnoPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editInnoPro(EditInnoProRequ editInnoProRequ){
        Map<String, Object> resp = prizeService.editInnoPro(editInnoProRequ);
        return resp;
    }

    @Path("/deleInnoPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleInnoPro(Integer id){
        Map<String, Object> resp = prizeService.deleInnoPro(id);
        return resp;
    }

    /**
     * 根据学号查询创想项目
     * @param stuId
     * @return
     */
    @Path("/getInnoPros")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInnoPros(String stuId){
        Map<String, Object> resp = prizeService.getInnoPros(stuId);
        return resp;
    }

    /**
     * 插入或者更新创业项目，用的requ 还是与创新项目相同
     * @param editInnoProRequ
     * @return
     */
    @Path("/editEntrPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editEntrPro(EditInnoProRequ editInnoProRequ){
        Map<String, Object> resp = prizeService.editEntrPro(editInnoProRequ);
        return resp;
    }

    @Path("/deleEntrPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleEntrPro(Integer id){
        Map<String, Object> resp = prizeService.deleEntrPro(id);
        return resp;
    }

    /**
     * 根据学号获取创业项目
     * @param stuId
     * @return
     */
    @Path("/getEntrPros")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getEntrPros(String stuId){
        Map<String, Object> resp = prizeService.getEntrPros(stuId);
        return resp;
    }

    /**
     * 更新或者插入工程项目
     * @param editEngiProRequ
     * @return
     */
    @Path("/editEngiPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editEngiPro(EditEngiProRequ editEngiProRequ){
        Map<String, Object> resp = prizeService.editEngiPro(editEngiProRequ);
        return resp;
    }

    @Path("/deleEngiPro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleEngiPro(Integer id){
        Map<String, Object> resp = prizeService.deleEngiPro(id);
        return resp;
    }

    /**
     * 根据学号获取
     * @param stuId
     * @return
     */
    @Path("/getEngiPros")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getEngiPros(String stuId){
        Map<String, Object> resp = prizeService.getEngiPros(stuId);
        return resp;
    }

    /**
     * 更新或者插入学术交流
     * @param editAcadExchRequ
     * @return
     */
    @Path("/editAcadExch")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editAcadExch(EditAcadExchRequ editAcadExchRequ){
        Map<String, Object> resp = prizeService.editAcadExch(editAcadExchRequ);
        return resp;
    }

    @Path("/deleAcadExch")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleAcadExch(Integer id){
        Map<String, Object> resp = prizeService.deleAcadExch(id);
        return resp;
    }
    /**
     * 根据学号获取学术交流
     * @param stuId
     * @return
     */
    @Path("/getAcadExchs")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getAcadExchs(String stuId){
        Map<String, Object> resp = prizeService.getAcadExchs(stuId);
        return resp;
    }


    /**
     * 插入或者更新就业深造
     * @param editWorkRequ
     * @return
     */
    @Path("/editWork")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editWork(EditWorkRequ editWorkRequ){
        Map<String, Object> resp = prizeService.editWork(editWorkRequ);
        return resp;
    }

    @Path("/deleWork")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleWork(Integer id){
        Map<String, Object> resp = prizeService.deleWork(id);
        return resp;
    }

    /**
     * 根据学号获取硕士论文
     * @param stuId
     * @return
     */
    @Path("/getWorks")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getWorks(String stuId){
        Map<String, Object> resp = prizeService.getWorks(stuId);
        return resp;
    }

    /**
     * 插入或者更新硕士论文
     * @param editMasterPaperRequ
     * @return
     */
    @Path("/editMasterPaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editMasterPaper(EditMasterPaperRequ editMasterPaperRequ){
        Map<String, Object> resp = prizeService.editMasterPaper(editMasterPaperRequ);
        return resp;
    }

    @Path("/deleMasterPaper")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleMasterPaper(Integer id){
        Map<String, Object> resp = prizeService.deleMasterPaper(id);
        return resp;
    }
    /**
     * 根据学号获取硕士论文
     * @param stuId
     * @return
     */
    @Path("/getMasterPapers")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMasterPapers(String stuId){
        Map<String, Object> resp = prizeService.getMasterPapers(stuId);
        return resp;
    }

    @Path("/editProject")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editProject(EditProjectRequ editProjectRequ){
        Map<String, Object> resp = prizeService.editProject(editProjectRequ);
        return resp;
    }

    @Path("/getProjects")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getProjects(String stuId){
        Map<String, Object> resp = prizeService.getProjects(stuId);
        return resp;
    }

    @Path("/deleProject")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleProject(Integer id){
        Map<String, Object> resp = prizeService.deleProject(id);
        return resp;
    }


}
