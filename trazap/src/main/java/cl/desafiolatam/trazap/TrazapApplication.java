package cl.desafiolatam.trazap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.CategoriasRepository;
import cl.desafiolatam.trazap.app.repository.PerfilRepository;
import cl.desafiolatam.trazap.app.repository.TipoProductoRepository;
import cl.desafiolatam.trazap.app.repository.UsuarioRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.repository.dao.model.Perfil;
import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.repository.dao.model.Usuario;

@SpringBootApplication
public class TrazapApplication {

	private final static Logger logger = LoggerFactory.getLogger(TrazapApplication.class);

	@Autowired
	private BodegaRepository bodegaRepository;

	@Autowired
	private CategoriasRepository categoriasRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private TipoProductoRepository tipoProductoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBodega() {
		return (args) -> {
			Bodegas bodega1 = new Bodegas();
			Bodegas bodega2 = new Bodegas();
			bodega1.setDescripcion("MI BODEGA 1");
			bodega2.setDescripcion("MI BODEGA 2");
			bodegaRepository.save(bodega1);
			bodegaRepository.save(bodega2);
		};
	}

	@Bean
	public CommandLineRunner createCategorias() {
		return (args) -> {
			Categorias categorias1 = new Categorias();
			categorias1.setNombre("Categoría 1");
			categoriasRepository.save(categorias1);
			Categorias categorias2 = new Categorias();
			categorias2.setNombre("Categoria 2");
			categoriasRepository.save(categorias2);
		};
	}

	@Bean
	public CommandLineRunner createTipoProducto() {
		return (args) -> {
			TipoProducto tipoProducto1 = new TipoProducto();
			tipoProducto1.setDescripcion("Descripcion 1");
			tipoProductoRepository.save(tipoProducto1);
			TipoProducto tipoProducto2 = new TipoProducto();
			tipoProducto2.setDescripcion("Descripción 2");
			tipoProductoRepository.save(tipoProducto2);
		};
	}

	@Bean
	public CommandLineRunner createUsuario() {
		return (args) -> {
			
			//ADMIN
			
			Usuario usuarioAdmin = new Usuario();
			Perfil perfil = new Perfil();

			perfil.setNombre("ADMIN");

			perfilRepository.save(perfil);

			usuarioAdmin.setNombre("bob");
			usuarioAdmin.setNombreUsuario("bob");
			usuarioAdmin.setEmail("admin");
			usuarioAdmin.setPassword(passwordEncoder.encode("1234"));
			usuarioAdmin.setPerfil(perfil);

			usuarioRepository.save(usuarioAdmin);
			
			//USER
			
			Usuario usuarioUser = new Usuario();
			Perfil perfil2 = new Perfil();
			
			perfil2.setNombre("USER");

			perfilRepository.save(perfil2);

			usuarioUser.setNombre("bab");
			usuarioUser.setNombreUsuario("bab");
			usuarioUser.setEmail("user");
			usuarioUser.setPassword(passwordEncoder.encode("1234"));
			usuarioUser.setPerfil(perfil2);

			usuarioRepository.save(usuarioUser);
			
			//PROV
			
			Usuario usuarioProv = new Usuario();
			Perfil perfil3 = new Perfil();
			
			perfil3.setNombre("USER");

			perfilRepository.save(perfil3);

			usuarioProv.setNombre("beb");
			usuarioProv.setNombreUsuario("beb");
			usuarioProv.setEmail("prov");
			usuarioProv.setPassword(passwordEncoder.encode("1234"));
			usuarioProv.setPerfil(perfil3);

			usuarioRepository.save(usuarioProv);

		};
	}

}
