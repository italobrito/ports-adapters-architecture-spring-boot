package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest extends BaseRequest {
	
	private String rua;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
}
