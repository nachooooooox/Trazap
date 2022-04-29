package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.TipoProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("tipoProductoDelegate")
public class TipoProductoDelegateImpl implements TipoProductoDelegate {

	@Autowired
	private TipoProductoService tipoProductoService;
	
	@Override
	public ResponseServiceObject findAll() {
		return tipoProductoService.findAll();
	}

	@Override
	public ResponseServiceObject save(TipoProducto tipoProducto) {
		return tipoProductoService.save(tipoProducto);
	}

	@Override
	public ResponseServiceObject findById(Integer idTipoProducto) {
		return tipoProductoService.findById(idTipoProducto);
	}

	@Override
	public ResponseServiceObject update(TipoProducto tipoProducto, Integer idTipoProducto) {
		return tipoProductoService.update(tipoProducto, idTipoProducto);
	}

	@Override
	public ResponseServiceObject delete(Integer idTipoProducto) {
		return tipoProductoService.delete(idTipoProducto);
	}

}
