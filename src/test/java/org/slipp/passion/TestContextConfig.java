package org.slipp.passion;

import static org.mockito.Mockito.mock;

import org.slipp.passion.imsi.HelloService;
import org.slipp.passion.imsi.SessionedUserRoleAccessor;
import org.slipp.passion.imsi.SessionedUserRoleSetter;
import org.slipp.passion.imsi.UserRoleAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class TestContextConfig{

	@Bean
	public HelloService helloService(){
		return new HelloService();
	}
	
	@Bean
	public UserRoleAccessor userRoleAccessor(){
		return mock(UserRoleAccessor.class);
	}

    @Bean
    public SessionedUserRoleSetter sessionedUserRoleSetter(){
        SessionedUserRoleSetter sessionedUserRoleSetter = mock(SessionedUserRoleSetter.class);
        return sessionedUserRoleSetter;
    }


}