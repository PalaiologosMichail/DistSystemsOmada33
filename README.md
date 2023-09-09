# DistributedSystemsErgasia


System Requirements:

-Download and install Intellij IDEA
https://www.jetbrains.com/idea/

-Download and install MySQLServer (optional: Download MySQLShell if you prefer CLI rather than MySQLWorkbench's GUI)
https://dev.mysql.com/downloads/

-Optional: Download and install DBeaver community Edition in case you prefer this software than MySQL CLI and GUI
https://dbeaver.io/download/


Setting up the application:


-Open the project in Intellij (preferably JDK version ≥ 17)

-Update Maven Dependencies 

-Change username(default: root) and password(default: MikePGR12345) in application properties to match MySQL server configuration. Optional: change database name(default:Ergasia)

-Connect MySQL Database in Intellij IDEA:
Database -> add Database -> MySQL -> 
username: same username as username in application properties, password: same password as password in application properties -> 
test connection -> make sure connection succeeds -> apply -> save

-Run the application through Intellij to create database and tables, then stop the application

-Optional: If you use DBeaver, connect MySQL database in dbeaver:
New Connection -> MySQL -> next -> Database: database name: Ergasia(can be configured in application properties in intellij) username: same username used before, password: same password used before

-Run Script.sql in dBeaver to create users and authorities

-Run the application through Intellij

You are ready to go!