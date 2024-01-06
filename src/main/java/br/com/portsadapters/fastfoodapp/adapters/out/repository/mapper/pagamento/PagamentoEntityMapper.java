package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EmpresaMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EnderecoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoCreditoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoDebitoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.DinheiroMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.ItemPedidoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.Pagamento;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

@Component
public class PagamentoEntityMapper {

	@Autowired
	private CartaoDebitoMapper cartaoDebitoMapper;

	@Autowired
	private CartaoCreditoMapper cartaoCreditoMapper;

	@Autowired
	private DinheiroMapper dinheiroMapper;

	@Autowired
	private EmpresaMapper empresaMapper;

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private ClienteMapper clienteMapper;

	@Autowired
	private ItemPedidoEntityMapper itemPedidoEntityMapper;

	@Autowired
	private FormaPagamentoEntityMapper formaPagamentoEntityMapper;

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

	private DinheiroEntity paraDinheiroEntity(Dinheiro dinheiro) {
		DinheiroEntity dinheiroEntity = new DinheiroEntity();
		dinheiroEntity.setId(dinheiro.getId());
		dinheiroEntity.setTipoPagamento(dinheiro.getTipoPagamento());
		return dinheiroEntity;
	}

	private ClienteEntity paraClienteEntity(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(cliente.getId());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
		if (cliente.getEmpresa() != null) {
			clienteEntity.setEmpresa(empresaMapper.paraEmpresaEntiy(cliente.getEmpresa()));
		}
		clienteEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos(), clienteEntity));
		if (cliente.getFormasPagamento() != null) {
			clienteEntity.setFormasPagamento(paraListaFormaPagamentoEntity(cliente.getFormasPagamento(), cliente));
		}
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

	private PedidoEntity paraPedidoEntity(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(pedido.getId());
		pedidoEntity.setCliente(clienteMapper.paraClienteEntity(pedido.getCliente()));
		pedidoEntity.setPrecoTotalPedido(pedido.getPrecoTotalPedido());
		pedidoEntity.setStatus(pedido.getStatus());
		pedidoEntity.setItemsPedido(
				itemPedidoEntityMapper.paraListaItemPedidoEntity(pedido.getItemsPedido(), pedidoEntity));

		PagamentoEntity pagamentoEntity = new PagamentoEntity();

		pagamentoEntity.setId(pedido.getPagamento().getId());
		pagamentoEntity.setValorTotal(pedido.getPagamento().getValorTotal());

		pagamentoEntity.setFormaPagamento(
				formaPagamentoEntityMapper.paraFormaPagamentoEntity(pedido.getPagamento().getFormaPagamento()));

		pedidoEntity.setPagamento(pagamentoEntity);

		return pedidoEntity;
	}

	public PagamentoEntity paraPagamentoEntity(Pagamento pagamento) {

		PagamentoEntity pagamentoEntity = new PagamentoEntity();

		if (pagamento.getId() != null) {
			pagamentoEntity.setId(pagamento.getId());
		}

		pagamentoEntity.setValorTotal(pagamento.getValorTotal());

		FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
		FormaPagamento formaPagamento = pagamento.getFormaPagamento();

		if (formaPagamento != null) {

			if (formaPagamento.getId() != null) {
				formaPagamentoEntity.setId(formaPagamento.getId());
			}

			formaPagamentoEntity.setTipoPagamento(formaPagamento.getTipoPagamento());

			if (formaPagamento.getCartaoCredito() != null) {
				formaPagamentoEntity.setCartaoCredito(paraCartaoCreditoEntity(formaPagamento.getCartaoCredito()));
			}

			if (formaPagamento.getCartaoDebito() != null) {
				formaPagamentoEntity.setCartaoDebito(paraCartaoDebitoEntity(formaPagamento.getCartaoDebito()));
			}

			if (formaPagamento.getDinheiro() != null) {
				formaPagamentoEntity.setDinheiro(paraDinheiroEntity(formaPagamento.getDinheiro()));
			}

			if (formaPagamento.getCliente() != null) {
				formaPagamentoEntity.setCliente(paraClienteEntity(formaPagamento.getCliente()));
			}

			if (formaPagamento.getPedido() != null) {
				formaPagamentoEntity.setPedido(paraPedidoEntity(formaPagamento.getPedido()));
			}

		}

		pagamentoEntity.setFormaPagamento(formaPagamentoEntity);

		return pagamentoEntity;
	}

}
