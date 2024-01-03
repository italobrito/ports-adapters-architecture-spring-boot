package br.com.portsadapters.fastfoodapp.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portsadapters.fastfoodapp.adapters.out.repository.entity.pagamento.formas.CartaoDebitoEntity;

@Repository
public interface CartaoDebitoRepository extends JpaRepository<CartaoDebitoEntity, Long> {

}
