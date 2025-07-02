package com.ufrrj.precomate.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(description = "Resposta com o cálculo do preço")
public class PrecoResponse {
    
    @Schema(description = "Quantidade de caixas", example = "15")
    private int quantidade;
    
    @Schema(description = "Preço por caixa", example = "50.00")
    private BigDecimal precoPorCaixa;
    
    @Schema(description = "Preço total sem desconto", example = "750.00")
    private BigDecimal precoTotal;
    
    @Schema(description = "Percentual de desconto aplicado", example = "5")
    private int descontoPercentual;
    
    @Schema(description = "Valor do desconto", example = "37.50")
    private BigDecimal valorDesconto;
    
    @Schema(description = "Preço final com desconto", example = "712.50")
    private BigDecimal precoFinal;
    
    public PrecoResponse() {}
    
    public PrecoResponse(int quantidade, BigDecimal precoPorCaixa, BigDecimal precoTotal, 
                        int descontoPercentual, BigDecimal valorDesconto, BigDecimal precoFinal) {
        this.quantidade = quantidade;
        this.precoPorCaixa = precoPorCaixa;
        this.precoTotal = precoTotal;
        this.descontoPercentual = descontoPercentual;
        this.valorDesconto = valorDesconto;
        this.precoFinal = precoFinal;
    }
    
    // Getters e Setters
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    public BigDecimal getPrecoPorCaixa() { return precoPorCaixa; }
    public void setPrecoPorCaixa(BigDecimal precoPorCaixa) { this.precoPorCaixa = precoPorCaixa; }
    
    public BigDecimal getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(BigDecimal precoTotal) { this.precoTotal = precoTotal; }
    
    public int getDescontoPercentual() { return descontoPercentual; }
    public void setDescontoPercentual(int descontoPercentual) { this.descontoPercentual = descontoPercentual; }
    
    public BigDecimal getValorDesconto() { return valorDesconto; }
    public void setValorDesconto(BigDecimal valorDesconto) { this.valorDesconto = valorDesconto; }
    
    public BigDecimal getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(BigDecimal precoFinal) { this.precoFinal = precoFinal; }
}