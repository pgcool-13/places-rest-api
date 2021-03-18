# places-rest-api
Backend service and API for a web application that shows information about a business entry like the business' name, address and opening hours.

Objective(Task description):
You have to implement a backend service that provides the data about "places" (business entries) for the UI and offers it as a REST API to the web application. Design the API in a manner that you deem suitable for consumption for a web application with the requirements below.

Write some meaningful tests (at least one unit test and one api test. No high coverage is expected or required.)

Either write a few sentences README.md or write / generate an OpenAPI spec to advise the web application how to use your service to fulfill its requirements.

Security Layer does not need to be implemented.

Tools and technologies used:
1. Java 8 (Language)
2. Maven (Dependency management)
3. SpringBoot (Framework)
4. Lombok (Remove boilerplate code)
5. JUnit and Mockito (Unit testing)
6. Rest-assured (API testing)
7. OpenAPI (API documentation)

Steps to configure for running the project:
docker-compose build
docker-compose up

Sample Request:
* List place details by Id
GET http://localhost:8080/api/place/id/1

API documentation 
http://localhost:8080/swagger-ui.html

Note: I have implemented the code for displaying opening hours using UTC timestamp. Regarding the logic of grouping day with same opening hours, it is recommended to have this logic at front-end due to various reasons like DST, etc. Hence I have not included that logic in my code
