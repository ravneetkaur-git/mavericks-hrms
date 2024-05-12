HRMS (Human Resource Management System)

Introduction

HRMS is a application developed to streamline various human resource management tasks within an organization. 
It provides functionalities for employee management, timesheet tracking, and authentication.

Features
Authentication: Secure authentication system for employees to access the system.
Employee Management: APIs for managing employee details such as name, email, role, etc.
Timesheet Tracking: APIs to save timesheet, get timesheet, get mentees timesheet.

Technologies Used
Spring Boot: Framework for building robust and scalable applications.
Spring Security: Provides authentication and authorization functionalities.
MySQL: Database management system for storing employee and timesheet data.
Postman: API development and testing tool for testing the implemented APIs.

Setup Instructions

Clone the Repository:
git clone <repository_url>

Database Configuration:
Set up MySQL database and configure the database connection details in application.properties.

Build and Run:
Build the project using Maven:
mvn clean install

Run the Spring Boot application:
java -jar target/hrms-0.0.1-SNAPSHOT.jar

Testing APIs:
Use Postman or any REST API client to test the implemented APIs.
