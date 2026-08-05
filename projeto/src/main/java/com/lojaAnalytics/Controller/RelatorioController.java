package com.lojaAnalytics.Controller;

import com.lojaAnalytics.dto.FaturamentoCategoriaDTO;
import com.lojaAnalytics.dto.PedidosPorCidadeDTO;
import com.lojaAnalytics.dto.ProdutoRankingDTO;
import com.lojaAnalytics.repository.ItemPedidoRepository;
import com.lojaAnalytics.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @GetMapping("/total-pedidos")
    public long totalPedidos() {
        return pedidoRepository.contarPedidosConcluidos();
    }

    @GetMapping("/faturamento-total")
    public BigDecimal faturamentoTotal() {
        return itemPedidoRepository.calcularFaturamento();
    }

    @GetMapping("/maior-pedido")
    public BigDecimal maiorPedido() {
        return itemPedidoRepository.calcularMaiorPedido();
    }

    @GetMapping("/faturamento-por-categoria")
    public List<FaturamentoCategoriaDTO> faturamentoPorCategoria() {
        return itemPedidoRepository.listarFaturamentoPorCategoria();
    }

    @GetMapping("/rank-produtos")
    public List<ProdutoRankingDTO> rankProdutos() {
        return itemPedidoRepository.listarRankProdutos();
    }

    // Novos endpoints
    @GetMapping("/menor-pedido")
    public BigDecimal menorPedido() {
        return pedidoRepository.calcularMenorPedido();
    }

    @GetMapping("/pedidos-por-cidade")
    public List<PedidosPorCidadeDTO> pedidosPorCidade() {
        return pedidoRepository.contarPedidosConcluidosPorCidade();
    }
}
