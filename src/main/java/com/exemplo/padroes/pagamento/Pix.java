package com.exemplo.padroes.pagamento;

import org.springframework.stereotype.Component;
import java.util.Locale;

@Component("pix") // bean name: "pix"
public class Pix implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        return String.format(Locale.US,
                "Pagamento de R$%.2f realizado via Pix.", valor);
    }
}
