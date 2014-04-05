package org.slipp.passion.admin;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slipp.passion.TestContextConfig;
import org.slipp.passion.imsi.UserRoleAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={TestContextConfig.class})
public class AdminControllerTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    UserRoleAccessor userRoleAccessor;
    
    protected MockHttpSession mockSession;
    
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        mockSession = new MockHttpSession(wac.getServletContext(), UUID.randomUUID().toString());
    }
    @Test
    public void 언떤롤이든_root에_접근할수없다() throws Exception{
    	when(userRoleAccessor.isAdmin()).thenReturn(true);
    	mockMvc.perform(get("/"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("hello"));
    	
    	when(userRoleAccessor.isAdmin()).thenReturn(false);
    	mockMvc.perform(get("/"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("hello"));
    	
    }
    
    @Test
    public void 일반사용자는_admin에_접근할수없다() throws Exception{
    	when(userRoleAccessor.isAdmin()).thenReturn(false);
    	mockMvc.perform(get("/admin"))
    	.andExpect(status().isForbidden())
    	.andExpect(view().name("forbidden"));
    }
    
    @Test
    public void 관리자는_어드민에_접근할수있다() throws Exception{
    	when(userRoleAccessor.isAdmin()).thenReturn(true);
    	mockMvc.perform(get("/admin"))
    	.andExpect(status().isOk())
    	.andExpect(view().name("admin"));
    }
    
    @Test
	public void 임시로_만들어둔_사용자_권한_변경페이지는_누구나_접근_할_수_있다() throws Exception {
		
	}
    

}
