# ports-adapters-architecture-spring-boot
<div style="text-align: center;">
![ ](https://github.com/italobrito/ports-adapters-architecture-spring-boot/blob/main/Port_and_Adapters.png)
</div>


## Resumo
Curso de pós graduação em arquitetura de software FIAP.
Projeto da primeira fase do Tech Challenge.


## Sobre o projeto
O projeto foi desenvolvido usando maven, spring boot(versão 17 do java), mysql. Para a infra, foi utilizado o 
docker, onde dois containers são levantados, um rodando o app spring boot e outro o mysql.
Foi implementada a arquitetura de "ports and adapters".
O spring security está rodando, isso significa que a autenticação deve ser feita para que os requets's funcionem.
Existe itens no roadmap, entre melhorias, bugs e afins.


## Para rodar o projeto
Baixe o projeto:

```
git clone https://github.com/italobrito/ports-adapters-architecture-spring-boot.git

```

Dentro do projeto execute:

```
mvn install

docker build -t tech-challenge

docker-compose up

```

## Documentações

DDD:
[https://miro.com/app/board/uXjVNPg5j2U=/](https://miro.com/app/board/uXjVNPg5j2U=/)

Documentação do Postman:
[https://documenter.getpostman.com/view/2856517/2s9YsM8qKD](https://documenter.getpostman.com/view/2856517/2s9YsM8qKD)

Documentação do Swagger em anexo no formato .pdf: [https://github.com/italobrito/ports-adapters-architecture-spring-boot/blob/main/API_Documentation_swagger_atualizado.pdf](https://github.com/italobrito/ports-adapters-architecture-spring-boot/blob/main/API_Documentation_swagger_atualizado.pdf)

