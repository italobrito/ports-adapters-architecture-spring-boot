package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequest extends BaseRequest {

	@NotBlank
	private String cnpj;
	
	@NotBlank
	private String nome;
	
	@NotBlank
    private List<EnderecoRequest> enderecos;
	
    @NotBlank
	private Boolean ativo;
    
    private List<ClienteRequest> clientes;
    
}
