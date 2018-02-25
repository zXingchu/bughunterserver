package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
import bughunter.bughunterserver.model.entity.User;
import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.ResultMessage;
import bughunter.bughunterserver.vo.UserVO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage addUser(HttpServletRequest request, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        User user=new User();
        user.setName(jsonObject.getString(Constants.NAME));
        user.setEmail(jsonObject.getString(Constants.EMAIL));
        user.setPwd(jsonObject.getString(Constants.PWD));
        user.setTeleNumber(jsonObject.getString(Constants.TeleNumber));
        user.setStatus(Constants.STATUS_NOT_ACTIVE);
        int id=userService.addUser(user);
        userService.sendActiveEmail(user.getEmail());
        return ResultMessageFactory.getResultMessage(id);
    }

    @RequestMapping(value = "/{id}/sendActiveEmail", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage sendActiveEmail(HttpServletRequest request, @PathVariable int id){
        //TODO 保存验证码
        //Verification Code
        String vc=userService.sendActiveEmail(userService.findUser(id).getEmail());
        return new ResultMessage(0,vc);
    }

    @RequestMapping(value = "/{id}/active", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage activeUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        //TODO 读取用户输入的验证码，与保存的验证码对比
        return ResultMessageFactory.getResultMessage(userService.activeUser(id),Constants.ERROR);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  modifyUser(HttpServletRequest request, @PathVariable int id, @RequestBody String jsonStr){
        JSONObject jsonObject=new JSONObject(jsonStr);
        return ResultMessageFactory.getResultMessage(userService.modifyUser(id,jsonObject),Constants.ERROR);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage  deleteUser(HttpServletRequest request, @PathVariable int id){
        return ResultMessageFactory.getResultMessage(userService.deleteUser(id),Constants.ERROR_NO_EXIST);
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.GET)
    public @ResponseBody
    ResultMessage  getUser(HttpServletRequest request, @PathVariable int id){
        UserVO user=userService.findUser(id);
        return ResultMessageFactory.getResultMessage(user);
    }

}
