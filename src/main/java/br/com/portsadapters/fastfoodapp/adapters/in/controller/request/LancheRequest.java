package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoLanche;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancheRequest extends BaseRequest {

	@NotBlank
	private String nome;
	
    private List<InsumoRequest> insumos = new ArrayList<>();
    
	@NotBlank
    private BigDecimal preco;
	
    private TipoLanche tipoLanche;
	
}
