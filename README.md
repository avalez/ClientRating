# ClientRating
## Microservices minimal proof of concept

This sample application is meant to demonstrate the development of a Java EE based Microservices application. For that purpose a very minimalistic application is created for demonstrating the scenario of a number of services cooperating in order to calculate a banking customer's rating for the purpose of risk assessment. 

The application is composed of four services. Customer service is the service initiating the call, asking for the rating of all customers in the system. It exposes a REST endpoint, returning the result in plain text. Business logic performs a JPA query to retrieve all customers and performs a REST call to RatingService to retrieve the customer rating. 

RatingService initially performs a REST call to BlacklistService to verify that the customer has not been blacklisted. The latter performs a JPA query to its own database and returns the status for the customers who are stored there (a subset of the customers requested). Then a call to FinancialRecordsService is performed in order to retrieve the customer's financial history rating from a public authority. A stub is used in the example application to represent this remote call. 

Configuration of the REST endpoints for each service TBD.

## Requirements
TBD

## Usage
* gradle -a bootRun

* gradle bootRepackage
* cf push blacklist-service -p BlacklistService/build/libs/blacklist-service.jar
* cf create-user-provided-service blacklist-service -r https://blacklist-service.cfapps.io/
* cf update-user-provided-service -p '{"uri": "http://blacklist-service.cfapps.io/"}' blacklist-service
* cf push rating-service -p RatingService/build/libs/rating-service.jar

* http://blacklist-service.cfapps.io/blacklist/1
* http://rating-service.cfapps.io/rating/1