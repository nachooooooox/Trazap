package cl.desafiolatam.trazap.app.repository.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bodegas")
@SequenceGenerator(name="Bodegas_idBodegas_seq", initialValue = 1, allocationSize = 1, sequenceName = "Bodegas_idBodegas_seq")
public class Bodegas {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bodegas_idBodegas_seq")
	@Column(name = "idBodegas")
	private int idBodega;
	private String descripcion;
	
	public int getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Bodega [idBodega=" + idBodega + ", descripcion=" + descripcion + "]";
	}
	
}
