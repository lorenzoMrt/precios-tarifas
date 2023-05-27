# Spring Boot Product API

The Spring Boot Product API is a RESTful web service that provides an endpoint for retrieving product information based on a product ID, brand ID, and date.

## Installation
1. Clone the repository.
2. Open the project in your IDE of choice.
3. Build the project using Maven.
``
mvn clean install
``
4. Run the project using Maven.
``
mvn spring-boot:run
``
5. The API will be available at http://localhost:8080/

## API Endpoints
----
After running the application, the documentation for the API will be available at http://localhost:8080/swagger-ui.html

### Error handling
If any error occurs, appropriate HTTP status code will be returned along with the error message.
- **404** (Product not found): If product is not found for the given parameters
- **400** (Invalid request): If parameters are not valid

## Configuration
----
The application can be configured by modifying the application.properties file located in the resources directory. You can customize various settings such as the server port, database configuration, or external service integration.