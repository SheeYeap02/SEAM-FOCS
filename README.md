# SEAM-FOCS
Software Evolution and Maintenance on TAR UMT FOCS 

# Tech Stack
SpringBoot + MybatisPlus Framework + MySQL + Vue.js + axios + JSON

# Prerequisite
- Java 8 or above
- Maven
- MySQL Server
- MySQL Workbench (for GUI access)
- An IDE (e.g., IntelliJ IDEA, Eclipse)

# Step to run the Application:
1. Run the SQL Script to Initialize the Database. Locate the SQL script file:
   <br/>/focs/src/main/resources/database/sqlscript.sql
   <br/>Note: You will need to run this script after setting up the database schema in the next steps.
2. Download and install MySQL Workbench from
   <br/>👉 https://dev.mysql.com/downloads/installer/
   <br/>Note: During installation, you’ll be prompted to create a MySQL user account. Remember your username and password — you’ll need them later for configuration.
3. Open MySQL Workbench and create a schema named seam.
   <br/>
   ![image](https://github.com/SheeYeap02/SEAM-FOCS/assets/84632952/14f01de2-1fcf-453d-8cf3-d312839623c1)
4. Use the Workbench to run the sqlscript.sql file on the seam schema to initialize tables and seed data.
5. Open the application.yml file (i.e. located at {path}/focs/src/main/resources/application.yml) to configure Database Connection.
6. Update the database connection settings with your MySQL username and password:
   <br/>spring:
   <br/>   datasource:
   <br/>    url: jdbc:mysql://localhost:3306/seam
   <br/>    username: your_mysql_username
   <br/>    password: your_mysql_password
7. Navigate to the main application file (e.g. /focs/src/main/java/com/seam/focs/FocsApplication.java)
8. Run FocsApplication.java as a Spring Boot application. It should show something "Run Successfully"
    ![image](https://github.com/SheeYeap02/SEAM-FOCS/assets/84632952/a86603bf-af01-4a7b-ae08-c981a81e5cbf)
9. In your browser, open:
   http://localhost:8080/dist/index.html   <-- this is for enrollment page testing
   Replace index.html with any other page name to test different parts of the frontend.


Note: If you face any port conflicts or startup issues, make sure port 8080 is available.


