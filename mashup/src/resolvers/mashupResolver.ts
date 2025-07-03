// src/resolvers/mashupResolver.ts

import { precoTomateResolver } from './tomateResolver';
import { calcularFrete } from './freteResolver';

// Regras de Negócio
const LUCRO_FIXO_PERCENTUAL = 0.55; // 55%
const IMPOSTOS_PERCENTUAL = 0.27; // 27%

interface ValorVendaTomateArgs {
  quantidadeCaixas: number;
  distanciaKm: number;
  tipoVeiculo: string;
}

interface ValorVendaTomateResult {
  precoCustoTomate: number;
  custoFrete: number;
  precoComLucro: number;
  descontoAplicado: number;
  precoPosDesconto: number;
  impostosAplicados: number;
  valorFinalVenda: number;
  detalhesFrete: string;
}

const valorVendaTomateResolver = (
  { quantidadeCaixas, distanciaKm, tipoVeiculo }: ValorVendaTomateArgs
): ValorVendaTomateResult => {

  // 1. Obter o preço do tomate usando o resolver existente
  const precoCustoTomate = precoTomateResolver({ quantidadeCaixas });

  // 2. Obter o custo do frete usando o resolver existente
  const freteResult = calcularFrete({ quilometragem: distanciaKm, tipoVeiculo });
  const custoFrete = freteResult.custoTotal;
  const detalhesFrete = freteResult.detalhe;

  // Preço de Custo Total (tomate + frete)
  const precoCustoTotal = precoCustoTomate + custoFrete;

  // 3. Aplicar Lucro Fixo: +55% sobre (preço do tomate + frete)
  const precoComLucro = precoCustoTotal * (1 + LUCRO_FIXO_PERCENTUAL);

  // 4. Descontos por volume
  let descontoAplicado = 0;
  if (quantidadeCaixas > 300) {
    descontoAplicado = precoComLucro * 0.12; // 12% de desconto acima de 300 caixas
  } else if (quantidadeCaixas > 50) {
    descontoAplicado = precoComLucro * 0.075; // 7.5% de desconto acima de 50 caixas
  }
  const precoPosDesconto = precoComLucro - descontoAplicado;

  // 5. Impostos: +27% sobre o valor final com lucro e desconto aplicados
  const impostosAplicados = precoPosDesconto * IMPOSTOS_PERCENTUAL;

  // 6. Valor Final de Venda
  const valorFinalVenda = precoPosDesconto + impostosAplicados;

  // Retornar todos os detalhes do cálculo
  return {
    precoCustoTomate: parseFloat(precoCustoTomate.toFixed(2)),
    custoFrete: parseFloat(custoFrete.toFixed(2)),
    precoComLucro: parseFloat(precoComLucro.toFixed(2)),
    descontoAplicado: parseFloat(descontoAplicado.toFixed(2)),
    precoPosDesconto: parseFloat(precoPosDesconto.toFixed(2)),
    impostosAplicados: parseFloat(impostosAplicados.toFixed(2)),
    valorFinalVenda: parseFloat(valorFinalVenda.toFixed(2)),
    detalhesFrete,
  };
};

export { valorVendaTomateResolver };