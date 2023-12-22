package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract class BaseRequest {
	
	@NotBlank
    private String nome;

}
