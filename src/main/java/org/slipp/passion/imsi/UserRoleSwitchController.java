package org.slipp.passion.imsi;

import javax.servlet.http.HttpSession;

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

	  
	
	@RequestMapping(value="/imsi/role/state",method=RequestMethod.GET)
	public String statePage(HttpSession session, Model model){
		; 
		model.addAttribute(USER_ROLE, getUserRoleAccessor(session).get());
		return "imsi/role/state";
	}


	private SessionedUserRoleAccessor getUserRoleAccessor(HttpSession session) {
		return new SessionedUserRoleAccessor(session);
	}

	
	@RequestMapping(value="/imsi/role/state",method=RequestMethod.POST)
	public String setRoleState(@RequestParam(defaultValue=GENERAL) String role, HttpSession session){
		switch(role){
		case ADMIN:
			getUserRoleAccessor(session).setAdmin();
			break;
		case GENERAL:
		default:
			getUserRoleAccessor(session).setGeneral();
			
		}
		return "redirect:/imsi/role/state";
	}
	
}
