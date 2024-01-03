package br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas;

import java.io.Serializable;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Cartao implements Serializable {

	private static final long serialVersionUID = 8837065201245954747L;
	
	private Long id;

	private String numeroCartao;
	
	private String validade;
	
	private String cvv;
	
	private String nomeDoTitular;
	
	private String cpfCnpj;
	
	private String apelido;
	
}
