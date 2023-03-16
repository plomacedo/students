
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

- Para gerar uma massa de transcações, foi gerado um faker dentro do TransactionController. Para carrega-la, basta entrar no navegador a quantidade de entradas desejadas na url. Por exemplo, para gerar 100 transações, digite http://localhost:8080/transactions/random/100 . Aguarde o aviso visual de criação dos dados. Também é possível a criação individual de transações, assim como a listagem por id e de todas as transações existendes, de acordo com a documentação do endpoint.

- Para exportar o relatório de transações, em seu navegador insira o id do aluno desejado na url. http://localhost:8080/transactions/{studentId}/report 
Por exemplo, http://localhost:8080/transactions/1297/report . O Download iniciará automaticamente. (OBS: O Faker cria transações para alunos randomicamente, portanto certifique-se de utilizasr um id de aluno que possui transações criadas. 
