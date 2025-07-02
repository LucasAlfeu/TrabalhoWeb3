package com.ufrrj.precomate.controller;

import com.ufrrj.precomate.dto.*;
import com.ufrrj.precomate.model.*;
import com.ufrrj.precomate.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/preco")
@Tag(name = "Preço do Tomate", description = "API para cálculo de preço de tomates com desconto")
public class PrecoTomateController {
    
    @Autowired
    private PrecoTomateService precoTomateService;
    
    @GetMapping("/health")
    @Operation(summary = "Health Check", description = "Verifica se o serviço está funcionando")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Serviço de Preço do Tomate está funcionando! ✅");
    }
    
    @PostMapping("/calcular")
    @Operation(summary = "Calcular preço total com desconto", 
               description = "Calcula o preço total das caixas de tomate aplicando desconto conforme quantidade")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cálculo realizado with sucesso"),
        @ApiResponse(responseCode = "400", description = "Quantidade inválida")
    })
    public ResponseEntity<PrecoResponse> calcularPreco(@RequestBody PrecoRequest request) {
        try {
            PrecoResponse response = precoTomateService.calcularPreco(request.getQuantidade());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/calcular/{quantidade}")
    @Operation(summary = "Calcular preço via GET", 
               description = "Calcula o preço total via parâmetro na URL")
    public ResponseEntity<PrecoResponse> calcularPrecoGet(
            @Parameter(description = "Quantidade de caixas", example = "15")
            @PathVariable int quantidade) {
        try {
            PrecoResponse response = precoTomateService.calcularPreco(quantidade);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/preco-base")
    @Operation(summary = "Obter preço base", description = "Retorna o preço base por caixa")
    public ResponseEntity<BigDecimal> obterPrecoBase() {
        return ResponseEntity.ok(precoTomateService.getPrecoBase());
    }
    
    @PutMapping("/preco-base")
    @Operation(summary = "Alterar preço base", description = "Altera o preço base por caixa")
    public ResponseEntity<String> alterarPrecoBase(@RequestBody BigDecimal novoPreco) {
        if (novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("Preço deve ser maior que zero");
        }
        precoTomateService.setPrecoBase(novoPreco);
        return ResponseEntity.ok("Preço base alterado para: R$ " + novoPreco);
    }
}
