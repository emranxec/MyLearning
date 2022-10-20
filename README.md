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

```
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

3. remove duplicate using streams?

> You can use the Stream.distinct() method to remove duplicates from a Stream in Java 8 and beyond.
> The distinct() method behaves like a distinct clause of SQL, which eliminates duplicate rows from the result set.

```
List<Integer> withDupes = Arrays.asList(10, 10, 20, 20, 30, 30, 40, 50); 
System.out.println("List with duplicates: " + withDupes); 
List<Integer> withoutDupes = withDupes.stream() .distinct() .collect(Collectors.toList());
```

4. design patterns in spring?

> [design patterns](https://github.com/emranxec/MyLearning/blob/master/designPattern/interviewQuestions.md)

> ## Singleton Pattern
    The singleton pattern is a mechanism that ensures only one instance of an object exists per application. This pattern can be useful when managing shared resources or providing cross-cutting services, such as logging.

### Singleton Beans
> Generally, a singleton is globally unique for an application, but in Spring, this constraint is relaxed. Instead, Spring restricts 
a singleton to one object per Spring IoC container. In practice, this means Spring will only create one bean for each type per application context.

### Autowired Singletons
> we can create two controllers within a single application context and inject a bean of the same type into each.
> First, we create a BookRepository that manages our Book domain objects.
> Next, we create LibraryController, which uses the BookRepository to return the number of books in the library
> In the application output, we see that both BookRepository objects have the same object ID
> NOTE: We can create separate instances of the BookRepository bean by changing the bean scope from singleton to prototype using the @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation.

## Factory Method Pattern

### Application Context
> Spring uses this technique at the root of its Dependency Injection (DI) framework.
Fundamentally, Spring treats a bean container as a factory that produces beans.
Thus, Spring defines the BeanFactory interface as an abstraction of a bean container:
```
public interface BeanFactory {

    getBean(Class<T> requiredType);
    getBean(Class<T> requiredType, Object... args);
    getBean(String name);

    // ...
]
```

>Each of the getBean methods is considered a factory method, which returns a bean matching the criteria supplied to the method, like the bean's type and name.
Spring then extends BeanFactory with the ApplicationContext interface, which introduces additional application configuration. 

## Proxy Pattern

### Transactions
> To create a proxy, we create an object that implements the same interface as our subject and contains a reference to the subject.
We can then use the proxy in place of the subject.
In Spring, beans are proxied to control access to the underlying bean. We see this approach when using transactions:
```
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

### JdbcTemplate
> The JdbcTemplate class provides the query method, which accepts a query String and ResultSetExtractor object:
```
public class JdbcTemplate {

    public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
        // Execute query...
    }

    // Other methods...
}
```

> The ResultSetExtractor converts the ResultSet object — representing the result of the query — into a domain object of type T:
```
@FunctionalInterface
public interface ResultSetExtractor<T> {
T extractData(ResultSet rs) throws SQLException, DataAccessException;
}
```

>Spring further reduces boilerplate code by creating more specific callback interfaces.
For example, the RowMapper interface is used to convert a single row of SQL data into a domain object of type T.

```
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


5. how to connect DB from spring?


6. 
7.  Map vs flatMap?
8.  what is singleton, factory pattern,builder pattern ?
9.  what is Azure function?
10. Azure kubernate?
11. what is responsive UI in JS?
12. what is Serverless computing?
11. what is java steams?
12. what factory class java having?
13. flow of Spring MVC?
14. How you test json implementation?
15. Explain MVC architectute?
16. how to process: 10000 request handling at once & persist inDB
17. what is SAAS?
18. what is Transactions in Spring?
19. explain Transactions in hibernate?
20. explain RESTFUL FLOW ?
21. what are RESTFUL annotations?
22. Explain microservices?
23. What DB model is prefered in microservice architecture?
24. What is @autowire usage?
25. Explain how to create user defined annotations ?
26. How many ways to connect DB from Hibernate & Spring ?
27. what are Microservices design patterns?
28. SQL queries with Functions & stored procedures
29. Basic packages requires to create spring boot application
30. What inbuilt server spring uses?
31. explain Spring security?
32. expalin Dirty - Hibernate?
33. why String immutable ?
34. how to configure Spring & hibernate?
35. what is Class not found and No class def error?
36. is static method override possible?
37. explain save,update, save and persist methods?
38. how to convert data in rest response in spring?
39. when to used native query & hibernate query?
40. what is criteria in hibernate ?
42. why jquery over javascript ?
43. what is bootstrap
44. what is service layer in Spring
45. Do we need DAO layer if we have Service layer
46. String vs String builder
47. What is docker
48. How to configure CI/CD process
49. expain Flow of Rest
50. what is functional interface
51. what is @Transactional in DB
52. explain Design patterns any
53. what is default spring bean status?
54. what is scope of hibernate attribute
55. Why concurrent HashMap used?
56. can two threads update in concurrent HashMap?
57. how you validate the request param and path param Done in spring
58. update vs merge?
59. at what time/place rollback gets called?
60. Microservice design pattern atleast 10
61. How to convert monolithic application to microservices
62. explain security handling
63. expalin hibernate entity states
64. what are diff types of garbage collector
65. jdbc versus hibernate
66. explain @mappedBy
67. explain hibernate criteria
68. explain hibernate caching
69. MQS
70. Java 8 - functional interface
71. Garbage collectors
72. Different method of garbage collector
73. How to configure techniques of JVM
74. Why to serialize a object
75. Reflaction API
76. How to serialize and deserialize object
77. Function vs bifunction
78. Mapping vs flat mapping
79. what are Design principles
80. explain Classnotfound, NoClassDefError,StackOverFlow,OOM
81. explain Microservice framework Netflix
82. diffrence between @Primary & @Qualifier
83. Spring global exceptions
84. Controller vs rest controlled
85. Spring actuators
86. Different types of class loaders
87. explain Hibernate inheritance
88. Why microservices?
89. Sort hashmap on basis of value.
90. what if we have a mutable instance in your immutable class such as Date?
91. in private constructor of your immutable class always
92. create a new instance of mutable field
93. and in getter always return a new instance of mutable field
94. explain Serialisation, UUID and its concepts
95. Hashtable vs concurrent hashmap
96. how linkedHashmap internal work
97. What function is java 8 filter backend?
98. what is weak hashmap
99. Where vs having in sql
100. Why overloading?and Over loading concept
101. Create outgoing service call from application
102. is Synchronized block entire object?
103. explain Thread with caching
104. how to Configure ehcache
105. Function vs procedures
106. explain Bean lifecycle
107. explain Maven in detail
108. explain Pom.xml in detail
109. Why to overide run in springApplication?
110. try with resources vs try with finally?
111. how to manage two different session factory?
112. what are Different library for hibernate,spring & SQI
113. What data structure does Executer service hold
114. Load a file and do operations
115. what is docker?
116. what is @Transactional
117. what is default spring bean status?
118. can two threads updated concurrent hashmap?
119. how to validate request param and path param in spring?
120. how many ways to connect DB from spring and hibernate?
121. how to configure techniques of JVM
122. why serialize a object?
123. what is reflaction API?
124. what are diffrent types of class loader?
125. what is spring global exception?
126. can mutable object is instance of immutable class? how to fix?
127. can private constructer of immutable class always create a new object of mutable instance?
128. getter of immutable class always return a new object of mutable instance?
129. linkedhashmap internal works?
130. write code to hit new api request from your code?
131. what data structure does executer service hold?
132. load a big trnsactional file and fetch the trnasction records using best data structures?

self:
1. how you identify which Asset type?
2. test your application
