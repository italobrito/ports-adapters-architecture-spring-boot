package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insumo extends Base implements Serializable {

	private static final long serialVersionUID = 5124820946367494987L;

	private String nome;
	
	private int pesoEmGramas;
	
    private List<LancheEntity> lanches = new ArrayList<>();
    
    private int quantidade;
    
	private BigDecimal preco;
    
	private byte[] imagem;
	
}
