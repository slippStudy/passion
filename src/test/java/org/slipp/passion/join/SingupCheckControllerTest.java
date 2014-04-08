package org.slipp.passion.join;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slipp.passion.TestContextConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={TestContextConfig.class})
public class SingupCheckControllerTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    SignUpChecker signupChecker;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void 체크_유요한이름() throws Exception {
        when(signupChecker.isReservedUsername(anyString())).thenReturn(true);
        mockMvc.perform(post("/signup_check/username").param("value", ""))
                .andExpect(status().isForbidden())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"success\":false,\"text\":\"Username is a reserved word.\"}"));

        when(signupChecker.isReservedUsername(anyString())).thenReturn(false);
        mockMvc.perform(post("/signup_check/username").param("value", "yangyang"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"success\":true,\"text\":\"\"}"));

    }

    @Test
    public void 체크_중복된이름() throws Exception{
        when(signupChecker.isReservedUsername(anyString())).thenReturn(false);

        String username = "yangwansu";
        when(signupChecker.isDuplicatedUsername(username)).thenReturn(false);
        mockMvc.perform(post("/signup_check/username").param("value", username))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"success\":true,\"text\":\"\"}"));

        when(signupChecker.isDuplicatedUsername(username)).thenReturn(true);
        mockMvc.perform(post("/signup_check/username").param("value", username))
                .andExpect(status().isForbidden())
                .andExpect(content().string("{\"success\":false,\"text\":\"Username is already taken.\"}"));
    }

    @Test
    public void 체크_유효한이메일() throws Exception{
        when(signupChecker.isReservedEmail(anyString())).thenReturn(false);
        mockMvc.perform(post("/signup_check/email").param("value", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"success\":true,\"text\":\"\"}"));

        when(signupChecker.isReservedEmail(anyString())).thenReturn(true);
        mockMvc.perform(post("/signup_check/email").param("value", "ywsaau77@gmail.com"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("{\"success\":false,\"text\":\"Email is a reserved word.\"}"));

        //Email is invalid or already taken
    }

    @Test
    public void 체크_중복된이메일() throws Exception{
        when(signupChecker.isReservedEmail(anyString())).thenReturn(false);

        when(signupChecker.isDuplicatedEmail(anyString())).thenReturn(false);
        mockMvc.perform(post("/signup_check/email").param("value", "ywsaau77@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"success\":true,\"text\":\"\"}"));

        when(signupChecker.isDuplicatedEmail(anyString())).thenReturn(true);
        mockMvc.perform(post("/signup_check/email").param("value", "ywsaau77@gmail.com"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("{\"success\":false,\"text\":\"Email is already taken.\"}"));
    }

    @Test
    public void 체크_패스워드유효성체크() throws  Exception {
        when(signupChecker.isValidPassword(anyString())).thenReturn(false);
        mockMvc.perform(post("/signup_check/password").param("value", ""))
                .andExpect(status().isForbidden())
                .andExpect(content().string("{\"success\":false,\"text\":\"Password is not valid\"}"));

        when(signupChecker.isValidPassword(anyString())).thenReturn(true);
        mockMvc.perform(post("/signup_check/password").param("value", "sdkhlsjglwsdf"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"success\":true,\"text\":\"\"}"));
    }
}
