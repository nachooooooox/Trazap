package cl.desafiolatam.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private Categorias categorias;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void getCategorias(){
		System.out.println(categorias.getIdCategoria());
		System.out.println(categorias.getNombre());
	}

}
