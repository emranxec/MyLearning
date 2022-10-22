# MyLearning interview

1. how to create a immutable class?
 > Immutable class in java means that once an object is created, we cannot change its content. 
 > In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable. 
 > We can create our own immutable class as well. 
 > Prior to going ahead do go through characteristics of immutability in order to have a good understanding while implementing the same. 
 
 > Following are the requirements:
  - The class must be declared as final so that child classes can’t be created.
    - Data members in the class must be declared private so that direct access is not allowed.
    - Data members in the class must be declared as final so that we can’t change the value of it after object creation.
    - A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
    - Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

```java
final class immmutableClass{
    final private String name;

    immmutableClass(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
```
----
2. what is sequential & parallel streams?

> A stream in Java is a sequence of objects which operates on a data source such as an array or a collection 
> and supports various methods.  
> It was introduced in Java 8’s java.util.stream package. 
> Stream supports many aggregate operations like filter, map, limit, reduce, find, and match 
> to customize the original data into a different form according to the need of the programmer. 
> The operations performed on a stream do not modify its source hence a new stream is created according to the operation applied to it. 
> The new data is a transformed copy of the original form.

[parallel-vs-sequential-stream-in-java](https://www.geeksforgeeks.org/parallel-vs-sequential-stream-in-java/) 
```
// we are using stream() method
// for sequential stream
// Iterate and print each element
// of the stream
list.stream().forEach(System.out::print);

// using parallelStream()
// method for parallel stream
list.parallelStream().forEach(System.out::print);
```
----
3. remove duplicate using streams?

> You can use the Stream.distinct() method to remove duplicates from a Stream in Java 8 and beyond.
> The distinct() method behaves like a distinct clause of SQL, which eliminates duplicate rows from the result set.

```
List<Integer> withDupes = Arrays.asList(10, 10, 20, 20, 30, 30, 40, 50); 
System.out.println("List with duplicates: " + withDupes); 
List<Integer> withoutDupes = withDupes.stream() .distinct() .collect(Collectors.toList());
```
----
4. design patterns in spring?

> [design patterns](https://github.com/emranxec/MyLearning/blob/master/designPattern/interviewQuestions.md)

> ## Singleton Pattern
    The singleton pattern is a mechanism that ensures only one instance of an object exists per application. 
This pattern can be useful when managing shared resources or providing cross-cutting services, such as logging.

#### Singleton Beans
> Generally, a singleton is globally unique for an application, but in Spring, this constraint is relaxed. Instead, Spring restricts
> a singleton to one object per Spring IoC container. In practice, this means Spring will only create one bean for each type per application context.

#### Autowired Singletons
> we can create two controllers within a single application context and inject a bean of the same type into each.
> First, we create a BookRepository that manages our Book domain objects.
> Next, we create LibraryController, which uses the BookRepository to return the number of books in the library
> In the application output, we see that both BookRepository objects have the same object ID
> NOTE: We can create separate instances of the BookRepository bean by changing the bean scope from singleton to prototype
> using the @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation.

## Factory Method Pattern

#### Application Context
> Spring uses this technique at the root of its Dependency Injection (DI) framework.
> Fundamentally, Spring treats a bean container as a factory that produces beans.
> Thus, Spring defines the BeanFactory interface as an abstraction of a bean container:
```java
public interface BeanFactory {

    getBean(Class<T> requiredType);

    getBean(Class<T> requiredType, Object... args);

    getBean(String name);

    // ...
}
```

> Each of the getBean methods is considered a factory method, which returns a bean matching the criteria supplied to the method, like the bean's type and name.
> Spring then extends BeanFactory with the ApplicationContext interface, which introduces additional application configuration. 

## Proxy Pattern

#### Transactions
> To create a proxy, we create an object that implements the same interface as our subject and contains a reference to the subject.
> We can then use the proxy in place of the subject.
> In Spring, beans are proxied to control access to the underlying bean. We see this approach when using transactions:
```java
@Service
public class BookManager {

    @Autowired
    private BookRepository repository;

    @Transactional
    public Book create(String author) {
        System.out.println(repository.getClass().getName());
        return repository.create(author);
    }
}
```
>In our BookManager class, we annotate the create method with the @Transactional annotation. 
> This annotation instructs Spring to atomically execute our create method. Without a proxy, 
> Spring wouldn't be able to control access to our BookRepository bean and ensure its transactional consistency.

## Template Method Pattern

#### JdbcTemplate
> The JdbcTemplate class provides the query method, which accepts a query String and ResultSetExtractor object:
```java
public class JdbcTemplate {

    public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
        // Execute query...
    }

    // Other methods...
}
```

> The ResultSetExtractor converts the ResultSet object — representing the result of the query — into a domain object of type T:
```java
@FunctionalInterface
public interface ResultSetExtractor<T> {
T extractData(ResultSet rs) throws SQLException, DataAccessException;
}
```

> Spring further reduces boilerplate code by creating more specific callback interfaces.
> For example, the RowMapper interface is used to convert a single row of SQL data into a domain object of type T.

```java
@FunctionalInterface
public interface RowMapper<T> {
T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
```
>With this converter, we can then query a database using the JdbcTemplate and map each resulting row:
```
JdbcTemplate template = // create template...
template.query("SELECT * FROM books", new BookRowMapper());
```
>Apart from JDBC database management, Spring also uses templates for:
- Java Message Service (JMS)
- Java Persistence API (JPA)
- Hibernate (now deprecated)
- Transactions

----
5. how to connect DB from spring?

>Now, since you have understood the benefits of connecting Spring Boot to MySQL, it’s time that you learn how to actually go through with it. The following steps will help you in setting up the Spring Boot MySQL Integration:

- Step 1: Creating a MySQL Database
> CREATE DATABASE restapi;
> USE restapi;
> CREATE TABLE blog (
> id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
> title VARCHAR(500) NOT NULL,
> content VARCHAR(5000) NOT NULL
);
- Step 2: Append MySQL Dependencies
```xml
<dependencies>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
</dependencies>
```
- Step 3: Set Spring Boot MySQL Connection Configuration
> spring.datasource.url=jdbc:mysql://localhost:3306/restapi
> spring.datasource.username=root
> spring.datasource.password=
- Step 4: Build a Repository Class for Spring Boot
```
- @Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {

    // custom query to search to blog post by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);  
    
 ```
- Step 5: Convert the Blog Class to Entity
 ```java
@Entity
public class Blog {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

    private String title;
    private String content;

    public Blog() {  }
    }
 ```
- Step 6: Add the Controller to Spring Boot MySQL Integration
 ```
@Autowired
BlogRespository blogRespository;
 ```
>This will allow you to use blogRepository anywhere in your controller without having to repeatedly instantiate it
----
6. what is spring actuators?
>Actuator brings production-ready features to our application.
>Monitoring our app, gathering metrics, understanding traffic, or the state of our database become trivial with this dependency.
>The main benefit of this library is that we can get production-grade tools without having to actually implement these features ourselves.
>Actuator is mainly used to expose operational information about the running application — health, metrics, info, dump, env, etc. 
> It uses HTTP endpoints or JMX beans to enable us to interact with it.
----
7. Map vs flatMap?
> map() can be used where we have to map the elements of a particular collection to a certain function, and then we need to return the stream which contains the updated results.
> Example: Multiplying All the elements of the list by 3 and returning the updated list.
> flatMap() can be used where we have to flatten or transform out the string, as we cannot flatten our string using map().
> Example: Getting the 1st Character of all the String present in a List of Strings and returning the result in form of a stream.
 ```
List list = fruit.stream()
.map(s -> s.length())
.collect(Collectors.toList());

List<Integer> flatList
= number.stream()
.flatMap(list -> list.stream())
.collect(Collectors.toList());
 ```
> [difference-between-map-and-flatmap-in-java-stream](https://www.geeksforgeeks.org/difference-between-map-and-flatmap-in-java-stream/) 
----
8. what is spring global exception?
> 
----
9.  what is Azure function?

> Azure Functions is a serverless solution that allows you to write less code, maintain less infrastructure, 
> and save on costs. Instead of worrying about deploying and maintaining servers, 
> the cloud infrastructure provides all the up-to-date resources needed to keep your applications running.
----
10. Azure kubernate?

>Azure Kubernetes Service is a managed container orchestration service based on the open source 
> Kubernetes system, which is available on the Microsoft Azure public cloud. An organization can 
> use AKS to handle critical functionality such as deploying, scaling and managing Docker containers and container-based applications.\
----
11. what is responsive UI in JS?

>Responsive design is a graphic user interface (GUI) design approach used to create content that adjusts smoothly 
> to various screen sizes. Designers size elements in relative units (%) and apply media queries, 
> so their designs can automatically adapt to the browser space to ensure content consistency across devices.

----
12. what is Serverless computing?
> Serverless computing allows you to build and run applications and services without thinking about servers. 
> With serverless computing, your application still runs on servers, but all the server management is done by AWS.
----
11. what is java steams?
> Introduced in Java 8, the Stream API is used to process collections of objects. 
> A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
> The features of Java stream are –
- A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
- Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
- Each intermediate operation is lazily executed and returns a stream as a result, 
- hence various intermediate operations can be pipelined. 
- Terminal operations mark the end of the stream and return the result.
----
12. what factory class java having?

>This design pattern has been widely used in JDK, such as
- getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern. 
- All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf() method.
- java.nio.charset.Charset.forName(), 
- java.sql.DriverManager#getConnection(), 
- java.net.URL.openConnection(), 
- java.lang.Class.newInstance(), 
- java.lang.Class.forName() are some of their example where factory method design pattern has been used.
----
13. flow of Spring MVC?
> ![MVC](https://user-images.githubusercontent.com/16031518/196950237-c8c079a6-ebd3-448a-aab8-a35486abf2ec.png)
----
14. How you test json implementation?
 ```java
@Test
class test {
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
            throws ClientProtocolException, IOException {

        // Given
        String name = RandomStringUtils.randomAlphabetic(8);
        HttpUriRequest request = new HttpGet("https://api.github.com/users/" + name);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }
}
 ```
----
15.  can mutable object is instance of immutable class? how to fix? 

- can private constructer of immutable class always create a new object of mutable instance? 
- getter of immutable class always return a new object of mutable instance? 
- what if we have a mutable instance in your immutable class such as Date? 
- in private constructor of your immutable class always? 
- create a new instance of mutable field? 
- and in getter always return a new instance of mutable field?
>
----
16. how to process: 10000 request handling at once & persist in DB ?
----
17. what is SAAS?
> What is SaaS? Software as a service (or SaaS) is a way of delivering applications over the Internet—as a service. 
> Instead of installing and maintaining software, you simply access it via the Internet, 
> freeing yourself from complex software and hardware management.
> eg. Netflix, Spotify, Dropbox and Slack are common SaaS products, in which the product 
> is then delivered to users over the internet on a subscription basis, 
> giving users the flexibility to not have to worry about upfront installation purchases or ongoing maintenance costs.
----
18. How to handle Transactions in Spring?
> #### Using @Transactional power
> As we defined before, in a transaction, if a single process fails then all transactions should fail. 
> We can implement this behavior using @Transactional annotation.
 ```java
@Service
public class TransferService {

private UserService userService;
private AccountService accountService;

@Autowired
public TransferService(UserService userService, AccountService accountService) {
this.userService = userService;
this.accountService = accountService;
}

@Transactional // This makes all difference
public void transferMoney(long accountFrom, long accountTo){
try {
userService.validateUserAccount(accountTo);
accountService.validateAccountMoney(accountFrom);
accountService.discountMoneyFromAccount(accountFrom);
accountService.addMoneyToAccount(accountTo);
} catch (TrasferException e) {
// Something in case the transaction fails
}
}

}
 ```
> @Transactional will make sure all our operations are successfully executed, 
> if not, it will roll back all operations at the database as if nothing happened.
> Resuming why we should use transaction management:
> Transactional operations are atomic units
> The same connection is reused across all transactions.

* To keep in mind, @Transactional could be used at class level too,
* then all inner methods will be considered single transaction. 

#### Isolation
> Spring allows managing the isolation level. The default strategy for most databases is READ_COMMITTED,
> but we have other ones such as: READ_UNCOMMITTED, REPEATABLE_READ and SERIALIZABLE.

- READ_COMMITTED will only read committed operations to the database and maintain us safe from dirty reads.
- READ_UNCOMMITTED allows the current transaction to read the uncommitted changes from another transaction. The lowest isolation level.
- REPEATABLE_READ prevent dirty reads and if one row is read more than one time in a single transaction, the read result will always be the same.
- SERIALIZABLE prevents non-repeatable reads, dirty reads, and phantom reads. Has impact on performance.

#### Propagation
>Below are propagation levels:
- REQUIRED 
- REQUIRES_NEW 
- SUPPORTS 
- MANDATORY 
- NEVER 
- NOT_SUPPORTED 
- NESTED

#### Rollback rules
>We can add specific configuration to allow rollback or non-rollback depending on the exception thrown:

`@Transactional(rollbackFor=MyException.class, noRollbackFor=OtherException.class)
public void addMoneyToAccount(long account) {`

- [spring-core-managing-transactions](https://medium.com/javarevisited/spring-core-managing-transactions-effectively-781bba6c47e8)
- [Transaction Management](https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/transaction.html)

----
19. explain Transactions in hibernate?

## Transaction Interface in Hibernate
> In hibernate framework, we have Transaction interface that defines the unit of work. 
> It maintains abstraction from the transaction implementation (JTA,JDBC).
> A transaction is associated with Session and instantiated by calling session.beginTransaction().

#### The methods of Transaction interface are as follows:
- void begin() starts a new transaction. 
- void commit() ends the unit of work unless we are in FlushMode.NEVER. 
- void rollback() forces this transaction to rollback. 
- void setTimeout(int seconds) it sets a transaction timeout for any transaction started by a subsequent call 
- to begin on this instance. 
- boolean isAlive() checks if the transaction is still alive. 
- void registerSynchronization(Synchronization s) registers a user synchronization callback for this transaction. 
- boolean wasCommited() checks if the transaction is commited successfully. 
- boolean wasRolledBack() checks if the transaction is rolledback successfully.
----
20. linkedhashmap internal works?

> 
----

21. what are RESTFUL annotations?
#### JAX-RS Annotations
- @Path(‘Path‘)
- @GET 
- @POST 
- @PUT 
- @DELETE 
- @Produces(MediaType.TEXT_PLAIN [, more-types])
- @Consumes(type[, more-types])
- @PathParam()
- @QueryParam()
- @MatrixParam()
- @FormParam()

----
22. write code to hit new api request from your code?

> 
----
23. What DB model is prefered in microservice architecture?
>Different services have different data storage requirements. For some services, a relational database 
> is the best choice. Other services might need a NoSQL database such as MongoDB,
> which is good at storing complex, unstructured data, or Neo4J, 
> which is designed to efficiently store and query graph data.
----
24. What is @autowire usage?
>The @Autowired annotation provides more fine-grained control over where and how 
> autowiring should be accomplished. The @Autowired annotation can be used to 
> autowire bean on the setter method just like @Required annotation, 
> constructor, a property or methods with arbitrary names and/or multiple arguments.

>class Red
`@Qualifier("redBean")
class Red implements Color {
// Class code here
}`
>class Blue
`@Qualifier("blueBean")
class Blue implements Color {
// Class code here
}`
>creating Red class injection using autowire
`@Autowired
@Qualifier("redBean")
public void setColor(Color color) {
this.color = color;
}`
----
25. Explain how to create user defined annotations ?

## Create Custom Annotation
- Class Level Annotation
- Field Level Annotation
- Method Level Annotation

#### Class Level Annotation

`@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.Type)
public @interface GFG {
}`

#### Field Level Annotation
`@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GFGElement { 
public String key() default "";
}`

#### Method Level Annotation
`@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
}`
----
26. what data structure does executer service hold?
> 
----
27. what are Microservices design patterns?
#### Microservices Design Patterns:
- Aggregator
- API Gateway 
- Chained or Chain of Responsibility 
- Asynchronous Messaging 
- Database or Shared Data 
- Event Sourcing 
- Branch 
- Command Query Responsibility Segregator 
- Circuit Breaker 
- Decomposition
> [design-patterns-for-microservices](https://dzone.com/articles/design-patterns-for-microservices)
----
28. SQL queries with Functions & stored procedures
> #### Stored Procedures
> Stored Procedures are pre-compiled objects which are compiled for the first time and its compiled format is saved, which executes (compiled code) whenever it is called. For more about a stored procedure, please refer to the article Different types of Stored Procedure.
#### Functions
> A function is compiled and executed every time whenever it is called. A function must return a value and cannot modify the data received as parameters. For more about functions, please refer to the article Different types of Functions.

#### Diffrences
- The function must return a value but in Stored Procedure it is optional. Even a procedure can return zero or n values. 
- Functions can have only input parameters for it whereas Procedures can have input or output parameters. 
- Functions can be called from Procedure whereas Procedures cannot be called from a Function. 
- The procedure allows SELECT as well as DML(INSERT/UPDATE/DELETE) statement in it whereas Function allows only SELECT statement in it. 
- Procedures cannot be utilized in a SELECT statement whereas Function can be embedded in a SELECT statement. 
- Stored Procedures cannot be used in the SQL statements anywhere in the WHERE/HAVING/SELECT section whereas Function can be. 
- Functions that return tables can be treated as another rowset. This can be used in JOINs with other tables. 
- Inline Function can be though of as views that take parameters and can be used in JOINs and other Rowset operations. 
- An exception can be handled by try-catch block in a Procedure whereas try-catch block cannot be used in a Function. 
- We can use Transactions in Procedure whereas we can't use Transactions in Function.

----
29. Basic packages requires to create spring boot application
#### For instance, we would like to develop a Spring WebApplication with Tomcat WebServer. Then we need to add the following minimal jar dependencies in your Maven’s pom.xml file or Gradle’s build.gradle file

- Spring core Jar file(spring-core-xx.jar)
- Spring Web Jar file(spring-web-xx.jar)
- Spring Web MVC Jar file(spring-webmvc-xx.jar)
- Servlet Jar file(servlet-xx.jar)
####  If we want to add some database stuff, then we need to add database related jars like Spring JDBC jar file, Spring ORM jar files,Spring Transaction Jar file etc.
- Spring JDBC Jar file(spring-jdbc-xx.jar)
- Spring ORM Jar file(spring-orm-xx.jar)
- Spring Transaction Jar file(spring-transaction-xx.jar)
#### Spring Boot Starter Web comes pre-packaged with these.
Dependencies can be classified into:
- Spring - core, beans, context, app
- Web MVC - (Spring MVC)
- Jackson - for JSON Binding 
- Validation - Hibernate Validator, Validation API 
- Embedded Servlet Container - Tomcat 
- Logging - logback, slf4j
----
30. What inbuilt server spring uses?
> With SpringBoot, the default embedded server is Tomcat. Other options available are Jetty and UnderTow.
----
31. explain Spring security?
> Spring Security is a framework which provides various security features like: authentication, authorization to create secure Java Enterprise Applications.
## Spring Security Features

#### LDAP (Lightweight Directory Access Protocol)
>It is an open application protocol for maintaining and accessing distributed directory information services over an Internet Protocol.

#### Single sign-on
>This feature allows a user to access multiple applications with the help of single account(user name and password).

#### JAAS (Java Authentication and Authorization Service) LoginModule
>It is a Pluggable Authentication Module implemented in Java. Spring Security supports it for its authentication process.

#### Basic Access Authentication
>Spring Security supports Basic Access Authentication that is used to provide user name and password while making request over the network.

#### Digest Access Authentication
>This feature allows us to make authentication process more secure than Basic Access Authentication. It asks to the browser to confirm the identity of the user before sending sensitive data over the network.

#### Remember-me
>Spring Security supports this feature with the help of HTTP Cookies. It remember to the user and avoid login again from the same machine until the user logout.

#### Web Form Authentication
>In this process, web form collect and authenticate user credentials from the web browser. Spring Security supports it while we want to implement web form authentication.

#### Authorization
>Spring Security provides the this feature to authorize the user before accessing resources. It allows developers to define access policies against the resources.

#### Software Localization
>This feature allows us to make application user interface in any language.

#### HTTP Authorization
>Spring provides this feature for HTTP authorization of web request URLs using Apache Ant paths or regular expressions.

## Features added in Spring Security 5.0
#### OAuth 2.0 Login
>This feature provides the facility to the user to login into the application by using their existing account at GitHub or Google. This feature is implemented by using the **Authorization Code Grant** that is specified in the OAuth 2.0 Authorization Framework.

#### Reactive Support
>From version Spring Security 5.0, it provides reactive programming and reactive web runtime support and even, we can integrate with Spring WebFlux.

#### Modernized Password Encoding
>Spring Security 5.0 introduced new Password encoder **DelegatingPasswordEncoder** which is more modernize and solve all the problems of previous encoder **NoOpPasswordEncoder**.
----
32. expalin Dirty - Hibernate?
>When an entity object is loaded, a copy of all properties of that entity object is created. 
> At the time of synchronization, which we call flush time, the properties of the entity object are matched 
> with the properties of the loaded object and the difference is checked. 
> This process is called “Hibernate Dirty Check”.

###### Each time, Hibernate checks the properties of the entity object with the last loaded snapshot.If there is a change, it performs the update. That's why this situation is called "Hibernate Dirty Check". In fact, it causes a performance loss.

`Hibernate: select commententity0_.id as id1_1_0_,
commententity0_.text as text2_1_0_, commententity0_.owner
as owner3_1_0_ from comment commententity0_ where commententity0_.id=?`
>
**`Hibernate: update comment set text=? where id=?`**

#### What is the solution?
> When an entity is loaded, the 'Hibernate dirty checking mechanism' compares the snapshot of the current entity
> with the loaded entity, but we can also turn off this comparison when we are not going to update it.
`@Transactional(readOnly = true)`
> If we mark the method we are processing as readOnly = true, there will be no 'Hibernate dirty check' operation,
> as there will be no update operation. This gives us performance.
----
33. why String immutable ?
> In the String constant pool, a String object is likely to have one or many references. 
> If several references point to the same String without even knowing it, 
> it would be bad if one of the references modified that String value. That’s why String objects are immutable.

[java-string-is-immutable](geeksforgeeks.org/java-string-is-immutable-what-exactly-is-the-meaning/?ref=lbp)

`String str = "knowledge"`
>
`str = str.concat(" base");`

>At this point in the example above, we have two String objects: the first one we created with value “knowledge”, 
pointed to by s, and the second one “knowledge base”, pointed to by str. But, technically, we have three String 
objects, **the third one being the literal “base” in the concat statement.**
----
34. how to configure Spring & hibernate?
> [spring-boot-with-hibernate](https://www.javadevjournal.com/spring-boot/spring-boot-with-hibernate/)
----
35. what is Class not found and No class def error?
> ClassNotFoundException is raised in the above program as class “GeeksForGeeks” is not found in the classpath.
    `try {Class.forName("GeeksForGeeks");
        }
 catch (ClassNotFoundException ex) {
  ex.printStackTrace();
        }`
> remove any .class file and run that .class when we saw that at Java runtime NoClassDefFoundError will be thrown.

- [classnotfoundexception-vs-noclassdeffounderror](https://www.geeksforgeeks.org/classnotfoundexception-vs-noclassdeffounderror-java/?ref=lbp)
----
36. is static method override possible?
> We can declare static methods with the same signature in the subclass, 
> but it is not considered overriding as there won't be any run-time polymorphism. Hence the answer is 'No
----
37. explain save,update, save and persist methods?
- [hibernate-save-persist-update-merge-saveorupdate](https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate)
----
38. how to convert data in rest response in spring?
> Either return text/plain as
```
@RequestMapping(value="/controller", method=GET)
@ResponseBody
public String foo() {
return "Response!";
}
```

>or Set your response type to MediaType.APPLICATION_JSON_VALUE (= "application/json")
```
@RequestMapping(value = "/getString", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
                
//and you'll have a JSON that looks like

{  "response" : "your string value" }
```
----
39. when to used native query & hibernate query?
>You do not need to create a native query unless you want to. 
###### JPQL eventually is translated into SQL by the framework but the framework lets you call the native query also. Why would want to do that:
- Low level access, which means that you can optimize and handle the mapping by yourself; with SQL you actually access the database table while with JPQL you access the entity objects; 
- Maybe you do not want to learn JPQL if you already know SQL 
- You already have the queries written in SQL, and do not have resources/time to port them to JPQL
----
40. what is criteria in hibernate ?
```java
class DBCOnnections{

public void employeeDetails(){
tx = session.beginTransaction();

        // This will simply return every object that
        // corresponds to the GeekEmployee class.
        Criteria geekEmployeeCriteria
            = session.createCriteria(GeekEmployee.class);
 
        // Here 2 expectations are there one with salary and
        // second one is name. Both are expected to be
        // present. Let us see how to do that
        Criterion salaryExpectation
            = Restrictions.gt("salary", 40000);
 
        Criterion nameExpectation
            = Restrictions.ilike("firstName", "Geek%");
        // As we are combining 2 conditions and that two
        // logically And, we need to add as Restrictions.and
        // To get records matching with AND conditions we
        // need to give below way
        LogicalExpression logicalAndExpression
            = Restrictions.and(salaryExpectation,
                               nameExpectation);
        geekEmployeeCriteria.add(logicalAndExpression);
        
        // setFirstResult-> It takes an integer and it is
        // represented as the first row in your result set,
        // starting with row 0.
 
        geekEmployeeCriteria.setFirstResult(1);
        // setMaxResults->fixed number maxResults of objects
        // are returned here
        geekEmployeeCriteria.setMaxResults(3);
        
           geekEmployeeCriteria.add(
            Restrictions.gt("salary", 20000));
 
        // Display the results in descending order
        geekEmployeeCriteria.addOrder(Order.desc("salary"));
        
          // Get total number of records by using rowcount
        geekEmployeeCriteria.setProjection(
            Projections.rowCount());
        List employeeRowCount = geekEmployeeCriteria.list();
 
        System.out.println("Total row Count: "
                           + employeeRowCount.get(0));
 
        // Getting sum(salary)
        geekEmployeeCriteria.setProjection(
            Projections.sum("salary"));
        List totalSalary = geekEmployeeCriteria.list();
 
        System.out.println("Total Salary of GeekEmployees: "
                           + totalSalary.get(0));
 
        // Getting average(salary)
        geekEmployeeCriteria.setProjection(
            Projections.avg("salary"));
        List averageSalary = geekEmployeeCriteria.list();
        System.out.println(
            "Average Salary of GeekEmployees: "
            + averageSalary.get(0));
 
        // Getting max(salary)
        geekEmployeeCriteria.setProjection(
            Projections.max("salary"));
        List maxSalary = geekEmployeeCriteria.list();
        System.out.println(
            "Maximum Salary among GeekEmployees: "
            + maxSalary.get(0));
 
        // Getting min(salary)
        geekEmployeeCriteria.setProjection(
            Projections.min("salary"));
        
 
        // As a list we can collect them and can iterate
        List geekEmployeeList = geekEmployeeCriteria.list();
 
        for (Iterator iterator
             = geekEmployeeList.iterator();
             iterator.hasNext();) {
            GeekEmployee employee
                = (GeekEmployee)iterator.next();
            System.out.print("First Name: "
                             + employee.getFirstName());
            System.out.print("  Last Name: "
                             + employee.getLastName());
            System.out.println("  Salary: "
                               + employee.getSalary());
        }
        tx.commit();
        }
        }
```
 [hibernate-criteria-queries](https://www.geeksforgeeks.org/hibernate-criteria-queries/)
----
41. load a big trnsactional file and fetch the trnasction records using best data structures?
> 
----
42. why jquery over javascript ?

##### JavaScript
> JavaScript is a dynamic, multiparadigm programming language. It is interpreted and not compiled. Therefore, as the name suggests, it is a scripting language.

##### jQuery
> jQuery is a lightweight, feature-rich JavaScript library. It allows us to perform various tasks in a much simpler and quicker way. With jQuery, DOM manipulation, AJAX calls, event handling, and animations become a cinch.

##### Angular JS
> Angular JS can do everything that JQuery does and even much more. It is easy to write and run unit tests in Angular JS applications. Dependency management is effortless and binding dynamic data is powerful. For building testable web applications, we can use Angular JS than JQuery.

##### React
> React Is Faster Than jQuery. One of the biggest things that React has going for it is the use of the Virtual DOM (Document Object Model) instead of the traditional DOM. While jQuery works with the DOM directly, React uses the virtual DOM which is what makes React so much faster.

##### Is Angular better than React? 
>Angular is better than React if your application is enterprise-grade and you need to incorporate complex functionalities like progressive, single-page, and native web apps. However, React specializes in creating UI components and can be used in any application, including single-page apps
----
43. what is bootstrap?
>Bootstrap is a free, open source front-end development framework for the creation of websites and web apps. 
> Designed to enable responsive development of mobile-first websites, 
> Bootstrap provides a collection of syntax for template designs.
----
44. what is service layer in Spring? 
### Reasons to use :

- Provides separation of concern-

>Service layer provides code modularity,the business logic and rules are specified in the service layer which in turn calls DAO layer ,the DAO layer is then only responsible for interacting with DB.

- Provides Security -

>If you provide a service layer that has no relation to the DB, then it is more difficult to gain access to the DB from the client except through the service. If the DB cannot be accessed directly from the client (and there is no trivial DAO module acting as the service) then an attacker who has taken over the client cannot have access to your data directly.

- Provide Loose Coupling-

>Service layer can also be used to serve loose coupling in the application.Suppose your controller has 50 methods and in turn it calls 20 Dao methods,Now at later point you decide to change the Dao methods serving these controllers.You need to change all the 50 methods in controller. Instead if you have 20 service methods calling those 20 Dao methods, you need to make change in only 20 Service methods to point to a new Dao.
    
[why-to-use-service-layer-in-spring-mvc](https://blog1.westagilelabs.com/why-to-use-service-layer-in-spring-mvc-5f4fc52643c0)

----
45. Do we need DAO layer if we have Service layer?
>They way you put it, the alternative to having a DAO layer is not having a DAO layer. 
> Not having a DAO layer means that the code on the next higher level is responsible 
> for handling low level persistence aspects, which contradicts the principle of single responsibility.

----
46. String vs String builder?
- [string-vs-stringbuilder-vs-stringbuffer](https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/) 

----
47. What is docker?
>Docker is an open platform for developing, shipping, and running applications. Docker enables you to separate your applications from your infrastructure so you can deliver software quickly.

##### What can I use Docker for?
- Fast, consistent delivery of your applications
- Responsive deployment and scaling
- Running more workloads on the same hardware

`docker run -i -t ubuntu /bin/bash`

[docker-cheat-sheet](https://www.docker.com/wp-content/uploads/2022/03/docker-cheat-sheet.pdf)
----
48. How to configure CI/CD process?
- [build-ci-cd-pipeline-in-azure-devops](https://www.lambdatest.com/blog/build-ci-cd-pipeline-in-azure-devops/)
- [azure-devops-pipeline-tutorial](https://medium.com/abn-amro-developer/azure-devops-pipeline-tutorial-part-1-ci-pipeline-fundamentals-41e590ff1d80)

----
49. how to avoid sql injection?
#### Option 1: Use of **Prepared Statements** (with Parameterized Queries)
>Prepared statements ensure that an attacker is not able to change the intent of a query, 
> even if SQL commands are inserted by an attacker.
- Hibernate Query Language (HQL) Prepared Statement (Named Parameters) Examples:

>First is an unsafe HQL Statement
`Query unsafeHQLQuery = session.createQuery("from Inventory where productID='"+userSuppliedParameter+"'");`
>Here is a safe version of the same query using named parameters
`Query safeHQLQuery = session.createQuery("from Inventory where productID=:productid");
safeHQLQuery.setParameter("productid", userSuppliedParameter);`

####  Option 2: Use of Properly Constructed Stored Procedures 
> The difference between prepared statements and stored procedures is that the SQL code for a stored procedure
> is defined and stored in the database itself, and then called from the application. Both of these techniques have
> the same effectiveness in preventing SQL injection so your organization should choose which approach makes 
> the most sense for you.
``` java
// This should REALLY be validated
String custname = request.getParameter("customerName");
try {
CallableStatement cs = connection.prepareCall("{call sp_getAccountBalance(?)}");
cs.setString(1, custname);
ResultSet results = cs.executeQuery();
// … result set handling
} catch (SQLException se) {
// … logging and error handling
}
```
####  Option 3: Allow-list Input Validation
[Input_Validation_Cheat_Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Input_Validation_Cheat_Sheet.html)

####  Option 4: Escaping All User Supplied Input
>This technique works like this. Each DBMS supports one or more character escaping schemes specific
> to certain kinds of queries. If you then escape all user supplied input using the proper
> escaping scheme for the database you are using, the DBMS will not confuse that input with SQL code
> written by the developer, thus avoiding any possible SQL injection vulnerabilities.

##### Escaping Dynamic Queries
- To use an ESAPI database codec is pretty simple. An Oracle example looks something like:

`ESAPI.encoder().encodeForSQL( new OracleCodec(), queryparam );`

- it would now be safe from SQL injection, regardless of the input supplied.

```
Codec ORACLE_CODEC = new OracleCodec();
 String query = "SELECT user_id FROM user_data WHERE user_name = '"
ESAPI.encoder().encodeForSQL( ORACLE_CODEC, req.getParameter("userID"))
"' and user_password = '"
ESAPI.encoder().encodeForSQL( ORACLE_CODEC, req.getParameter("pwd")) +"'";
```

[SQL_Injection_Prevention_Cheat_Sheet](https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html)
----
50. what is functional interface?
[functional-interfaces-java](https://www.geeksforgeeks.org/functional-interfaces-java/?ref=lbp)
----
51. how to configure techniques of JVM?
>
----
52. why serialize a object?
>
----
53. what is default spring bean status?
>The default scope for the bean is a singleton, like the example below, 
> in which we haven't explicitly given a scope. Singleton means that the Spring container 
> creates only one instance of the bean, and cached in memory, 
> and all the requests for that bean will return a shared reference to the same bean.

##### we can change scope by
```java
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TwitterMessageService implements MessageService {
}
```
----
54. what is states of hibernate attribute?
#### transient 
− A new instance of a persistent class, which is not associated with a Session and has no representation in the database and no identifier value is considered transient by Hibernate.

#### persistent 
− You can make a transient instance persistent by associating it with a Session. A persistent instance has a representation in the database, an identifier value and is associated with a Session.

#### detached 
- Once we close the Hibernate Session, the persistent instance will become a detached instance.
----
55. Why concurrent HashMap used?
[concurrenthashmap-in-java](https://www.geeksforgeeks.org/concurrenthashmap-in-java/?ref=lbp)
----
56. can two threads update in concurrent HashMap?
>	Yes, Thread safety is ensured by having separate locks for separate buckets, 
> resulting in better performance. Performance is further improved by providing 
> read access concurrently without any blocking.
----
57. how you validate the request param and path param Done in spring?
```xml
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.10.Final</version>
</dependency>
```
##### @Validated

```java
@RestController
@RequestMapping("/")
@Validated
public class Controller {
// ...

    @GetMapping("/name-for-day")
    public String getNameOfDayByNumber(@RequestParam @Min(1) @Max(7) Integer dayOfWeek) {
        // ...
    }
    @GetMapping("/valid-name/{name}")
    public void createUsername(@PathVariable("name") @NotBlank @Size(max = 10) String username) {
        // ...
    }
}
```
>We can change the default message by adding a custom one:
`@Max(value = 1, message = “day number has to be less than or equal to 7”)`

[spring-validate-requestparam-pathvariable](https://www.baeldung.com/spring-validate-requestparam-pathvariable)
----
58. what is reflaction API?
----
59. at what time/place rollback gets called?
> In Spring Boot, when @Transactional annotation is used, Spring Boot implicitly creates a proxy 
> that will be creating a connection to the database. A transaction will be started and commit 
> after the code has been executed errorless. Otherwise, it will roll back the changes if an 
> exception occurred.

```java
class someClass{
@Transactional
public void createProduct() {  
System.out.println("------ createProduct ------");
Product prod = new Product();
prod.setDescription("This is an example with runtime exception and transactional annotation.");
prod.setPrice(10);
prod.setTitle("Second Product");
productRepository.save(prod);
System.out.println("Second Product inserted.");
throw new RuntimeException();
}
}
```

**_Take note, Spring only rolled back on unchecked exceptions by default. To roll back checked exception, we need to specify the rollbackFor_**

[spring-transactional-rollback-handling](https://medium.com/geekculture/spring-transactional-rollback-handling-741fcad043c6)
----
60. what are diffrent types of class loader?

----
61. How to convert monolithic application to microservices?
1. Identify logical components.
2. Flatten and refactor components.
3. Identify component dependencies.
4. Identify component groups.
5. Create an API for remote user interface.
6. Migrate component groups to macroservices (move component groups to separate projects and make separate deployments).
7. Migrate macroservices to microservices.
8. Repeat steps 6-7 until complete.

[8-steps-for-migrating-existing-applications-to-microservices](https://insights.sei.cmu.edu/blog/8-steps-for-migrating-existing-applications-to-microservices/)
----
62. How to load balance in 60% ,40% weightage ?

----
63. Load a file and do operations?
>
----
64. Garbage collectors? what are diff types of garbage collector? Different method of garbage collector?
>
----
65. jdbc versus hibernate?
>
----
66. explain @mappedBy?
>
----
67. explain hibernate criteria?
>
----
68. explain hibernate caching?
>
----
69. MQS?
>
----
70. explain Maven in detail? explain Pom.xml in detail?
>
----
71. Why to overide run in springApplication?
>
----
72. try with resources vs try with finally?
>
----
73. How to configure techniques of JVM?
>
----
74. Why to serialize a object?
>
----
75. Reflaction API?
>
----
76. How to serialize and deserialize object?
>
----
77. Function vs bifunction?
>
----
78. Mapping vs flat mapping?
>
----
79. what are Design principles?
>
----
80. explain Classnotfound, NoClassDefError,StackOverFlow,OOM?
>
----
81. explain Microservice framework Netflix?
>
----
82. diffrence between @Primary & @Qualifier?
>
----
83. Spring global exceptions?
>
----
84. Controller vs rest controlled?
>
----
85. Spring actuators?
>
----
86. Different types of class loaders?
>
----
87. explain Hibernate inheritance?
>
----
88. Why microservices?
>
----
89. Sort hashmap on basis of value.?
>
----
90. how to manage two different session factory?
>
----
91.  what are Different library for hibernate,spring & SQI?
>
----
92. What data structure does Executer service hold?
>
----
93. Function vs procedures?
>
----
94. explain Serialisation, UUID and its concepts?
>
----
95. Hashtable vs concurrent hashmap?
>
----
96. how linkedHashmap internal work?
>
----
97. What function is java 8 filter backend?
>
----
98. what is weak hashmap?
>
----
99. Where vs having in sql?
>
----
100. Why overloading?
>
----and Over loading concept?
>
----
101. Create outgoing service call from application?
>
----
102. is Synchronized block entire object?
>
----
103. explain Thread with caching?
>
----
104. how to Configure ehcache?
>

----
5explain Bean lifecycle?
> https://www.topcoder.com/thrive/articles/bean-scopes-and-lifecycle-spring

----

self:
1. how you identify which Asset type?
>
----
2. test your application
