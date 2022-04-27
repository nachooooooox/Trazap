package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"categorias\"", schema = "public")
@SequenceGenerator(name = "categorias_id_categoria_seq", initialValue = 1, allocationSize = 1, sequenceName = "categorias_id_categoria_seq")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_id_categoria_seq")
	//la siguiente columna no es necesaria si "column" y el "atributo" tienen el mismo nombre
	@Column(name = "id_categoria")
	private int idCategoria;
	private String nombre;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Categorias [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}

}
