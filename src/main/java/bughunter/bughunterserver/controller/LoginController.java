package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.service.UserService;
import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.ResultMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bughunter")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage login(HttpServletRequest request, @RequestBody String jsonStr){

        JSONObject jsonObject=new JSONObject(jsonStr);
        Integer uid= Integer.valueOf(jsonObject.getString(Constants.USER_ID));
        String email=jsonObject.getString(Constants.EMAIL);
        String pwd=jsonObject.getString(Constants.PWD);
        ResultMessage resultMessage;
        if(userService.testLogin(uid,pwd))
            resultMessage=new ResultMessage(0);
        else
            resultMessage=new ResultMessage(1,"登录错误");
        return resultMessage;
    }


}
