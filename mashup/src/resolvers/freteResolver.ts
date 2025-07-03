import { veiculos, TipoVeiculo } from "../data/veiculos";

export const calcularFrete = ({
  quilometragem,
  tipoVeiculo
}: {
  quilometragem: number;
  tipoVeiculo: string;
}) => {
  const tipo = tipoVeiculo.toLowerCase() as TipoVeiculo;

  if (!Object.keys(veiculos).includes(tipo)) {
    throw new Error("Tipo de veículo inválido");
  }

  const veiculo = veiculos[tipo];

  const kmNormal = Math.min(quilometragem, 100);
  const kmDesconto = Math.max(quilometragem - 100, 0);
  const precoDescontado = veiculo.precoPorKm * (1 - veiculo.desconto);

  const custoKmNormal = kmNormal * veiculo.precoPorKm;
  const custoKmDesconto = kmDesconto * precoDescontado;
  const custoTotal = custoKmNormal + custoKmDesconto + veiculo.taxaFixa;

  return {
    custoTotal,
    detalhe: `${kmNormal}km a R$${veiculo.precoPorKm} + ${kmDesconto}km a R$${precoDescontado} + taxa R$${veiculo.taxaFixa}`
  };
};
