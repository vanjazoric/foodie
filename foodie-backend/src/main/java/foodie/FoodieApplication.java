package foodie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import foodie.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@Controller
@Configuration
//@EnableZuulProxy
public class FoodieApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	@GetMapping("/")
	public String home() {
		return "forward:/index.html";
	}

}
