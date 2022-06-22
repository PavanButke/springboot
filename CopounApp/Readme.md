Date 22/06/22

#Concept of Actuator
* Added Dependency of Actuator
* http://localhost:8080/actuator/
* http://localhost:8080/actuator/health --> Only 1 endpoint activated
* All beans included using "*" except beans using exclude: -beans
* Use Postman for [Post] http://localhost:8080/actuator/shutdown  --> it will shutdown your running programm
* Make sure you pass empty object {} in body of postman
* Logging Level Change of "com.zensar" --> INFO to TRACE