package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
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
public class PagamentoEntity implements Serializable {

	private static final long serialVersionUID = 7827904857260165179L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
	@JsonManagedReference
	private FormaPagamentoEntity formaPagamento;
    
    @OneToOne
    @JoinColumn(name = "pedido_id")
	@JsonManagedReference 
    private PedidoEntity pedido;
    
	private BigDecimal valorTotal;

}
