package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.model.entity.AppBaseInfo;
import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.service.AppService;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.ResultMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    AppService appService;

    ResultMessage resultMessage;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage addApp(HttpServletRequest request, @RequestBody String jsonStr){

        JSONObject jsonObject=new JSONObject(jsonStr);
        AppBaseInfo appBaseInfo=new AppBaseInfo();
        appBaseInfo.setName(jsonObject.getString(Constants.NAME));
        appBaseInfo.setCreateTime(Date.valueOf(jsonObject.getString(Constants.CREATE_TIME)));
        appBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        appBaseInfo.setSDKVersion(Double.parseDouble(jsonObject.getString(Constants.SDK_VERSION)));
        appBaseInfo.setAppKey(jsonObject.getString(Constants.APP_KEY));
        appBaseInfo.setAppSecret(jsonObject.getString(Constants.APP_Secret));
        int id=appService.addApp(appBaseInfo);
        if(id>0){
            resultMessage=new ResultMessage(0,"",id);
        }else {
            resultMessage=new ResultMessage(1,Constants.ERROR);
        }
        return resultMessage;
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        AppBaseInfo appBaseInfo=appService.findApp(id);
        JSONObject jsonObject=new JSONObject(jsonStr);
        appBaseInfo.setType(jsonObject.getString(Constants.TYPE));
        appBaseInfo.setName(jsonObject.getString(Constants.NAME));
        if(appService.modifyApp(appBaseInfo))
            resultMessage=new ResultMessage(0);
        else
            resultMessage=new ResultMessage(1,Constants.ERROR);
        return resultMessage;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        if(appService.deleteApp(id))
            resultMessage=new ResultMessage(0);
        else
            resultMessage=new ResultMessage(1,Constants.ERROR);
        return resultMessage;
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        AppBaseInfo appBaseInfo=appService.findApp(id);
        if(appBaseInfo==null)
            resultMessage=new ResultMessage(1,Constants.ERROR);
        else
            resultMessage=new ResultMessage(0,Constants.OKSTR,appBaseInfo);
        return resultMessage;
    }

    @RequestMapping(value = "/{developerId}/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int developerId, @RequestBody String jsonStr){
        List<AppBaseInfo> appBaseInfoList=appService.findAllAppsByUserId(developerId);
        if(appBaseInfoList==null)
            resultMessage=new ResultMessage(1,Constants.ERROR);
        else
            resultMessage=new ResultMessage(0,Constants.OKSTR,appBaseInfoList);
        return resultMessage;
    }

}
