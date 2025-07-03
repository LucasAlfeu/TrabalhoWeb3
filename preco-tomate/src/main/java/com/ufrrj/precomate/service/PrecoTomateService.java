package com.ufrrj.precomate.service;

import com.ufrrj.precomate.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PrecoTomateService {
    
    @Value("${app.preco-base:50.00}")
    private BigDecimal precoBase;
    
    public PrecoResponse calcularPreco(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        
        BigDecimal precoTotal = precoBase.multiply(BigDecimal.valueOf(quantidade));
        int descontoPercentual = obterDescontoPercentual(quantidade);
        
        BigDecimal valorDesconto = precoTotal
            .multiply(BigDecimal.valueOf(descontoPercentual))
            .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            
        BigDecimal precoFinal = precoTotal.subtract(valorDesconto);
        
        return new PrecoResponse(
            quantidade,
            precoBase,
            precoTotal,
            descontoPercentual,
            valorDesconto,
            precoFinal
        );
    }
    
    private int obterDescontoPercentual(int quantidade) {
        if (quantidade >= 30) {
            return 22;
        } else if (quantidade >= 20) {
            return 11;
        } else if (quantidade >= 10) {
            return 5;
        } else {
            return 0;
        }
    }
    
    public BigDecimal getPrecoBase() {
        return precoBase;
    }
    
    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }
}