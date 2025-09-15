# Employee Spring Boot CRUD API

This is a simple Spring Boot 3.x project using Spring Data JPA and H2 in-memory database.
Run with Java 17 / Maven.

## Endpoints
- `GET /api/employees` - list all employees
- `GET /api/employees/{id}` - get employee by id
- `POST /api/employees` - create employee (JSON body)
- `PUT /api/employees/{id}` - update employee
- `DELETE /api/employees/{id}` - delete employee

H2 console: `/h2-console` (JDBC URL: `jdbc:h2:mem:employeedb`)

