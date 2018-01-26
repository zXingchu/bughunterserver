package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
public class UserController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage createUser(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return null;
    }

}
