package cl.desafiolatam.trazap.app.ui.front.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionProductos {

	@GetMapping("/user/gestionProductos")
	public String gestionBodegas() {
		return "/cliente/gestionProducto";
	}
}
