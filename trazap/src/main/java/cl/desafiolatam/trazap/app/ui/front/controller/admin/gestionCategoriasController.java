package cl.desafiolatam.trazap.app.ui.front.controller.admin;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class gestionCategoriasController {
	
	@GetMapping("/admin/gestionCategorias")
	public String gestionCategorias(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object details = auth.getDetails();
		Object credentials = auth.getCredentials();
		Iterator<GrantedAuthority> itCredentials = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
		Object principal = auth.getPrincipal();
		String name = auth.getName();
		return "/admin/gestionCategorias";
	}

}
