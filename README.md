# Microservices exercise
This project demonstrates a small scale microservice architecture for handling product prices at Globo Mart. The project implements common microservice architectural patterns like service discovery, inter-service communication, circuit breaker, load balancing etc. Each microservice exposes its business functions via REST APIs.

Following services have been implemented:
 - Discovery service - a service registry built upon Netflix Eureka.
 - Product catalogue service - a higher level service to handle products
 - Price service - a lower level service to handle product prices.
  
![alt text](https://github.com/sskelkar/microservice-exercise/blob/master/images/service-architecture.jpg?raw=true)
## Flow
Price service exposes an endpoint to return the price for a specific product. 
Product service exposes multiple endpoints to add, delete and retrieve products. While returning product information, this service calls price service to fetch the product's price. 
## Technical specifications
### Database
Oracle database 11g has been used for persistence. 
### Build tool
All the services use Gradle for build tasks and dependency management. An elementary top level multi-project build script is also present so that simple tasks like build and test can be performed on all the services by executing a single command.
### Service discovery and load balancing
All the services register themselves on a Eureka server. If a service wants to make REST call to another service via Netflix Feign client, the Eureka server is used to get the address of a running instance of the second service. If multiple instances of a service are registered at the Eureka server, it evenly distributes all incoming calls to that service among available instances.
### Circuit breaker
Product catalogue service uses Netflix Hystrix library to handle failures while making calls to the price service. Network calls to the price service are wrapped in an implementation of [HystrixCommand]. In case, there is some problem fetching price from the price-service, a fallback method has been provided to return a default price. A timeout period of 5 seconds has been declared in the product catalogue service's bootstrap.yml file.
Because HystrixCommand instances can be used just once, a PriceCommandBuilder class based on builder design pattern has been provided to create the HystrixCommand instance on demand. 
The above two classes handle lower level logic, so they should not be accessed directly by a higher level service class. Therefore they have been declared to be package private. A PriceServiceHandler class has been provided that exposes only business specific methods. A product catalogue service class can use this PriceServiceHandler instance to communicate with price-service. 

[HystrixCommand]: <https://netflix.github.io/Hystrix/javadoc/com/netflix/hystrix/HystrixCommand.html>
