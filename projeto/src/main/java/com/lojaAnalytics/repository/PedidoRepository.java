package com.lojaAnalytics.repository;

import com.lojaAnalytics.dto.PedidosPorCidadeDTO;
import com.lojaAnalytics.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.status = 'CONCLUIDO'")
    long contarPedidosConcluidos();

    // 1. Valor do menor pedido
    @Query(value = """
            SELECT MIN(total_pedido)
            FROM (
                SELECT ip.pedido_id, SUM(ip.quantidade * ip.preco_unitario) AS total_pedido
                FROM item_pedido ip
                INNER JOIN pedido p ON p.id = ip.pedido_id
                WHERE p.status = 'CONCLUIDO'
                GROUP BY ip.pedido_id
            ) totais
            """, nativeQuery = true)
    BigDecimal calcularMenorPedido();

    // 2. Total de pedidos concluídos por cidade
    @Query("""
            SELECT new com.lojaAnalytics.dto.PedidosPorCidadeDTO(c.cidade, COUNT(p))
            FROM Pedido p
            INNER JOIN p.cliente c
            WHERE p.status = 'CONCLUIDO'
            GROUP BY c.cidade
            ORDER BY COUNT(p) DESC
            """)
    List<PedidosPorCidadeDTO> contarPedidosConcluidosPorCidade();
}
