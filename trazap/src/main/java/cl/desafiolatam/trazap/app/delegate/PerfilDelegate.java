package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.dao.model.Perfil;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface PerfilDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(Integer idPerfil);
	public ResponseServiceObject create(Perfil perfil);
	public ResponseServiceObject update(Integer idPerfil,Perfil perfil);
	public ResponseServiceObject delete(Integer idPerfil);
}
