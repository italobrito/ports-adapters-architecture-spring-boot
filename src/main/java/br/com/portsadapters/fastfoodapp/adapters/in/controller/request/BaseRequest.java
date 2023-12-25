package br.com.portsadapters.fastfoodapp.adapters.in.controller.request;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract class BaseRequest {
	
    private Long id;

}
