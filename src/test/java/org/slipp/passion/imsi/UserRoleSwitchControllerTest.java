package org.slipp.passion.imsi;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.slipp.passion.imsi.UserRoleSwitchController.ADMIN;
import static org.slipp.passion.imsi.UserRoleSwitchController.GENERAL;
import static org.slipp.passion.imsi.UserRoleSwitchController.USER_ROLE;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slipp.passion.TestContextConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes={TestContextConfig.class})
public class UserRoleSwitchControllerTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired SessionedUserRoleSetter sessionedUserRoleSetter;

    protected MockHttpSession mockSession;

    
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(wac).build();
        mockSession = new MockHttpSession(wac.getServletContext(), UUID.randomUUID().toString());
    }
    
    @Test
    public void 롤변경페이지이동() throws Exception{
        when(sessionedUserRoleSetter.get()).thenReturn(GENERAL);

		mockMvc.perform(get("/imsi/role/state"))
		.andExpect(view().name("imsi/role/state"))
		.andExpect(model().attribute(USER_ROLE, GENERAL));
    }
    
    @Test
    public void 세션에관리자로설정() throws Exception{
		mockMvc.perform(post("/imsi/role/state").param("role", ADMIN))
		.andExpect(redirectedUrl("/imsi/role/state"));
		
        verify(sessionedUserRoleSetter).setAdmin();
    }

    @Test
    public void 세션에일반사용자로설정() throws Exception{
        mockMvc.perform(post("/imsi/role/state").param("role", GENERAL))
                .andExpect(redirectedUrl("/imsi/role/state"));

        verify(sessionedUserRoleSetter).setGeneral();
    }

    @Test
    public void 세션에일반사용자로설정_파람안넘겼을() throws Exception{
        mockMvc.perform(post("/imsi/role/state"))
                .andExpect(redirectedUrl("/imsi/role/state"));

        verify(sessionedUserRoleSetter).setGeneral();
    }
    
    
}
