package oauth2.resourceserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import exception.UserAlreadyExistsException;
import oauth2.resourceserver.dto.SignUpRequest;
import oauth2.resourceserver.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	UserService userService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/signup")
	public String signUpPage(Model model) {
		SignUpRequest request = new SignUpRequest();
		model.addAttribute("user", request);
		return "signup";
	}

	@PostMapping("/sign-up")
	public ModelAndView registerUser(@ModelAttribute("user") @Valid SignUpRequest request, BindingResult result,
			Errors errors) {
		if (!result.hasErrors()) {
			try {
				userService.create(request);
			} catch (UserAlreadyExistsException e) {
				result.rejectValue("email", "message.regError");
			}
		}
		if (result.hasErrors()) {
			return new ModelAndView("signup", "user", request);
		} else {
			return new ModelAndView("login", "user", request);
		}

		/*
		 * if (userService.create(signUpRequest)) {
		 * restTemplate.getForObject("http://localhost:9999/login?registered=true",
		 * String.class); } else { redirectAttributes.addFlashAttribute("message",
		 * "Failed"); redirectAttributes.addFlashAttribute("alertClass",
		 * "alert-danger"); } return "redirect:/signup";
		 */
	}
}
