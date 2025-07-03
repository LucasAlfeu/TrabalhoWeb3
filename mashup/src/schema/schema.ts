import { buildSchema } from "graphql";

const typeDefsString = `
  type Frete {
    custoTotal: Float
    detalhe: String
  }

  type ValorVendaTomateResult {
    precoCustoTomate: Float!
    custoFrete: Float!
    precoComLucro: Float!
    descontoAplicado: Float!
    precoPosDesconto: Float!
    impostosAplicados: Float!
    valorFinalVenda: Float!
    detalhesFrete: String
  }

  type Query {
    calcularFrete(quilometragem: Int!, tipoVeiculo: String!): Frete
    precoTomate(quantidadeCaixas: Int!): Float!
    valorVendaTomate(quantidadeCaixas: Int!, distanciaKm: Int!, tipoVeiculo: String!): ValorVendaTomateResult!
  }
`;

export const schema = buildSchema(typeDefsString);


