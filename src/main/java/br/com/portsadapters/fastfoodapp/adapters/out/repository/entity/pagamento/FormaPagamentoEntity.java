package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class FormaPagamentoEntity implements Serializable {

	private static final long serialVersionUID = -4532537806194198129L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @OneToOne
    @JoinColumn(name = "cartao_debito_id")
    @JsonBackReference
	private CartaoDebitoEntity cartaoDebito;

    @OneToOne
    @JoinColumn(name = "cartao_credito_id")
    @JsonBackReference
	private CartaoCreditoEntity cartaoCredito;

    @OneToOne
    @JoinColumn(name = "dinheiro_id")
    @JsonBackReference
	private DinheiroEntity dinheiro;

	private TipoPagamentoEnum tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonBackReference
	private ClienteEntity cliente;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "pedido_id")
	 * 
	 * @JsonBackReference private PedidoEntity pedido;
	 */

}
