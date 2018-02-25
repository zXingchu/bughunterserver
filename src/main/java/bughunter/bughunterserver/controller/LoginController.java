package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.factory.ResultMessageFactory;
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
    ResultMessage login(HttpServletRequest request){
//        Integer uid= Integer.valueOf(jsonObject.getString(Constants.USER_ID));
        String email=request.getHeader(Constants.EMAIL);
        String pwd=request.getHeader(Constants.PWD);
        ResultMessage resultMessage;
        switch (userService.testLogin(email,pwd)) {
            case -2:
                return new ResultMessage(1,Constants.ERROR_NO_EXIST);
            case -1:
                return new ResultMessage(2,Constants.ERROR_NO_ACTIVE);
            case 0:
                return new ResultMessage(3,Constants.ERROR_PWD);
            case 1:
                return new ResultMessage(0);
            default:
                return new ResultMessage(4,Constants.ERROR);
        }
    }

    @RequestMapping(value = "/isExist", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage isExist(HttpServletRequest request){
        String emailAddr=request.getHeader(Constants.EMAIL);
        return ResultMessageFactory.getResultMessage(userService.findByEmail(emailAddr)!=null,Constants.ERROR_NO_EXIST);
    }


}
