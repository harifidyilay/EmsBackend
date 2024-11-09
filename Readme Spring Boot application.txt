
Spring boot - API REST project 
Link Tutorial :  https://www.youtube.com/watch?v=yybOzbOLegE&ab_channel=JavaGuides 

use : common architectural pattern
-----------------------------------------------------------------------------
Presentation layer
Service layer
Data access layer


Tools and technologie 
-----------------------------------------------------------------------------
Java 17
Spring Boot 3
Spring Data JPA  (Hibernate 6)
Mysql Database
Intellij IDEA 
Postman client



Developemt Steps   |   View in commit  11  Step 
-----------------------------------------------------------------------------
1 Spring Boot Application Three-Layer Architecture
2 Create and Setup Spring Boot Project in IntelliJ IDEA
3 Configure MySQL Database in Spring Boot Application
4 Create Employee JPA Entity
5 Create EmployeeRepository 
6 Create EmployeeDto and EmployeeMapper
7 Build Add Employee REST API
8 Build Get Employee REST API
9 Build Get All Employees REST API
10 Build Update Employee REST API
11 Build Delete Employee REST API


Step development - Add Employee REST API
-----------------------------------------------------------------------------
1 - Create the service layer  - Interface and Implementation Why  ?
		Decoupling and Flexibility : Loose coopling / Flexibility to change 
		Testability : Mocking for Unit test, Separation concerns
		Abstraction & Encapsulation 
		Dependency Injection : 

2 - Build Add Employee REST API 

3 - Write test unitaire ? Integration 

4 - Test Manualy -  Add Employee using postman 



View Processes Running on a Specific Port
-----------------------------------------------------------------------------
### Step 1: netstat -ano | findstr :PORT_NUMBER 
### Step 2: Identify the Process ID (PID) The output will show the PID of the process using the specified port[_{{{CITATION{{{_1{Windows: Find & Kill Processes Running on Port using CMD / Powershell ...](https://gist.github.com/dbagley1/9cc94ff5252aa40dee685e6ff7c1a52d). Note down the PID[_{{{CITATION{{{_1{Windows: Find & Kill Processes Running on Port using CMD / Powershell ...](https://gist.github.com/dbagley1/9cc94ff5252aa40dee685e6ff7c1a52d). 
### Step 3: Kill the Process 1. **Use the `taskkill` command** to terminate the process using the PID: 
```bash taskkill /PID PID



Test performance with Postman
-----------------------------------------------------------------------------
Create Runner > Drop API to test on Tab Runner > Select property > Run test call API  ...



Relation OneToMany
-----------------------------------------------------------------------------
Unidirectional @OneToMany    | More request executed +++++ ...
Create new table relation , like in Merise Configuration , hibernate create all request to manage all ...
Example  :
@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
  private List<PostComment> comments = new ArrayList<>();


Unidirectional @OneToMany with @JoinColumn   | More request executed ...
Add : @JoinColumn(name = "post_id")    ->    remove table relation


Bidirectional @OneToMany      | is BEST to use ...
The best way to map a @OneToMany association is to rely on the @ManyToOne side to propagate all entity state changes