package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2376560531664840552L;
	
	private String nome;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<EnderecoEntity> enderecos;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonBackReference
    private EmpresaEntity empresa;
	
	private String cpfCnpj;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference 
	private List<FormaPagamentoEntity> formasPagamento;

}
