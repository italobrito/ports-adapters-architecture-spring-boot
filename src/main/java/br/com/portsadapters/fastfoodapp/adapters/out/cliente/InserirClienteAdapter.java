package br.com.portsadapters.fastfoodapp.adapters.out.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.CartaoCreditoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.CartaoDebitoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.ClienteRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.DinheiroRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.FormaPagamentoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.ClienteEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.FormaPagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoCreditoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.DinheiroEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.ClienteEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Cliente;
import br.com.portsadapters.fastfoodapp.application.ports.out.cliente.InserirClienteOutputPort;

@Component
public class InserirClienteAdapter implements InserirClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CartaoDebitoRepository cartaoDebitoRepository;

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

	@Autowired
	private DinheiroRepository dinheiroRepository;

	/*
	 * @Autowired private FormaPagamentoRepository formaPagamentoRepository;
	 */

	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public ClienteEntity inserir(Cliente cliente) {

		ClienteEntity clienteEntity = clienteEntityMapper.paraClienteEntity(cliente);

		setarFormasPagamento(clienteEntity);

		ClienteEntity clienteSalvo = clienteRepository.save(clienteEntity);

		System.out.print(clienteSalvo);

		for (FormaPagamentoEntity pagamento : clienteEntity.getFormasPagamento()) {

			if (pagamento.getCartaoDebito() != null) {
				pagamento.getCartaoDebito().setFormaPagamento(pagamento);
				CartaoDebitoEntity cartaoDebitoSalvo = cartaoDebitoRepository.save(pagamento.getCartaoDebito());
				pagamento.getCartaoDebito().setId(cartaoDebitoSalvo.getId());
			}

			if (pagamento.getCartaoCredito() != null) {
				pagamento.getCartaoCredito().setFormaPagamento(pagamento);
				CartaoCreditoEntity cartaoCreditoSalvo = cartaoCreditoRepository.save(pagamento.getCartaoCredito());
				pagamento.getCartaoCredito().setId(cartaoCreditoSalvo.getId());
			}

			if (pagamento.getDinheiro() != null) {
				pagamento.getDinheiro().setFormaPagamento(pagamento);
				DinheiroEntity dinheiroSalvo = dinheiroRepository.save(pagamento.getDinheiro());
				pagamento.getDinheiro().setId(dinheiroSalvo.getId());
			}

		}

		clienteSalvo.getFormasPagamento();
		clienteEntity.setId(clienteSalvo.getId());

		return clienteSalvo;
	}

	private void setarFormasPagamento(ClienteEntity clienteEntity) {
		for (FormaPagamentoEntity pagamento : clienteEntity.getFormasPagamento()) {
			if (pagamento.getCartaoDebito() != null) {
				CartaoDebitoEntity cartaoDebitoSalvo = cartaoDebitoRepository.save(pagamento.getCartaoDebito());
				pagamento.setCartaoDebito(cartaoDebitoSalvo);
			}

			if (pagamento.getCartaoCredito() != null) {
				CartaoCreditoEntity cartaoCreditoSalvo = cartaoCreditoRepository.save(pagamento.getCartaoCredito());
				pagamento.setCartaoCredito(cartaoCreditoSalvo);
			}

			if (pagamento.getDinheiro() != null) {
				DinheiroEntity dinheiroSalvo = dinheiroRepository.save(pagamento.getDinheiro());
				pagamento.setDinheiro(dinheiroSalvo);
			}
		}
	}

	@Override
	public List<ClienteEntity> inserirTodos(List<Cliente> clientes) {
		List<ClienteEntity> clientesEntity = clienteEntityMapper.paraClienteEntity(clientes);
		List<ClienteEntity> savedEntities = clienteRepository.saveAll(clientesEntity);

		for (int i = 0; i < clientes.size(); i++) {
			clientes.get(i).setId(savedEntities.get(i).getId());
		}

		return savedEntities;
	}

}
