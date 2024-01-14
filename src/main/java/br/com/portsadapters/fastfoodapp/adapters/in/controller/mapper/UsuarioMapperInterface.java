package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.usuario.UsuarioRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;

@Component
public class UsuarioMapperInterface {

	public Usuario paraUsuario(UsuarioRequest usuarioRequest) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioRequest.getId());
		usuario.setLogin(usuarioRequest.getLogin());
		usuario.setPassword(usuarioRequest.getPassword());
		usuario.setRole(usuarioRequest.getRole());
		return usuario;
	}

	public UsuarioEntity paraUsuarioEntity(Usuario usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setId(usuario.getId());
		usuarioEntity.setLogin(usuario.getLogin());
		usuarioEntity.setPassword(usuario.getPassword());
		usuarioEntity.setRole(usuario.getRole().toString());
		return usuarioEntity;
	}
}
