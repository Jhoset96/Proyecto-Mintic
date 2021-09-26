package com.mintic.tienda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.TipoDocumento;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.repositories.ITipoDocumento;
import com.mintic.tienda.servicio.IUsuarioService;

/*prueba push controlador 1*/
/*@RestController permitir el manejo de solicitudes HTTP  get post put delete
 * */
@RestController
public class Controlador {

	
	/*
	 * inyectamos el la iterface del servicio para acceder a los metodos del negocio 
	 **/
	@Autowired
	IUsuarioService iUsuario;

	
	/*
	 * inyectamos el la iterface del repositirio
	 * OJO lo hice directamento porque no es necesaria ninguna logica de negocio solo necesito el listado de tipos de documento
	 * si quieren pueden hacerlo directamente con el repositorio de usuario y no tendrian que crear el servicio (pero no es la mejor forma de realzarlo)
	 **/
	@Autowired
	ITipoDocumento iTipoDocumento;
	
	
	
	/*
	 * @CrossOrigin indica desde que sitios se van a realizar peticiones
	 * */
	@CrossOrigin(origins = { "http://localhost:8080" })
	@PostMapping("/loginclient")//ruta del servicio  desde el front deben  direccionar a esta ruta preguntar que es requestbody
	public int login(@RequestBody LoginDto usuario) {

		int responseLogin = iUsuario.login(usuario);

		return responseLogin;

	}

	@PostMapping("/usuarios")
	public Usuario usuario(@RequestBody UsuarioDto usuarioDto) {

		return iUsuario.nuevoUsuario(usuarioDto);
	}

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {

		return iUsuario.getUsuarios();/*de donde sale esl getUsuarios*/
	}
	/*@PathhVariable es el que reconoce esa variable*/
	@GetMapping("/usuarios/{id}")
	public Usuario buscarUsuarioId(@PathVariable Long id) {
		return iUsuario.buscarUsuario(id);
	}

	@DeleteMapping("/usuarios/{id}")
	public int eliminarUsuario(@PathVariable Long id) {

		return iUsuario.borrarUsuario(id);
	}

	@GetMapping("/tipodocumento")
	public List<TipoDocumento> listarTipoDocumento() {

		return (List<TipoDocumento>) iTipoDocumento.findAll();
	}

}
