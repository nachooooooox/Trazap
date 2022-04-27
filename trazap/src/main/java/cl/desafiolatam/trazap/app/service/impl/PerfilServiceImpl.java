package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.PerfilRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Perfil;
import cl.desafiolatam.trazap.app.service.PerfilService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Autowired
	private ResponseServiceObject responseServiceObject;
	
	List<ResponseServiceMessage> messageList = null;
	
	@Override
	public ResponseServiceObject findAll() {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		List<Perfil> perfiles = new ArrayList<Perfil>();
		Iterable<Perfil> itPerfiles = perfilRepository.findAll();
		itPerfiles.forEach(perfiles::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(perfiles);
		responseServiceObject.setMessageList(this.messageList);
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idPerfil) throws ServiceException{
		this.messageList = new ArrayList<ResponseServiceMessage>();
		Perfil perfil = new Perfil();
		responseServiceMessage.setTimestamp(new Date());
		try {
			perfil = perfilRepository.findById(idPerfil).get();
			
			
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("Búsqueda finalizada");
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setBody(perfil);
			responseServiceObject.setMessageList(messageList);
			return responseServiceObject;
		} catch (NoSuchElementException ex) {
			responseServiceMessage.setCode("404");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("No existen registros con el ID " + idPerfil);
			
			this.messageList.add(responseServiceMessage);
			responseServiceObject.setMessageList(messageList);
			return responseServiceObject;
		} catch (Exception e) {
			throw new ServiceException("Error en el servicio");
		}
	}

	@Override
	public ResponseServiceObject create(Perfil perfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		responseServiceObject.setBody(perfilRepository.save(perfil));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro ingresado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(Integer idperfil, Perfil perfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		perfil.setIdPerfil(idperfil);
		responseServiceObject.setBody(perfilRepository.save(perfil));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject delete(Integer idPerfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		perfilRepository.deleteById(idPerfil);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro eliminado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
