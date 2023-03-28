# User-Management-Rest-API


## Demo User Management Rest API, Restful API Security, validation

## Target for this test
- The purpose is to test for user management, how mini spring security configuration works, swagger API and some basic CRUD functionality for user management

## Prerequisites

- JDK 19
- Maven
- MariaDB

## Set request body as raw with JSON payload
```
{   
    "name":"dan",
    "email" : "dan9@gmdsfail.com",
    "gender" : "Male",
    "password" : "admin",
    "phone" : "0388 888 999"
}
```
## Summary chart
<!--  
                                             - src
                                                  - main
                                                        -* com.DanCreate.loginregisEmail
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
 -->
![image](https://user-images.githubusercontent.com/127305381/228211127-cd5927ff-b3aa-4a72-b576-121d2d255908.png)



## End
Okay,that is all and i'm Dan - P-Minh Huong
