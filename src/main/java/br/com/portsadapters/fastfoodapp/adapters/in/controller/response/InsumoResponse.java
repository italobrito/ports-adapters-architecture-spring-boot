package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsumoResponse extends BaseResponse {
	
	private Long id;
	
	private int pesoEmGramas;
	
	/* private BigDecimal preco; */
	
	private int quantidade;
	
	/* private List<LancheEntity> lanches; */
	
	/* private byte[] imagem; */

}
