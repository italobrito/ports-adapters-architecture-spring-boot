package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;
import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Base implements Serializable {

	private static final long serialVersionUID = 5739658264457191968L;
	
    private String nome;

    private List<Endereco> enderecos;
	
	private String cpfCnpj;
	
	private Empresa empresa;
	
	private List<FormaPagamento> formasPagamento;

}
