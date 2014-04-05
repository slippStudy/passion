package org.slipp.passion.imsi;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionedUserRoleAccessor implements UserRoleAccessor, SessionedUserRoleSetter {

	private HttpSession session;

    public SessionedUserRoleAccessor(){
    }

	SessionedUserRoleAccessor(HttpSession session) {
		this.session =session;
	}

    HttpSession getSession(){
        return session==null?
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(true):session;
    }

	@Override
    public String get() {
		return getRole(getSession());
	}
	
	private String getRole(HttpSession session) {
		return (String) (null == session.getAttribute("USER_ROLE") ? "GENERAL" : session.getAttribute("USER_ROLE"));
	}

	@Override
    public void setAdmin() {
        getSession().setAttribute("USER_ROLE", "ADMIN");
		
	}

	@Override
    public void setGeneral() {
        getSession().setAttribute("USER_ROLE", "GENERAL");
	}

	/* (non-Javadoc)
	 * @see org.slipp.passion.imsi.UserRoleAccessor#isAdmin()
	 */
	@Override
	public boolean isAdmin() {
		return "ADMIN".equals(get());
	}

}
