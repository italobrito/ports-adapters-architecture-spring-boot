package br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas;

import java.io.Serializable;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class CartaoResponse implements Serializable {

	private static final long serialVersionUID = 3556100658256912712L;

	private Long id;

	private String numeroCartao;
	
	private String validade;
	
	private String cvv;
	
	private String nomeDoTitular;
	
	private String cpfCnpj;
	
	private String apelido;
	
}
