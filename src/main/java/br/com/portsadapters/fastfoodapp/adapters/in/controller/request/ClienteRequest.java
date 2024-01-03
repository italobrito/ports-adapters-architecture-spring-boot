package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.FormaPagamentoRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest extends BaseRequest {
	
	@NotBlank
    private List<EnderecoRequest> enderecos;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpfCnpj;
	
	private EmpresaRequest empresa;
	
	private List<FormaPagamentoRequest> formasPagamento;
	
}
