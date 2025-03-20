# Project Setup Guide
## Prerequisites

Make sure you have the following installed before running the project:
- JDK 8
- Java EE 7
- Payara Server 5.2022.5
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
Ensure that the required services (EJB, Database, REST API) are running correctly.

## Troubleshooting
- Port Issues: Make sure Payara is running on the correct port (default is 8080).
- Database Connection Errors: Verify the connection string and credentials in persistence.xml.
- Dependency Issues: Run mvn dependency:resolve to ensure all dependencies are correctly installed.

## Additional Notes
The project follows a layered architecture with DAO, Service, and Servlet components.
Uses Stateless EJB for transaction management and business logic.
Ensure @EJB or @Inject is used properly in managed beans.
