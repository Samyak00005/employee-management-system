# Employee Management Project: Folder Guide

## Folders and their purposes

1. controller/ — Handles incoming HTTP requests from a client or browser.
2. entity/ — Contains Java classes that describe database records, such as `Employee`. These are also called model
   classes or POJOs.
3. repository/ — Reads and writes data in the database. `EmployeeRepository` is also the app's DAO (data access) layer.
4. service/ — Holds the app's business logic. The folder exists, but it does not have a service class yet.
5. resources/ — Holds app settings and other files. For example, `application.properties` contains database settings;
   `static/` can hold CSS, JavaScript, and images; `templates/` can hold HTML pages.
6. test/ — Contains automated test classes.

## Request flow

Client or browser → Controller → Service → Repository → MySQL database

The client sends a request. The controller receives it, the service handles the app's rules, and the repository
communicates with MySQL. The database stores the information.

## Optional folders as the app grows

- dto/ — Defines the data sent to or returned from the API.
- exception/ — Holds custom error types and error-handling code.
- config/ — Holds additional app configuration.