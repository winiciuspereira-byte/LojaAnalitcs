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

    @Query(value = """
            SELECT p.nome, SUM(i.quantidade) AS quantidadeVendida
            FROM item_pedido i
            INNER JOIN produto p ON i.produto_id = p.id
            GROUP BY p.nome
            ORDER BY quantidadeVendida DESC
            LIMIT 5
            """, nativeQuery = true)
    List<ProdutoRankingDTO> listarRankProdutos();
}
