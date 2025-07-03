# Frete GraphQL

API GraphQL em TypeScript para cálculo de frete com base em:

- Tipo de veículo (`caminhao` ou `carreta`)
- Quilometragem
- Regras de desconto (após 100km)
- Taxa fixa

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

cd frete

npm install

Se necessário: npm init -y

Para rodar:
npx ts-node src/index.ts

Acesse o playground do GraphQL em:
<http://localhost:4000/graphql>

Teste com as querys:

```bash
{
  calcularFrete(quilometragem: 120, tipoVeiculo: "carreta") {
    custoTotal
    detalhe
  }
}
{
  calcularFrete(quilometragem: 150, tipoVeiculo: "caminhao") {
    custoTotal
    detalhe
  }
}
```

As regras de cálculo estão de acordo com o dado no arquivo de descrição do trablho que o sr. apresentou.
