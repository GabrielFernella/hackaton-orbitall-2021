![Projeto Customers](http://revistapress.com.br/wp-content/uploads/2018/12/Sem-t%C3%ADtulo19.png)

By [Stefanini](https://stefanini.com/).

# Projeto Customers
O projeto Customers é um exemplo de como desenvolver uma API na plataforma Java, inicialmente este projeto está usando
[Spring Boot](https://projects.spring.io/spring-boot/) e [H2 Database Engine](http://www.h2database.com/html/main.html).

## Executando
Antes de tudo, cheque se você tem [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
e [Maven](https://maven.apache.org/) instalado. Depois basta clonar o projeto localmente,
instalar as dependências e por fim, inicializar o projeto.

```sh
git clone git@github.com:leandrocapuano/hackaton-orbitall-2021.git
cd hackaton-orbitall-2021/java/customers
npm install
mvn clean install
mvn spring-boot:run
```

Sua aplicação deve ser executada como [localhost:8080/customers](http://localhost:8080/customers).

## H2 Database Engine
Este projeto contém [H2 Database Engine](http://www.h2database.com/html/main.html), voce deve abrir via browser:

```browser
http://localhost:8080/h2-console/
```

Sobre a configuração do [H2 Database Engine](http://www.h2database.com/html/main.html), você deve colocar os dados abaixo
 e avante pra cima:

```browser
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:customer-database
User Name: sa
Password: password
```

## Issues
Se você encontrar algum tipo de bug ou erro sobre este projeto, por fafor, nos diga:

https://github.com/leandrocapuano/hackaton-orbitall-2021/issues

## Colaboradores
* Leandro Ferreira Machado Capuano (https://github.com/leandrocapuano)

## Licença
MIT License. Copyright 2021 Stefanini https://stefanini.com/
