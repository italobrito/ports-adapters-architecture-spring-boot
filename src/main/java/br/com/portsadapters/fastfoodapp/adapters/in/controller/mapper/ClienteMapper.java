package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoCreditoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.CartaoDebitoMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento.formas.DinheiroMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.ClienteRequest;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.FormaPagamentoRequest;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoCredito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.CartaoDebito;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.formas.Dinheiro;

@Component
public class ClienteMapper {

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private EmpresaMapper empresaMapper;

	@Autowired
	private CartaoDebitoMapper cartaoDebitoMapper;

	@Autowired
	private CartaoCreditoMapper cartaoCreditoMapper;

	@Autowired
	private DinheiroMapper dinheiroMapper;

	/*
	 * @Autowired private FormaPagamentoMapper formaPagamentoMapper;
	 */

	public Cliente paraCliente(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteRequest.getId());
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpfCnpj(clienteRequest.getCpfCnpj());
		cliente.setEnderecos(enderecoMapper.paraListaEndereco(clienteRequest.getEnderecos()));
		if (clienteRequest.getEmpresa() != null) {
			cliente.setEmpresa(empresaMapper.paraEmpresa(clienteRequest.getEmpresa()));
		}
		cliente.setFormasPagamento(paraListaFormaPagamento(clienteRequest.getFormasPagamento(), cliente));
		return cliente;
	}

	private List<FormaPagamento> paraListaFormaPagamento(List<FormaPagamentoRequest> formasPagamentoRequest,
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
				/* formaPagamento.setPedido(pedido); */
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getCartaoCredito() != null) {
				CartaoCredito cartaoCredito = cartaoCreditoMapper
						.paraCartaoCredito(formaPagamentoRequest.getCartaoCredito());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setCartaoCredito(cartaoCredito);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formaPagamento.setCliente(cliente);
				/* formaPagamento.setPedido(pedido); */
				formasPagamento.add(formaPagamento);
			}

			if (formaPagamentoRequest.getDinheiro() != null) {
				Dinheiro dinheiro = dinheiroMapper.paraDinheiro(formaPagamentoRequest.getDinheiro());
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setDinheiro(dinheiro);
				formaPagamento.setTipoPagamento(formaPagamentoRequest.getTipoPagamento());
				formaPagamento.setCliente(cliente);
				/* formaPagamento.setPedido(pedido); */
				formasPagamento.add(formaPagamento);
			}
		}

		return formasPagamento;
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

	public ClienteEntity paraClienteEntity(Cliente cliente) {
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

	public Cliente paraCliente(ClienteEntity clienteEntity) {
		Cliente cliente = new Cliente();

		cliente.setId(clienteEntity.getId());

		cliente.setNome(clienteEntity.getNome());
		cliente.setCpfCnpj(clienteEntity.getCpfCnpj());
		cliente.setEnderecos(enderecoMapper.paraEndereco(clienteEntity.getEnderecos()));

		cliente.setEmpresa(empresaMapper.paraEmpresa(clienteEntity.getEmpresa()));

		return cliente;
	}

	public List<Cliente> paraCliente(List<ClienteRequest> clienteRequests) {
		List<Cliente> clientes = new ArrayList<>();
		for (ClienteRequest clienteRequest : clienteRequests) {
			Cliente cliente = new Cliente();
			cliente.setId(clienteRequest.getId());
			cliente.setNome(clienteRequest.getNome());
			cliente.setCpfCnpj(clienteRequest.getCpfCnpj());
			if (clienteRequest.getEnderecos() != null) {
				cliente.setEnderecos(enderecoMapper.paraListaEndereco(clienteRequest.getEnderecos()));
			}
			clientes.add(cliente);
		}
		return clientes;
	}

	public List<ClienteEntity> paraClienteEntity(List<ClienteRequest> clienteRequests) {
		List<ClienteEntity> clientesEntity = new ArrayList<>();
		for (ClienteRequest clienteRequest : clienteRequests) {
			ClienteEntity clienteEntity = new ClienteEntity();
			clienteEntity.setNome(clienteRequest.getNome());
			clienteEntity.setCpfCnpj(clienteRequest.getCpfCnpj());
			clienteEntity.setEnderecos(enderecoMapper.paraListaEnderecoEntity(clienteRequest.getEnderecos()));
			clientesEntity.add(clienteEntity);
		}
		return clientesEntity;
	}

	public List<ClienteEntity> deClienteParaClienteEntity(List<Cliente> clientes) {
		List<ClienteEntity> clientesEntity = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ClienteEntity clienteEntity = new ClienteEntity();

			clienteEntity.setId(cliente.getId());

			clienteEntity.setNome(cliente.getNome());
			clienteEntity.setCpfCnpj(cliente.getCpfCnpj());
			clienteEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos()));

			clienteEntity.setEmpresa(empresaMapper.paraEmpresaEntiy(cliente.getEmpresa()));

			clientesEntity.add(clienteEntity);
		}
		return clientesEntity;
	}

}
