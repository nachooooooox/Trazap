package cl.desafiolatam.trazap.app.ui.front.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionBodegas {

	@GetMapping("/user/gestionBodegas")
	public String gestionBodegas() {
		return "/cliente/gestionBodega";
	}
}
