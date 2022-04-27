package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name="users_id_user_seq", initialValue = 1, allocationSize = 1, sequenceName = "users_id_user_seq")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_user_seq")
	@Column(name = "id_user")
	private Integer idUser;
	private String nombre;
	private String password;
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	private String correo;
	@Column(name = "id_perfil")
	private int idPerfil;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUser, String nombre, String password, String nombreUsuario, String correo, int idPerfil) {
		super();
		this.idUser = idUser;
		this.nombre = nombre;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.idPerfil = idPerfil;
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
}
