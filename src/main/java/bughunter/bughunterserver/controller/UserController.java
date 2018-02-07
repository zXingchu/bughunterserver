package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.ResultMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    ResultMessage resultMessage;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage addUser(HttpServletRequest request, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        User user=new User();
        user.setName(jsonObject.getString(Constants.NAME));
        user.setEmail(jsonObject.getString(Constants.EMAIL));
        user.setPwd(jsonObject.getString(Constants.PWD));
        user.setTeleNumber(jsonObject.getString(Constants.TeleNumber));
        int id=userService.addUser(user);
        return ResultMessageFactory.getResultMessage(id);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        User user=userService.findUser(id);
        JSONObject jsonObject=new JSONObject(jsonStr);
        user.setName(jsonObject.getString(Constants.NAME));
        user.setTeleNumber(jsonObject.getString(Constants.TeleNumber));
        user.setEmail(jsonObject.getString(Constants.EMAIL));
        if(jsonObject.has(Constants.PWD))
            user.setPwd(jsonObject.getString(Constants.PWD));
        return ResultMessageFactory.getResultMessage(userService.modifyUser(user));
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        return ResultMessageFactory.getResultMessage(userService.deleteUser(id));
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  getUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        User user=userService.findUser(id);
        return ResultMessageFactory.getResultMessage(user);
    }

}
