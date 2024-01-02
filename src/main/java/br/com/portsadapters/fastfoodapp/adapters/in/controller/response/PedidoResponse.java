package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.List;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.PagamentoResponse;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponse extends BaseResponse {
	
	private List<ItemPedidoResponse> itemsPedido;
	
	private ClienteResponse cliente;
	
	private PagamentoResponse pagamento;
	
	private BigDecimal precoTotalPedido;
	
	private TipoStatus status;
	
}
