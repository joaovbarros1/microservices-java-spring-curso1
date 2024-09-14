# Curso de Microsserviços na prática: Implementando com Java e Spring

- Link: https://cursos.alura.com.br/course/microsservicos-implementando-java-spring

Este curso faz parte da formação "Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ" da Alura.   
Nele, foram vistos os seguintes temas:

- **Capítulo 1: Considerações Inicias**
  - Introdução à Arquitetura de Microsserviços;
  - Preparação do ambiente;
  - Estratégia de decomposição de um monolito em microsserviços.
- **Caítulos 2 e 3: Colocando a mão na massa**
  - Implementação dos microsserviços de Pagamentos e Pedidos com Java e Spring Boot (config, controller, dtos, models, repository, service, migrations, etc.);
  - Testes no Postman;
- **Capítulo 4: Serviço de descoberta**
  - Conceitos de service discovery e registry;
  - Implementação do service discovery nos serviços de pagamentos e pedidos utilizando o Eureka;
- **Capítulo 5: Gateway e Load Balancer**
  - Incluindo um Gateway como um serviço (Spring Cloud Gateway);
  - Balanceamento de carga - teste subindo várias instâncias do ms de pedidos e monitorando a porta do que estava sendo chamado.
- **Caítulo 6: Integração entre Microsserviços**
  - Utilização do Spring Feign;
  - Comunicação síncrona entre os microsserviços de pagamentos e pedidos;
  - Resiliência: circuit breaker e fallback.

Dentro do diretório "microservices-java-spring-curso1", se encontram todos os serviços de pagamentos, pedidos, gateway e server (Eureka).