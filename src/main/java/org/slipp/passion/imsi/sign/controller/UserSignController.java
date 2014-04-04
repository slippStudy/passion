package org.slipp.passion.imsi.sign.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slipp.passion.imsi.sign.service.UserSignService;
import org.slipp.passion.imsi.sign.vo.UserSignVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserSignController {
    
    @Resource(name = "userSignService")
    private UserSignService userSignService;

    @RequestMapping(value="/imsi/sign/sign",method=RequestMethod.GET)
    public String statePage(HttpSession session, Model model) {
        
        return "imsi/sign/sign";
    }
    
    @RequestMapping(value = "/imsi/sign/signinForm", method=RequestMethod.POST)
    public String signinForm(@ModelAttribute("signup") UserSignVo userSignVo,
            Model model) throws Exception {
        
        UserSignVo userId = userSignService.getUser(userSignVo.getLogin_id());
        
        if (userId.getLogin_id().equals(userSignVo.getLogin_id()) && userId.getLogin_id().equals(userSignVo.getLogin_id())) {
            List<UserSignVo> list = this.userSignService.getList();
            model.addAttribute("list", list);
     
            return "imsi/user/userList";
        } else {
            return "imsi/sign/sign";
        }
        
    }
    
    @RequestMapping(value = "/imsi/sign/signupForm", method=RequestMethod.POST)
    public String signupForm(@ModelAttribute("signup") UserSignVo userSignVo,
            Model model) throws Exception {
        
        userSignService.insert(userSignVo);
        
        List<UserSignVo> list = this.userSignService.getList();
        model.addAttribute("list", list);
 
        return "imsi/user/userList";
    }
    
}
