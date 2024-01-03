package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7052806046280030188L;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ItemPedidoEntity> itemsPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonBackReference
	private ClienteEntity cliente;

	private BigDecimal precoTotalPedido;

	@Enumerated(EnumType.STRING)
	private TipoStatus status;

	/*
	 * @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) private
	 * PagamentoEntity pagamento;
	 */

	private TipoPagamentoEnum tipoPagamento;

}
