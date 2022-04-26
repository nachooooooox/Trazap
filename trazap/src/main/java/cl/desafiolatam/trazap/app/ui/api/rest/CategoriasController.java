package cl.desafiolatam.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.trazap.app.delegate.CategoriasDelegate;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasDelegate categoriasDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getCategorias(){
		System.out.println(categoriasDelegate.findAll().toString());
		return new ResponseEntity<ResponseServiceObject>(categoriasDelegate.findAll(), HttpStatus.OK);
	}

}
