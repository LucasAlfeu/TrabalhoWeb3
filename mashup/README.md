# Mashup GraphQL

API GraphQL em TypeScript para fazer o mashup entre os dois serviços:

- Consulta Disponível:

  valorVendaTomate: Calcula o valor final de venda de um pedido de tomates,
  considerando a quantidade de caixas, a distância e o tipo de veículo para entrega.

- Parâmetros de Entrada:

  quantidadeCaixas (Int!): O número de caixas de tomate.

  distanciaKm (Int!): A distância total em quilômetros para a entrega.

  tipoVeiculo (String!): O tipo de veículo a ser utilizado para a entrega.


- Lucro Fixo:

  Aplica um +55% de lucro sobre a soma do preço de custo dos tomates e o custo do frete.

- Descontos por Volume (no valor com lucro):

  7,5% de desconto se a quantidadeCaixas for acima de 50 caixas.

  12% de desconto se a quantidadeCaixas for acima de 300 caixas.

  Nota: O desconto de 12% tem precedência sobre o de 7.5% se a condição for atendida.

- Impostos:

  Aplica +27% de impostos sobre o valor resultante após o lucro e os descontos por volume.

- Valor Final:

  O valor final é a soma do preço de custo dos tomates e frete, mais o lucro fixo (já com os descontos aplicados) e os impostos.

---

## 🚀 Tecnologias

- Node.js
- TypeScript
- Express
- GraphQL (`express-graphql`)

---

## 📦 Instalação

1. Clone o repositório:

git clone <https://github.com/LucasAlfeu/TrabalhoWeb3.git>

cd mashup

npm install

Se necessário: npm init -y

Para rodar:
npx ts-node src/index.ts

Acesse o playground do GraphQL em:
<http://localhost:4000/graphql>

Teste com as querys:

```bash
{
  valorVendaTomate(quantidadeCaixas: 60, distanciaKm: 150, tipoVeiculo: "caminhao") {
    precoCustoTomate
    custoFrete
    precoComLucro
    descontoAplicado
    impostosAplicados
    valorFinalVenda
    detalhesFrete
  }
}
```

As regras de cálculo estão de acordo com o dado no arquivo de descrição do trabalho que o sr. apresentou.
