Java Design Patterns Interview Questions
Idea behind this article is to give an overview of Design Patterns and not really explain all the implementation details related to them. For me, understanding the basics of a design pattern is important. The implementation details are secondary. Implementation details can easily be looked up when needed if I understand the context in which a design pattern applies.

There are three different types of Design Patterns

# Design Patterns interview questions

Creational Patterns : Concerned with creation of Objects. Prototype, Singleton, Builder etc.
Structural Patterns : Concerned with structure of Objects and the relationships between them. Decorator, Facade, Adapter etc.
Behavioural Patterns : Concerned with interaction between objects. Strategy, Template Method etc.
Creational Patterns
Creational Patterns deal with creation of objects.

## “Creational"

### Prototype
Prototype is defined as “A fully initialized instance to be copied or cloned”. Let’s consider a Chess Game. At the start of the game, the way the pieces are arranged on a board is the same. Following strategy can be used in a chess program to setup a new game:

Create a fully initialized instance of a chess game with the correct positions for all pieces.This is the prototype.

Whenever there is a need to create a new chess game, clone or copy the initial chess game prototype.

### Builder
Builder pattern is usually used to hide the complexity of an object construction. Certain objects might have complex internal structure. Every time an instance is created, the entire structure needs to be created. It is a good practice to hide this complexity from the dependant objects. And that’s where the Builder pattern comes in.

Builder pattern is defined as “Separates object construction from its representation”.

Example : Consider a fast-food restaurant offering a Vegetarian Meal and a Non Vegetarian Meal. A typical meal is a burger and a cold drink. Depending on the type of the meal, the burger is a vegetarian burger or a chicken burger. The drink is either an orange juice or a pineapple juice. The below Builder class can be used to create meal objects.

public class MealBuilder {
public Meal buildVegMeal (){
Meal meal = new Meal();
meal.addItem(new VegetarianBurger());
meal.addItem(new OrangeJuice());
return meal;
}

public Meal buildNonVegMeal (){
Meal meal = new Meal();
meal.addItem(new ChickenBurger());
meal.addItem(new PineappleJuice());
return meal;
}
}

### Singleton
Singleton is defined as “A class of which only a single instance can exist (in a jvm). A good example of Singleton class in Java is java.lang.System.

If you are a Java guys, then these things might be useful:

Best way to implement Singleton is using a Enum. Refer “Effective Java” by Joshua Bloch.
JEE7 has inbuilt @Singleton annotation with @Startup, @PostConstruct and @DependsOn("other beans") options
Singletons make code difficult to unit test.
In Spring, all beans are singletons by default (in the scope of application context).
Structural
Structural patterns deal with the structure of objects and their relationships.

## “Structural

### Proxy
Proxy is defined as “An object representing another object”.

A good example of a proxy is a Debit Card. It represents the bank account but is really not the bank account itself. It acts as a proxy to our Bank Account.

EJB’s typically have two interfaces - Remote and Home. Home interface is a good example of a proxy.

### Decorator
Decorator is defined as “Add responsibilities to objects dynamically”.

Let’s take an example of a Pizza shop offering 10 types of Pizzas. Currently these are defined using an inheritance chain. All these 10 pizza types extend AbstractPizza class. Now, there is a new functionality requested - we would want to allow 3 different types of toppings for each of the pizza type. We have two options

Create 3 classes for each of the 10 pizza types resulting in a total of 30 classes.
Use a topping decorator on top of AbstractPizza class.
Usually the preference would be to use a decorator.

Good example for decorator is the Java IO Class Structure. To create a LineNumberInputStream we do something like LineNumberInputStream(BufferedInputStream(FileInputStream))). BufferedInputStream is a decorator for FileInputStream. LineNumberInputStream is a decorator for BufferedInputStream.

Disadvantage of Decorator is the resulting complexity in creating objects.

### Facade
Facade is defined as “A single class that represents an entire subsystem”.

A good example of facade in real life is an event manager. We approach an event manager to organize an event and they would take care of arranging everything related to the event - Decoration, Food, Invitations, Music Band etc.

Let’s consider an application taking online orders for books. Following steps are involved.

Check if there is stock and reserve the book.
Make payment.
Update stock
Generate invoice
Its preferred to create a facade called OrderService which takes care of all these steps. Facade also become a good place to implement transaction management.

Advantages of a Facade:

Reduced network calls
Reduced coupling
Helps in establishing transaction boundary
Adapter
Defined as “Match interfaces of different classes”. All the translators that we create to map one type of object to another type are good examples.

A good real life example would be Power Adapters.

## Behavioural
“Behavioural

### Chain of Responsibility
Defined as “A way of passing a request between a chain of objects”.

A good real time example is the Loan or Leave Approval Process. When a loan approval is needed, it first goes to the clerk. If he cannot handle it (large amount), it goes to his manager and so on until it is approved or rejected.

Another good example is Exception Handling in most programming languages. When an exception is thrown from a method with no exception handling, it is thrown to the calling method. If there is no exception handling in that method too, it is further thrown up to its calling method and so on. This happens until an appropriate exception handler is found.

### Iterator
Defined as “Sequentially access the elements of a collection”.

Different objects might have different internal representations. Iterator defines one way of looping through the objects in a list or a collection or a map, so that the internal complexities are hidden.

### Strategy
Defined as “Encapsulates an algorithm inside a class”.

Typically used to decouple the algorithm or strategy used from the implementation of the class so that the algorithm can be changed independent of the class.

A good example in Java is the Comparator interface. java.util.Comparator#compare()

### Observer
Defined as “A way of notifying change to a number of classes”.

A good example is Online Bidding. Different people can register as observers. They all are notified when there is a new bid.

If you are a Java programmer, Observer design pattern is already built for you. Look up the Observer interface and Observable class.

### Template Method
Defined as “Defer the exact steps of an algorithm to a subclass”.

Good example is a House Plan. A high level floor plan is provided first. Within a floor plan, the foundation, framing, plumbing, and wiring will be identical for each house. Variations for each house can be added in later - additional wing, wooden flooring/carpet, which color to paint.

Another example for Template Method is implementation of Spring AbstractController. The total flow is implemented by handleRequest method. However, subclasses can control the details by implementing the abstract method handleRequestInternal. (example simplified to focus only on necessary details)

@Override
public ModelAndView handleRequest(***) throws Exception {
// Delegate to WebContentGenerator for checking and preparing.
checkAndPrepare(request, response);

	HttpSession session = request.getSession(false);
	if (session != null) {
		Object mutex = WebUtils.getSessionMutex(session);
		return handleRequestInternal(request, response);
	}

	return handleRequestInternal(request, response);
}

protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
throws Exception;
Memento
Defined as “Capture and restore an object's internal state”.

In a number of games, we have the feature to do an intermediate save and return to it at a later point. Implementing this needs using the Memeto pattern. We save the state of the game at the intermediate point so that we can return back to it.

Another good example is the Undo / Redo Operations in text or image editing software. Software saves the intermediate state at various points so that we can easily return back to that state.

### Mediator
Defined as “Defines simplified communication between classes”.

A good example of Mediator is an Enterprise Service Bus. Instead of allowing applications to directly communicate with each other, they go through an ESB.

A good real life example is Air Traffic Controller. All the flights talk to ATC to decide the route to take. Imagine the chaos if each flight has to talk to all other flights to decide the route.
