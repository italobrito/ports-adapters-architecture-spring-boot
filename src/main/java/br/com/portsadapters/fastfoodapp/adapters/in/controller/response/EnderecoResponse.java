package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoResponse {
	
	private Long id;
	
	private String rua;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
    private EmpresaResponse empresa;

    private ClienteResponse cliente;

}
