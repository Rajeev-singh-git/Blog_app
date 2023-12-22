# Blog App with Spring Boot

A simple blog application developed using the Spring Boot framework.

## Getting Started

1. Clone the repository.
2. Configure the application properties for database connectivity (`application.properties` or `application.yml`).
3. Build and run the application.

## Steps to work with Postman

1. Send a POST request to "http://localhost:9090/api/auth/login/" with your username and password in JSON format.

   Example:

   ```json
   {
     "username": "your_email@example.com",
     "password": "your_password"
   }
   ```

You will get token
Add that token in postman, in the header section of any request you want to hit.

Key : Authorization

Value : Bearer then single space followed by the token.

## To Do :->

We are providing role to the user manually in DB, needs to changed.

- Implement a dynamic role assignment system instead of manually assigning roles in the database.

2 roles are there currently -> ADMIN, NORMAL

- Restrict the delete functionality to users with the ADMIN role.

Currently all Create user and all GET request are public, no authentication required. We can change this in future.

- Enhance security by requiring authentication for create user and certain GET requests.

We are saving encrypted password in the DB manually, needs to change this also in future.

- Improve password handling by implementing a secure password storage mechanism.

## API Documentation

http://localhost:9090/swagger-ui/index.html#
