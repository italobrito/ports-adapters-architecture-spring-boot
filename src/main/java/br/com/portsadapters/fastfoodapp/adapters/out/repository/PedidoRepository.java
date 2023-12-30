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
}
