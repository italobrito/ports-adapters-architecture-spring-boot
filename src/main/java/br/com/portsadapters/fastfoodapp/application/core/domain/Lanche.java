package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lanche  extends Base implements Serializable {
	
	private static final long serialVersionUID = -3193160914691037935L;
	
	private String nome;
	
    private List<Insumo> insumos = new ArrayList<>();
    
    private BigDecimal preco;

}
