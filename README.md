## API para Notificar Usando o E-Carta

Nest projeto iremos simular os seguintes procedimentos:

- Disponibiliza os processos que serão notificados através do E-Carta pelo método GET de uma API REST;
- Serão disponibilizados no mínimo 10 processos para o envio; 
- Usaremos o método PUT para atualizar as processos que foram notificadas; 
- Será consultada a API ViaCEP para atualizar as informações de endereço das partes no banco através do CEP;

<hr>

Para iniciar este projeto, foi utilizado o [spring initializr](https://start.spring.io/) utilizando as seguintes opções:

![image](spring.png)

<hr>

Foi utilizado também os seguintes recursos:
* NetBeans IDE 18;
* JDK 20;
* PostgreSQL 15.4;

<hr>

Foi utilizado os seguintes Endpoints:

```
GET - processos/ecarta
GET - processos/ecarta/id
PUT - processos/ecarta
```
<hr>

Utilização do método GET

![image](get.png)

<hr>

Utilização do método PUT

![image](put.png)

<hr>
