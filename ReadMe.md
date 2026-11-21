# Folder and Purposes.

1. Controller = Handles incoming HTTP requests
2. Entity/Modal = Contains Java classes representing database entities (POJO)
3. Repository = Communicates with the database
4. Service = Contains business logic
5. Resources = Configuration files and other resources
6. Tests = Contains test classes

# Flow...

1. Client/Browser (Sends HTTP req) -->
2. Controller (Receives Request) -->
3. Service (Process business Logic) -->
4. Repository (Communicates with databases) -->
5. MySQLDatabase (Stores data)
   