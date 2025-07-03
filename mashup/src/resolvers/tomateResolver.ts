const PRECO_BASE_POR_CAIXA = 50.00;

interface DescontoFaixa {
  min: number;
  max: number;
  percentual: number;
}

const TABELA_DESCONTOS: DescontoFaixa[] = [
  { min: 0, max: 9, percentual: 0 },
  { min: 10, max: 19, percentual: 0.05 },
  { min: 20, max: 29, percentual: 0.11 },
  { min: 30, max: Infinity, percentual: 0.22 },
];

const precoTomateResolver = ({ quantidadeCaixas }: { quantidadeCaixas: number }): number => {
  if (quantidadeCaixas < 0) {
    throw new Error("A quantidade de caixas não pode ser negativa.");
  }

  const precoTotalBruto = quantidadeCaixas * PRECO_BASE_POR_CAIXA;
  let descontoAplicado = 0;

  for (const faixa of TABELA_DESCONTOS) {
    if (quantidadeCaixas >= faixa.min && quantidadeCaixas <= faixa.max) {
      descontoAplicado = precoTotalBruto * faixa.percentual;
      break;
    }
  }

  const precoFinal = precoTotalBruto - descontoAplicado;
  return parseFloat(precoFinal.toFixed(2));
};

export { precoTomateResolver };