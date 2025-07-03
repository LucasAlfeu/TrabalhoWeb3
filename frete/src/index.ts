import express from "express";
import { graphqlHTTP } from "express-graphql";
import { schema } from "./schema/schema";
import { calcularFrete } from "./resolvers/freteResolver";

const root = { calcularFrete };

const app = express();
app.use(
  "/graphql",
  graphqlHTTP({
    schema,
    rootValue: root,
    graphiql: true
  })
);

app.listen(4000, () => {
  console.log("Servidor rodando em http://localhost:4000/graphql");
});
