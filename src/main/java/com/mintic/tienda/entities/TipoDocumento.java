package com.mintic.tienda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //es una entidad
@Table(name = TipoDocumento.TABLE_NAME)/* nombre de la tabla en este caso sera "tipoDocumento*/
public class TipoDocumento {
	public static final String TABLE_NAME = "tipodocumento";

	@Id /*llave principal*/
	@Column(name = "id_tipo_documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*indica que el valor es autoincremental*/
	private Long id;

	@Column(name = "tipo_documento")
	private String tipo;

	public TipoDocumento() {

	}

	public TipoDocumento(Long id, String tipo) {

		this.id = id;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
