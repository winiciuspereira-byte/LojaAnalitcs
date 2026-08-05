package com.lojaAnalytics.repository;

import com.lojaAnalytics.dto.FaturamentoCategoriaDTO;
import com.lojaAnalytics.dto.ProdutoRankingDTO;
import com.lojaAnalytics.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    @Query("SELECT SUM(i.quantidade * i.precoUnitario) FROM ItemPedido i WHERE i.pedido.status = 'CONCLUIDO'")
    BigDecimal calcularFaturamento();

    @Query(value = """
            SELECT MAX(total_pedido)
            FROM (
                SELECT ip.pedido_id, SUM(ip.quantidade * ip.preco_unitario) AS total_pedido
                FROM item_pedido ip
                GROUP BY ip.pedido_id
            ) totais
            """, nativeQuery = true)
    BigDecimal calcularMaiorPedido();

    @Query("""
            SELECT new com.lojaAnalytics.dto.FaturamentoCategoriaDTO(c.nome, SUM(ip.quantidade * ip.precoUnitario))
            FROM ItemPedido ip
            INNER JOIN ip.produto p
            INNER JOIN p.categoria c
            WHERE ip.pedido.status = 'CONCLUIDO'
            GROUP BY c.nome
            ORDER BY SUM(ip.quantidade * ip.precoUnitario) DESC
            """)
    List<FaturamentoCategoriaDTO> listarFaturamentoPorCategoria();

    @Query("""
            SELECT new com.lojaAnalytics.dto.ProdutoRankingDTO(p.nome, SUM(i.quantidade))
            FROM ItemPedido i
            INNER JOIN i.produto p
            GROUP BY p.nome
            ORDER BY SUM(i.quantidade) DESC
            LIMIT 5
            """)
    List<ProdutoRankingDTO> listarRankProdutos();
}
