# 1 - Curso de Microsserviços na prática: Implementando com Java e Spring

- Link: https://cursos.alura.com.br/course/microsservicos-implementando-java-spring

## Conteúdo
Este curso faz parte da formação "Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ" da Alura.   
Nele, foram vistos os seguintes temas:

- **Capítulo 1: Considerações Inicias**
  - Introdução à Arquitetura de Microsserviços;
  - Preparação do ambiente;
  - Estratégia de decomposição de um monolito em microsserviços.
- **Caítulos 2 e 3: Colocando a mão na massa**
  - Implementação dos microsserviços de Pagamentos e Pedidos com Java e Spring Boot (config, controller, dtos, models, repository, service, migrations, banco MySQL, etc.);
  - Testes no Postman.
- **Capítulo 4: Serviço de descoberta**
  - Conceitos de service discovery e registry;
  - Implementação do service discovery nos serviços de pagamentos e pedidos utilizando o Eureka.
- **Capítulo 5: Gateway e Load Balancer**
  - Incluindo um Gateway como um serviço (Spring Cloud Gateway);
  - Balanceamento de carga - teste subindo várias instâncias do ms de pedidos e monitorando a porta do que estava sendo chamado.
- **Caítulo 6: Integração entre Microsserviços**
  - Utilização do Spring Feign;
  - Comunicação síncrona entre os microsserviços de pagamentos e pedidos;
  - Resiliência: circuit breaker e fallback.

Dentro do diretório "microservices-java-spring-curso1", se encontram todos os serviços de pagamentos, pedidos, gateway e server (Eureka).

OBS: Em anexo, temos um pdf chamado "Java e Microsservicos" com todas as anotações do curso e de cursos anteriores sobre conceitos e padrões de Microsserviços.

## Pontos importantes

- Eureka: configurado na porta 8081
- Gateway: configurado na porta 8082

## Como executar a aplicação?

- Executar os serviços:
  - server;
  - gateway;
  - pagamentos;
  - pedidos.   
  OBS: podem ser executados via IntelliJ, executando os métodos main das classes Application ou rodando o seguinte comando no terminal (Linux) de cada pasta de projeto:
  ```
  java -jar target/${nome-arquivo-jar}.jar
  ```
- Para acessar o Eureka (service discovery), digitar no navegador: 
  ```
  http://localhost:8081
  ```
- Para realizar as requisições para as APIs, utilizar o Gateway que está configuruado na porta 8082. Por exemplo: 
  ```
  http://localhost:8082/${spring.application.name}/${path}
  ```
  Exemplo:
  ```
  GET http://localhost:8082/pagamentos-ms/pagamentos
  ```

- Na pasta "requisicoes-insomnia", estão as requisições utilizando o Insomnia.

OBS: Não se esqueça de configurar as credenciais de acesso do banco de dados MySQL utilizado nos serviços de pagamentos e pedidos.


# 2 - Curso de Microsserviços na prática: IaC com CDK e deploy na AWS

- Link: https://cursos.alura.com.br/course/microsservicos-pratica-iac-cdk-deploy-aws

## Conteúdo
Este curso faz parte da formação "Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ" da Alura.   
Nele, foram vistos os seguintes temas:

- **Capítulo 1: Projeto inicial e containers**
  - Overview sobre microsserviços e Docker;
  - Utilização do banco MySQL com Docker;
  - Geração da imagem da aplicação de pedidos.
- **Caítulos 2: Partindo para a Cloud**
  - Configuração da conta na AWS;
  - Apresentação do CDK e configuração até o bootstrapping;
  - Inicialização do projeto com o CDK.
- **Capítulo 4: Completando a infra**
  - Stacks do projeto CDK e recursos;
  - Overview sobre ECS;
  - VPC;
  - Cluster;
  - Load Balancer com instância Fargate;
  - Serviços e deploy;
  - Ordem de procedência do deploy das Stacks.
- **Capítulo 5: Projeto no ar**
  - RDS - criando um MySQL a partir do RDS (no CDK, a senha foi configurada para ser passada no momento de deploy e a aplicação lia a senha via variável de ambiente);
  - Subida da aplicação para a AWS (utilizando a imagem da aplicação no ECR e o banco de dados no RDS);
  - Testes da aplicação pelo Postman.
- **Caítulo 6: Verificação e monitoramento**
  - Overview sobre Docker Hub e ECR;
  - Monitoramento na AWS através do CloudWatch (criação de log groups, etc.);
  - Técnicas de Auto Scaling na nuvem.

Dentro do diretório "microservices-java-spring-curso1", se encontram todos os serviços de pagamentos, pedidos, gateway, server (Eureka) e o projeto CDK.

## Pontos importantes

- A principal mudança do curso anterior consiste na subida do microsserviço de pedidos para a AWS e na criação de um projeto CDK para deploy dos recursos na AWS.
- Acesse o projeto CDK: <a href="https://github.com/joaovbarros1/alura-aws-infra" target="_blank">alura-aws-infra</a>.
