package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.CategoriasRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.CategoriasService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("categoriasService")
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	List<ResponseServiceMessage> messageList = null;
	
	@Override
	public ResponseServiceObject findAll() {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		List<Categorias> categoriaList = new ArrayList<Categorias>();
		
		Iterable<Categorias> itCategorias = categoriasRepository.findAll();
		
		itCategorias.forEach(categoriaList::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(categoriaList);
		responseServiceObject.setMessageList(this.messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idCategoria) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		Categorias categorias = new Categorias();
		responseServiceMessage.setTimestamp(new Date());
		
		try {
			categorias = categoriasRepository.findById(idCategoria).get();
			
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("Búsqueda finalizada");
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setBody(categorias);
			responseServiceObject.setMessageList(messageList);
			return responseServiceObject;
		}catch(NoSuchElementException ex) {
			responseServiceMessage.setCode("404");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("No existen registros con el ID " + idCategoria);
			
			this.messageList.add(responseServiceMessage);
			responseServiceObject.setMessageList(messageList);
			return responseServiceObject;
		}catch(Exception e) {
			throw new ServiceException("Error en el servicio");
		}
		
	}

	@Override
	public ResponseServiceObject create(Categorias categorias) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		responseServiceObject.setBody(categoriasRepository.save(categorias));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro ingresado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(Integer idCategoria, Categorias categorias) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		categorias.setIdCategoria(idCategoria);
		responseServiceObject.setBody(categoriasRepository.save(categorias));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject delete(Integer idCategoria) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		categoriasRepository.deleteById(idCategoria);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro eliminado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
