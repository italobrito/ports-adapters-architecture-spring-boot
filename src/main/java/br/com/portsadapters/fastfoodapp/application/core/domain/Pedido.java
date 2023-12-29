package br.com.portsadapters.fastfoodapp.application.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido extends Base implements Serializable {

	private static final long serialVersionUID = -884940894273064263L;

	private List<ItemPedido> itemsPedido;

	private Cliente cliente;

	private BigDecimal precoTotalPedido;

	private TipoStatus status;

}
