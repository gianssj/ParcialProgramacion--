package com.cooweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooweb.dao.usuarioDao;
import com.cooweb.models.Usuario;

@RestController
public class usuarioController {
	
	@Autowired
	private usuarioDao usuarioDao;
	
	@RequestMapping(value = "mensaje")
	public String mensaje() {
		return "Hola mundo";
	}
	
	@RequestMapping(value = "usuario")
	public List<String> listarUsuarios(){
		return List.of("Usuario1", "Usuario2", "Usuario3");
	}
	
	@RequestMapping(value = "usuario/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("Usuario1");
		usuario.setApellido("Apellido1");
		usuario.setTelefono("123456789");
		usuario.setEmail("usuario1@example.com");
		
		return usuario;
	}
	
	@RequestMapping(value = "usuario/lista_usuarios")
	public List<Usuario> listarVariosUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(1L);
		usuario1.setNombre("Usuario1");
		usuario1.setApellido("Apellido1");
		usuario1.setTelefono("123456789");
		usuario1.setEmail("usuario1@example.com");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setNombre("Usuario2");
		usuario2.setApellido("Apellido2");
		usuario2.setTelefono("987654321");
		usuario2.setEmail("usuario2@example.com");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		return usuarios;
	}

	@RequestMapping(value = "api/usuarios")
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
		return usuarios;
	}
}
