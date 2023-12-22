package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends Base implements Serializable {

	private static final long serialVersionUID = -5419243113189984426L;

	private String rua;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
}
