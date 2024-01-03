package br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.formas;

import java.io.Serializable;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class CartaoRequest implements Serializable {

	private static final long serialVersionUID = 7614663936690087113L;

	private Long id;

	private String numeroCartao;
	
	private String validade;
	
	private String cvv;
	
	private String nomeDoTitular;
	
	private String cpfCnpj;
	
	private String apelido;
	
}
