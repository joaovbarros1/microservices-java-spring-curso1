# 1 - Curso de Microsserviços na prática: Implementando com Java e Spring

- Link: https://cursos.alura.com.br/course/microsservicos-implementando-java-spring

## Conteúdo
Este curso faz parte da formação <a href="https://www.alura.com.br/formacao-java-microsservicos" target="_blank">Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ</a> da Alura.   
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
- **Capítulo 6: Integração entre Microsserviços**
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
Este curso faz parte da formação <a href="https://www.alura.com.br/formacao-java-microsservicos" target="_blank">Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ</a> da Alura.   
Nele, foram vistos os seguintes temas:

- **Capítulo 1: Projeto inicial e containers**
  - Overview sobre microsserviços e Docker;
  - Utilização do banco MySQL com Docker;
  - Geração da imagem da aplicação de pedidos (Dockerfile).
- **Caítulos 2: Partindo para a Cloud**
  - Configuração da conta na AWS;
  - Apresentação do CDK e configuração até o bootstrapping;
  - Inicialização do projeto com o CDK.
- **Capítulo 3: Completando a infra**
  - Stacks do projeto CDK e recursos;
  - Overview sobre ECS;
  - VPC;
  - Cluster;
  - Load Balancer com instância Fargate;
  - Serviços e deploy;
  - Ordem de procedência do deploy das Stacks.
- **Capítulo 4: Projeto no ar**
  - RDS - criando um MySQL a partir do RDS (no CDK, a senha foi configurada para ser passada no momento de deploy e a aplicação lia a senha via variável de ambiente);
  - Subida da aplicação para a AWS (utilizando a imagem da aplicação no ECR e o banco de dados no RDS);
  - Testes da aplicação pelo Postman.
- **Capítulo 5: Verificação e monitoramento**
  - Overview sobre Docker Hub e ECR;
  - Monitoramento na AWS através do CloudWatch (criação de log groups, etc.);
  - Técnicas de Auto Scaling na nuvem.

Dentro do diretório "microservices-java-spring-curso1", se encontram todos os serviços de pagamentos, pedidos, gateway, server (Eureka) e o projeto CDK.

## Pontos importantes

- A principal mudança do curso anterior consiste na subida do microsserviço de pedidos para a AWS e na criação de um projeto CDK para deploy dos recursos na AWS.
- Acesse o projeto CDK: <a href="https://github.com/joaovbarros1/alura-aws-infra" target="_blank">alura-aws-infra</a>.

# 3 - Curso de Microsserviços na prática: mensageria com RabbitMQ

- Link: https://cursos.alura.com.br/course/microsservicos-pratica-mensageria-rabbitmq

## Conteúdo
Este curso faz parte da formação <a href="https://www.alura.com.br/formacao-java-microsservicos" target="_blank">Aprofunde em Java com arquitetura de Microsserviços, Spring e RabbitMQ</a> da Alura.   
Nele, foram vistos os seguintes temas:

- **Capítulo 1: Requisições assíncronas**
  - Overview sobre microsserviços e mensageria (broker, filas, exchanges, etc.);
  - Por que utilizar mensageria?;
  - Protocolos de comunicação em mensageria (foco no AMQP);
  - Overview sobre os tipos de exchanges;
  - Preparação do ambiente para utilização do RabbitMQ (Dockerfile, interface do RabbitMQ, etc.).
- **Caítulos 2: Padrão Pub/Sub**
  - Configuração do projeto de pagamentos para utilizar o Spring AMQP (dependência, properties, classe para criar a fila, RabbitAdmin, etc.);
  - Publicação de mensagens na fila criada quando um pagamento era criado (visualização via interface do RabbitMQ) através do RabbitTemplate;
  - Consumo das mensagens publicadas na fila (configuração da aplicação de pedidos para realizar esse procedimento - utilizando o RabbitListerner e Jackson2JsonMessageConverter - para mandar um json inteiro para a fila).
- **Capítulo 3: Aprimorando as mensagens**
  - Aprofundando no uso do Jackson2JsonMessageConverter para envio e consumo de mensagens em formato json;
  - Tipos e uso de exchanges (sem ser a default do RabbitMQ utilizada até então);
  - Novo microsserviço de avaliação disponibilizado para trabalhar com exchanges (situação: pagamento aprovado - mensagem para a fila de pedidos e para a de avaliação);
  - Para não precisar alterar o de pagamentos e especificar as duas filas em que a mensagem deve ser enviada, utilizou-se a exchange do tipo Fanout (que insere a mensagem em todas as filas que possuírem um binding com ela);
  - Uso do <a href="https://tryrabbitmq.com/" target="_blank">RabbitMQ Simulator</a> para verificar o comportamento de exchanges (direct, fanout (foco), etc.);
  - Retirada da criação de filas do ms de pagamentos, sendo que os ms de pedidos e avaliacao é que criarão as filas. O de pagamentos agora passa a criar uma exchange;
  - Alteração nos ms de pedidos e avaliacao para criar as filas, exchange e os bindings de associação das filas com a exchange fanout (vínculo entre filas e exchange);
  - Publicação de mensagens ao criar um pagamento e consumo pelos ms de pedidos a avaliacao com sucesso.
- **Capítulo 4: Falhas e resiliência**
  - Apresentação de possíveis cenários de falhas (se um pagamento tiver um ID 0000, lança uma exceção no ms de avaliacao) - a aplicação de avaliacao entra em looping ao consumir uma mensagem com esse id e fica tentando processar;
  - Mensagens com esse id ficam "presas" no RabbitMQ;
  - Primeira ação: application.properties - propriedades para setar um número máximo de tentativas de consumo da mensagem (evita o looping) e até inserir um multiplicador de tempo para provocar um delay no consumo dessas mensagens;
  - Cenário problemático: a mensagem foi perdida e só conseguimos visualizar esse fato através de logs;
  - Para correção, foram apresentados os conceitos de DLQ e DLX e foram criadas essa DLQ e DLX no ms de avaliacao para ilustração (explicação do parâmetro Dead letter exchange na criação da fila da aplicação de avaliacao);
  - Exemplificação da mensagem sendo enviada para a DLQ e apresentação de cenários do que poderia ser feito com essa mensagem na DLQ;
  - Apresentação do plugin shovel do rabbitMQ para conseguir dar o move da mensagem entre filas.
- **Capítulo 5: Alta disponibilidade**
  - Overview sobre a importância de se ter várias instâncias do rabbitMQ para que se evite a perda de mensagens;
  - Utilização do rabbitmqctl para exemplificação de criação de clusters de rabbitMQ (criação de uma rede no docker, criação de vários containers de rabbitMQ, união dos 3 containers em um único cluster utilizando operações do rabbitmqctl, etc.);
  - Criação de police no rabbitMQ para que as mensagens sejam replicadas em todos os nós do cluster (todas as filas das instâncias do rabbitMQ). Dessa forma, quando paro um container, não perco a mensagem, ela se replica em outro container.

Dentro do diretório "microservices-java-spring-curso1", se encontram todos os serviços de pagamentos, pedidos, avaliacao, gateway, server (Eureka) e o projeto CDK.
