package com.ufrrj.precomate.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Requisição para cálculo do preço")
public class PrecoRequest {
    
    @Schema(description = "Quantidade de caixas de tomate", example = "15", minimum = "1")
    private int quantidade;
    
    public PrecoRequest() {}
    
    public PrecoRequest(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

