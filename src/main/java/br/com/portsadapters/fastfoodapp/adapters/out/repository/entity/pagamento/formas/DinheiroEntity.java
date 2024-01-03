package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas;

import java.io.Serializable;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoPagamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class DinheiroEntity implements Serializable {

	private static final long serialVersionUID = 7753367846781226478L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private TipoPagamentoEnum tipoPagamento = TipoPagamentoEnum.DINHEIRO;
	
    @OneToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamentoEntity formaPagamento;

}
