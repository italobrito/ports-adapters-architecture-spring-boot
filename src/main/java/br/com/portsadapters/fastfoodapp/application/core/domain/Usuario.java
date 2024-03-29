package br.com.portsadapters.fastfoodapp.application.core.domain;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Base {
	private String login;
	private String password;
	private TipoUsuario role;	
}
