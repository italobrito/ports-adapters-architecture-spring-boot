package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EmpresaMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoCreditoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoDebitoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.DinheiroMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.FormaPagamentoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EnderecoMapper;

@Component
public class FormaPagamentoMapper {

	@Autowired
	private CartaoDebitoMapper cartaoDebitoMapper;

	@Autowired
	private CartaoCreditoMapper cartaoCreditoMapper;

	@Autowired
	private DinheiroMapper dinheiroMapper;

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private EmpresaMapper empresaMapper;

	public List<FormaPagamento> paraListaFormaPagamento(List<FormaPagamentoRequest> formasPagamentoRequest,
			Cliente cliente) {

		List<FormaPagamento> formasPagamento = new ArrayList<>();

		for (FormaPagamentoRequest formaPagamentoRequest : formasPagamentoRequest) {
			if (formaPagamentoRequest.getCartaoDebito() != null) {
				CartaoDebito cartaoDebito = cartaoDebitoMapper
						.paraCartaoDebito(formaPagamentoRequest.getCartaoDebito());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setCartaoDebito(cartaoDebito);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formaPagamento.setCliente(cliente);
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getCartaoCredito() != null) {
				CartaoCredito cartaoCredito = cartaoCreditoMapper
						.paraCartaoCredito(formaPagamentoRequest.getCartaoCredito());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setCartaoCredito(cartaoCredito);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formaPagamento.setCliente(cliente);
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getDinheiro() != null) {
				Dinheiro dinheiro = dinheiroMapper.paraDinheiro(formaPagamentoRequest.getDinheiro());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setDinheiro(dinheiro);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formaPagamento.setCliente(cliente);
				formasPagamento.add(formaPagamento);
			}
		}

		return formasPagamento;
	}

	public List<FormaPagamento> paraListaFormaPagamento(List<FormaPagamentoRequest> formasPagamentoRequest) {

		List<FormaPagamento> formasPagamento = new ArrayList<>();

		for (FormaPagamentoRequest formaPagamentoRequest : formasPagamentoRequest) {
			if (formaPagamentoRequest.getCartaoDebito() != null) {
				CartaoDebito cartaoDebito = cartaoDebitoMapper
						.paraCartaoDebito(formaPagamentoRequest.getCartaoDebito());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setCartaoDebito(cartaoDebito);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getCartaoCredito() != null) {
				CartaoCredito cartaoCredito = cartaoCreditoMapper
						.paraCartaoCredito(formaPagamentoRequest.getCartaoCredito());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setCartaoCredito(cartaoCredito);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getDinheiro() != null) {
				Dinheiro dinheiro = dinheiroMapper.paraDinheiro(formaPagamentoRequest.getDinheiro());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setDinheiro(dinheiro);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formasPagamento.add(formaPagamento);
			}
		}

		return formasPagamento;
	}

	public FormaPagamento paraFormaPagamento(FormaPagamentoRequest formaPagamentoRequest) {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(formaPagamentoRequest.getId());
		formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
		formaPagamento.setDinheiro(dinheiroMapper.paraDinheiro(formaPagamentoRequest.getDinheiro()));
		formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
		formaPagamento
				.setCartaoCredito(cartaoCreditoMapper.paraCartaoCredito(formaPagamentoRequest.getCartaoCredito()));
		formaPagamento.setCartaoDebito(cartaoDebitoMapper.paraCartaoDebito(formaPagamentoRequest.getCartaoDebito()));
		return formaPagamento;
	}

	public FormaPagamentoEntity paraFormaPagamentoEntity(FormaPagamento formaPagamento) {

		FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();

		formaPagamentoEntity.setId(formaPagamento.getId());
		formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());

		if (formaPagamento.getCartaoDebito() != null) {
			CartaoDebitoEntity cartaoDebitoEntity = new CartaoDebitoEntity();
			cartaoDebitoEntity.setApelido(formaPagamento.getCartaoDebito().getApelido());
			cartaoDebitoEntity.setCpfCnpj(formaPagamento.getCartaoDebito().getCpfCnpj());
			cartaoDebitoEntity.setCvv(formaPagamento.getCartaoDebito().getCvv());
			cartaoDebitoEntity.setNomeDoTitular(formaPagamento.getCartaoDebito().getNomeDoTitular());
			cartaoDebitoEntity.setNumeroCartao(formaPagamento.getCartaoDebito().getNumeroCartao());
			cartaoDebitoEntity.setValidade(formaPagamento.getCartaoDebito().getValidade());
			cartaoDebitoEntity.setId(formaPagamento.getCartaoDebito().getId());
			cartaoDebitoEntity.setTipoPagamento(formaPagamento.getCartaoDebito().getTipoPagamento());
			formaPagamentoEntity.setCartaoDebito(cartaoDebitoEntity);
		}

		if (formaPagamento.getCartaoCredito() != null) {
			CartaoCreditoEntity cartaoCreditoEntity = new CartaoCreditoEntity();
			cartaoCreditoEntity.setApelido(formaPagamento.getCartaoCredito().getApelido());
			cartaoCreditoEntity.setCpfCnpj(formaPagamento.getCartaoCredito().getCpfCnpj());
			cartaoCreditoEntity.setCvv(formaPagamento.getCartaoCredito().getCvv());
			cartaoCreditoEntity.setNomeDoTitular(formaPagamento.getCartaoCredito().getNomeDoTitular());
			cartaoCreditoEntity.setNumeroCartao(formaPagamento.getCartaoCredito().getNumeroCartao());
			cartaoCreditoEntity.setValidade(formaPagamento.getCartaoCredito().getValidade());
			cartaoCreditoEntity.setId(formaPagamento.getCartaoCredito().getId());
			cartaoCreditoEntity.setTipoPagamento(formaPagamento.getCartaoCredito().getTipoPagamento());
			formaPagamentoEntity.setCartaoCredito(cartaoCreditoEntity);
		}

		if (formaPagamento.getDinheiro() != null) {
			DinheiroEntity dinheiroEntity = new DinheiroEntity();
			formaPagamentoEntity.setDinheiro(dinheiroEntity);
		}

		formaPagamentoEntity.setCliente(paraClienteEntity(formaPagamento.getCliente()));

		return formaPagamentoEntity;
	}

	public ClienteEntity paraClienteEntity(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(cliente.getId());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
		if (cliente.getEmpresa() != null) {
			clienteEntity.setEmpresa(empresaMapper.paraEmpresaEntiy(cliente.getEmpresa()));
		}
		clienteEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos(), clienteEntity));
		clienteEntity.setFormasPagamento(paraListaFormaPagamentoEntity(cliente.getFormasPagamento(), cliente));
		return clienteEntity;
	}

	private List<FormaPagamentoEntity> paraListaFormaPagamentoEntity(List<FormaPagamento> formasPagamento,
			Cliente cliente) {

		List<FormaPagamentoEntity> formasPagamentoEntity = new ArrayList<>();

		for (FormaPagamento formaPagamento : formasPagamento) {
			if (formaPagamento.getCartaoDebito() != null) {
				FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
				formaPagamentoEntity
						.setCartaoDebito(cartaoDebitoMapper.paraCartaoDebitoEntity(formaPagamento.getCartaoDebito()));
				formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());
				formasPagamentoEntity.add(formaPagamentoEntity);
			}

			if (formaPagamento.getCartaoCredito() != null) {
				FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
				formaPagamentoEntity.setCartaoCredito(
						cartaoCreditoMapper.paraCartaoCreditoEntity(formaPagamento.getCartaoCredito()));
				formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());
				formasPagamentoEntity.add(formaPagamentoEntity);
			}

			if (formaPagamento.getDinheiro() != null) {
				FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
				formaPagamentoEntity.setDinheiro(dinheiroMapper.paraDinheiroEntity(formaPagamento.getDinheiro()));
				formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());
				formasPagamentoEntity.add(formaPagamentoEntity);
			}
		}

		return formasPagamentoEntity;
	}

}
