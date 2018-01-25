package bughunter.bughunterserver.controller;

import bughunter.bughunterserver.vo.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app/test")
public class AppTestController {

    @RequestMapping("/bug/submit")
    public @ResponseBody
    ResultMessage submitBug(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }

    @RequestMapping("/bug/getSimilarity")
    public @ResponseBody
    ResultMessage  getBugSimilarity(HttpServletRequest request, @RequestBody String jsonStr){
        return null;
    }


}
