# DSCommerce

## Description
DSCommerce is a RESTful API built with **Spring Boot 3** for managing a simplified e-commerce ecosystem. This project implements a layered architecture (Controller-Service-Repository) and focuses on best practices for backend development.

## Key Features
- Full CRUD for product management.
- Data encapsulation using DTOs.
- H2 database integration with automated seeding.
- RESTful standards and clean architecture.

## Conceptual Data Model
<img width="755" height="424" alt="Conceptual Data Model" src="https://github.com/user-attachments/assets/d75e1a90-1f04-4e92-b48a-c64a1a6057a0" />



## How to Run

### Prerequisites
- Java 17 or higher.
- Maven 3.8+.

### Execution
1. **Clone the repository:**
   git clone https://github.com/Edu-Paz/DSCommerce.git

2. **Navigate to the directory:**
   cd DSCommerce

3. **Run the application:**
   ./mvnw spring-boot:run

The server will start at http://localhost:8080.

## Database Access
You can access the H2 Console at http://localhost:8080/h2-console to visualize the database in real-time during development.

---
**Author:** Eduardo Paz
**Education:** Systems Analysis and Development - Unisinos
