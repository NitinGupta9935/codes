REST endpoint just using plain java

cd ProductService && mvn spring-boot:run

* Start the application
  * mvn -f ProductService/pom.xml spring-boot:run &
mvn -f OrderService/pom.xml spring-boot:run &

* Stop the application
jobs
  * kill %1
  * kill %2

* Test API 
  * GET http://localhost:8082/products/2
  * GET http://localhost:8081/orders/1