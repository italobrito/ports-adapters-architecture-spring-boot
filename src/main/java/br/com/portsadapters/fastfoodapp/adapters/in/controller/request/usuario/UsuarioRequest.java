package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.usuario;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
	
	private Long id;
	
	@NotBlank
	private String login;

	@NotBlank
	private String password;

	@NotBlank
	private TipoUsuario role;
}
