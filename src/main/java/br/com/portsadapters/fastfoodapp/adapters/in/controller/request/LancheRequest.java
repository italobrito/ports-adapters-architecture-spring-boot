package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	
}
