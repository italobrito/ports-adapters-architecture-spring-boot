package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.usuario;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
/*

  public record UsuarioRequest(String login, String password, TipoUsuario role)
  { }
 */

@Getter
@Setter
public class UsuarioRequest {
	
	@NotBlank
	private String login;

	@NotBlank
	private String password;

	@NotBlank
	private TipoUsuario role;
}
