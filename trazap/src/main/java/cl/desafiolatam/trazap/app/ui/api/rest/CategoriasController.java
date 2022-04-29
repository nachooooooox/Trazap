package cl.desafiolatam.trazap.app.ui.api.rest;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.trazap.app.delegate.CategoriasDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
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
	
	@GetMapping(path = "{idCategoria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getCategoria(@PathVariable Integer idCategoria) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(categoriasDelegate.findById(idCategoria), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> create(@RequestBody Categorias categorias){
		return new ResponseEntity<ResponseServiceObject>(categoriasDelegate.create(categorias), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idCategoria}")
	public ResponseEntity<ResponseServiceObject> update(@PathVariable Integer idCategoria, @RequestBody Categorias categorias){
		return new ResponseEntity<ResponseServiceObject>(categoriasDelegate.update(idCategoria, categorias), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{idCategoria}")
	public ResponseEntity<ResponseServiceObject> delete(@PathVariable Integer idCategoria){
		return new ResponseEntity<ResponseServiceObject>(categoriasDelegate.delete(idCategoria), HttpStatus.OK);
	}
	
}
