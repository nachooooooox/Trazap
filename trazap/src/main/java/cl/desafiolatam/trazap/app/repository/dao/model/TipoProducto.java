package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_productos")
@SequenceGenerator(name="tipo_productos_id_tipo_producto_seq", initialValue = 1, allocationSize = 1, sequenceName = "tipo_productos_id_tipo_producto_seq")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="tipo_productos_id_tipo_producto_seq")
	@Column(name = "idtipoproductos")
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
