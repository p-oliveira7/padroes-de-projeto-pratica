package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeraPedido {

    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;

    public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public void executa() {
        Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
        LocalDateTime data = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente, data, orcamento);

        System.out.println("Salvar pedido no Banco dd dados");
        System.out.println("Enviar email com dados do novo pedido");
    }
}
