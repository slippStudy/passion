package org.slipp.passion.imsi;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.slipp.passion.imsi.UserRoleSwitchController.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","classpath:/testContext.xml"})
public class UserRoleSwitchControllerTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    protected MockHttpSession mockSession;

    
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        mockSession = new MockHttpSession(wac.getServletContext(), UUID.randomUUID().toString());
    }
    
    @Test
    public void goRoleStatePage() throws Exception{
		mockMvc.perform(get("/imsi/role/state"))
		.andExpect(view().name("imsi/role/state"))
		.andExpect(model().attribute(USER_ROLE, GENERAL));
    }
    
    @Test
    public void 세션에관리자로설정() throws Exception{
		mockMvc.perform(post("/imsi/role/state").param("role", ADMIN).session(mockSession))
		.andExpect(request().sessionAttribute(USER_ROLE, ADMIN))
		.andExpect(redirectedUrl("/imsi/role/state"));
		

		mockMvc.perform(get("/imsi/role/state").session(mockSession))
		.andExpect(model().attribute(USER_ROLE, ADMIN));
    }
    
    @Test
    public void 세션에일반사용자로설정() throws Exception{
		mockMvc.perform(post("/imsi/role/state").param("role", GENERAL).session(mockSession))
		.andExpect(request().sessionAttribute(USER_ROLE, GENERAL))
		.andExpect(redirectedUrl("/imsi/role/state"));
		
		mockMvc.perform(get("/imsi/role/state").session(mockSession))
		.andExpect(model().attribute(USER_ROLE, GENERAL));
    }
    
    @Test
    public void 세션에일반사용자로설정_파람안넘겼을() throws Exception{
		mockMvc.perform(post("/imsi/role/state").session(mockSession))
		.andExpect(request().sessionAttribute(USER_ROLE, GENERAL))
		.andExpect(redirectedUrl("/imsi/role/state"));
    }
    
    
}
