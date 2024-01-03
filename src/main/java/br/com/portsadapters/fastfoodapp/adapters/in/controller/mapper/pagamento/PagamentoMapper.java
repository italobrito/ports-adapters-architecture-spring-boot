package br.com.portsadapters.fastfoodapp.adapters.in.controller.mapper.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.portsadapters.fastfoodapp.adapters.in.controller.request.pagamento.PagamentoRequest;
import br.com.portsadapters.fastfoodapp.application.core.domain.pagamento.Pagamento;

@Component
public class PagamentoMapper {

	/*
	 * @Autowired private DinheiroMapper dinheiroMapper;
	 * 
	 * @Autowired private CartaoCreditoMapper cartaoMapper;
	 */
	
	@Autowired
	private FormaPagamentoMapper formaPagamentoMapper;

    public Pagamento paraPagamento(PagamentoRequest pagamentoRequest) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoRequest.getId());
        pagamento.setValorTotal(pagamentoRequest.getValorTotal());
        if (pagamentoRequest.getFormaPagamento() != null) {
            pagamento.setFormaPagamento(formaPagamentoMapper.paraFormaPagamento(pagamentoRequest.getFormaPagamento()));
        }
        return pagamento;
    }
    
	/*
	 * public PagamentoRequest paraPagamentoRequest(Pagamento pagamento) {
	 * PagamentoRequest pagamentoRequest = new PagamentoRequest();
	 * pagamentoRequest.setId(pagamento.getId());
	 * pagamentoRequest.setValorTotal(pagamento.getValorTotal());
	 * 
	 * if (pagamento.getFormaPagamento() != null) { FormaPagamentoRequest
	 * formaPagamentoRequest =
	 * formaPagamentoMapper.paraFormaPagamentoRequest(pagamento.getFormaPagamento())
	 * ; pagamentoRequest.setFormaPagamento(formaPagamentoRequest); }
	 * 
	 * return pagamentoRequest; }
	 */

	/*
	 * public List<Pagamento> paraListaPagamento(List<PagamentoRequest>
	 * pagamentosRequest, Cliente cliente) {
	 * 
	 * }
	 */

	/*
	 * public List<FormaPagamento> paraListaPagamento(List<PagamentoRequest>
	 * pagamentosRequest, Cliente cliente) { List<FormaPagamento> pagamentos = new
	 * ArrayList<>(); for (PagamentoRequest pagamentoRequest : pagamentosRequest) {
	 * FormaPagamento pagamento = new FormaPagamento();
	 * pagamento.setId(pagamentoRequest.getId());
	 * pagamento.setTipoPagamento(pagamentoRequest.getTipoPagamento());
	 * pagamento.setCliente(cliente);
	 * 
	 * 
	 * if (pagamentoRequest.getCartao() != null) { Cartao cartao =
	 * cartaoMapper.paraCartao(pagamentoRequest.getCartao());
	 * pagamento.setCartao(cartao); } if (pagamentoRequest.getDinheiro() != null) {
	 * Dinheiro dinheiro =
	 * dinheiroMapper.paraDinheiro(pagamentoRequest.getDinheiro());
	 * pagamento.setDinheiro(dinheiro); }
	 * 
	 * 
	 * pagamentos.add(pagamento); } return pagamentos; }
	 */

}
