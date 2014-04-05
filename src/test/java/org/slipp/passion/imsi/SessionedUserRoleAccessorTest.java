package org.slipp.passion.imsi;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;


public class SessionedUserRoleAccessorTest {
	
	SessionedUserRoleAccessor dut;

	@Before
	public void before(){
		HttpSession session =new MockHttpSession();
		dut = new SessionedUserRoleAccessor(session);
	}
	
	@Test
	public void 초기롤은_일반이다(){
		assertThat(dut.get(), is("GENERAL"));
		assertThat(dut.isAdmin(), is(false));
	}
	
	@Test
	public void 관리자설정및_확인(){
		dut.setAdmin();
		assertThat(dut.get(), is("ADMIN"));
		assertThat(dut.isAdmin(), is(true));
	}
	
	@Test
	public void 일반설정및_확인(){
		dut.setAdmin();
		dut.setGeneral();
		assertThat(dut.get(), is("GENERAL"));
	}
}
