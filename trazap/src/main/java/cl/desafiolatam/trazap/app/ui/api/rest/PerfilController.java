package cl.desafiolatam.trazap.app.ui.api.rest;

import javax.websocket.server.PathParam;

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

import cl.desafiolatam.trazap.app.delegate.PerfilDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Perfil;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	
	@Autowired
	private PerfilDelegate perfilDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getPerfiles() {
		return new ResponseEntity<ResponseServiceObject>(perfilDelegate.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "{idPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getPerfil(@PathVariable Integer idPerfil) throws ServiceException{
		return new ResponseEntity<ResponseServiceObject>(perfilDelegate.findById(idPerfil), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> create(@RequestBody Perfil perfil){
		return new ResponseEntity<ResponseServiceObject>(perfilDelegate.create(perfil), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "{idPerfil}")
	public ResponseEntity<ResponseServiceObject> update(@PathVariable Integer idPerfil, @RequestBody Perfil perfil) {
		return new ResponseEntity<ResponseServiceObject>(perfilDelegate.update(idPerfil, perfil), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{idPerfil}")
	public ResponseEntity<ResponseServiceObject> delete(@PathVariable Integer idPerfil) {
		return new ResponseEntity<ResponseServiceObject>(perfilDelegate.delete(idPerfil), HttpStatus.OK);
	}
	
}
