package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacaoResponse {

	@NotBlank
	private String login;

	@NotBlank
	private String password;

}