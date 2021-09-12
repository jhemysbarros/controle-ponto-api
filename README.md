<h1  align="center">Desafio Backend | Ília</h1>  

## Descrição do Projeto :page_facing_up:

<p  align="justify"> Desafio Backend para a empresa Ília. Criar uma Web API para controle de ponto, seguindo o contrato Open API fornecido pela empresa, que permite realizar as seguintes ações.</p> 

### Registrar os horários da jornada diária de trabalho :heavy_check_mark:

- [x] Apenas 4 horários podem ser registrados por dia.

- [x] Deve haver no mínimo 1 hora de almoço.

- [x] Sábado e domingo não são permitidos como dia de trabalho. 

## Tecnologias utilizadas :hammer_and_wrench:

- Java 11;
- Spring Boot;
- Spring Data JPA;
- H2 Database in-memory;

## Como rodar o projeto :arrow_forward:

No terminal de sua preferência clone o projeto:
```
>git clone https://github.com/jhemysbarros/controle-ponto-api.git
```
 
Abra sua IDE que comporte projeto Spring:

> Aqui foi utilizado o **Visual Studio Code**
> 
>**Outras ferramentas**: *Spring Tool Suite, , IntelliJ IDEA*

### Acessando Banco de Dados H2:
> http://localhost:8080/h2-console
>
>**JDBC URL:** jdbc:h2:mem:controleponto
> **user:** sa
> **password (sem senha):**

### Endpoint aplicação:

Para inserção de uma data, recomendo utilizar uma API Client, tais como **Postman** ou **Insomnia** 
> Registrar um ponto
> **POST** http://localhost:8080/batidas
> 
> Obs*: JSON do endpoint Postman no projeto "**Controle de Ponto API.postman_collection.json**"

### URL  Swagger UI:
>http://localhost:8080/swagger-ui/index.html