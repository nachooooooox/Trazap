package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.UsuarioDelegate;
import cl.desafiolatam.trazap.app.service.UsuarioService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("usuarioDelegate")
public class UsuarioDelegateImpl implements UsuarioDelegate{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public ResponseServiceObject finAll() {
		return usuarioService.finAll();
	}
}
