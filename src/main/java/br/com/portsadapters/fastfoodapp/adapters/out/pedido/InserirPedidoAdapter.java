package br.com.portsadapters.fastfoodapp.adapters.out.pedido;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.PagamentoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.PedidoRepository;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.PedidoEntityMapper;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.mapper.pagamento.PagamentoEntityMapper;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.InserirPedidoOutputPort;

@Component
public class InserirPedidoAdapter implements InserirPedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PedidoEntityMapper pedidoEntityMapper;

	@Autowired
	private PagamentoEntityMapper pagamentoEntityMapper;

	@Override
	public PedidoEntity inserir(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoEntityMapper.paraPedidoEntity(pedido);
		PagamentoEntity pagamentoEntity = pagamentoEntityMapper.paraPagamentoEntity(pedido.getPagamento());
		pedidoEntity.setPagamento(null);
		PedidoEntity pedidoSalvo = pedidoRepository.save(pedidoEntity);
		pagamentoEntity.setPedido(pedidoSalvo);
		pagamentoRepository.inserir(pedido.getPagamento().getFormaPagamento().getId(), pedidoSalvo.getId(),
				pedido.getPrecoTotalPedido());
		Long ultimoPagamentoId = pagamentoRepository.buscarUltimoPagamentoId();
		pedidoEntity.setPagamento(pagamentoEntity);
		pedidoEntity.setId(pedidoSalvo.getId());
		pedidoSalvo.getPagamento().setId(ultimoPagamentoId);
		pedidoRepository.pagamentoId(ultimoPagamentoId, pedidoSalvo.getId());
		return pedidoSalvo;
	}

}
