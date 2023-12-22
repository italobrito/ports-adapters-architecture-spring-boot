package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaResponse extends BaseResponse {
	
    private String nome;

	private String cnpj;
	
	private String status;
	
    private List<Endereco> enderecos;

}
