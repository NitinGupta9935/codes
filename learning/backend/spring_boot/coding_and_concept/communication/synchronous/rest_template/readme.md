# Rest Template

* Abstract low level code like creating HttpURLConnection object etc.
* Traditional/Legacy way to call REST APIs in Spring application.

## Start the application
* mvn -f ProductService/pom.xml spring-boot:run &
  mvn -f OrderService/pom.xml spring-boot:run &

## Stop the application
* jobs
* kill %1
* kill %2

## Test API
* GET http://localhost:8082/products/2
* GET http://localhost:8081/orders/1

## Limitation of Rest Template
* In RestTemplate, there are already so many overloaded methods, so its hard to remember and maintain.
* RestTemplate was build before concepts like Retry, circuit breaker etc.. So adding support means more overloaded methods and not user friendly. 
* RestTemplate is in Maintenance mode - means no new feature, only bug fixes. 

### That’s where latest RestClient comes into the picture: 
* Introduction of Fluent, builder-style API (more readable and user friendly way of configuring and invoking the endpoint) 
* RestClient supports easy integration with interceptors, filters etc.