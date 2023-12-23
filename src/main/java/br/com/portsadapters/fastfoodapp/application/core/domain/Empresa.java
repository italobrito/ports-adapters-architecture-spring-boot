package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Base implements Serializable  {

	private static final long serialVersionUID = 1072948770078946657L;
	
    private String nome;

	private String cnpj;
	
    private Boolean ativo;
	
    private List<Endereco> enderecos;
    
    private List<Cliente> clientes;

}
