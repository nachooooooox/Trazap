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

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/tipoProducto")
public class TipoProductoController {

	@Autowired
	private TipoProductoDelegate tipoProductoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getTipoProductos(){
		return new ResponseEntity<ResponseServiceObject>(tipoProductoDelegate.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "{idTipoProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getTipoProducto(@PathVariable Integer idTipoProducto) {
		return new ResponseEntity<ResponseServiceObject>(tipoProductoDelegate.findById(idTipoProducto), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> create(@RequestBody TipoProducto tipoProducto) {
		return new ResponseEntity<ResponseServiceObject>(tipoProductoDelegate.save(tipoProducto), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "{idTipoProducto}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> update(@RequestBody TipoProducto tipoProducto, @PathVariable Integer idTipoProducto) {
		return new ResponseEntity<ResponseServiceObject>(tipoProductoDelegate.update(tipoProducto, idTipoProducto), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{idTipoProducto}")
	public ResponseEntity<ResponseServiceObject> delete(@PathVariable Integer idTipoProducto) {
		return new ResponseEntity<ResponseServiceObject>(tipoProductoDelegate.delete(idTipoProducto), HttpStatus.OK);
	}
	
}
