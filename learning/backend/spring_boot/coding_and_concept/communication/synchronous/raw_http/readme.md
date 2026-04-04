REST endpoint just using plain java

cd ProductService && mvn spring-boot:run

* Start the application
mvn -f ProductService/pom.xml spring-boot:run &
mvn -f OrderService/pom.xml spring-boot:run &

* Stop the application
jobs
kill %1
kill %2