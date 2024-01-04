package br.com.portsadapters.fastfoodapp.adapters.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.FormaPagamentoResponse;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.FormaPagamentoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.ports.in.pagamento.BuscarFormaPagamentoInputPort;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/forma-pagamento")
public class FormaPagamentoController {
	
	@Autowired
	private BuscarFormaPagamentoInputPort buscarFormaPagamentoInputPort;
	
	@Autowired
	private FormaPagamentoEntityMapper formaPagamentoEntityMapper;
	
	@Operation(summary = "Buscar formas de pagamento cadastradas.", description = "Pesquisa todas as formas de pagamento cadastrado.")
	@GetMapping
	public List<FormaPagamentoResponse> buscarTodos() {
		List<FormaPagamentoEntity> formaPagamentos = buscarFormaPagamentoInputPort.buscarTodos();
		
		List<FormaPagamentoResponse> formasPagamentoResponse = formaPagamentoEntityMapper.paraFormaPagamentoResponse(formaPagamentos);
		
		return formasPagamentoResponse;
	}
}
