package cl.desafiolatam.trazap.app.ui.api.rest;

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

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/user/bodegasApi")
public class BodegaController {
	
	@Autowired
	private BodegaDelegate bodegaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBodegas(){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "{idBodega}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBogega(@PathVariable Integer idBodega) {
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findById(idBodega), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idBodega}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateBodega(@PathVariable Integer idBodega, @RequestBody Bodegas bodegas) {
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.update(bodegas, idBodega), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createBodega(@RequestBody Bodegas bodegas) {
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.save(bodegas), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{idBodega}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> deleteBodega(@PathVariable Integer idBodega) {
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.delete(idBodega), HttpStatus.OK);
	}
}
