package org.slipp.passion.imsi;

import javax.servlet.http.HttpSession;

public class SessionedUserRoleAccessor {

	private HttpSession session;

	public SessionedUserRoleAccessor(HttpSession session) {
		this.session =session;
	}

	public String get() {
		return getRole(session);
	}
	
	private String getRole(HttpSession session) {
		return (String) (null == session.getAttribute("USER_ROLE") ? "GENERAL" : session.getAttribute("USER_ROLE"));
	}

	public void setAdmin() {
		session.setAttribute("USER_ROLE", "ADMIN");
		
	}

	public void setGeneral() {
		session.setAttribute("USER_ROLE", "GENERAL");
	}

}
