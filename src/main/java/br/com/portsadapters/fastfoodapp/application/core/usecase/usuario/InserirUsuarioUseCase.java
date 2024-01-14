package br.com.portsadapters.fastfoodapp.application.core.usecase.usuario;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;

import br.com.portsadapters.fastfoodapp.application.ports.in.usuario.InserirUsuarioInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.usuario.InserirUsuarioOutputPort;

public class InserirUsuarioUseCase implements InserirUsuarioInputPort {
	
	private final InserirUsuarioOutputPort inserirUsuarioOutputPort;

	public InserirUsuarioUseCase(InserirUsuarioOutputPort inserirUsuarioOutputPort) {
		this.inserirUsuarioOutputPort = inserirUsuarioOutputPort;
	}

	@Override
	public UsuarioEntity inserir(Usuario usuario) {
		return this.inserirUsuarioOutputPort.inserir(usuario);
	}

}
