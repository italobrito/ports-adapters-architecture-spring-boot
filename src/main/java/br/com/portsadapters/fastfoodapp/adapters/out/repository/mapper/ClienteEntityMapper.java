package br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas.DinheiroEntityMapper;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.EnderecoMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EmpresaEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.EnderecoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas.CartaoCreditoEntityMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.formas.CartaoDebitoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.core.domain.Endereco;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.FormaPagamento;

@Component
public class ClienteEntityMapper {

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private DinheiroEntityMapper dinheiroEntityMapper;

	@Autowired
	private CartaoCreditoEntityMapper cartaoCreditoEntityMapper;

	@Autowired
	private CartaoDebitoEntityMapper cartaoDebitoEntityMapper;

	public ClienteEntity paraClienteEntity(Cliente cliente) {

		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setId(cliente.getId());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setCpfCnpj(cliente.getCpfCnpj());

		List<EnderecoEntity> enderecosEntity = new ArrayList<>();

		if (cliente.getEnderecos() != null) {
			for (Endereco endereco : cliente.getEnderecos()) {

				EnderecoEntity enderecoEntity = new EnderecoEntity();
				enderecoEntity.setRua(endereco.getRua());
				enderecoEntity.setCep(endereco.getCep());
				enderecoEntity.setNumero(endereco.getNumero());
				enderecoEntity.setComplemento(endereco.getComplemento());
				enderecoEntity.setCliente(clienteEntity);

				enderecosEntity.add(enderecoEntity);
			}
		}

		if (cliente.getEmpresa() != null) {
			EmpresaEntity empresaEntity = new EmpresaEntity();
			empresaEntity.setCnpj(cliente.getEmpresa().getCnpj());
			empresaEntity.setAtivo(cliente.getEmpresa().getAtivo());
			empresaEntity.setId(cliente.getEmpresa().getId());
			empresaEntity.setEnderecos(enderecoMapper.paraEnderecoEntity(cliente.getEnderecos()));
		}

		List<FormaPagamentoEntity> pagamentosEntity = new ArrayList<>();

		if (cliente.getFormasPagamento() != null) {
			for (FormaPagamento pagamento : cliente.getFormasPagamento()) {

				FormaPagamentoEntity pagamentoEntity = new FormaPagamentoEntity();

				pagamentoEntity.setCliente(clienteEntity);
				pagamentoEntity.setId(pagamento.getId());

				if (pagamento.getCartaoCredito() != null) {
					pagamentoEntity.setCartaoCredito(
							cartaoCreditoEntityMapper.paraCartaoCreditoEntity(pagamento.getCartaoCredito()));
				}
				
				if (pagamento.getCartaoDebito() != null) {
					pagamentoEntity.setCartaoDebito(
							cartaoDebitoEntityMapper.paraCartaoDebitoEntity(pagamento.getCartaoDebito()));
				}
				
				if (pagamento.getDinheiro() != null) {
					pagamentoEntity.setDinheiro(dinheiroEntityMapper.paraDinheiroEntity(pagamento.getDinheiro()));
				}

				pagamentoEntity.setTipoPagamento(pagamento.getTipoPagamento());
				pagamentosEntity.add(pagamentoEntity);
			}
		}

		clienteEntity.setEnderecos(enderecosEntity);

		clienteEntity.setFormasPagamento(pagamentosEntity);

		return clienteEntity;
	}

	public List<ClienteEntity> paraClienteEntity(List<Cliente> clientes) {
		List<ClienteEntity> clientesEntity = new ArrayList<>();

		for (Cliente cliente : clientes) {
			ClienteEntity clienteEntity = new ClienteEntity();
			clienteEntity.setId(cliente.getId());
			clienteEntity.setNome(cliente.getNome());
			clienteEntity.setCpfCnpj(cliente.getCpfCnpj());

			List<EnderecoEntity> enderecosEntity = new ArrayList<>();

			if (cliente.getEnderecos() != null) {
				for (Endereco endereco : cliente.getEnderecos()) {
					EnderecoEntity enderecoEntity = new EnderecoEntity();
					enderecoEntity.setRua(endereco.getRua());
					enderecoEntity.setCep(endereco.getCep());
					enderecoEntity.setNumero(endereco.getNumero());
					enderecoEntity.setComplemento(endereco.getComplemento());
					enderecoEntity.setCliente(clienteEntity);

					enderecosEntity.add(enderecoEntity);
				}
			}

			clienteEntity.setEnderecos(enderecosEntity);
			clientesEntity.add(clienteEntity);
		}

		return clientesEntity;
	}

	public Cliente paraCliente(ClienteEntity clienteEntity) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteEntity.getId());
		cliente.setNome(clienteEntity.getNome());
		cliente.setCpfCnpj(clienteEntity.getCpfCnpj());

		List<Endereco> enderecos = new ArrayList<>();
		if (clienteEntity.getEnderecos() != null) {
			for (EnderecoEntity enderecoEntity : clienteEntity.getEnderecos()) {

				Endereco endereco = new Endereco();
				endereco.setRua(enderecoEntity.getRua());
				endereco.setCep(enderecoEntity.getCep());
				endereco.setNumero(enderecoEntity.getNumero());
				endereco.setComplemento(enderecoEntity.getComplemento());

				enderecos.add(endereco);
			}
		}
		cliente.setEnderecos(enderecos);

		return cliente;
	}

}
