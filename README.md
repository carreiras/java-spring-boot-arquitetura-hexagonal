# Java Spring Boot Hexagonal Architecture

![Badge](https://img.shields.io/badge/license-MIT-green?style=for-the-badge)

## Sobre o projeto

Este é um projeto que utiliza a arquitetura hexagonal com Java e Spring Boot. O projeto também utiliza Kafka para mensageria e MongoDB para persistência de dados.

## Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- [Java](https://docs.oracle.com/en/java/): Linguagem de programação utilizada para desenvolver a lógica de negócios do projeto.
- [Spring Boot](https://spring.io/projects/spring-boot): Framework utilizado para facilitar o desenvolvimento de aplicações Java.
- [Gradle](https://gradle.org/): Ferramenta de automação de compilação utilizada para gerenciar dependências e construir o projeto.
- [Kafka](https://kafka.apache.org/documentation/): Sistema de mensageria utilizado para comunicação assíncrona entre diferentes partes do projeto.
- [MongoDB](https://docs.mongodb.com/): Banco de dados NoSQL utilizado para persistência de dados.
- [Docker](https://www.docker.com/): Plataforma utilizada para contêinerização da aplicação e suas dependências.

Para mais informações sobre cada tecnologia, consulte a documentação oficial fornecida nos links acima.

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

## Utilizando WireMock para Simulação de Serviços

Este projeto utiliza o WireMock para simular respostas de serviços externos durante o desenvolvimento e testes. O WireMock permite que você configure respostas estáticas para determinadas requisições HTTP.

Aqui estão alguns exemplos de como configurar o WireMock para responder a requisições GET para dois CEPs diferentes:

```json
{
  "request": {
    "method": "GET",
    "url": "/addresses/38400000"
  },
  "response": {
    "status": 200,
    "headers": {
      "Content-Type": "application/json"
    },
    "jsonBody": {
      "street": "Rua Hexagonal",
      "city": "Uberlândia",
      "state": "Minas Gerais"
    }
  }
}
```
   
 ```json
    {
    "request": {
        "method": "GET",
        "url": "/addresses/38401000"
    },
    "response": {
        "status": 200,
        "headers": {
        "Content-Type": "application/json"
        },
        "jsonBody": {
        "street": "Rua Circular",
        "city": "Uberlândia",
        "state": "Minas Gerais"
        }
    }
    }
```


## Utilizando Postman para Testar a API

Este projeto pode ser testado utilizando o Postman. 

Aqui está a collection do Postman que pode ser utilizado para testar este projeto:

```json
{
	"info": {
		"_postman_id": "8e92fdb3-7c4e-45fc-a60e-5803ccff362c",
		"name": "java-spring-boot-arquitetura-hexagonal",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "13175288"
	},
	"item": [
		{
			"name": "Wiremock",
			"item": [
				{
					"name": "/addresses/38400000",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8082/addresses/38400000",
							"host": [
								"localhost"
							],
							"port": "8082",
							"path": [
								"addresses",
								"38400000"
							]
						}
					},
					"response": []
				},
				{
					"name": "/addresses/38400001",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "localhost:8082/addresses/38400001",
							"host": [
								"localhost"
							],
							"port": "8082",
							"path": [
								"addresses",
								"38400001"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Customers",
			"item": [
				{
					"name": "/api/v1/customers",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Bararandir\",\r\n    \"zipCode\": \"38400000\",\r\n    \"cpf\": \"11111111111\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/v1/customers",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"v1",
								"customers"
							]
						}
					},
					"response": []
				},
				{
					"name": "/api/v1/customers/{id}",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/api/v1/customers/66bfacc3e35a313c9a1d0b94",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"v1",
								"customers",
								"66bfacc3e35a313c9a1d0b94"
							]
						}
					},
					"response": []
				},
				{
					"name": "/api/v1/customers/{id}",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\": \"Belbeyguk\",\r\n    \"zipCode\": \"38400001\",\r\n    \"cpf\": \"11111111111\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/v1/customers/66bfacc3e35a313c9a1d0b94",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"v1",
								"customers",
								"66bfacc3e35a313c9a1d0b94"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}
```

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

## Licença

Este projeto está licenciado sob a licença MIT.