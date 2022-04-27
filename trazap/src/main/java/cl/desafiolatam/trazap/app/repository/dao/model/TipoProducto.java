package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TipoProductos")
@SequenceGenerator(name="TipoProductos_idTipoProducto_seq", initialValue = 1, allocationSize = 1, sequenceName = "TipoProductos_idTipoProducto_seq")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="TipoProductos_idTipoProducto_seq")
	@Column(name = "idTipoProductos")
	private int idTipoProducto;
	private String descripcion;
	
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoProducto [idTipoProducto=" + idTipoProducto + ", descripcion=" + descripcion + "]";
	}
	

}
