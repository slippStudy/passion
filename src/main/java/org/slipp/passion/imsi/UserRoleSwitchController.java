package org.slipp.passion.imsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserRoleSwitchController {

	static final String GENERAL = "GENERAL";
	static final String ADMIN = "ADMIN";
	static final String USER_ROLE = "USER_ROLE";

    @Autowired
    SessionedUserRoleSetter sessionedUserRoleSetter;
	
	@RequestMapping(value="/imsi/role/state",method=RequestMethod.GET)
	public String statePage(Model model){
        model.addAttribute(USER_ROLE, sessionedUserRoleSetter.get());
		return "imsi/role/state";
	}

    @RequestMapping(value="/imsi/role/state",method=RequestMethod.POST)
	public String setRoleState(@RequestParam(defaultValue=GENERAL) String role){
        switch(role){
		case ADMIN:
            sessionedUserRoleSetter.setAdmin();
			break;
		case GENERAL:
		default:
            sessionedUserRoleSetter.setGeneral();
			
		}
		return "redirect:/imsi/role/state";
	}
	
}
