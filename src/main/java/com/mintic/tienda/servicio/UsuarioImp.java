package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.LoginDto;
import com.mintic.tienda.dto.UsuarioDto;
import com.mintic.tienda.entities.TipoDocumento;
import com.mintic.tienda.entities.Usuario;
import com.mintic.tienda.repositories.IUsuario;


/*
 * Implementamos la interface con sus metodos
 * @Service  indica la logina empresarial toda la logica de negocio
 * */
@Service 
public class UsuarioImp implements IUsuarioService {

	/*
	 * @Autowired inyeccion de dependencia  en este caso para acceder a los metodos del repositorio IUsuario (accedemos al crud)
	 * 
	 * */
	
	@Autowired
	IUsuario iUsuario;

	/*
	 * Motodo para validar si existe el usuari 
	 * */
	@Override
	public int login(LoginDto usuarioDto) {
		int u = iUsuario.findByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword());
		return u;
	}

	@Override
	public List<Usuario> getUsuarios() {

		return (List<Usuario>) iUsuario.findAll();
	}

	@Override
	public Usuario nuevoUsuario(UsuarioDto usuarioDto) {

		Usuario usuario = new Usuario();
		TipoDocumento td = new TipoDocumento();
		td.setId(usuarioDto.getIdTipoDocumento());
				
		if(usuarioDto.getId()!=null) {
			usuario.setId(usuarioDto.getId());
		}
		
		usuario.setIdTipoDocumento(td);
		usuario.setNumeroDocumento(usuarioDto.getNumeroDocumento());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setEmail(usuarioDto.getEmail());
		return iUsuario.save(usuario);
	}


	@Override
	public int borrarUsuario(Long id) {
		iUsuario.deleteById(id);
		return 1;
	}

	@Override
	public Usuario buscarUsuario(Long id) {

		Usuario usuario = null;

		usuario = iUsuario.findById(id).orElse(null);
		if (usuario == null) {
			return null;
		}

		return usuario;
	}

}
