package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/developerLogin")
    public @ResponseBody
    ResultMessage developerLogin(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }


    @RequestMapping("/testerLogin")
    public @ResponseBody
    ResultMessage  testerLogin(HttpServletRequest request,@RequestBody String jsonStr){
        return null;
    }


}
