package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface BodegaDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodegas bodega);
	public ResponseServiceObject findById(Integer idBodega);
	public ResponseServiceObject update(Bodegas bodegas, Integer idBodega);
	public ResponseServiceObject delete(Integer idBodega);
}
