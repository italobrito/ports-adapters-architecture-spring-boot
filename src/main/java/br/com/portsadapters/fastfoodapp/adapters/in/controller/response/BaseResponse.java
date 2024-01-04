package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract class BaseResponse {
    private Long id;
    private String nome;
}

