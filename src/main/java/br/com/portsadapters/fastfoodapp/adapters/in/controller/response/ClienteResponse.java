package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse extends BaseResponse {

    private List<Endereco> enderecos;
	
	private String cpf;
	
}
