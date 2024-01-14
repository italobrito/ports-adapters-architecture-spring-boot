package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
	private Long id;
	private String login;
	private String password;
	private TipoUsuario role;	
}
