package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("tipoProductoDelegate")
public class TipoProductoDelegateImpl implements TipoProductoDelegate {

	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject save(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return null;
	}

}
