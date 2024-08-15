
# NextSkill Academy REST API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-blue?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-lightgrey?style=for-the-badge)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## Description

NextSkill Academy REST API is a backend application for the NextSkill Academy built using Java Spring Boot. This API provides functionality to manage users, courses, enrollments, lessons, and lesson completions.

## How to Run

To run this application, clone the repository, navigate to the project directory, and execute the following commands:

```bash
mvn clean install
mvn spring-boot:run
```

You can also test the API using Postman with this [Postman Collection](https://www.postman.com/enigma-amal/workspace/sandbox/collection/14513514-7ad17ae7-010e-4de8-b015-abe37ea75809?action=share&creator=14513514&active-environment=14513514-f06e516f-e9f7-4b26-8c12-8a81515f17df).

## Base URL

`http://localhost:8080`

## Routes

### Users

| Path             | Method   | Description                      |
|------------------|----------|----------------------------------|
| `/api/v1/users`  | `POST`   | Create a new user                |
| `/api/v1/users`  | `GET`    | Retrieve all users               |
| `/api/v1/users/{id}` | `GET`    | Retrieve user by ID             |
| `/api/v1/users/{id}` | `PUT`    | Update user by ID               |
| `/api/v1/users/{id}` | `DELETE` | Delete user by ID               |

### Courses

| Path              | Method   | Description                      |
|-------------------|----------|----------------------------------|
| `/api/v1/courses` | `POST`   | Create a new course              |
| `/api/v1/courses` | `GET`    | Retrieve all courses             |
| `/api/v1/courses/{id}` | `GET`    | Retrieve course by ID            |
| `/api/v1/courses/{id}` | `PUT`    | Update course by ID              |
| `/api/v1/courses/{id}` | `DELETE` | Delete course by ID              |

### Enrollments

| Path                   | Method   | Description                      |
|------------------------|----------|----------------------------------|
| `/api/v1/enrollments`  | `POST`   | Create a new enrollment          |
| `/api/v1/enrollments`  | `GET`    | Retrieve all enrollments         |
| `/api/v1/enrollments/{id}` | `GET`    | Retrieve enrollment by ID         |
| `/api/v1/enrollments/{id}/progress` | `PUT`    | Update enrollment progress by ID |

### Lessons

| Path               | Method   | Description                      |
|--------------------|----------|----------------------------------|
| `/api/v1/lessons`  | `POST`   | Create a new lesson              |
| `/api/v1/lessons`  | `GET`    | Retrieve all lessons             |
| `/api/v1/lessons/{id}` | `GET`    | Retrieve lesson by ID             |
| `/api/v1/lessons/{id}` | `PUT`    | Update lesson by ID               |
| `/api/v1/lessons/{id}` | `DELETE` | Delete lesson by ID               |

### Lesson Completions

| Path                          | Method   | Description                       |
|-------------------------------|----------|-----------------------------------|
| `/api/v1/lesson-completions`  | `POST`   | Create a new lesson completion    |
| `/api/v1/lesson-completions`  | `GET`    | Retrieve all lesson completions   |
| `/api/v1/lesson-completions/{id}` | `GET`    | Retrieve lesson completion by ID  |
| `/api/v1/lesson-completions/{id}/completed` | `PUT` | Update lesson completion status   |