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
* we wrote SysHealthCheck where it implements HealthIndicator
* In this class we have a method public Health health()
* Here we wrote a logic if checkCode is any Non-Zero Number then system gets down 
