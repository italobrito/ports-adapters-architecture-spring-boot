package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import java.math.BigDecimal;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.PagamentoRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest extends BaseRequest {
	
	@NotBlank
	private List<ItemPedidoRequest> itemsPedido;
	
	@NotBlank
	private ClienteRequest cliente;
	
	@NotBlank
	private PagamentoRequest pagamento;
	
	private BigDecimal precoTotalPedido;
	
	private TipoStatus status;
	
}
