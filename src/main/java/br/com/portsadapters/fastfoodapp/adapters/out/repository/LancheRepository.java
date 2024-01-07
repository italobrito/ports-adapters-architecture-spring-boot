package br.com.portsadapters.fastfoodapp.adapters.out.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.LancheEntity;
import jakarta.transaction.Transactional;

@Repository
public interface LancheRepository extends JpaRepository<LancheEntity, Long> {
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO lanche_entity (nome, preco, tipo_lanche) VALUES (:nome, :preco, :tipoLanche)", nativeQuery = true)
	int inserirLanchesDiferentesDeSanduiche(@Param(value = "nome") String nome, @Param(value = "preco") BigDecimal preco, @Param(value = "tipoLanche") String tipoLanche);
	
	@Query(value = "SELECT * FROM lanche_entity WHERE tipo_lanche = :tipoLanche", nativeQuery = true)
	List<LancheEntity> buscarLanchesPorTipo(@Param(value = "tipoLanche") String tipoLanche);
}