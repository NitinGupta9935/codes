# REST endpoint just using plain java


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

# Disadvantage

### Too much Boilerplate code: 
* Open connection 
* Setting headers 
* Reading response 
* Closing streams and connections. 

### Response should be handled manually. 
* No automatic mapping to some Objects. 

### Limited support for Advance features like 
* Connection pooling 
* Interceptors etc. 