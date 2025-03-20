# Project Setup Guide
## Project Description
This project is a web application built using Java EE technologies, utilizing Enterprise Java Beans (EJB) for business logic and data management.  It is divided into multiple components, including DTO, DAO, Bean, and Servlet, ensuring modularity and maintainability. The application interacts with an SQL database via JDBC and supports stateless session beans for efficient transaction handling.

## Prerequisites

Make sure you have the following installed before running the project:
- JDK 8
- Java EE 7
- Payara Server 5.2022.5 (or any server supporting JDK8, Java EE 7 and EJB) 
- SQL Server (or the database you configured)
- JDBC Driver supporting JDK 8

## Installation and Setup

**Step1**: Clone the Repository

**Step 2**: Configure Database
Set up your database in SQL Server (or the database you configured).

Update the database connection settings in persistence.xml.

**Step 3**: Build the Project

**Step 4**: Deploy to Payara Server
Start the Payara Server.
Deploy the generated .war file to the Payara deploy folder.

**Step 5**: Run the Application
Access the application via http://localhost:8080/<your_project>. 

(ex: http://localhost:8080/BTL-Retail-EJB-war/product-manage)

Ensure that the required services (EJB, Database, REST API) are running correctly.

## Database Configuration on Server

<img src="https://github.com/user-attachments/assets/d2cb9a7f-34bf-43bd-8be0-762f3052e351" width="500">

<img src="https://github.com/user-attachments/assets/d981af32-aa5c-4fc2-a0ac-b129fca8daa2" width="500">

<img src="https://github.com/user-attachments/assets/3c6462bc-c3d2-4c03-9139-3b991d7f9b8e" width="500">

## Troubleshooting
- Port Issues: Make sure Payara is running on the correct port (default is 8080).
- Database Connection Errors: Verify the connection string and credentials in persistence.xml.
- Dependency Issues: Run mvn dependency:resolve to ensure all dependencies are correctly installed.

## Additional Notes
The project follows a layered architecture with DAO, Service, and Servlet components.

Uses Stateless EJB for transaction management and business logic.

Ensure @EJB or @Inject is used properly in managed beans.
