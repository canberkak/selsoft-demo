## Requirements

- Java 11, Maven, Lombok, Docker

## How to use ?

- Build via:  mvn clean install

- http://localhost:8080/swagger-ui.html 



- For endpoints that required authentication you have to sign-in with existing account.
  You can create a new one with sign-up endpoint.
  

- Sign-in endpoint returns a token. In swagger.ui click Authorize button. 
  Add token as:  Bearer "TOKEN"  (without quotation marks) 