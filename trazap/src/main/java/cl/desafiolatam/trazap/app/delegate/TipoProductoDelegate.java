package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface TipoProductoDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(TipoProducto tipoProducto);
}
