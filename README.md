# QuizApplication

A Quiz Management System built with Java and Spring Boot — supports quiz creation, question management, real-time score evaluation, and user sessions.

---

## Features
- Create, update, delete quizzes (title, description, time limit)
- Add questions with multiple choices and correct answer flags
- User-friendly quiz taking with per-question timer and real-time scoring
- Admin panel for managing quizzes and questions
- REST APIs for integration with frontends
- Basic authentication and role-based access (Admin / User)

---

## Tech Stack
- Java 17  
- Spring Boot  
- Spring Data JPA / Hibernate  
- MySQL (or PostgreSQL)  
- Maven  


---

## Architecture
- `com.app.controller` — REST controllers  
- `com.app.service` — Business logic  
- `com.app.repository` — JPA repositories  
- `com.app.model` — Entities  
- `com.app.dto` — DTOs  
- `com.app.config` — Configurations  
- `com.app.exception` — Exception handling  

---


### 1. Package & Class Roles
- Consistent package naming  
- Single Responsibility Principle  

### 2. Controllers / Endpoints
- REST semantics (GET/POST/PUT/DELETE)  
- Request/response DTOs (no entity leakage)  
- Input validation (`@Valid`, `@NotNull`)  
- Consistent exception mapping  

### 3. Services / Business Logic
- Thin controllers, thick services  
- Transaction boundaries  
- No repository logic in controllers  

### 4. Data Layer
- JPA/Hibernate usage  
- Parameterized queries  
- Correct entity mapping  

### 5. Models / DTOs / Entities
- Entities separated from DTOs  
- No sensitive fields exposed  
- Immutability for DTOs  

### 6. Exception Handling
- Centralized `@ControllerAdvice`  
- Consistent error schema and HTTP status codes  

### 7. Security
- Authentication (JWT/session)  
- Role-based authorization  
- Brute-force prevention  

### 8. Validation & Sanitization
- Input validation everywhere  
- XSS prevention  

### 9. Concurrency & State
- Thread-safe singletons  
- No request-scoped state in beans  

### 10. Persistence & Schema
- Flyway/Liquibase migrations  
- Normalized schema  
- Indexing for queries  

### 11. Testing
- Unit tests for services  
- Integration tests for controllers  
- Edge case coverage  

### 12. Build & Packaging
- Clean `pom.xml`  
- Executable JAR build  

### 13. Documentation
- Swagger/OpenAPI docs  
- Setup instructions  

### 14. CI/CD
- GitHub Actions build/test  
- Automated checks on PRs  

### 15. Performance & Scalability
- Pagination for large lists  
- Optimized bulk operations  
- Caching frequently accessed data  
