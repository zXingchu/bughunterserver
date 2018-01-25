package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app/bugInfo")
public class BugInofController {

    @RequestMapping("/bug")
    public @ResponseBody
    ResultMessage getBugInfo(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/device")
    public @ResponseBody
    ResultMessage  getDeviceInfo(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/console")
    public @ResponseBody
    ResultMessage  getConsoleLog(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/step")
    public @ResponseBody
    ResultMessage  getOperateStep(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/data")
    public @ResponseBody
    ResultMessage  getUserData(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/network")
    public @ResponseBody
    ResultMessage  getNetworkRequest(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }



}
