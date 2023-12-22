package br.com.portsadapters.fastfoodapp.adapters.out.repository.entity;

import java.io.Serializable;

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
public class EnderecoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3415888727769920169L;
	
	private String rua;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

}
