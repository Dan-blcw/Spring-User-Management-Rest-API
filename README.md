## Demo User Management Rest API, Restful API Security, validation

## Target for this test
- The purpose is to test for user management, how mini spring security configuration works, swagger API and some basic CRUD functionality for user management

## Prerequisites

- JDK 19
- Maven
- MariaDB

## Set request body as raw with JSON payload
#### @PostRequest
```
{   
    "name":"dan",
    "email" : "dan9@gmdsfail.com",
    "gender" : "Male",
    "password" : "admin",
    "phone" : "0388 888 999"
}
```
```
{   
    "name":"noah",
    "email" : "noah933@gmdsfail.com",
    "gender" : "Female",
    "password" : "admin",
    "phone" : "0388 777 999"
}
```
## PostMan
#### @PostRequest
![image](https://user-images.githubusercontent.com/127305381/229308778-68344849-e8b1-4ffc-a105-fd41f6626fb5.png)
#### PostRequest
![image](https://user-images.githubusercontent.com/127305381/229308811-297873b1-f450-4ea1-8712-7edb43871ca0.png)
#### @GetRequest all user
![image](https://user-images.githubusercontent.com/127305381/229308823-c02c1736-e886-41cd-a159-e2243fbb6207.png)

## Summary chart
```
- src
      - main
            -* com.example.demo
                  - config 
                          - ApplicationConfigAuxiliary.java
                          - PasswordEncoder.java
                          - SecurityConfig.java
                          - SpringDocConfig.java
                          - SwaggerConfig.java
                  - controller
                          - UserController.java
                  - exception
                          - DuplicateRecordException
                          - ErrorResponse
                          - GlobalExceptionHandler
                          - NotFoundException
                  - model
                      - dtos
                             -- CreateUserDto.java
                             -- UpdateUserDto.java
                             -- UploadFileDto.java
                      - entities
                             -- User.java
                  - reponsitory
                          - TokenRepository.java
                          - UserRepository.java
                  - response
                          - UserRepository.java
                  - runDemo
                          - testController.java
                  - service
                          - UserService.java
                          - UserServiceImpl.java
                  - DemoApplication.java
      - resources
                  -application.properties
- pom.xml
```
## End
Okay,that is all and i'm Dan - P-Minh Huong
