package cl.desafiolatam.trazap.app.ui.front.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user")
	public String getHome() {
		return "/cliente/home";
	}
}
