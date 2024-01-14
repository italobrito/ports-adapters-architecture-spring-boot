package br.com.portsadapters.fastfoodapp.adapters.out.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.UsuarioMapperInterface;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.UsuarioRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.portsadapters.fastfoodapp.application.ports.out.usuario.InserirUsuarioOutputPort;

@Component
public class InserirUsuarioAdapter implements InserirUsuarioOutputPort {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapperInterface usuarioMapperInterface;

	@Override
	public UsuarioEntity inserir(Usuario usuario) {
		if (this.usuarioRepository.findByLogin(usuario.getLogin()) != null)
			return null;
		UsuarioEntity usuarioEntity = usuarioMapperInterface.paraUsuarioEntity(usuario);
		String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioEntity.getPassword());
		UsuarioEntity newUser = new UsuarioEntity(usuarioEntity.getLogin(), encryptedPassword, usuarioEntity.getRole().toString());
		return usuarioRepository.save(newUser);
	}
}