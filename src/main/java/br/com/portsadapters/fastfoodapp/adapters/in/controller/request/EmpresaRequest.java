package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequest extends BaseRequest {

	@NotBlank
	private String cnpj;
	
	@NotBlank
	private String status;
	
	@NotBlank
    private List<Endereco> enderecos;
    
}
