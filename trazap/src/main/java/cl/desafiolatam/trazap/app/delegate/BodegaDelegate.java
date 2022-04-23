package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.model.Bodegas;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface BodegaDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodegas bodega);
}
