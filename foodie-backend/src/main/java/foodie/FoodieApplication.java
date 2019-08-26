package foodie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import foodie.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@Controller
//@EnableZuulProxy
public class FoodieApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "forward:/index.html";
	}

}
