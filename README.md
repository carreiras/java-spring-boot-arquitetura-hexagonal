# Java Spring Boot Hexagonal Architecture

Este é um projeto que utiliza a arquitetura hexagonal com Java e Spring Boot. O projeto também utiliza Kafka para mensageria e MongoDB para persistência de dados.

## Pré-requisitos

- Java 11
- Docker e Docker Compose
- Gradle

## Instalação

1. Clone o repositório para o seu computador.
2. Navegue até o diretório do projeto.
3. Execute o comando `gradle build` para compilar o projeto.
4. Execute o comando `docker-compose up -d` para iniciar os serviços do Kafka e MongoDB.

## Uso

Após a instalação, você pode iniciar a aplicação executando o comando `gradle bootRun`.


## Produzindo Mensagens para o Kafka

Este projeto utiliza um formato específico de JSON para produzir mensagens no tópico do Kafka chamado "tp-cpf-validated". Aqui está um exemplo do formato JSON:

```json
{
   "id": "string",
   "name": "string",
   "zipCode": "string",
   "cpf": "string",
   "isValidCpf": boolean
}
```
Cada campo no JSON tem um propósito específico:

- id: Uma string que representa o identificador único do usuário. Este é um campo obrigatório e deve ser único para cada usuário.
name: Uma string que representa o nome do usuário. Este é um campo obrigatório.
- zipCode: Uma string que representa o CEP do usuário. Este é um campo obrigatório.
- cpf: Uma string que representa o CPF do usuário. Este é um campo obrigatório e deve seguir o formato padrão de CPF.
- isValidCpf: Um valor booleano que indica se o CPF do usuário é válido ou não. Este é um campo obrigatório e deve ser true se o CPF for válido e false se não for.


## Documentação

Para mais informações, consulte a documentação oficial dos seguintes recursos utilizados neste projeto:

- [Java](https://docs.oracle.com/en/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Kafka](https://kafka.apache.org/documentation/)
- [MongoDB](https://docs.mongodb.com/)

## Contribuição

Se você deseja contribuir para este projeto, por favor, siga as diretrizes de contribuição fornecidas.

## Licença

Este projeto está licenciado sob a licença MIT.