package com.exemplo.padroes.pagamento;

import org.springframework.stereotype.Component;
import java.util.Locale;

@Component("boleto") // bean name: "boleto"
public class Boleto implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        return String.format(Locale.US,
                "Pagamento de R$%.2f realizado com Boleto Bancário.", valor);
    }
}
