# MO - E-Commerce API for Checkout Counter
## Running APIs as Services
Locally running the Code
```bash
./mvnw spring-boot:run
```

Creating and Running the Executable JAR
```bash
$ ./mvnw clean package
$ java -jar target/<name of jar>.jar
```

## Production APIs
Getting list of available Products
```sh
GET: /api/v1/products
```

Getting list of Placed Orders
```sh
GET: /api/v1/order
```

Placing an Order
```sh
POST: /api/v1/order
```

## Admin Preparatory Production APIs
Loading Products and their Categories for Application
```sh
GET: /api/v1/products/load
```

Getting list of Categories
```sh
GET: /api/v1/category
```
