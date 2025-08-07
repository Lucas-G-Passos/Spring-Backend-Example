# Exemplo de crud básico em java

### Uso:
```
Adiciona uma nova comida

curl -X POST \\
  http://127.0.0.1:8080/food/add \\
  -H "Content-Type: application/json" \\
  -d '{"name":"CheeseBurger","healthy":false}'

Pega a comida com id = 1

curl -X GET \\
  http://127.0.0.1:8080/food/1

Atualiza a comida com id = 1

curl -X PUT \\
  http://127.0.0.1:8080/food/update/1 \\
  -H "Content-Type: application/json" \\
  -d '{"name":"BeeseChurger","healthy":true}'

Deleta a comida com id = 1

curl -X DELETE \\
  http://127.0.0.1:8080/food/1 
```

##### Créditos: [Tutorial por Alexander Obregon](https://medium.com/@AlexanderObregon/connecting-spring-boot-applications-to-mysql-databases-ea025e4b5f19)
