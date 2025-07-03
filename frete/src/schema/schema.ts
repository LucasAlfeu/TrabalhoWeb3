import { buildSchema } from "graphql";

export const schema = buildSchema(`
  type Frete {
    custoTotal: Float
    detalhe: String
  }

  type Query {
    calcularFrete(quilometragem: Int!, tipoVeiculo: String!): Frete
  }
`);
