package br.com.portsadapters.fastfoodapp.application.core.usecase.pedido;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.InsumoEntity;
import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import br.com.portsadapters.fastfoodapp.application.core.domain.Insumo;
import br.com.portsadapters.fastfoodapp.application.core.domain.ItemPedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.Lanche;
import br.com.portsadapters.fastfoodapp.application.core.domain.Pedido;
import br.com.portsadapters.fastfoodapp.application.core.domain.enums.TipoStatus;
import br.com.portsadapters.fastfoodapp.application.core.domain.exceptions.EstoqueInsuficienteException;
import br.com.portsadapters.fastfoodapp.application.ports.in.pedido.InserirPedidoInputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.AtualizarInsumoOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.insumo.BuscarInsumoPorIdOutputPort;
import br.com.portsadapters.fastfoodapp.application.ports.out.pedido.InserirPedidoOutputPort;
import br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.InsumoMapper;

public class InserirPedidoUseCase implements InserirPedidoInputPort {
	
	@Autowired
	private InsumoMapper insumoMapper;

	private final InserirPedidoOutputPort inserirPedidoOutputPort;

	private final BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort;
	
	private final AtualizarInsumoOutputPort atualizarInsumoOutputPort;
	
	public InserirPedidoUseCase(InserirPedidoOutputPort inserirPedidoOutputPort,
			BuscarInsumoPorIdOutputPort buscarInsumoPorIdOutputPort, 
			AtualizarInsumoOutputPort atualizarInsumoOutputPort) {
		this.inserirPedidoOutputPort = inserirPedidoOutputPort;
		this.buscarInsumoPorIdOutputPort = buscarInsumoPorIdOutputPort;
		this.atualizarInsumoOutputPort = atualizarInsumoOutputPort;
	}
	
	@Override
	public PedidoEntity inserir(Pedido pedido) {
		pedido.setStatus(TipoStatus.RECEBIDO);
		if (!realizarPagamento(pedido)) {
			throw new RuntimeException("Pagamento não realizado");
		}
		fluxoDoEstoque(pedido);
		return this.inserirPedidoOutputPort.inserir(pedido);
	}
	
	// TODO - Desenvolver os fluxos de pagamento
	private boolean realizarPagamento(Pedido pedido) {
		if (pedido.getPagamento().getFormaPagamento().getCartaoCredito() != null) {
			executarFluxoCredito();
		}
		
		if (pedido.getPagamento().getFormaPagamento().getCartaoDebito() != null) {
			executarFluxoDebito();
		}
		
		if (pedido.getPagamento().getFormaPagamento().getDinheiro() != null) {
			return true;
		}
		return true;
	}
	
	private void executarFluxoCredito() {
		System.out.print("EXECUTOU O FLUXO DE CREDITO");
	}
	
	private void executarFluxoDebito() {
		System.out.print("EXECUTOU O FLUXO DE DEBITO");
	}
	
	
	private void fluxoDoEstoque(Pedido pedido) {
		verificaEstoque(pedido);
		reduzirInsumos(pedido);
	}

	private void verificaEstoque(Pedido pedido) {
		Map<Long, Integer> totalInsumos = new HashMap<>();

		for (ItemPedido itemPedido : pedido.getItemsPedido()) {
			Lanche lanche = itemPedido.getLanches();

			for (Insumo insumo : lanche.getInsumos()) {
				long insumoId = insumo.getId();
				int quantidadeAtual = totalInsumos.getOrDefault(insumoId, 0);
				totalInsumos.put(insumoId, quantidadeAtual + insumo.getQuantidade() * itemPedido.getQuantidade());
			}
		}

		for (Map.Entry<Long, Integer> entry : totalInsumos.entrySet()) {
			Long insumoId = entry.getKey();
			int quantidadeNecessaria = entry.getValue();

			Optional<InsumoEntity> insumoEntity = buscarInsumoPorIdOutputPort.buscarPorId(insumoId);

			if (insumoEntity.isPresent() && insumoEntity.get().getQuantidade() < quantidadeNecessaria) {
				throw new EstoqueInsuficienteException(
						"Insumo com ID " + insumoId + " não possui quantidade suficiente.");
			}
		}
	}
	
	private void reduzirInsumos(Pedido pedido) {
	    Map<Long, Integer> insumoQuantidadeMap = new HashMap<>();

	    for (ItemPedido itemPedido : pedido.getItemsPedido()) {
	        Lanche lanche = itemPedido.getLanches();

	        for (Insumo insumo : lanche.getInsumos()) {
	        	
	            long insumoId = insumo.getId();
	            int quantidadeNecessaria = insumo.getQuantidade() * itemPedido.getQuantidade();
	            insumoQuantidadeMap.put(insumoId, insumoQuantidadeMap.getOrDefault(insumoId, 0) + quantidadeNecessaria);
	            
	        }
	    }

	    for (Map.Entry<Long, Integer> entry : insumoQuantidadeMap.entrySet()) {
	        long insumoId = entry.getKey();
	        int quantidadeNecessaria = entry.getValue();

	        Optional<InsumoEntity> insumoEntityOptional = buscarInsumoPorIdOutputPort.buscarPorId(insumoId);

	        if (insumoEntityOptional.isPresent()) {
	            InsumoEntity insumoEntity = insumoEntityOptional.get();
	            insumoEntity.setQuantidade(insumoEntity.getQuantidade() - quantidadeNecessaria);
	            atualizarInsumoOutputPort.atualizar(insumoMapper.paraInsumo(insumoEntity));
	        }
	    }
	}

}
