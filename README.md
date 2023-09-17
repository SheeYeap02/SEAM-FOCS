# SEAM-FOCS
Software Evolution and Maintenance on TAR UMT FOCS 

# Tech Stake
SpringBoot + MybatisPlus Framework + MySQL + Vue.js + axios

# Step to run the Application:
1. First, you need to run the sqlscript to create database
2. Install MySQL Workbench via https://dev.mysql.com/downloads/installer/ 
3. Latest MySQL Version 8.0.34 is fine, open it when it's done installed (create account also --> remember the username and password!)
4. Create a schema called "seam", which will be mapped to the application.yml database connection file
   ![image](https://github.com/SheeYeap02/SEAM-FOCS/assets/84632952/14f01de2-1fcf-453d-8cf3-d312839623c1)

5. Find and run the "sqlscript.sql" file for seam schema under direcotry e.g. C:\{your path where project cloned}\SEAM-FOCS\focs\src\main\resources\database
6. Check whether the script file run successfully. Databaset is set and open IDE now
8. Remember to change the setting of application.yml to your own MySQL account's username and password under directory e.g. C:\{your path where project cloned}\SEAM-FOCS\focs\src\main\resources 
9. Find the SpringBoot Application under directory e.g. C:\{your path where project cloned}\SEAM-FOCS\focs\src\main\java\com\seam\focs
10. Open "FocsApplication.java" and click to run it directly. It should show something "Run Successfully"
    ![image](https://github.com/SheeYeap02/SEAM-FOCS/assets/84632952/a86603bf-af01-4a7b-ae08-c981a81e5cbf)

11. In browser, type localhost:8080/dist/{your desire page} to view the page. e.g. localhost:8080/dist/index.html  <-- this is for enrollment page testing

Note: You may need to enable or install some plugins like Lombok. IDE will detect for you