package org.slipp.passion.imsi;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserSignController {

    @RequestMapping(value="/imsi/sign/sign",method=RequestMethod.GET)
    public String statePage(HttpSession session, Model model){
        
        return "imsi/sign/sign";
    }
    
}
