package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancheResponse extends BaseResponse {

	private Long id;
	
    private List<InsumoResponse> insumos = new ArrayList<>();
    
	private BigDecimal preco;
	
    private TipoLanche tipoLanche;
	
}
