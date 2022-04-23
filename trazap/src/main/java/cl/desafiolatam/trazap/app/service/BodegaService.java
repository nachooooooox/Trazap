package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.model.Bodegas;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface BodegaService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodegas bodega);
}
