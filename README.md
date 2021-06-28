# Assessment
#Technology:
java 8
maven 3
jsp
spring-boot

# For Testing
 Postman

# How to run the application
mvn clean install
mvn spring-boot:run

#endpoint to access:
Post:http://localhost:8082/assessment/api/v1/agents
Request:
{
    "firstName":"Bruce",
    "lastName":"Banner",
    "idNumber":"1011125190081",
    "teamName":"DC"
}
Get: http://localhost:8082/assessment/api/v1/agents

Get:http://localhost:8082/assessment/api/v1/agents/{id}

Post: http://localhost:8082/assessment/api/v1/teams
Request:
{
    "name":"DC"
    
}

Get:http://localhost:8082/assessment/api/v1/teams/{id}
Post:http://localhost:8082/assessment/api/v1/managers
Request:
{
    "firstName":"May",
    "lastName":"Maile",
    "idNumber":"8001125190081",
    "teamName":"DC"
}

#Database
h2-console
#url:

http://localhost:8082/assessment/h2-console

Please enter below details after access the h2-console db

JDBC URL:jdbc:h2:file:~/assessment_db
username:sa
password:

