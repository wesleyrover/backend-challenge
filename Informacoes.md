# Informações


O projeto está dividido em 5 micros serviços, cada serviço com a sua responsabilidade.
- back-gatware - Seu objetivo é temos um ponto de entrada no back-end, nestes serviço poderia ter colocado ainda o actuator, se comunicando com o prometheus e grafana. Para melhorar a solução colocaria rabbitmq, caso tivesse perda de comunicação com os outros serviços. Também usei o Zuul.
- back-auth - Seu Objetivo e controle dos token da aplicação, usando o spring security, o usuários admin e client, estão fixo no código e a senha são 123456, 12345678. A senha deveria está armazenada no banco de dados e a mesma criptografada, pro questão de segurança.
- back-store - Responsável pela criação da loja.- back-payment  - Responsável pela pagamento das order- back-order -  Responsável pela criação da order da loja.


# Informações do git 

1.  Realizar o clone do projeto 
2.  Rodar o comando mvn install no projeto principal
3.  Criar o banco invillia no postgres 
4.  Atualizar o application.proprerties dos projeto  app_back_store , app_back_order,app_back_payment
5.  Na sua IDE você pode subir os projetos executando a classe principal de cada um ou acessar a pasta target do projeto via cmd e executar o comando "java -jar {jardoprojeto}"

# Subindo o projeto no Docker

1. Fazer um clone do git. 
2. Para rodar a aplicação usar o mavem install, ou acessar individualmente cada um.
3. Em cada pasta tem um dockerfile com a confirguração para subir individualmente.
4. Coloquei docker compose, onde não é necessário rodar o maven install, pois ele faz um builder na image.
5. Queria colocar para fazer o clone direto na image. após o seu termino não ficaria acumulo de lib.

# Testando o projeto no Swagger

Apos tudo configurado você podera acessar o swagger de cada projeto


Auth -> http:localhost:8080/auth/swagger-ui.html
Store -> http:localhost:8080/store/swagger-ui.html
Order -> http:localhost:8080/order/swagger-ui.html
Payment -> http:localhost:8080/payment/swagger-ui.html

Auth -> http:localhost:8884/auth/swagger-ui.html
Store -> http:localhost:8881/store/swagger-ui.html
Order -> http:localhost:8882/order/swagger-ui.html
Payment -> http:localhost:8883/payment/swagger-ui.html

# Teste

- Coloquei o alguns teste com o objetivo de intergra o ambiente, claro que poder ser melhorado.

# Item não implementado

* Asynchronous processing - Fiz um estudo e verifiquei que poderia ser aplicado na solução como eventos ou agendamento de job, para as rotina de processamento de pagamentos. 
* AWS - Só não foi configurado, mas o ajuste para colocar em Docker, poder ser colocado ma aws, com alguns pequenos ajuste.

# Database

Usei o mysql e h2 ou poderia ser qualquer outro banco de dados.

Application module spring-boot-data-jpa

| Environment variable | Configuração |
| ------ | -------|
| MYSQL_HOST | db4free.net |
| MYSQL_DATABASE |brwstore  |
| MYSQL_USERNAME |roverdb |
| MYSQL_PASSWORD |R@ver1978 |

# git 

Usei o git, fazendo um fork do projeto original.





