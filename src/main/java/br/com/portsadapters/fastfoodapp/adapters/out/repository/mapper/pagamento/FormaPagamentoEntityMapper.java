package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.ClienteResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.EmpresaResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.EnderecoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.FormaPagamentoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.CartaoCreditoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.CartaoDebitoResponse;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.response.pagamento.formas.DinheiroResponse;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;

@Component
public class FormaPagamentoEntityMapper {

	public List<FormaPagamentoResponse> paraFormaPagamentoResponse(List<FormaPagamentoEntity> formaPagamentoEntities) {
		List<FormaPagamentoResponse> formaPagamentoResponses = new ArrayList<>();
		for (FormaPagamentoEntity formaPagamentoEntity : formaPagamentoEntities) {
			formaPagamentoResponses.add(criarFormaPagamentoResponse(formaPagamentoEntity));
		}
		return formaPagamentoResponses;
	}

	public FormaPagamentoEntity paraFormaPagamentoEntity(FormaPagamento formaPagamento) {
		FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
		formaPagamentoEntity.setId(formaPagamento.getId());
		formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());

		if (formaPagamento.getCliente() != null) {
			formaPagamentoEntity.setCliente(paraClienteEntity(formaPagamento.getCliente()));
		}

		if (formaPagamento.getCartaoCredito() != null) {
			formaPagamentoEntity.setCartaoCredito(paraCartaoCreditoEntity(formaPagamento.getCartaoCredito()));
		}
		if (formaPagamento.getCartaoDebito() != null) {
			formaPagamentoEntity.setCartaoDebito(paraCartaoDebitoEntity(formaPagamento.getCartaoDebito()));
		}
		if (formaPagamento.getDinheiro() != null) {
			formaPagamentoEntity.setDinheiro(paraDinheiroEntity(formaPagamento.getDinheiro()));
		}
		return formaPagamentoEntity;
	}

	private FormaPagamentoResponse criarFormaPagamentoResponse(FormaPagamentoEntity formaPagamentoEntity) {
		FormaPagamentoResponse formaPagamentoResponse = new FormaPagamentoResponse();
		formaPagamentoResponse.setId(formaPagamentoEntity.getId());
		formaPagamentoResponse.setTipoPagamento(formaPagamentoEntity.getTipoPagamento());

		if (formaPagamentoEntity.getCliente() != null) {
			formaPagamentoResponse.setCliente(paraClienteResponse(formaPagamentoEntity.getCliente()));
		}

		if (formaPagamentoEntity.getCartaoCredito() != null) {
			formaPagamentoResponse.setCartaoCredito(paraCartaoCreditoResponse(formaPagamentoEntity.getCartaoCredito()));
		}
		if (formaPagamentoEntity.getCartaoDebito() != null) {
			formaPagamentoResponse.setCartaoDebito(paraCartaoDebitoResponse(formaPagamentoEntity.getCartaoDebito()));
		}
		if (formaPagamentoEntity.getDinheiro() != null) {
			formaPagamentoResponse.setDinheiro(paraDinheiroResponse(formaPagamentoEntity.getDinheiro()));
		}
		return formaPagamentoResponse;
	}

	public FormaPagamentoResponse paraFormaPagamentoResponse(FormaPagamentoEntity formaPagamentoEntity) {
		FormaPagamentoResponse formaPagamentoResponse = new FormaPagamentoResponse();
		formaPagamentoResponse.setId(formaPagamentoEntity.getId());
		formaPagamentoResponse.setTipoPagamento(formaPagamentoEntity.getTipoPagamento());
		formaPagamentoResponse.setCliente(paraClienteResponse(formaPagamentoEntity.getCliente()));
		formaPagamentoResponse.setCartaoCredito(paraCartaoCreditoResponse(formaPagamentoEntity.getCartaoCredito()));
		formaPagamentoResponse.setCartaoDebito(paraCartaoDebitoResponse(formaPagamentoEntity.getCartaoDebito()));
		formaPagamentoResponse.setDinheiro(paraDinheiroResponse(formaPagamentoEntity.getDinheiro()));
		return formaPagamentoResponse;
	}

	private CartaoCreditoEntity paraCartaoCreditoEntity(CartaoCredito cartaoCredito) {
		CartaoCreditoEntity cartaoCreditoEntity = new CartaoCreditoEntity();
		cartaoCreditoEntity.setApelido(cartaoCredito.getApelido());
		cartaoCreditoEntity.setCpfCnpj(cartaoCredito.getCpfCnpj());
		cartaoCreditoEntity.setCvv(cartaoCredito.getCvv());
		cartaoCreditoEntity.setNomeDoTitular(cartaoCredito.getNomeDoTitular());
		cartaoCreditoEntity.setNumeroCartao(cartaoCredito.getNumeroCartao());
		cartaoCreditoEntity.setValidade(cartaoCredito.getValidade());
		cartaoCreditoEntity.setId(cartaoCredito.getId());
		cartaoCreditoEntity.setTipoPagamento(cartaoCredito.getTipoPagamento());
		return cartaoCreditoEntity;
	}

	private CartaoCreditoResponse paraCartaoCreditoResponse(CartaoCreditoEntity cartaoCreditoEntity) {
		CartaoCreditoResponse cartaoCreditoResponse = new CartaoCreditoResponse();
		cartaoCreditoResponse.setApelido(cartaoCreditoEntity.getApelido());
		cartaoCreditoResponse.setCpfCnpj(cartaoCreditoEntity.getCpfCnpj());
		cartaoCreditoResponse.setCvv(cartaoCreditoEntity.getCvv());
		cartaoCreditoResponse.setNomeDoTitular(cartaoCreditoEntity.getNomeDoTitular());
		cartaoCreditoResponse.setNumeroCartao(cartaoCreditoEntity.getNumeroCartao());
		cartaoCreditoResponse.setValidade(cartaoCreditoEntity.getValidade());
		cartaoCreditoResponse.setId(cartaoCreditoEntity.getId());
		cartaoCreditoResponse.setTipoPagamento(cartaoCreditoEntity.getTipoPagamento());
		return cartaoCreditoResponse;
	}

	private CartaoDebitoEntity paraCartaoDebitoEntity(CartaoDebito cartaoDebito) {
		CartaoDebitoEntity cartaoDebitoEntity = new CartaoDebitoEntity();
		cartaoDebitoEntity.setApelido(cartaoDebito.getApelido());
		cartaoDebitoEntity.setCpfCnpj(cartaoDebito.getCpfCnpj());
		cartaoDebitoEntity.setCvv(cartaoDebito.getCvv());
		cartaoDebitoEntity.setNomeDoTitular(cartaoDebito.getNomeDoTitular());
		cartaoDebitoEntity.setNumeroCartao(cartaoDebito.getNumeroCartao());
		cartaoDebitoEntity.setValidade(cartaoDebito.getValidade());
		cartaoDebitoEntity.setId(cartaoDebito.getId());
		cartaoDebitoEntity.setTipoPagamento(cartaoDebito.getTipoPagamento());
		return cartaoDebitoEntity;
	}

	private CartaoDebitoResponse paraCartaoDebitoResponse(CartaoDebitoEntity cartaoDebitoEntity) {
		CartaoDebitoResponse cartaoDebitoResponse = new CartaoDebitoResponse();
		cartaoDebitoResponse.setApelido(cartaoDebitoEntity.getApelido());
		cartaoDebitoResponse.setCpfCnpj(cartaoDebitoEntity.getCpfCnpj());
		cartaoDebitoResponse.setCvv(cartaoDebitoEntity.getCvv());
		cartaoDebitoResponse.setNomeDoTitular(cartaoDebitoEntity.getNomeDoTitular());
		cartaoDebitoResponse.setNumeroCartao(cartaoDebitoEntity.getNumeroCartao());
		cartaoDebitoResponse.setValidade(cartaoDebitoEntity.getValidade());
		cartaoDebitoResponse.setId(cartaoDebitoEntity.getId());
		cartaoDebitoResponse.setTipoPagamento(cartaoDebitoEntity.getTipoPagamento());
		return cartaoDebitoResponse;
	}

	private DinheiroResponse paraDinheiroResponse(DinheiroEntity dinheiroEntity) {
		DinheiroResponse dinheiroResponse = new DinheiroResponse();
		dinheiroResponse.setId(dinheiroEntity.getId());
		dinheiroResponse.setTipoPagamento(dinheiroEntity.getTipoPagamento());
		return dinheiroResponse;
	}

	private DinheiroEntity paraDinheiroEntity(Dinheiro dinheiro) {
		DinheiroEntity dinheiroEntity = new DinheiroEntity();
		dinheiroEntity.setId(dinheiro.getId());
		dinheiroEntity.setTipoPagamento(dinheiro.getTipoPagamento());
		return dinheiroEntity;
	}

	private List<EnderecoEntity> paraEnderecoEntity(List<Endereco> enderecos) {
		List<EnderecoEntity> enderecoResponses = new ArrayList<>();
		for (Endereco endereco : enderecos) {
			enderecoResponses.add(criarEnderecoEntity(endereco));
		}
		return enderecoResponses;
	}

	private EnderecoEntity criarEnderecoEntity(Endereco endereco) {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setCep(endereco.getCep());
		enderecoEntity.setComplemento(endereco.getComplemento());
		enderecoEntity.setNumero(endereco.getNumero());
		enderecoEntity.setRua(endereco.getRua());
		enderecoEntity.setId(endereco.getId());
		return enderecoEntity;
	}

	private List<EnderecoResponse> paraEnderecoResponse(List<EnderecoEntity> enderecoEntities) {
		List<EnderecoResponse> enderecoResponses = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : enderecoEntities) {
			enderecoResponses.add(criarEnderecoResponse(enderecoEntity));
		}
		return enderecoResponses;
	}

	private EnderecoResponse criarEnderecoResponse(EnderecoEntity enderecoEntity) {
		EnderecoResponse enderecoResponse = new EnderecoResponse();
		enderecoResponse.setCep(enderecoEntity.getCep());
		enderecoResponse.setComplemento(enderecoEntity.getComplemento());
		enderecoResponse.setNumero(enderecoEntity.getNumero());
		enderecoResponse.setId(enderecoEntity.getId());
		return enderecoResponse;
	}

	private ClienteResponse paraClienteResponse(ClienteEntity clienteEntity) {
		ClienteResponse clienteResponse = new ClienteResponse();
		clienteResponse.setId(clienteEntity.getId());
		clienteResponse.setCpfCnpj(clienteEntity.getCpfCnpj());
		clienteResponse.setNome(clienteEntity.getNome());
		clienteResponse.setEnderecos(paraEnderecoResponse(clienteEntity.getEnderecos()));
		return clienteResponse;
	}

	private ClienteEntity paraClienteEntity(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(cliente.getId());
		clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setEnderecos(paraEnderecoEntity(cliente.getEnderecos()));
		return clienteEntity;
	}

	public EmpresaResponse paraEmpresaResponse(EmpresaEntity empresaEntity) {
		EmpresaResponse empresaResponse = new EmpresaResponse();
		empresaResponse.setId(empresaEntity.getId());
		empresaResponse.setNome(empresaEntity.getNome());
		empresaResponse.setCnpj(empresaEntity.getCnpj());
		empresaResponse.setAtivo(empresaEntity.getAtivo());

		List<EnderecoResponse> enderecos = new ArrayList<>();

		for (EnderecoEntity enderecoEntity : empresaEntity.getEnderecos()) {
			EnderecoResponse enderecoResponse = new EnderecoResponse();
			enderecoResponse.setCep(enderecoEntity.getCep());
			enderecoResponse.setComplemento(enderecoEntity.getComplemento());
			enderecoResponse.setNumero(enderecoEntity.getNumero());
			enderecoResponse.setRua(enderecoEntity.getRua());
			enderecoResponse.setNumero(enderecoEntity.getNumero());
			enderecoResponse.setId(enderecoEntity.getId());
			enderecos.add(enderecoResponse);
		}

		empresaResponse.setEnderecos(enderecos);

		List<ClienteResponse> clientes = new ArrayList<>();

		for (ClienteEntity clienteEntity : empresaEntity.getClientes()) {
			clientes.add(paraClienteResponse(clienteEntity));
		}

		empresaResponse.setClientes(clientes);

		return empresaResponse;
	}

}
