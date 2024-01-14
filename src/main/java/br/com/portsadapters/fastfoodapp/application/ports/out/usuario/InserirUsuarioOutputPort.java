package br.com.portsadapters.fastfoodapp.application.ports.out.usuario;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;

public interface InserirUsuarioOutputPort {
	UsuarioEntity inserir(Usuario pedido);
}
