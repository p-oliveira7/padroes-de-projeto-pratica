package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBanco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeraPedidoHandler {

    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;

    public GeraPedidoHandler(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public void executa() {
        Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
        LocalDateTime data = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente, data, orcamento);

        EnviarEmailPedido email = new EnviarEmailPedido();
        SalvarPedidoNoBanco salvar = new SalvarPedidoNoBanco();

        email.executar(pedido);
        salvar.executar(pedido);
    }
}
