# order

Biblioteca de contrato do microsserviço Order: DTOs e interface HTTP/Feign compartilhados
entre o gateway/consumidores e o `order-service`.

## Criar pedido

`POST /orders` recebe uma lista não vazia de produtos e quantidades. O serviço obtém o
proprietário do header `id-account` encaminhado pelo gateway, consulta cada produto no
Product e calcula os valores com `BigDecimal`.

```json
{
  "items": [
    { "productId": "produto-1", "quantity": 2 }
  ]
}
```

Uma resposta `201 Created` contém o pedido salvo e os snapshots de preço usados no cálculo:

```json
{
  "id": "uuid",
  "accountId": "uuid-da-conta",
  "total": 39.98,
  "createdAt": "2026-11-19T16:30:00Z",
  "items": [
    {
      "productId": "produto-1",
      "name": "Produto",
      "quantity": 2,
      "unitPrice": 19.99,
      "subtotal": 39.98
    }
  ]
}
```

O serviço rejeita itens sem produto, quantidade não positiva e chamadas sem `id-account`.
Produtos inexistentes resultam em `404`; falhas de comunicação com Product resultam em `503`.

```bash
./mvnw clean verify
```
