Before running the system, download or install the following first:
  1. Apache Netbeans IDE 19
  2. XAMPP
  3. Java Development Kit (I have JDK 20)
  4. MySQL Connector/J JAR file 

This is a tutorial I found and used on how to download the JAR file of MySQL Java Connector
  * https://www.tutorialsfield.com/how-to-connect-mysql-database-in-java-using-netbeans/

Setup your XAMPP
  * Upon opening XAMPP Control Panel, start both Apache and MySQL 

To run the system properly, follow the following instructions:
  1. After downloading/setting up everything, open your Apache Netbeans IDE 19
  2. Open the project and open Library -> Source Package -> DatabaseConnection -> InitDB.java
  3. Read the comment (directions) inside the main method of the InitDB class and follow it
  4. Now open Library -> Source Package -> DatabaseConnection -> DBConn.java
  5. Read the comment (directions) inside the DBConn class and follow it
  6. Run the testClass.java (by pressing Shift + F6) to initiate the database itself and the database tables
  7. Now open Library -> Source Package -> LibraryGUI -> RegistrationGUI.java
  8. Run the RegistrationGUI.java (by pressing Shift + F6) to start the program
