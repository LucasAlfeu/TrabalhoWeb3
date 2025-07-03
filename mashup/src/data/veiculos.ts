export type TipoVeiculo = 'caminhao' | 'carreta';

export interface Veiculo {
  capacidade: number;
  precoPorKm: number;
  taxaFixa: number;
  desconto: number;
}

export const veiculos: Record<TipoVeiculo, Veiculo> = {
  caminhao: {
    capacidade: 250,
    precoPorKm: 20,
    taxaFixa: 200,
    desconto: 0.2,
  },
  carreta: {
    capacidade: 1500,
    precoPorKm: 40,
    taxaFixa: 400,
    desconto: 0.2,
  }
};
