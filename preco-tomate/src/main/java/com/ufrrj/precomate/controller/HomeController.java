package com.ufrrj.precomate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
public class HomeController {
    
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("""
            🍅 Serviço de Preço do Tomate - UFRRJ
            
            Endpoints disponíveis:
            • GET /api/preco/health - Health check
            • GET /api/preco/calcular/{quantidade} - Calcular preço
            • POST /api/preco/calcular - Calcular preço (JSON)
            • GET /api/preco/preco-base - Ver preço base
            • PUT /api/preco/preco-base - Alterar preço base
            
            📖 Documentação: /swagger-ui.html
            """);
    }
}