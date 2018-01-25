package bughunter.bughunterserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/my")
    public @ResponseBody
    String  myBooks(){
        return "hello";
    }

}
