package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.UsuarioRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Usuario;
import cl.desafiolatam.trazap.app.service.UsuarioService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	
	@Override
	public ResponseServiceObject finAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Iterable<Usuario> itUsuario = usuarioRepository.findAll();
		itUsuario.forEach(usuarios::add);
		System.out.println(itUsuario);
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(usuarios);
		responseServiceObject.setMessageList(messageList);
		return responseServiceObject;
	}
	
}
