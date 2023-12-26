package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsumoRequest extends BaseRequest implements Serializable {
	
	private static final long serialVersionUID = 57636427712450854L;

	@NotBlank
	private String nome;

	@NotNull
	private int pesoEmGramas;

	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private int quantidade;
	
    private List<LancheEntity> lanches;
	
	private byte[] imagem;

}
