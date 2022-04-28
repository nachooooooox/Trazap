package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.BodegaDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
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

	@Override
	public ResponseServiceObject findById(Integer idBodega) {
		return bodegaService.findById(idBodega);
	}

	@Override
	public ResponseServiceObject update(Bodegas bodegas, Integer idBodega) {
		return bodegaService.update(bodegas, idBodega);
	}

	@Override
	public ResponseServiceObject delete(Integer idBodega) {
		return bodegaService.delete(idBodega);
	}


}
