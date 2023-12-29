package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2122578881416941101L;
	
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private PedidoEntity pedido;
    
    @ManyToOne
    @JoinColumn(name = "lanche_id")
    private LancheEntity lanches;
    
    private Integer quantidade;

}
