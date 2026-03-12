# Book Management System

## Project Overview
This project is a **Book Management System** built using **Spring Boot** with **Thymeleaf templates** for the web user interface and a relational database (H2, MySQL, or PostgreSQL) connected via **JPA**.  

The application allows users to **manage books, genres, and publishers**, providing full CRUD (Create, Read, Update, Delete) functionality for each domain model.

---

## Domain Model

### Book (Entity)
- **Properties:** Title, Author  
- **Relationships:** Genre, Publisher  

### Genre (Value Object)
- **Properties:** Name  

### Publisher (Entity)
- **Properties:** Name, Address  

---

## Features

- **CRUD Operations** for Books, Genres, and Publishers in all layers (domain, service, database)  
- **User Interface** to add, update, delete, and list entities using **Thymeleaf templates**  
- Proper **validation** for required fields  
- **Navigation** between entities in the UI  
- Graceful handling of **null values** in the UI (e.g., showing “None” if a field is empty)  
- **MVC architecture**: controllers, service layers, and repositories for proper layering and business logic  
- **Relational Database Support:** H2 (in-memory or file), MySQL, PostgreSQL  
- **Testing:** Unit tests using **JUnit** and **Mockito** for CRUD operations  
- **Modeling:** Class diagrams in **PlantUML** to visualize the domain and MVC roles  

---

## Technology Stack

- **Backend:** Java, Spring Boot  
- **UI:** Thymeleaf Templates  
- **Database:** H2 / MySQL / PostgreSQL via JPA  
- **Testing:** JUnit, Mockito  
- **Modeling:** PlantUML  

---
## Folder Structure (Example)


BookManagementSystem/
├─ src/
│ ├─ main/
│ │ ├─ java/com/example/bookmanagement/
│ │ │ ├─ controller/
│ │ │ ├─ service/
│ │ │ ├─ domain/
│ │ │ └─ repository/
│ │ └─ resources/
│ │ ├─ templates/ # Thymeleaf UI templates
│ │ └─ application.properties
├─ test/
│ └─ java/... # Unit tests
├─ pom.xml
└─ README.md

Configure the database connection in application.properties or application.yml

Run the Spring Boot application:
mvn spring-boot:run

Access the application in a browser at:
http://localhost:8080

Use the UI to add, update, delete, and list books, genres, and publishers.

Testing
Run JUnit tests to validate CRUD operations and business logic
Use Mockito for mocking dependencies in unit tests
