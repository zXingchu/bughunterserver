package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app/bug")
public class BugInofController {

    @RequestMapping(value = "/{appId}/submit", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage submitBug(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/getSimilarity", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugSimilarity(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int appId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage deleteBug(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }


    @RequestMapping(value = "/{appId}/{bugId}/base", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage getBugBaseInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/device", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugDeviceInfo(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/console", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugConsoleLog(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/step", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugOperateStep(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/data", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getBugUserData(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{appId}/{bugId}/network", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getNetworkRequest(HttpServletRequest request, @PathVariable int appId, @PathVariable int bugId, @RequestBody String jsonStr){
        return null;
    }



}
