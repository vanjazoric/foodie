package oauth2.authserver;

import java.security.KeyPair;
import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import oauth2.authserver.service.CustomClientDetailsServiceImpl;
import oauth2.authserver.service.CustomUserDetailsService;

@SpringBootApplication
@Controller
@SessionAttributes("authorizationRequest")
public class AuthServerApplication implements WebMvcConfigurer {

	private ApplicationContext applicationContext;

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		/*
		 * SpringResourceTemplateResolver automatically integrates with Spring's own //
		 * resource resolution infrastructure, which is highly recommended.
		 */
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		/*
		 * HTML is the default value, added here for the sake of clarity.
		 * templateResolver.setTemplateMode(TemplateMode.HTML); // Template cache is
		 * true by default. Set to false if you want // templates to be automatically
		 * updated when modified.
		 */
		templateResolver.setCacheable(true);
		return templateResolver;
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		/*
		 * // SpringTemplateEngine automatically applies SpringStandardDialect and //
		 * enables Spring's own MessageSource message resolution mechanisms.
		 */
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(springSecurityDialect());
		return templateEngine;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
		registry.addViewController("/client-registration").setViewName("client-registration");
		registry.addViewController("/credentials").setViewName("credentials");
		registry.addViewController("/apis").setViewName("apis");
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Configuration
	@Order(-20)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private CustomUserDetailsService userDetailsService;
		
		@Bean
		PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}

		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off

			http.formLogin().loginPage("/login").permitAll().and().requestMatchers()
					.antMatchers("/login", "/logout", "/user", "/oauth/authorize", "/oauth/confirm_access",
							"/client-registration", "/create-client")
					.and().authorizeRequests().anyRequest().authenticated().and().logout().logoutUrl("/logout")
					.logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID").and()
					.httpBasic().disable();
			// @formatter:on

		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}
	}

	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private CustomClientDetailsServiceImpl clientDetailsService;

		@Bean
		public TokenStore tokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter());
		}

		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray())
					.getKeyPair("test");
			converter.setKeyPair(keyPair);
			return converter;
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetailsService);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(new BCryptPasswordEncoder(8));
		}

	}
}