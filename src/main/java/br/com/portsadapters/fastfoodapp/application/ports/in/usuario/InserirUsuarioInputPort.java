package br.com.portsadapters.fastfoodapp.application.ports.in.usuario;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.usuario.UsuarioEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Usuario;

public interface InserirUsuarioInputPort {
	UsuarioEntity inserir(Usuario pedido);
}
