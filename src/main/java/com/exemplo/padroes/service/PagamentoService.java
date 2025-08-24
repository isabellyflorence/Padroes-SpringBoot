package com.exemplo.padroes.service;

import com.exemplo.padroes.pagamento.PagamentoStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service // Singleton por padrão no Spring
public class PagamentoService {

    // O Spring injeta todas as Implementações de PagamentoStrategy neste Map.
    // A CHAVE do Map é o nome do bean (definido no @Component("nome")).
    private final Map<String, PagamentoStrategy> estrategias;

    public PagamentoService(Map<String, PagamentoStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public String processarPagamento(String metodo, double valor) {
        PagamentoStrategy estrategia = estrategias.get(metodo);
        if (estrategia == null) {
            return "Método de pagamento inválido. Use: cartao, pix ou boleto.";
        }
        return estrategia.pagar(valor);
    }
}
