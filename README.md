# Student Registration Application  
(Spring Boot + MySQL + Docker )

## Overview

This is a simple **two-tier web application** built using **Spring Boot** and **MySQL**.  
The application allows a user to enter a **student name from a web browser** and store it in a **MySQL database**.

The application is fully **Dockerized** using **Docker**, so both the backend application and database can be started together.

---

## Architecture

Browser (HTML/CSS + Thymeleaf)  
↓  
Spring Boot Application  
↓  
MySQL Database  

---

## Tech Stack

- Java 17  
- Spring Boot 3.x  
- Spring MVC  
- Spring Data JPA  
- Thymeleaf  
- MySQL 8  
- Maven  
- Docker  
- Docker Compose  

---

## Project Structure
```bash
student-app
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── src
└── main
├── java
│ └── com/example/studentapp
│ ├── StudentAppApplication.java
│ ├── controller
│ │ └── StudentController.java
│ ├── entity
│ │ └── Student.java
│ └── repository
│ └── StudentRepository.java
└── resources
├── templates
│ └── student.html
└── application.properties
```

---

## Application Configuration

### application.properties

The application uses **environment variables** for database configuration.

```bash
spring.datasource.url=jdbc:mysql://mysql:3306/${stu_db}
spring.datasource.username=${db_user}
spring.datasource.password=${db_password}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
server.port=8000
server.address=0.0.0.0
```

> `stud_db`, `db_user`, and `DB_PASSWORD`  
> are **user-defined environment variables**.

---

## Docker Setup

### Docker Compose Services

- **mysql**
  - Runs MySQL 8
  - Creates database automatically
  - Persists data using Docker volumes

- **app**
  - Spring Boot application
  - Connects to MySQL using environment variables
  - Exposes port 8080

---

## How to Run the Application

### Prerequisites

- Docker
- Docker Compose

---

### Run Using Docker Compose
`docker-compose up -d`

---

## Access the Application

Open browser and visit:

`https://serverip:8080`

---

## Database Details (Docker)

| Property | Value |
|--------|------|
| Database Name | studentdb |
| Username | root |
| Password | yourpassword |
| Port | 3306 |

---

## Verify Data in Database
`docker exec -it student-mysql mysql -uroot -ppassword`

`USE studentdb;
SELECT * FROM student;`


---

## Application Flow

1. User opens the web page
2. Enters student name
3. Form sends POST request to controller
4. Controller saves data using JPA repository
5. Hibernate inserts data into MySQL
6. Success message is displayed on UI

---

## Features

- Clean and responsive UI
- Spring MVC architecture
- JPA-based database interaction
- Dockerized environment
- Environment-variable-based configuration
- Persistent MySQL storage

---

## Best Practices Used

- Environment variables for configuration
- No hardcoded database credentials
- Proper package structure
- Docker Compose for multi-container setup
- Hibernate auto table management

---

## Future Enhancements

- View all students
- REST API support
- Validation and exception handling
- Spring Security
- Pagination and search
- Cloud deployment

---

## Author

Pushkraj Katkar  
Java / DevOps Engineer  

---

## License

This project is for learning and educational purposes.






