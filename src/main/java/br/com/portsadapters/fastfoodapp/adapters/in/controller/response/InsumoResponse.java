package br.com.portsadapters.fastfoodapp.adapters.in.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsumoResponse extends BaseResponse {
	
	private Long id;
	
	private int pesoEmGramas;
	
	private int quantidade;
	
}
