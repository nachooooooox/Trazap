package cl.desafiolatam.trazap.app.ui.front.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionTipoProductoController {
	@GetMapping("/admin/gestionTipoProducto")
	public String gestionCategorias() {
		
		return "/admin/gestionTipoProducto";
	}
	
}
