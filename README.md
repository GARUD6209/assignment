# Assignment

A **Spring Boot** application with an **H2 in-memory database** for simplified testing and development.

---

## Environment Requirements

- **JDK Version:** 21  
  - Verify installation using:  
    ```bash
    java --version
    ```
- **Build Tool:** Maven  
  - Verify installation using:  
    ```bash
    mvn --version
    ```
- **Spring Boot Version:** 3.1+  

---

## How to Run the Project

### Prerequisites  
Ensure the following are installed:
1. **JDK 21**  
2. **Maven**  

### Steps to Run:
1. Clone the repository:
    ```bash
    git clone <repository-url>
    cd <project-directory>
    ```
2. Build the project using Maven:
    ```bash
    mvn clean install
    ```
3. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```
4. Access the H2 database console at:  
   [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---
## Run in docker 
  ```bash
    docker compose up
  ```
   

## Default Credentials

| **Property**      | **Value**           |
|--------------------|---------------------|
| JDBC URL          | `jdbc:h2:mem:test` |
| Username          | `sa`                |
| Password          | *(empty)*           |

---

## Default Credentials for signin for student

| **Property**      | **Value**           |
|--------------------|---------------------|
| Username          | student               |
| Password          | studentPass           |

---

## Default Credentials for signin for admin

| **Property**      | **Value**           |
|--------------------|---------------------|
| Username          | admin              |
| Password          | adminPass           |

---

## Tech Stack

- **Java 21**  
- **Spring Boot 3.1+**  
- **Maven**  
- **H2 In-Memory Database**  

---

## Postman api documentation

https://replitteam.postman.co/workspace/assignment~0b91f55c-51af-4317-8828-860046595dc5/collection/31891362-071ad25e-2f9a-469b-832e-a5c1903afb5c?action=share&creator=31891362


---
