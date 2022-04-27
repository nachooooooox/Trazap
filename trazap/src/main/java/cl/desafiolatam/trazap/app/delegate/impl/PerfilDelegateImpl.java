package cl.desafiolatam.trazap.app.delegate.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.PerfilDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Perfil;
import cl.desafiolatam.trazap.app.service.PerfilService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("perfilFacade")
public class PerfilDelegateImpl implements PerfilDelegate{

	@Autowired
	PerfilService perfilService;
	
	@Override
	public ResponseServiceObject findAll() {
		return perfilService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idPerfil) throws ServiceException{
		return perfilService.findById(idPerfil);
	}

	@Override
	public ResponseServiceObject create(Perfil perfil) {
		return perfilService.create(perfil);
	}

	@Override
	public ResponseServiceObject update(Integer idPerfil,Perfil perfil) {
		return perfilService.update(idPerfil, perfil);
	}

	@Override
	public ResponseServiceObject delete(Integer idPerfil) {
		return perfilService.delete(idPerfil);
	}

}
