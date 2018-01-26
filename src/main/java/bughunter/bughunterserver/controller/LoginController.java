package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bughunter")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResultMessage login(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }


}
