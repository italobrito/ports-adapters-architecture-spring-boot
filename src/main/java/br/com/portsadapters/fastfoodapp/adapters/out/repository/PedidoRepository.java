package br.com.portsadapters.fastfoodapp.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.PedidoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "update pedido_entity u set u.status = :status WHERE u.id = :id", nativeQuery = true)
	int atualizarStatus(@Param(value = "id") Long id, @Param(value = "status") String status);
	
	@Modifying
	@Transactional
	@Query(value = "update pedido_entity u set u.pagamento_id = :pagamento_id WHERE u.id = :id", nativeQuery = true)
	int pagamentoId(@Param(value = "pagamento_id") Long pagamento_id, @Param(value = "id") Long id);
}
