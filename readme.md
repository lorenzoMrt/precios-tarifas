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

### Get Product By ID, brand ID and Date
- Endpoint: /products?productId={productId}&brandId={brandId}&date={date}
- Method: GET
- Description: Retrieves the product information for the given product ID, brand ID, and date.
- Response:
    - Status Code: 200
    - Body: Product information
- Sample request:
    ```
    curl 'http://localhost:8080/products?productId=35455&brandId=1&date=2020-06-14-10.00.00'
    ```
- Sample response:
    - Status Code: 200
    - Body: 
    ```
    {
        "productId": 35455,
        "brandId": 1,
        "priceList": 1,
        "startDate": "2020-06-14-00.00.00",
        "endDate": "2020-12-31-23.59.59",
        "price": 35.5
    }
    ```
## Error handling
If any error occurs, appropriate HTTP status code will be returned along with the error message.
- **404** (Product not found): If product is not found for the given parameters
- **400** (Invalid request): If parameters are not valid