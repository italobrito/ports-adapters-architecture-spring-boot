package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.FormaPagamentoResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse extends BaseResponse {

	private String nome;
	
    private List<EnderecoResponse> enderecos;
    
    private EmpresaResponse empresa;
	
	private String cpfCnpj;
	
	private List<FormaPagamentoResponse> formasPagamento;
	
}
