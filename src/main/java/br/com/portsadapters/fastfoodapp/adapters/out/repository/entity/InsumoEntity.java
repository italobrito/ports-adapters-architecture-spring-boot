package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;*/
import jakarta.persistence.Entity;
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
public class InsumoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3824686849055642771L;
	
	private String nome;
	
	private int pesoEmGramas;
	
	/*
	 * @ManyToMany(mappedBy = "insumos", cascade = CascadeType.ALL)
	 * 
	 * @JsonBackReference private List<LancheEntity> lanches;
	 */
    
    @ManyToMany(mappedBy = "insumos")
    private List<LancheEntity> lanches = new ArrayList<>();
    
    private BigDecimal preco;
    
	private int quantidade;
    
	private byte[] imagem;

}
