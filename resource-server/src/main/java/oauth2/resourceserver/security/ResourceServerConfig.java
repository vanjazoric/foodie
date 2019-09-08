package oauth2.resourceserver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		{
			http.csrf().disable();
			http.authorizeRequests().antMatchers("/signup", "/sign-up", "/img/**").permitAll().and().authorizeRequests()
					.anyRequest().authenticated();
		}
	}

}