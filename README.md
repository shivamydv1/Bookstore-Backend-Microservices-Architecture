# Bookstore-Backend-Microservices-Architecture
A Java-based backend system for an online bookstore, built using Spring Boot Microservices architecture. Includes API Gateway, Eureka Discovery Server, Config Server, and services for User, Book, and Order management.

# 📚 Bookstore Backend - Microservices Architecture

This is a backend system for an online bookstore built using Java and Spring Boot, following a microservices architecture. It provides functionality for managing users, books, and orders using RESTful APIs and service discovery.

---

## 🏗️ Architecture

The project is organized into the following services:

- **User Service** - Handles user registration and profile management
- **Book Service** - Manages book inventory and details
- **Order Service** - Processes book orders for users
- **API Gateway** - Acts as the single entry point for all requests
- **Service Registry (Eureka)** - Enables dynamic service discovery and load balancing

---

## ⚙️ Tech Stack

| Technology     | Description                           |
|----------------|---------------------------------------|
| Java 17        | Programming Language                  |
| Spring Boot    | Application Framework                 |
| Spring Web     | REST APIs                             |
| Spring Data JPA| ORM for database interactions         |
| Eureka Server  | Service Registry for microservices    |
| MySQL          | Relational Database for persistence   |
| Maven          | Dependency Management & Build Tool    |
| Postman        | API Testing Tool                      |

---

## 📂 Project Structure
bookstore-backend/
├── api-gateway/ # Gateway for routing requests
├── eureka-server/ # Eureka service registry
├── user-service/ # User microservice
├── book-service/ # Book microservice
├── order-service/ # Order microservice


## 🚀 How to Run 
Start the Eureka Server
Start the API Gateway
Start each microservice
cd ../user-service && mvn spring-boot:run
cd ../book-service && mvn spring-boot:run
cd ../order-service && mvn spring-boot:run

🛠️ API Endpoints
Service	Port	Base URL
User Service	8081	/api/users
Book Service	8082	/api/books
Order Service	8083	/api/orders
API Gateway	8080	/user, /book, /order

All services are registered with Eureka and can be accessed via the API Gateway.

📌 Features
Modular microservices with loose coupling

Centralized service registry via Eureka

RESTful API design

Database connectivity with Spring Data JPA

Environment-specific properties
