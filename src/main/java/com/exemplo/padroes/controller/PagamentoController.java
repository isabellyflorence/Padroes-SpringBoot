package com.exemplo.padroes.controller;

import com.exemplo.padroes.service.PagamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    // Ex.: GET /pagamento?metodo=pix&valor=50
    @GetMapping
    public String pagar(@RequestParam String metodo, @RequestParam double valor) {
        return pagamentoService.processarPagamento(metodo, valor);
    }
}
