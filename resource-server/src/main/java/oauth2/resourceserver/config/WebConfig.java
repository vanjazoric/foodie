package oauth2.resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
	 * ; }
	 */

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/signup").setViewName("signup");
	}
}