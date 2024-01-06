package br.com.portsadapters.fastfoodapp.adapters.out.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.PagamentoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "insert into pagamento_entity (forma_pagamento_id, pedido_id, valor_total) values(:forma_pagamento_id, :pedido_id, :valor_total)", nativeQuery = true)
	void inserir(@Param(value = "forma_pagamento_id") Long forma_pagamento_id, @Param(value = "pedido_id") Long pedido_id, @Param(value = "valor_total") BigDecimal valor_total);
	
	@Query(value = "SELECT id FROM pagamento_entity p ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Long buscarUltimoPagamentoId();
}
