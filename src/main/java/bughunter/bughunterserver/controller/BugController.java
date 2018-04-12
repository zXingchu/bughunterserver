package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.model.entity.BugInfo;
import bughunter.bughunterserver.service.BugService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/app/bug")
public class BugController {

    @Autowired
    BugService bugService;

    @RequestMapping(value = "/{appId}/{bugId}/getSimilarity", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getSimilarBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        List<BugBaseInfoVO> bugBaseInfoList=bugService.findSimilarBugs(bugId);
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }

    @RequestMapping(value = "/{appId}/{bugId}/getCurrentActivityBug", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getCurrentActivityBug(HttpServletRequest request, @PathVariable int appId){
        //TODO
        return null;
    }


    @RequestMapping(value = "/{appId}/getAll", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int appId){
        List<BugBaseInfoVO> bugBaseInfoList=bugService.findAllBugByAppId(appId);
        return ResultMessageFactory.getResultMessage(bugBaseInfoList);
    }

    @RequestMapping(value = "/{appId}/submit", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage submitBug(HttpServletRequest request, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        BugInfo bugInfo=new BugInfo(jsonObject);
        int id=bugService.addBug(bugInfo);
        return ResultMessageFactory.getResultMessage(id);
    }

    @RequestMapping(value = "/{appId}/{bugId}/get", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getBugById(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugInfoVO bugInfo=bugService.findWholeBug(bugId);
        return ResultMessageFactory.getResultMessage(bugInfo);
    }

    @RequestMapping(value = "/{appId}/{bugId}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage modifyBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        return ResultMessageFactory.getResultMessage(bugService.modifyBug(bugId, jsonObject),Constants.ERROR);
    }

    @RequestMapping(value = "/{appId}/{bugId}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage deleteBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return ResultMessageFactory.getResultMessage(bugService.deleteBug(bugId),Constants.ERROR_NO_EXIST);
    }





    @RequestMapping(value = "/{appId}/{bugId}/base", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage getBugBaseInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugBaseInfoVO bugBaseInfo=bugService.findBugBaseInfo(bugId);
        return ResultMessageFactory.getResultMessage(bugBaseInfo);
    }


    @RequestMapping(value = "/{appId}/{bugId}/device", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getBugDeviceInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugDeviceInfoVO bugDeviceInfo=bugService.findDeviceInfoByBugId(bugId);
        return ResultMessageFactory.getResultMessage(bugDeviceInfo);
    }

    @RequestMapping(value = "/{appId}/{bugId}/console", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getBugConsoleLog(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugConsoleLogVO bugConsoleLog=bugService.findConsoleLogByBugId(bugId);
        return ResultMessageFactory.getResultMessage(bugConsoleLog);
    }

    @RequestMapping(value = "/{appId}/{bugId}/step", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getBugOperateStep(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugOperateStepVO bugOperateStep=bugService.findOperateStepByBugId(bugId);
        return ResultMessageFactory.getResultMessage(bugOperateStep);
    }

    @RequestMapping(value = "/{appId}/{bugId}/data", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getBugUserData(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugUserDataVO bugUserData=bugService.findUserDataByBugId(bugId);
        return ResultMessageFactory.getResultMessage(bugUserData);
    }

    @RequestMapping(value = "/{appId}/{bugId}/network", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getNetworkRequest(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId){
        BugNetRequestVO bugNetRequest=bugService.findNetRequestByBugId(bugId);
        return ResultMessageFactory.getResultMessage(bugNetRequest);
    }

}
