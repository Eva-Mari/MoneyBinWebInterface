# Mortgage planner webb app

This project is the web interface for the Money Bin Inc. mortgage calculator. The aim is to display 
the added prospects for the customers. It also allows the users to add new prospects, as well as
delete the current ones.

****

## About the project

The project is written in java and html. The framework Spring Boot has been used. The tool for building is Maven. 
The program uses several dependencies; Lombok, Spring Web, Spring data JPA, H2 Database, Spring Boot DevTools, 
Validation and Thymeleaf. The project also uses a local database.

To start the application, one can use the IDE. Thereafter, the address is http://localhost:7575/.
To enter the database, the address is http://localhost:7575/h2-console. Username is ADMIN and password admin.

The program is separated in several packages and classes. These have different responsibilities, such as
loading the data, different controllers and of course the mortgage planning.

****

## Future improvements

This is my first encounter of creating a web interface using Java and Spring boot. 
The interface could have had more styling, with for example CSS. Although there already is some input
validation for the user input, this could have been even more extensive; for example with the deleting 
of current prospects.