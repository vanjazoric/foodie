package oauth2.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/login-page")
	public String registerClient(@RequestParam String registered) {
		return "redirect:/login?registered=true";
	}
}
