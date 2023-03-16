
# Fiap Credit Card


**Requisitos:**
- Java JDK 8
- PostgreSQL

*******
**Documentação swagger:**
- Student Controller: http://localhost:8080/swagger-ui.html#/student-controller
- Transaction Controller: http://localhost:8080/swagger-ui.html#/transaction-controller

*******

**Para rodar o projeto siga os passos abaixo:**

- Abra o arquivo application.properties
- Preencha os campos abaixo:

 ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/[database]
  spring.datasource.username=[username]
  spring.datasource.password= [password]
  ```

 - Inicialize o PostgreSQL e verifique a cricação do datavase students

 - Windows
  `./mvnw.cmd spring-boot:run`

 - Linux/Mac
   `./mvnw spring-boot:run`

- Para carregar a lista de alunos, foi utilizado Spring Batch através da leitura do arquivo lista_alunos.txt. Para iniciar o carregamento dos dados, abra o navegador e digite http://localhost:8080/alunos/runjob

 ![image](https://user-images.githubusercontent.com/114959652/225450312-579a22dc-183c-461d-a0c6-eae21b6e7e5b.png)

A lista completa de alunos estará disponível em http://localhost:8080/alunos.
Também é possível adicionar alunos individualmente, assim como consulta-los por id, conforme documentação do endpoint.


