# inditex
Technical Test for Inditex group

This is the Technical test for inditex group. 

1 - How to execute the project :
    For executing the project this comand must be used
    - Enter the api folder: cd api
    - Execute    mvnw spring-boot:run 
2- Execute tests
   For test execution once the project has been started  in other cmd this comand must be executed:
                mvnw test

3 - Execute swagger:
       You can launch swagger in the following url : 
             http://localhost:8080/swagger-ui.html

Architecture :

The service developed has been developed in the SpringController PricesController using the following URL:
http://localhost:8080/api/price/obtenerproductos/{applicationDate}/{productId}/{brandId}

The H2 database has been preconfigured /resources/application.properties file and can be accessed with the following client:

http://localhost:8080/h2-console/
using the following parameters:
 Driver Class: org.h2.Driver
 JDBC URL: jdbc:h2:mem:testdb
 User name: sa
 Password:48514520E

 All the information on the table are filled by the following file:
 dbOperationRunner.java

 TEST:
 Unit test are executed from the folloing file: ApiApplicationTests.java


