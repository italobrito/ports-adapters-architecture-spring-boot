package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancheEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -1287929352930864350L;

	private String nome;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lanche_insumo",
            joinColumns = @JoinColumn(name = "lanche_id"),
            inverseJoinColumns = @JoinColumn(name = "insumo_id"))
    private List<InsumoEntity> insumos = new ArrayList<>();
    
    private BigDecimal preco;

}
