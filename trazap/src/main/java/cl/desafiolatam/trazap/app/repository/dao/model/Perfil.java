package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
@SequenceGenerator(name="perfiles_id_perfil_seq", initialValue = 1, allocationSize = 1, sequenceName = "perfiles_id_perfil_seq")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfiles_id_perfil_seq")
	@Column(name = "id_perfil")
	private int idPerfil;
	private String nombre;
	private String descripcion;
	
	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(int idPerfil, String nombre, String descripcion) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
