package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoEntity implements Serializable {

	private static final long serialVersionUID = 7437695214320655799L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private CartaoEntity cartaoEntity;
	
	private DinheiroEntity dinheiroEntity;
	
	private TipoPagamentoEnum tipoPagamento;
	
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private PedidoEntity pedido;
	
}

