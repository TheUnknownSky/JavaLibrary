Before running the system, download or install the following first:
  1. Apache Netbeans IDE 19
  2. XAMPP
  3. Java Development Kit (I have JDK 20)
  4. MySQL Connector/J JAR file 

To get the project into your Netbeans IDE, follow the following:
  1. Download the ZIP File of this repository.
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/767e6981-ed3e-42b4-84d6-08a46560dc8c)
  2. Extract it to a folder you can easily locate.
  3. Open the project from Netbeans.
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/572bf19a-1ef3-41e8-a86f-69344edc2950)
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/c7eb45da-52d4-49fb-9d4e-5ebae18b0ff9)
  5. If you don't jave the JAR file of Java MySQL Connector, download it here in: https://dev.mysql.com/downloads/connector/j/
    * Select "Platform Independent" in Select Operating System
    * Download the ZIP archive 
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/8ad6b247-430b-4333-95e3-f4040b3dde3d)
    * Just click "No thanks, just start my download" once this shows up
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/d8fc1c0f-02ba-443d-89a2-c084dc768605)
    * Extract the ZIP into a folder you can easily locate
  6. Go back to Netbeans. Right click Libraries, then click Add JAR/Folder
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/5d3a7639-dd86-4124-8ee5-024a381bba8e)
  7. Locate the extracted ZIP file then select the JAR file and open it
![image](https://github.com/TheUnknownSky/JavaLibrary/assets/118141177/df70b7d2-ac03-4b97-88bc-b6b90ecaeac4)

Extra tutorial for using MySQL in Java I found (how to download it and include it in your project is included)
  * https://www.tutorialsfield.com/how-to-connect-mysql-database-in-java-using-netbeans/

Setup your XAMPP
  * Upon opening XAMPP Control Panel, start both Apache and MySQL 

To run the system properly, follow the following:
  1. Make sure Apache and MySQL is started in XAMPP Control Panel.
  2. Open Library -> Source Package -> DatabaseConnection -> DBConn.java.
  3. Read the comment (directions) inside DBConn class and follow it.
  4. Run the DBConn.java file (by pressing Shift + F6) to initialize the database and its tables
  5. Check in phpMyAdmin if the database was properly initiated. If database initiation has succeeded, proceed to the next direction.
  6. Run the Runner.java (by pressing Shift + F6) to start the program.
  7. Before adding books, you must add genres to choose first.
  8. Before borrowing books, you must register students first.
