package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.factory.VOFactory;
import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.service.AppService;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.AppBaseInfoVO;
import bughunter.bughunterserver.vo.ResultMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    AppService appService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage addApp(HttpServletRequest request, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        AppBaseInfo appBaseInfo=new AppBaseInfo();
        appBaseInfo.setName(jsonObject.getString(Constants.NAME));
        appBaseInfo.setcTime(new Date(new java.util.Date().getTime()));
        appBaseInfo.setmTime(appBaseInfo.getcTime());
//        appBaseInfo.setCreateTime(Date.valueOf(jsonObject.getString(Constants.CREATE_TIME)));
        appBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        appBaseInfo.setSDKVersion(jsonObject.getDouble(Constants.SDK_VERSION));
        appBaseInfo.setAppKey(jsonObject.getString(Constants.APP_KEY));
        appBaseInfo.setAppSecret(jsonObject.getString(Constants.APP_Secret));
        int id=appService.addApp(appBaseInfo);
        return ResultMessageFactory.getResultMessage(id);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        AppBaseInfo appBaseInfo=appService.findApp(id);
        if(appBaseInfo==null)
            return new ResultMessage(1,Constants.ERROR_NO_EXIST);
        JSONObject jsonObject=new JSONObject(jsonStr);
        appBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        appBaseInfo.setName(jsonObject.getString(Constants.NAME));
        appBaseInfo.setSDKVersion(jsonObject.getDouble(Constants.SDK_VERSION));
        appBaseInfo.setmTime(new Date(new java.util.Date().getTime()));
        return ResultMessageFactory.getResultMessage(appService.modifyApp(appBaseInfo),Constants.ERROR);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteApp(HttpServletRequest request, @PathVariable int id){
        return ResultMessageFactory.getResultMessage(appService.deleteApp(id),Constants.ERROR_NO_EXIST);
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getApp(HttpServletRequest request, @PathVariable int id){
        AppBaseInfo appBaseInfo=appService.findApp(id);
        AppBaseInfoVO appBaseInfoVO= VOFactory.getAppBaseInfoVO(appBaseInfo);
        return ResultMessageFactory.getResultMessage(appBaseInfoVO);
    }

    @RequestMapping(value = "/{developerId}/getAll", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int developerId){
        List<AppBaseInfo> appBaseInfoList=appService.findAllAppsByUserId(developerId);
        if(appBaseInfoList==null)
            return new ResultMessage(1,Constants.ERROR);
        List<AppBaseInfoVO> appBaseInfoVOList=new ArrayList<AppBaseInfoVO>(appBaseInfoList.size());
        for (AppBaseInfo appBaseInfo: appBaseInfoList) {
            AppBaseInfoVO appBaseInfoVO=new AppBaseInfoVO(appBaseInfo);
            appBaseInfoVOList.add(appBaseInfoVO);
        }
        return ResultMessageFactory.getResultMessage(appBaseInfoVOList);
    }

}
