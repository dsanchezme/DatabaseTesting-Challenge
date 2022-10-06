# DatabaseTesting-Challenge

1. Create the table `institution` that will have a relationship with the table `employee`
   (use foreign key), to show the studies from an employee. Take a screenshot from the
   new Entity-Relationship Diagram.  
   ```sql
   CREATE TABLE institution (
       idInstitution INT AUTO_INCREMENT PRIMARY KEY,
       instName VARCHAR(45) NOT NULL,
       instType VARCHAR(45) NOT NULL,
       location VARCHAR(45) NOT NULL,
       website VARCHAR(45) NOT NULL
   );
   
   ALTER TABLE employee ADD idInstitution INT NOT NULL;
   ALTER TABLE employee ADD CONSTRAINT FK_idInstitution FOREIGN KEY (idInstitution)  
   REFERENCES institution  (idInstitution)
   ON DELETE CASCADE     
   ON UPDATE CASCADE;
   ```

   <p align="center">
     <img height="400" src="https://raw.githubusercontent.com/dsanchezme/DatabaseTesting-Challenge/main/src/main/resources/images/Entity-Relationship-Diagram.png">
   </p>

2. Use the Join Clause to get the data from the tables `institution` and `employee`.  
   ```sql
   SELECT e.firstName as Employee, i.instName as Institution
   FROM institution i
   INNER JOIN employee e on i.idInstitution = e.idInstitution;
   ```
   <p align="center">
     <img height="130" src="https://raw.githubusercontent.com/dsanchezme/DatabaseTesting-Challenge/main/src/main/resources/images/imgQuery2.png">
   </p>
   
3. Use Sub-Queries to get the data from the children whose parents work in PriceSmart
   (*idCompany* = 5). Note: Get the data only from the table `children`.
   ```sql
   SELECT * FROM children
   WHERE idEmployee IN (
       SELECT idEmployee FROM employee
       WHERE idCompany = 5
   );
   ```
   <p align="center">
     <img height="90" src="https://raw.githubusercontent.com/dsanchezme/DatabaseTesting-Challenge/main/src/main/resources/images/imgQuery3.png">
   </p>