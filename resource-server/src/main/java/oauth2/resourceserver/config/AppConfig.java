package oauth2.resourceserver.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	/*
	 * @Bean public SpringResourceTemplateResolver templateResolver() {
	 * SpringResourceTemplateResolver templateResolver = new
	 * SpringResourceTemplateResolver();
	 * templateResolver.setPrefix("classpath:/templates/");
	 * templateResolver.setSuffix(".html"); templateResolver.setCacheable(true);
	 * return templateResolver; }
	 * 
	 * @Bean public SpringSecurityDialect springSecurityDialect() { return new
	 * SpringSecurityDialect(); }
	 * 
	 * @Bean public SpringTemplateEngine templateEngine() { SpringTemplateEngine
	 * templateEngine = new SpringTemplateEngine();
	 * templateEngine.setTemplateResolver(templateResolver());
	 * templateEngine.addDialect(springSecurityDialect()); return templateEngine; }
	 * 
	 */
}
