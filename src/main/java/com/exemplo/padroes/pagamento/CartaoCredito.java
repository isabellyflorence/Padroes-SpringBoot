package com.exemplo.padroes.pagamento;

import org.springframework.stereotype.Component;
import java.util.Locale;

@Component("cartao") // bean name: "cartao"
public class CartaoCredito implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        return String.format(Locale.US,
                "Pagamento de R$%.2f realizado com Cartão de Crédito.", valor);
    }
}
