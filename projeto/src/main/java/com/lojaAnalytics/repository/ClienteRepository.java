package com.lojaAnalytics.repository;

import com.lojaAnalytics.dto.ClienteResumoDTO;
import com.lojaAnalytics.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("""
            SELECT new com.lojaAnalytics.dto.ClienteResumoDTO(c.id, c.nome, COUNT(p))
            FROM Cliente c
            INNER JOIN Pedido p
            GROUP BY c.id, c.nome
            ORDER BY COUNT(p) DESC
            """)
    List<ClienteResumoDTO> contarPedidoPorCliente();
}
