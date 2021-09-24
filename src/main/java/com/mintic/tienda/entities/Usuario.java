package com.mintic.tienda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * aquie se mapea la bd  las tablas de la base de datos son las entidades
 *la entidad se utiliza en los repositorios 
 * */
@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
	public static final String TABLE_NAME = "usuario";
	
		
	/*
	 * @id para identificar la llave primaria
	 * @@GeneratedValue(strategy = GenerationType.IDENTITY) se define el autoincremental	
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	
	/*@ManyToOne  hace referencia la relacion muchos a uno en este caso muchos usuario tienen un tipo de documento
	 * @JoinColumn  el campo que hace de referecia a la llave foranea
	 * */
	@ManyToOne
	@JoinColumn(name = "id_tipo_documento")
	private TipoDocumento idTipoDocumento;
	
	/*@Column nombre de la columna , si el nombre en la base de datos del campo es igual a el de la variable no es necesario poner la anotacion
	 * */
	@Column(name = "cedula_usuario")
	private String numeroDocumento;

	@Column(name = "nombre_usuario")
	private String nombre;

	@Column(name = "password")
	private String password;

	@Column(name = "usuario")
	private String nombreUsuario;

	@Column(name = "email_usuario")
	private String email;

	public Usuario() {

	}

	public Usuario(Long id, TipoDocumento idTipoDocumento, String numeroDocumento, String nombre, String password,
			String nombreUsuario, String email) {
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
