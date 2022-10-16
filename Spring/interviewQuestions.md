1. ### What is Dependency Injection?

  >  Most java classes are dependant on a large number of other classes. For example,a ClientService will depend on ClientDO to get the data from database. Before   Spring Framework, ClientService class would directly create an instance of ClientDO class by using code like “new ClientDO()” (in constructor, for example). This introduces tight coupling between ClientService and ClientDO. If I want ClientService to use some other data instead of that provided by ClientDO, we need to reimplement ClientService.
    This is where Spring framework comes in. It removes tight coupling between classes. In above example, Spring framework would inject ClientDO into ClientService class. This concept is called Dependency Injection or Inversion of Control.
    If needed ( when writing a unit test), we can ask Spring framework to inject a different class (which has same interface as ClientDO).
    Why is Spring one of the most popular Java related frameworks?
    Spring framework enables development of loosely coupled classes based on well defined interfaces (Dependency Injection and IOC). It makes writing testable code simple.
    Beauty of Spring framework is that it provides great integration support with other non Spring open source frameworks – In case you would want to integrate with frameworks like AspectJ (instead of Spring AOP) or Struts 2(instead of Spring MVC).
    Spring framework is built upon loosely coupled Spring modules enabling us to pick and choose the specific aspects of the Spring module we would like to use.
    This flexibility is what makes Spring framework one of most popular Java frameworks.

2. ###  What are the different modules in Spring Framework?

	![alt text](https://user-images.githubusercontent.com/16031518/196046587-e491db62-51af-4e7e-9981-21556744b3f4.png)
    
   > Spring Modules Interview Questions
    The Core package provides
    IoC
    Dependency Injection
    BeanFactory, an implementation of the factory pattern, helps us decouple configuration and injection of dependencies from program logic.
    The DAO package provides an abstraction over JDBC to simplify writing code that interacts with database. Declarative transaction management is an addition feature      provided by DAO package.
    The ORM package provides integration for Spring with most popular JPA implementations (Hibernate etc) and Query Mapping (iBatis).
    Spring AOP package provides a basic AOP implementation featuring definition of interceptors and pointcuts. Cross cutting concerns like security and transaction         management can be implemented using Spring AOP.
    Spring Web package provides
    multipart file-upload functionality
    Integration with Struts and other MVC Frameworks
    Spring's MVC package provides a clean implementation of the MVC model for web applications.
    
3. Can you give an overview of a web application that is implemented using Spring related Modules?
> Different Layers of a web application can be implemented using different spring modules. Beauty of Spring framework is that Spring provides great integration support with other non Spring open source frameworks – In case you would want to integrate with frameworks like AspectJ (instead of Spring AOP) or Struts 2(instead of Spring MVC).
Service & Business Layers
Core Business Logic using simple POJOs, managed by Spring's IoC container
Transaction Management using Spring AOP
Integration Layer
Spring ORM to integrate with Databases (JPA & iBatis).
Spring JMS to intergrate with external interfaces using JMS
Spring WS to consume web services.
Web Layer
Spring MVC to implement MVC pattern.
Spring WS to expose web services.

4. What is the simplest way of ensuring that we are using single version of all Spring related dependencies?
> Spring is made up of a number of small components (spring-core, spring-context, spring-aop, spring-beans and so on). One of the quirks of using Spring framework is the dependency management of these components. Simple way of doing this is using Maven "Bill Of Materials" Dependency.

```
<dependencyManagement>
<dependencies>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-framework-bom</artifactId>
<version>4.1.6.RELEASE</version>
<type>pom</type>
<scope>import</scope>
</dependency>
</dependencies>
</dependencyManagement> 
All spring dependencies can now be included in this and the child poms without using version.
<dependencies>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
</dependency>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-web</artifactId>
</dependency>
<dependencies>
```

5. What are the major features in different versions of Spring ?
    > Spring 2.5 made annotation-driven configuration possible.
    > Spring 3.0 made great use of the Java 5 improvements in language.
    > Spring 4.0 is the first version to fully support Java 8 features. 
    > Minimum version of Java to use Spring 4 is Java SE 6.

6. What are the latest specifications supported by Spring 4.0?
> Spring Framework 4.0 supports the Java EE 7 specifications
JMS 2.0
JTA 1.2
JPA 2.1
Bean Validation 1.1
JSR-236 for Concurrency.


7. Can you describe some of the new features in Spring 4.0?
> Following are some of the new features in Spring 4.0 and Spring 4.1
spring-websocket module provides support for WebSocket-based communication in web applications.
Spring Framework 4.0 is focused on Servlet 3.0+ environments
@RestController annotation is introduced for use with Spring MVC applications
Spring 4.1 introduces @JmsListener annotations to easily register JMS listener endpoints.
Spring 4.1 supports JCache (JSR-107) annotations using Spring’s existing cache configuration.
Jackson’s@JsonViewissupporteddirectlyon@ResponseBodyandResponseEntitycontroller methods for serializing different amounts of detail for the same POJO

8. What is auto-wiring?
> The Spring container can autowire dependencies into interacting beans. 
> Spring container can resolve dependencies by looking at the other beans defined in the ApplicationContext. 
> This elimates the need for maintaining an xml specifying beans and their dependencies. 
> Autowiring can be done byName (name of the property) and byType (type of the property).

9. What would happen in Spring Container finds multiple bean definitions matching the property to be auto wired?
> Spring framework does not resolve this kind of ambiguity. It would throw and exception. The programmer has the choice to remove one of the bean or explicitly wire in a dependency.

10. How is Spring’s Singleton bean different from Gang of Four Singleton Pattern?
> The singleton scope is the default scope in Spring. 
> The Gang of Four defines Singleton as having one and only one instance per ClassLoader. However, Spring singleton is defined as one instance of bean definition per container.

11.How do you represent Stateful bean in Spring?
> Stateful beans are represented in Spring with a prototype scope. A new instance is created every time a request for bean is made. Example below.

``` ￼<bean id="state" class="com.foo.SomeState" scope="prototype"/> ```

12. How do you use values defined in a property file in an application context xml?

> Following example shows how to configure a data source using the url, username and password configured in a property file (database-connection.properties)
```
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
<property name="locations" value="classpath:database-connection.properties"/>
</bean>
<bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
<property name="driverClassName" value="${jdbc.driverClassName}"/>
<property name="url" value="${jdbc.url}"/>
<property name="username" value="${jdbc.username}"/>
<property name="password" value="${jdbc.password}"/>
</bean>
```
13. How is validation done using Spring Framework?
> Spring validator can be used both in web and business layers to validate objects. 
> It is based on the org.springframework.validation.Validator interface having two important methods
 ``` 
supports(Class) – does this validator support a particular class
validate(Object, org.springframework.validation.Errors) – validates and sets errors into Errors object
 ```
An example is provided below: MessageCodesResolver can be used to convert the message code into proper internationalized text.
```
public class CarValidator implements Validator {
public boolean supports(Class clazz) {
return Car.class.equals(clazz);
}
public void validate(Object obj, Errors e) {
ValidationUtils.rejectIfEmpty(e, "name", "name.is.empty");
Car c = (Car) obj;
if (c.getUsedYears() < 0) {
e.rejectValue("usedYears", "not.yet.bought");
}
}
}
```
14. How do you implement cross cutting concerns in a web application?
> Functionality spanning multiple layers of an application are called cross cutting concerns. 
> Examples are logging, security, declarative transactions.
Cross cutting concerns are best implemented using Aspect Oriented Programming (AOP). 
AOP enables us to apply the cross cutting features across multiple classes.

15. What is an Aspect and Pointcut in AOP?
> Two important AOP concepts are
Aspect : Aspect is the concern that we are trying to implement generically. Ex: logging, transaction management. Advice is the specific aspect of the concern we are implementing.
Pointcut : An expression which determines what are the methods that the Advice should be applied on.

16. What are the different types of AOP advices?
> Before advice : Executed before executing the actual method.
After returning advice: Executed after executing the actual method.
After throwing advice : Executed if the actual method call throws an exception.
After (finally) advice : Executed in all scenarios (exception or not) after actual method call.
Around advice : Most powerful advice which can perform custom behavior before and after the method invocation.

17. How do you define transaction management for Spring – Hibernate integration?
> First step is to define a a transaction manager in the xml.

```
<bean id="transactionManager"
class="org.springframework.orm.hibernate3.HibernateTransactionManager"
p:sessionFactory-ref="sessionFactory" />
<tx:annotation-driven/>
Next, we can add the @Transactional annotation on the methods which need to part of a transactions.
@Transactional(readOnly = true)
public class CustomerDaoImpl implements CustomerDao {

```

18. How do you choose the framework to implement AOP - Spring AOP or AspectJ?
> Spring AOP is very simple implementation of AOP concepts. Its an ideal fit If the needs of an application are simple like
Simple method executions and/or
Advising the execution of operations only on spring beans
AspectJ is a full fledged AOP framework that helps you
Advise objects not managed by the Spring container .
Advise join points other than simple method executions (for example, field get or set join points).

19.What are the different mock objects provided by Spring test framework?
> org.springframework.mock.env package : Mock implementations of the Environment and PropertySource abstractions.
org.springframework.mock.jndi package : Implementation of the JNDI SPI, which can be used to create a simple JNDI environment for test suites.
org.springframework.mock.web package : Servlet API mock objects to test Spring MVC classes like controllers.

19. What are the utility methods available to test JDBC classes?
JdbcTestUtils provides the following static utility methods.
countRowsInTable(..) & deleteFromTables(..): counts/deletes the rows in the given table
countRowsInTableWhere(..) & deleteFromTableWhere(..): counts /deletes the rows in the given table, using the provided WHERE clause
dropTables(..): drops the specified tables

20. How do you setup a Session Factory to integrate Spring and Hibernate?
> Hibernate SessionFactory can be configured as a spring bean.

```

<bean id="mySessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">                
<property name="dataSource" ref="specificDataSource"/>
<property name="mappingResources">
<list>
<value>tablename.hbm.xml</value>
</list>
</property>
<property name="hibernateProperties">
<value>
hibernate.dialect=org.hibernate.dialect.HSQLDialect
</value>
</property>
</bean>
Datasource can be created from JNDI.
￼<beans>
<jee:jndi-lookup id=" specificDataSource " jndi-name="java:comp/env/jdbc/specificds"/>
</beans>
 ```
21. How do you implement caching with Spring framework?
> Enabling caching in Spring is all the matter of making the right annotations available in appropriate methods. First, we need to enable caching. This can be done using Annotation or XML based configuration. Below example shows enabling Spring based caching using Annotation.
```
@Configuration
@EnableCaching
public class AppConfig {
}
Next step is to add the annotations on the method we would like to cache results from.
@Cacheable("players")
public Player findPlayer(int playerId) {
...
}
Spring offers features to control caching
Conditional Caching : condition="#name.length < 32"
@CachePut : Update existing cache. For example, when player details cached above are updated.
@CacheEvict : Remove from cache. For example, the player is deleted.
Spring also provides integration with well known caching frameworks like EhCache. Sample xml configuration shown below.
<bean id="cacheManager"
class="org.springframework.cache.ehcache.EhCacheCacheManager" p:cache-manager-ref="ehcache"/>
<!-- EhCache library setup -->
<bean id="ehcache" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean" p:config-
location="ehcache.xml"/>

```

22. What are the important features of Spring Batch?
> Restartability : Easy to restart a batch program from where it failed
> Different Readers and Writers : Provides great support to read from JMS, JDBC, Hibernate, iBatis etc. It can write to JMS, JDBC, Hibernate and more.
> Chunk Processing : If we have 1 Million records to process, these can be processed in configurable chunks (1000 at a time or 10000 at a time).
> Easy to implement proper transaction management even when using chunk processing.
> Easy to implement parallel processing. With simple configuration, different steps can be run in parallel.

23. What are the important concepts related to setting up a Job in Spring Batch?
> A Job in Spring Batch is a sequence of Steps. Each Step can be configured with
next : next step to execute
tasklet : task or chunk to execute. A chunk can be configured with a Item Reader, Item Processor and Item Writer.
decision : Decide which steps need to executed.
What are the different ItemReader and ItemWriter implementations available with Spring Batch?
Important ones are those that allow to read/write from
Flat File
Hibernate Cursor
JDBC
JMS
Hibernate Paging
Stored Procedure

24. How do you start running a Spring Batch Job?
> A Job Launcher can be used to execute a Spring Batch Job. A job can be launched/scheduled in a web container as well.
Each execution of a job is called a Job Instance. Each Job Instance is provided with an execution id which can be used to restart the job (if needed).
Job can be configured with parameters which can be passed to it from the Job Launcher.
How do you configure parallel execution of steps with Spring Batch?
To execute jobs in parallel we can use a split. Example shows configuring a split. In below example, flow1 (step1 and step2 sequence) is executed in parallel with flow2 (step3). Step4 is executed after both flows are complete.
 
 ```
 
 <job id="job1">
    <split id="split1" task-executor="taskExecutor" next="step4">
    <flow>
    <step id="step1" parent="s1" next="step2"/>
    <step id="step2" parent="s2"/>
    </flow>
    <flow>
    <step id="step3" parent="s3"/>
    </flow>
    </split>
    <step id="step4" parent="s4"/>
    </job>

```

25. How does request flow happen in Spring MVC?
> Spring MVC Request Flow
Shown in the picture below. DispatcherServlet acts as the front controller. Simplified actions taken by DispatcherServlet are listed below.

All requests arrive at the DispatcherServlet (Front Controller) - STEP 0 in Figure
DispatcherServlet resolves theme and locale as configured.
Find’s appropriate Controller (Handler) to handle the request. (pre-processors and post-processors, if configured) (STEP 1)
Redirect to the Controller (Handler) - STEP 2. Controller executes the request and returns a view name and a view model object. (STEP 3,4,5)
DispatcherServlet resolves the view name and redirects to the view template. The response html is returned to DispatcherServlet. (STEP 6)
DispatcherServlet send the response back to the browser. (STEP 7)

26. Can you list a few advantages of using Spring MVC framework?
> In Spring Web MVC, any POJO can be used as a command or form-backing object.
Highly flexible databinding – If there is a type mismatch, it is shown as a validation error on the screen. Business POJO’s can directly be used as form-backing objects.
Flexible view resolution: Controller can either select a view name and prepare model map for it or write directly to response stream.
Supports JSP, Velocity and Freemarker view technologies.
Can directly generate XML, JSON, Atom, and many other types of content.
Highly convenient tag library.

27. Give examples of important Spring MVC annotations?
> Important Spring MVC annotations are listed below.

@Controller : This class would serve as a controller.
@RequestMapping : Can be used on a class or a method. Maps an url on the class (or method).
@PathVariable : Used to map a dynamic value in the url to a method argument.
Example 1 : Maps a url “/players “ for the controller method.

@RequestMapping(value="/players", method=RequestMethod.GET)
public String findAllPlayers(Model model) {
Example 2 : If a url /players/15 is keyed in, playerId is populated with value 15.

@RequestMapping(value="/players/{playerid}", method=RequestMethod.GET)
public String findPlayer(@PathVariable String playerId, Model model) {


28. Can you explain the concept of Interceptors in Spring MVC?
> Handler interceptors are used when you want to apply specific functionality to certain requests. Handler Interceptors should implement the interface HandlerInterceptor.

Three methods are defined:

preHandle(..) is called before the actual handler is executed;
postHandle(..) is called after the handler is executed;
afterCompletion(..) is called after the complete request has finished.
Interceptors can be configured using the interceptors property.

```

<bean id="handlerMapping" class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping">         
<property name="interceptors">
<list>
<ref bean="yourCustomHandlerInterceptor"/>
</list>
</property>
</bean>
```
29. How do you schedule tasks with Spring?
> Spring 3.0 introduced TaskScheduler abstract to deal with scheduling jobs. Spring has support for Timer (Jdk) and Quartz. Sample methods in the interface TaskScheduler are shown below:

ScheduledFuture scheduleAtFixedRate(Runnable task, long period);
ScheduledFuture scheduleWithFixedDelay(Runnable task, long delay);
Scheduling can also be done using an annotation
```
@Scheduled(fixedDelay=5000)
public void doSomething() {
// something that should execute periodically
}
```
Below example shows scheduling with xml configuration
```
<task:scheduler id="customScheduler" pool-size="30"/>
<task:scheduled-tasks scheduler=" customScheduler ">
<task:scheduled ref="someBean" method="someOtherMethod" fixed-delay="5000" initial-delay="1000"/>     
<task:scheduled ref="someOtherBean" method="someMethod" cron="*/5 * * * * MON-FRI"/>
</task:scheduled-tasks>
```
30. How do you integrate Spring MVC with tiles?
> Tiles helps us to define the layout for a web page. We can integrate Spring MVC with tiles by configuring TilesConfigurer and setting up appropriate view resolver.
```
    <bean id="tilesConfigurer"
    class="org.springframework.web.servlet.view.tiles2.TilesConfigurer"
    p:definitions="/WEB-INF/tiles-defs/templates.xml" />
    <bean id="tilesViewResolver"
    class="org.springframework.web.servlet.view.UrlBasedViewResolver"
    p:viewClass="org.springframework.web.servlet.view.tiles2.TilesView" />
    ```
31. How do you configure Spring MVC web application to use UTF-8 encoding for handling forms?
> Using org.springframework.web.filter.CharacterEncodingFilter. Shown below.
```
<filter>
    <filter-name>encoding-filter</filter-name>
    <filter-class>
        org.springframework.web.filter.CharacterEncodingFilter
    </filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encoding-filter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```
32. How do you enable spring security for a web application?
> Spring Security is used to implement Authentication and Authorization for a web application. We can enable spring security by configuring an appropriae security filter. Example shown below. We can create a separate security-context.xml to define the authentication and authorization roles and accesses.
```
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>
      org.springframework.web.filter.DelegatingFilterProxy
        </filter-class>
    </filter>
    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
33. What is a REST Web Service?
> There are a set of architectural constraints (we will discuss them shortly) called Rest Style Constraints. Any service which satisfies these constraints is called RESTful Web Service.

There are a lot of misconceptions about REST Web Services : They are over HTTP , based on JSON etc. Yes : More than 90% of RESTful Web Services are JSON over HTTP. But these are not necessary constraints. We can have RESTful Web Services which are not using JSON and which are not over HTTP.

34. What are important constraints for a RESTful Web Service?
The five important constraints for RESTful Web Service are

Client - Server : There should be a service producer and a service consumer.
The interface (URL) is uniform and exposing resources. Interface uses nouns (not actions)
The service is stateless. Even if the service is called 10 times, the result must be the same.
The service result should be Cacheable. HTTP cache, for example.
Service should assume a Layered architecture. Client should not assume direct connection to server - it might be getting info from a middle layer - cache.

35. What is Richardson Maturity Model?
> Richardson Maturity Model defines the maturity level of a Restful Web Service. Following are the different levels and their characteristics.

Level 0 : Expose SOAP web services in REST style. Expose action based services (http://server/getPosts, http://server/deletePosts, http://server/doThis, http://server/doThat etc) using REST.
Level 1 : Expose Resources with proper URI’s (using nouns). Ex: http://server/accounts, http://server/accounts/10. However, HTTP Methods are not used.
Level 2 : Resources use proper URI's + HTTP Methods. For example, to update an account, you do a PUT to . The create an account, you do a POST to . Uri’s look like posts/1/comments/5 and accounts/1/friends/1.
Level 3 : HATEOAS (Hypermedia as the engine of application state). You will tell not only about the information being requested but also about the next possible actions that the service consumer can do. When requesting information about a facebook user, a REST service can return user details along with information about how to get his recent posts, how to get his recent comments and how to retrieve his friend’s list.

36. What are the best practices in designing RESTful APIs?
> While designing any API, the most important thing is to think about the api consumer i.e. the client who is going to use the service. What are his needs? Does the service uri make sense to him? Does the request, response format make sense to him?
In Rest, we think Nouns (resources) and NOT Verbs (NOT actions). So, URI’s should represent resources. URI’s should be hierarchical and as self descriptive as possible. Prefer plurals.
Always use HTTP Methods. Best practices with respect to each HTTP method is described in the next question.

37. What are the best practices in using HTTP methods with Restful Web Services?
> GET : Should not update anything. Should be idempotent (same result in multiple calls). Possible Return Codes 200 (OK) + 404 (NOT FOUND) +400 (BAD REQUEST)
POST : Should create new resource. Ideally return JSON with link to newly created resource. Same return codes as get possible. In addition : Return code 201 (CREATED) is possible.
PUT : Update a known resource. ex: update client details. Possible Return Codes : 200(OK)
DELETE : Used to delete a resource.

38. Can you explain a little bit about JAX-RS?
> JAX-RS is the JEE Specification for Restful web services implemented by all JEE compliant web servers (and application servers).

Important Annotations:
```
@ApplicationPath("/"). @Path("users") : used on class and methods to define the url path.
@GET @POST : Used to define the HTTP method that invokes the method.
@Produces(MediaType.APPLICATION_JSON) : Defines the output format of Restful service.
@Path("/{id}") on method (and) @PathParam("id") on method parameter : This helps in defining a dynamic parameter in Rest URL. @Path("{user_id}/followers/{follower_id}") is a more complicated example.
@QueryParam("page") : To define a method parameter ex: /users?page=10.
Useful methods:

Response.OK(jsonBuilder.build()).build() returns json response with status code.
Json.createObjectBuilder(). add("id",user.getId()); creates a user object.
```
39. What are the advantages of Restful web services?
> Lightweight : Easy to consume from mobile devices also.
Easy to expose : Little or no restrictions on output format and communication protocol.
Most Restful services use HTTP protocol : Entire web is based on HTTP and is built for efficiency of HTTP. Things like HTTP caching enable Restful services to be effective.
High Performance : Less xml & soap overhead and More caching enable Restful services to be highly performant.

40. What is the difference between REST and SOAP Based Services?
> First of all, REST is a set of architectural principles defining how a RESTful service should look look like. SOAP is a message exchange format. SOAP defines the structure of message to exchanged. How should the header be? How should the request content be? So, there is no real comparison between REST and SOAP.

To get a real comparison, I compare two popular implementation of these concepts.

Restful Sample Implementation : JSON over HTTP
SOAP Sample Implementation : XML over SOAP over HTTP
All comparison is between the Sample Restful and SOAP implementations described above.

REST is built over simple HTTP protocol. SOAP services are more complex to implement and more complex to consume.
REST has better performance and scalability. REST reads can be cached, SOAP based reads cannot be cached.
REST permits many different data formats (JSON is the most popular choice) where as SOAP only permits XML.
SOAP services have well defined structure and interface (WSDL).
SOAP is based on well defined standards (WS-Security, WS-AtomicTransaction and WS-ReliableMessaging).
