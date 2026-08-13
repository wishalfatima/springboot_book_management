
# Book Management System

A Java Spring Boot web application for managing books, genres, and publishers through a structured MVC architecture, with CRUD operations, Thymeleaf-based web pages, JPA persistence, validation, and automated testing.

## Project Overview

This project demonstrates the development of a web-based **Book Management System** using **Spring Boot**.

The application models a small library/book management domain where users can manage:

- Books
- Genres
- Publishers

The project focuses on applying common enterprise application patterns, including:

- Model-View-Controller (MVC) architecture
- Service-layer business logic
- Repository-based data access
- CRUD operations
- Server-side web rendering with Thymeleaf
- Relational database persistence using JPA
- Input validation
- Automated testing

## Business Purpose

The system provides functionality for maintaining book-related information in a structured application.

A book is associated with a genre and publisher, allowing users to manage the relationships between these domain objects.

### Main Domain Objects

#### Book

Represents a book managed by the system.

Example information includes:

- Title
- Author
- Genre
- Publisher

#### Genre

Represents a classification/category for books.

Example information:

- Name

#### Publisher

Represents the organization or person responsible for publishing a book.

Example information includes:

- Name
- Address

## Key Features

### Book Management

- Create books
- View books
- Update books
- Delete books
- Associate books with genres
- Associate books with publishers

### Genre Management

- Create genres
- View genres
- Update genres
- Delete genres

### Publisher Management

- Create publishers
- View publishers
- Update publishers
- Delete publishers

### Web Interface

The application uses **Thymeleaf** to provide server-rendered web pages for interacting with the system.

The interface supports:

- Listing entities
- Adding records
- Updating records
- Deleting records
- Navigating between related entities

### Validation

The application includes validation for required data fields to help prevent invalid or incomplete records.

## Application Architecture

The application follows a layered **MVC architecture**:

```text
                    User
                     |
                     v
              Thymeleaf UI
                     |
                     v
               Controller
                     |
                     v
                Service
                     |
                     v
               Repository
                     |
                     v
              Relational DB
````

### Controller Layer

Handles incoming web requests and coordinates the appropriate application operations.

### Service Layer

Contains the application's business logic and separates business operations from the web and persistence layers.

### Repository Layer

Provides data-access functionality for storing and retrieving domain objects using JPA.

### Domain / Model Layer

Represents the core business entities:

* Book
* Genre
* Publisher

### View Layer

Thymeleaf templates provide the web interface used to interact with the application.

## Technology Stack

| Technology               | Purpose                                |
| ------------------------ | -------------------------------------- |
| Java                     | Backend programming language           |
| Spring Boot              | Application framework                  |
| Spring MVC               | Web application architecture           |
| Thymeleaf                | Server-side HTML rendering             |
| Spring Data JPA          | Persistence and repository abstraction |
| Hibernate                | ORM / database interaction             |
| H2 / Relational Database | Data persistence                       |
| Maven                    | Build and dependency management        |
| JUnit                    | Automated testing                      |
| Mockito                  | Unit-test mocking                      |
| PlantUML                 | System and domain modelling            |

## Project Structure

```text
springboot_book_management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       └── ...
│   │
│   └── test/
│       └── java/
│           └── ...
│
├── .gitignore
├── pom.xml
└── README.md
```

The project separates production code from test code using the standard Maven project structure.

## Data and Persistence

The application uses **JPA** to map domain objects to relational database structures.

Depending on the project configuration, a relational database such as **H2, MySQL, or PostgreSQL** can be used.

Database configuration is managed through the Spring Boot application configuration.

## Testing

The project includes a dedicated test structure under:

```text
src/test/
```

Testing is used to validate application behaviour and business logic.

The project uses:

* **JUnit** for automated testing
* **Mockito** for mocking dependencies in unit tests

## Running the Application

### Prerequisites

Make sure you have:

* Java installed
* Maven available, or use the Maven Wrapper included with the project
* A configured relational database if required by the application configuration

### Using Maven

From the project root:

```bash
mvn spring-boot:run
```

If the Maven Wrapper is available:

### Linux / macOS

```bash
./mvnw spring-boot:run
```

### Windows

```bash
mvnw.cmd spring-boot:run
```

The application can then be accessed through the configured Spring Boot port, typically:

```text
http://localhost:8080
```

## Running Tests

Run the automated tests with:

```bash
mvn test
```

Or using the Maven Wrapper:

### Linux / macOS

```bash
./mvnw test
```

### Windows

```bash
mvnw.cmd test
```

## Design and Modelling

The project also includes domain/system modelling using **PlantUML**.

The diagrams are intended to communicate:

* Domain relationships
* Application structure
* MVC responsibilities
* Relationships between the main entities

This provides a visual representation of the system in addition to the implementation.


## Business & Process Analysis Perspective

Although this is a software development project, it also demonstrates skills relevant to **Process Analyst and Business Analyst roles**.

The project involves translating a business domain into a working application by:

* Identifying business entities and their relationships
* Defining business operations and CRUD requirements
* Structuring application responsibilities across layers
* Translating business requirements into system functionality
* Modelling relationships between business objects
* Applying validation rules to business data
* Separating business logic from data-access responsibilities
* Communicating system structure through diagrams

These concepts are relevant to analysing business processes, understanding system requirements, and working with technical teams.

## Project Status

This project is an academic/learning implementation demonstrating a Spring Boot web application, CRUD functionality, database persistence, MVC architecture, testing, and domain modelling.

## Future Improvements

Potential future improvements include:

* API documentation
* Improved exception handling
* Additional integration tests
* Authentication and authorization
* Improved UI/UX
* Pagination and search functionality
* REST API endpoints
* Automated CI/CD pipeline

```



That keeps this repository focused on the actual project rather than generated/IDE files.
```
