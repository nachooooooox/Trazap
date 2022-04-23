package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.repository.model.Bodegas;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("bodegaDelegate")
public class BodegaDelegateImpl implements BodegaDelegate {

	@Autowired
	private BodegaService bodegaService;
	
	@Override
	public ResponseServiceObject findAll() {
		return bodegaService.findAll();
	}

	@Override
	public ResponseServiceObject save(Bodegas bodega) {
		return bodegaService.save(bodega);
	}


}
