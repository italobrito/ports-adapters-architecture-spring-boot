package br.com.portsadapters.fastfoodapp.application.core.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract class Base {
	
    private Long id;

}
