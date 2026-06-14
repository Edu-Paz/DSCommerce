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

## Technologies & Tools

- **Java 17 / 21**
- **Spring Boot 3.x**
  - **Spring Web** (RESTful Endpoints)
  - **Spring Data JPA** (Data Persistence & ORM)
  - **Spring Security** (Authentication & Authorization)
- **OAuth2 & JWT (JSON Web Token)** (Secure stateless session management)
- **Database Management**:
  - **H2 Database** (In-memory database used for local development and testing)
  - **PostgreSQL** (Production-ready relational database)
- **Maven** (Project management and build automation)
- **Jakarta Bean Validation** (Data input sanitization and constraints)
- **Insomnia / Postman** (API Testing and request chaining)

## Architecture & Layer Design

The system follows a strict monolithic multi-tier architecture, applying the **Separation of Concerns (SoC)** principle to decouple business logic from data access and transport layers:

- **Resource/Controller Layer**: Exposes secure REST endpoints, maps incoming HTTP requests, handles HTTP status codes, and delegates execution to the service layer.
- **Service Layer**: Houses the core business logic of the e-commerce platform (e.g., calculation of totals, order placements, custom validations). It manages transactional boundaries using `@Transactional`.
- **Repository Layer**: Interfaces extending `JpaRepository` to abstract database queries and operations through Hibernate/JPA.
- **Data Transfer Objects (DTOs)**: Used exclusively to transfer data between layers and clients, hiding database entity structures and mitigating mass-assignment security vulnerabilities.

## Security & Authorization Roles

Authentication and access control are powered by **Spring Security** using the **OAuth2** framework with **JWT** tokens. Requests are validated based on explicit access tiers:

- **Public Access**:
  - `GET /products` — Paged product listing and search.
  - `GET /products/{id}` — Fetch product details by ID.
  - `GET /categories` — List available product categories.
- **Client Access (`ROLE_CLIENT`)**:
  - `POST /oauth2/token` — User login and token generation.
  - `GET /users/me` — Retrieve the authenticated user's profile info.
  - `POST /orders` — Place a new order.
  - `GET /orders/{id}` — View order details (*restricted to the order owner or admins only*).
- **Admin Access (`ROLE_ADMIN`)**:
  - Full CRUD operations over products and database entries (`POST`, `PUT`, `DELETE /products`).

## Exception Handling

The application features a centralized **Global Exception Handler** using `@ControllerAdvice`. This ensures the API always responds with a standardized, readable JSON structure when anomalies occur, instead of breaking or leaking stack traces:

- **`404 Not Found`**: Triggered when a requested resource (Product, User, or Order) does not exist in the database.
- **`422 Unprocessable Entity`**: Returned during data payload validation failures (e.g., blank names, negative prices), yielding an explicit array of fields and their specific error validation messages.
- **`401 Unauthorized` / `403 Forbidden`**: Handled automatically when a request lacks a valid token or attempts an action above its assigned role permissions.
- **`400 Bad Request`**: Triggered by database integrity violations (e.g., trying to delete a product associated with existing orders).

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
