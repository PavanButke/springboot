Date 22/06/22

#Concept of Actuator
* Added Dependency of Actuator
* http://localhost:8080/actuator/
* http://localhost:8080/actuator/health --> Only 1 endpoint activated
* All beans included using "*" except beans using exclude: -beans
* Use Postman for [Post] http://localhost:8080/actuator/shutdown  --> it will shutdown your running programm
* Make sure you pass empty object {} in body of postman
* Logging Level Change of "com.zensar" --> INFO to TRACE
* checked http://localhost:8080/actuator/configprops --> fetches all Configuration Properties beans
* checked http://localhost:8080/actuator/env --> gives propertied in current env
* checked http://localhost:8080/actuator/caches --> which was empty
* checked http://localhost:8080/actuator/metrics
* checked http://localhost:8080/actuator/scheduledtasks 
*  New Class SysHealthCheck created to override an health endpoint
* Initially health endpoint shows status -"UP" as everything in project is going well
* we wrote SysHealthCheck where it implements AbstractHealthIndicator
* Here we wrote a logic if number is  Zero Number then system gets down 
* We are generating random numbers from 0-2
* implemented base-path and changed actuator path to http://localhost:8080/javaactuator/
* Coded new class InfoImpmntr which implements InfoContributor interface
* We can configure http://localhost:8080/javaactuator/info w/o writing into application.yml
* Created an  class CopounEndpoint to illustrate workings of Custom Actuator Operations such as @ReadOperation @WriteOperation @DeleteOperation 
copoun-endpoint:

[GET] http://localhost:8080/javaactuator/copoun-endpoint/     --> Returns all copouns
[GET] http://localhost:8080/javaactuator/copoun-endpoint/{code} --> Returns copoun based on code
[Post] http://localhost:8080/javaactuator/copoun-endpoint/{code}/{sentence1}, {sentence2}
eg. http://localhost:8080/javaactuator/copoun-endpoint/Go100/Oohoo! , You wanna Rs.100 off on Your next Purchase
[DELETE] http://localhost:8080/javaactuator/copoun-endpoint/{code}

* All Endpoint Tested