package org.slipp.passion.admin;

import javax.servlet.http.HttpServletResponse;

import org.slipp.passion.imsi.UserRoleAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@Autowired UserRoleAccessor userRoleAccessor;
	
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String admin(HttpServletResponse response){
		if(false == userRoleAccessor.isAdmin()){
			response.setStatus(HttpStatus.FORBIDDEN.value());
			return "forbidden";
		}
		
		return "admin";
	}
}
