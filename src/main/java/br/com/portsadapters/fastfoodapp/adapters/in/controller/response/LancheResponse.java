package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.InsumoRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancheResponse extends BaseResponse {

	private Long id;
	
    private List<InsumoRequest> insumos = new ArrayList<>();
    
	private BigDecimal preco;
	
}
