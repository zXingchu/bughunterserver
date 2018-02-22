package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.factory.VOFactory;
import bughunter.bughunterserver.model.entity.BugBaseInfo;
import bughunter.bughunterserver.model.entity.BugUserData;
import bughunter.bughunterserver.service.BugService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app/bug")
public class BugController {

    @Autowired
    BugService bugService;

    @RequestMapping(value = "/{appId}/{bugId}/getSimilarity", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getSimilarBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        List<BugBaseInfo> bugBaseInfoList=bugService.findSimilarBugs(bugService.findBug(bugId));
        List<BugBaseInfoVO> bugBaseInfoVOList=new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo:bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO=new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return ResultMessageFactory.getResultMessage(bugBaseInfoVOList);
    }

    @RequestMapping(value = "/{appId}/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int appId, @RequestBody String jsonStr){
        List<BugBaseInfo> bugBaseInfoList=bugService.findAllBugByAppId(appId);
        if(bugBaseInfoList==null)
            return new ResultMessage(1,Constants.ERROR);
        List<BugBaseInfoVO> bugBaseInfoVOList=new ArrayList<BugBaseInfoVO>(bugBaseInfoList.size());
        for (BugBaseInfo bugBaseInfo:bugBaseInfoList) {
            BugBaseInfoVO bugBaseInfoVO=new BugBaseInfoVO(bugBaseInfo);
            bugBaseInfoVOList.add(bugBaseInfoVO);
        }
        return ResultMessageFactory.getResultMessage(bugBaseInfoVOList);
    }

    @RequestMapping(value = "/{appId}/submit", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage submitBug(HttpServletRequest request, @RequestBody String jsonStr){
        BugBaseInfo bugBaseInfo=new BugBaseInfo();
        JSONObject jsonObject=new JSONObject(jsonStr);
        bugBaseInfo.setAppId(Integer.parseInt(jsonObject.getString(Constants.APP_ID)));
        bugBaseInfo.setPriority(Integer.parseInt(jsonObject.getString(Constants.PRIORITY)));
        bugBaseInfo.setStatus(jsonObject.getString(Constants.STATUS));
        bugBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        bugBaseInfo.setuId(Integer.parseInt(jsonObject.getString(Constants.USER_ID)));
        int id=bugService.addBug(bugBaseInfo);
        return ResultMessageFactory.getResultMessage(id);
    }

    @RequestMapping(value = "/{appId}/{bugId}/get", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugById(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugBaseInfo bugBaseInfo=bugService.findBug(bugId);
        BugBaseInfoVO bugBaseInfoVO= VOFactory.getBugBaseInfoVO(bugBaseInfo);
        return ResultMessageFactory.getResultMessage(bugBaseInfoVO);
    }

    @RequestMapping(value = "/{appId}/{bugId}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage modifyBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugBaseInfo bugBaseInfo=bugService.findBug(bugId);
        JSONObject jsonObject=new JSONObject(jsonStr);
        bugBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        bugBaseInfo.setStatus(jsonObject.getString(Constants.STATUS));
        bugBaseInfo.setmTime(Date.valueOf(jsonObject.getString(Constants.MODIFY_TIME)));
        return ResultMessageFactory.getResultMessage(bugService.modifyBug(bugBaseInfo));
    }

    @RequestMapping(value = "/{appId}/{bugId}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage deleteBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return ResultMessageFactory.getResultMessage(bugService.deleteBug(bugId));
    }

    @RequestMapping(value = "/{appId}/{bugId}/base", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage getBugBaseInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugBaseInfo bugBaseInfo=bugService.findBug(bugId);
        BugBaseInfoVO bugBaseInfoVO=VOFactory.getBugBaseInfoVO(bugBaseInfo);
        return ResultMessageFactory.getResultMessage(bugBaseInfoVO);
    }



    @RequestMapping(value = "/{appId}/{bugId}/device", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugDeviceInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugDeviceInfoVO bugDeviceInfoVO=VOFactory.getBugDeviceInfoVO(bugService.findDeviceInfoByBugId(bugId));
        return ResultMessageFactory.getResultMessage(bugDeviceInfoVO);
    }

    @RequestMapping(value = "/{appId}/{bugId}/console", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugConsoleLog(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugConsoleLogVO bugConsoleLogVO=VOFactory.getBugConsoleLogVO(bugService.findConsoleLogByBugId(bugId));
        return ResultMessageFactory.getResultMessage(bugConsoleLogVO);
    }

    @RequestMapping(value = "/{appId}/{bugId}/step", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugOperateStep(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugOperateStepVO bugOperateStepVO=VOFactory.getBugOperateStepVO(bugService.findOperateStepByBugId(bugId));
        return ResultMessageFactory.getResultMessage(bugOperateStepVO);
    }

    @RequestMapping(value = "/{appId}/{bugId}/data", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugUserData(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugUserDataVO bugUserDataVO=VOFactory.getBugUserDataVO(bugService.findUserDataByBugId(bugId));
        return ResultMessageFactory.getResultMessage(bugUserDataVO);
    }

    @RequestMapping(value = "/{appId}/{bugId}/network", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getNetworkRequest(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        BugNetRequestVO bugNetRequestVO=VOFactory.getBugNetRequestVO(bugService.findNetRequestByBugId(bugId));
        return ResultMessageFactory.getResultMessage(bugNetRequestVO);
    }

}
