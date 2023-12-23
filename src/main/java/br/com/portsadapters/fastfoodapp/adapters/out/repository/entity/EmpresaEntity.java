package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class EmpresaEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4333358093250864745L;
	
    private String nome;
    
    private String cnpj;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EnderecoEntity> enderecos;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ClienteEntity> clientes;
    
    private Boolean ativo;

}
