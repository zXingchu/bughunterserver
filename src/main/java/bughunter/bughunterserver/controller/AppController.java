package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class AppController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage createApp(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getApp(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{developerId}/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getAllApps(HttpServletRequest request, @PathVariable int developerId, @RequestBody String jsonStr){
        return null;
    }

}
