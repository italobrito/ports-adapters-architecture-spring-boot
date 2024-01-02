package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CartaoRequest implements Serializable {

	private static final long serialVersionUID = 8837065201245954747L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroCartao;
	
	private String validade;
	
	private String cvv;
	
	private String nomeDoTitular;
	
	private String cpfCnpj;
	
	private String apelido;
	
	private TipoPagamentoEnum tipoPagamento;
}
