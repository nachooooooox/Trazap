package cl.desafiolatam.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
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
	
}
