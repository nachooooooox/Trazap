package cl.desafiolatam.trazap.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.UsuarioRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Usuario;

@Service
public class AuthServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<Usuario> listaUsuario = usuarioRepository.findByEmail(email);
		Usuario usuario = null;
		UserBuilder userBuilder = null;
		
		if (listaUsuario == null || listaUsuario.size() != 1) {
			throw new UsernameNotFoundException(email);
		} else {
			usuario = listaUsuario.get(0);
			userBuilder = User.withUsername(email);
			userBuilder.password(usuario.getPassword());
			String[] roles = {usuario.getPerfil().getNombre()};
			userBuilder.roles(roles);
		}
		
		return userBuilder.build();
	}
}
