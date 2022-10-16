Why is Java so Popular?
Two main reasons for popularity of Java are

Platform Independence
Object Oriented Language
We will look at these in detail in later sections.

What is Platform Independence?
This video (https://www.youtube.com/watch?v=lLgcgvIHyAw) explains Platform Independence in great detail. Refer to it for a more detailed answer.

core java interview questions related to jvm
Platform Independence is also called build once, run anywhere. Java is one of the most popular platform independent languages. Once we compile a java program and build a class file or a jar file, we can run the jar file or class file (compiled java program) in any Platform - where a JVM is installed.

Java achieves Platform Independence in a beautiful way. On compiling a java file the output is a class file - which contains an internal java representation called bytecode. JVM converts bytecode to executable instructions.

The executable instructions are different in different operating systems. So, there are different JVM's for different operating systems. A JVM for windows is different from a JVM for mac. However, both the JVM's understand the bytecode and convert it to the executable code for the respective operating system.

What are the important differences between C++ and Java?
Few differences between C++ and Java are listed below.

Java is platform independent. C++ is not platform independent.
Java is a pure Object Oriented Language (except for primitive variables). In C++, one can write structural programs without using classes and objects.
C++ has pointers (access to internal memory). Java has no concept called pointers.
In C++, programmer has to handle memory management. A programmer has to write code to remove an object from memory. In Java, JVM takes care of removing objects from memory using a process called Garbage Collection.
C++ supports Multiple Inheritance. Java does not support Multiple Inheritance.
What is the role for a ClassLoader in Java?
A Java program is made up of a number of custom classes (written by programmers like us) and core classes (which come pre-packaged with Java). When a program is executed, JVM needs to load the content of all the needed class. JVM uses a ClassLoader to find the classes.

Three Class Loaders are shown in the picture

java class loader
System Class Loader - Loads all classes from CLASSPATH
Extension Class Loader - Loads all classes from extension directory
Bootstrap Class Loader - Loads all the Java core files
When JVM needs to find a class, it starts with System Class Loader. If it is not found, it checks with Extension Class Loader. If it not found, it goes to the Bootstrap Class Loader. If a class is still not found, a ClassNotFoundException is thrown.

What are Wrapper Classes?
This video(https://www.youtube.com/watch?v=YQbZRw2yIBk) covers the topic in great detail. A brief description is provided below.

wrapper class interview questions
A primitive wrapper class in the Java programming language is one of eight classes provided in the java.lang package to provide object methods for the eight primitive types. All of the primitive wrapper classes in Java are immutable.

Wrapper : Boolean,Byte,Character,Double,Float,Integer,Long,Short
Primitive: boolean,byte,char,double, float, int , long,short
Wrapper classes are final and immutable. Examples of creating wrapper classes are listed below.

Integer number = new Integer(55);//int
Integer number2 = new Integer("55");//String

Float number3 = new Float(55.0);//double argument
Float number4 = new Float(55.0f);//float argument
Float number5 = new Float("55.0f");//String

Character c1 = new Character('C');//Only char constructor
//Character c2 = new Character(124);//COMPILER ERROR

Boolean b = new Boolean(true);

//"true" "True" "tRUe" - all String Values give True
//Anything else gives false
Boolean b1 = new Boolean("true");//value stored - true
Boolean b2 = new Boolean("True");//value stored - true
Boolean b3 = new Boolean("False");//value stored - false
Boolean b4 = new Boolean("SomeString");//value stored - false

b = false;
What are the different utility methods present in wrapper classes?
A number of utility methods are defined in wrapper classes to create and convert them from primitives.
valueOf Methods
Provide another way of creating a Wrapper Object
Integer seven =
Integer.valueOf("111", 2);//binary 111 is converted to 7

Integer hundred =
Integer.valueOf("100");//100 is stored in variable
YyyValue methods
YyyValue methods help in creating primitives
Integer integer = Integer.valueOf(57);
int primitive = seven.intValue();//57
float primitiveFloat = seven.floatValue();//57.0f

Float floatWrapper = Float.valueOf(57.0f);
int floatToInt = floatWrapper.intValue();//57
float floatToFloat = floatWrapper.floatValue();//57.0f
parseYyy methods
parseYyy methods are similar to valueOf but they return primitive values
int sevenPrimitive =
Integer.parseInt("111", 2);//binary 111 is converted to 7

int hundredPrimitive =
Integer.parseInt("100");//100 is stored in variable
static toString method
Look at the example of the toString static method below.
Integer wrapperEight = new Integer(8);
System.out.println(Integer.
toString(wrapperEight));//String Output: 8
Overloaded static toString method
2nd parameter: radix
System.out.println(Integer
.toString(wrapperEight, 2));//String Output: 1000
static toYyyString methods.
Yyy can be Hex,Binary,Octal
System.out.println(Integer
.toHexString(wrapperEight));//String Output:8
System.out.println(Integer
.toBinaryString(wrapperEight));//String Output:1000
System.out.println(Integer
.toOctalString(wrapperEight));//String Output:10
What is Auto Boxing?
Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.

Integer ten = new Integer(10);
ten++;//allowed. Java does had work behind the screen for us
Boxing and new instances
Auto Boxing helps in saving memory by reusing already created Wrapper objects. However wrapper classes created using new are not reused.
Two wrapper objects created using new are not same object.
Integer nineA = new Integer(9);
Integer nineB = new Integer(9);
System.out.println(nineA == nineB);//false
System.out.println(nineA.equals(nineB));//true
Two wrapper objects created using boxing are same object.
Integer nineC = 9;
Integer nineD = 9;
System.out.println(nineC == nineD);//true
System.out.println(nineC.equals(nineD));//true
Are all String’s immutable?
This video (https://www.youtube.com/watch?v=wh6L8zO_Hr4 ) covers all the topics related to String’s in great detail. Refer to it for more details.

Value of a String Object once created cannot be modified. Any modification on a String object creates a new String object.

String str3 = "value1";
str3.concat("value2");
System.out.println(str3); //value1
Note that the value of str3 is not modified in the above example. The result should be assigned to a new reference variable (or same variable can be reused).

String concat = str3.concat("value2");
System.out.println(concat); //value1value2
Where are string literals stored in memory?
All strings literals are stored in "String constant pool". If compiler finds a String literal,it checks if it exists in the pool. If it exists, it is reused.

Following statement creates 1 string object (created on the pool) and 1 reference variable.

String str1 = "value";
However, if new operator is used to create string object, the new object is created on the heap. Following piece of code create 2 objects.

//1. String Literal "value" - created in the "String constant pool"
//2. String Object - created on the heap
String str2 = new String("value");
Can you give examples of different utility methods in String class?
String class defines a number of methods to get information about the string content.

String str = "abcdefghijk";
Get information from String
Following methods help to get information from a String.
//char charAt(int paramInt)
System.out.println(str.charAt(2)); //prints a char - c
System.out.println("ABCDEFGH".length());//8
System.out.println("abcdefghij".toString()); //abcdefghij
System.out.println("ABC".equalsIgnoreCase("abc"));//true

//Get All characters from index paramInt
//String substring(int paramInt)
System.out.println("abcdefghij".substring(3)); //cdefghij

//All characters from index 3 to 6
System.out.println("abcdefghij".substring(3,7)); //defy
Explain about toString method in Java?
This video (https://www.youtube.com/watch?v=k02nM5ukV7w ) covers toString in great detail. toString method is used to print the content of an Object. If the toString method is not overridden in a class, the default toString method from Object class is invoked. This would print some hashcode as shown in the example below. However, if toString method is overridden, the content returned by the toString method is printed.

Consider the class given below:
class Animal {

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    String name;
    String type;

}
Run this piece of code:
Animal animal = new Animal("Tommy", "Dog");
System.out.println(animal);//com.rithus.Animal@f7e6a96
Output does NOT show the content of animal (what name? and what type?). To show the content of the animal object, we can override the default implementation of toString method provided by Object class.

Adding toString to Animal class
class Animal {

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    String name;
    String type;

    public String toString() {
        return "Animal [name=" + name + ", type=" + type
                + "]";
    }

}
Run this piece of code:
Animal animal = new Animal("Tommy","Dog");
System.out.println(animal);//Animal [name=Tommy, type=Dog]
Output now shows the content of the animal object.
What is the use of equals method in Java?
Equals method is used when we compare two objects. Default implementation of equals method is defined in Object class. The implementation is similar to == operator. Two object references are equal only if they are pointing to the same object.
We need to override equals method, if we would want to compare the contents of an object.
Consider the example Client class provided below.
class Client {
private int id;

    public Client(int id) {
        this.id = id;
    }
}
== comparison operator checks if the object references are pointing to the same object. It does NOT look at the content of the object.
Client client1 = new Client(25);
Client client2 = new Client(25);
Client client3 = client1;

//client1 and client2 are pointing to different client objects.
System.out.println(client1 == client2);//false

//client3 and client1 refer to the same client objects.
System.out.println(client1 == client3);//true

//similar output to ==
System.out.println(client1.equals(client2));//false
System.out.println(client1.equals(client3));//true
We can override the equals method in the Client class to check the content of the objects. Consider the example below: The implementation of equals method checks if the id's of both objects are equal. If so, it returns true. Note that this is a basic implementation of equals and more needs to be done to make it fool-proof.

class Client {
private int id;

    public Client(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Client other = (Client) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
Consider running the code below. Below code compares the values (id's) of the objects.
Client client1 = new Client(25);
Client client2 = new Client(25);
Client client3 = client1;

//both id's are 25
System.out.println(client1.equals(client2));//true

//both id's are 25
System.out.println(client1.equals(client3));//true
What are the important things to consider when implementing equals method?
Any equals implementation should satisfy these properties:
Reflexive. For any reference value x, x.equals(x) returns true.
Symmetric. For any reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
Transitive. For any reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
Consistent. For any reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, if no information used in equals is modified.
For any non-null reference value x, x.equals(null) should return false.
Let's now provide an implementation of equals which satisfy these properties:
//Client class
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Client other = (Client) obj;
if (id != other.id)
return false;
return true;
}
What is the hashCode method used for in Java?
HashCode's are used in hashing to decide which group (or bucket) an object should be placed into. A group of object's might share the same hashcode.

The implementation of hash code decides effectiveness of Hashing. A good hashing function evenly distributes object's into different groups (or buckets).

A good hashCode method should have the following properties:
If obj1.equals(obj2) is true, then obj1.hashCode() should be equal to obj2.hashCode()
obj.hashCode() should return the same value when run multiple times, if values of obj used in equals() have not changed.
If obj1.equals(obj2) is false, it is NOT required that obj1.hashCode() is not equal to obj2.hashCode(). Two unequal objects MIGHT have the same hashCode.
A sample hashcode implementation of Client class which meets above constraints is given below:
//Client class
@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + id;
return result;
}
What is Casting?
Casting is used when we want to convert on data type to another. There are two types of Casting:
Implicit Casting
Explicit Casting
What is Implicit Casting?
Implicit Casting is done by the compiler. Good examples of implicit casting are all the automatic widening conversions i.e. storing smaller values in larger variable types.
int value = 100;
long number = value; //Implicit Casting
float f = 100; //Implicit Casting
What is Explicit Casting?
Explicit Casting is done through code. Good examples of explicit casting are the narrowing conversions - storing larger values into smaller variable types. Explicit casting would cause truncation of value if the value stored is greater than the size of the variable.
long number1 = 25678;
int number2 = (int)number1;//Explicit Casting
//int x = 35.35;//COMPILER ERROR
int x = (int)35.35;//Explicit Casting
int bigValue = 280;
byte small = (byte) bigValue;
System.out.println(small);//output 24. Only 8 bits remain.
How are variables initialialized in Java?
Following are the important rules regarding variable initialisation in Java
Member and Static variables are always initialized with default values.
Default values for numeric types is 0, floating point types is 0.0, boolean is false, char is '\u0000' and object reference variable is null.
Local/block variables are NOT initialized by compiler.
If local variables are used before initialization, it would result in a compilation error.
package com.rithus.variables;

public class VariableInitialization {
public static void main(String[] args) {
Player player = new Player();

        //score is an int member variable - default 0
        System.out.println(player.score);//0 - RULE1
        
        //name is a member reference variable - default null
        System.out.println(player.name);//null - RULE1
        
        int local; //not initialized
        //System.out.println(local);//COMPILER ERROR! RULE3

        String value1;//not initialized
        //System.out.println(value1);//COMPILER ERROR! RULE3
        
        String value2 = null;//initialized
        System.out.println(value2);//null - NO PROBLEM.
    }
}
What is a nested if else? Can you explain with an example?
Look at the example below. The code in first if condition which is true is executed. If none of the if conditions are true, then code in else is executed.
int z = 15;
if(z==10){
System.out.println("Z is 10");//NOT executed
} else if(z==12){
System.out.println("Z is 12");//NOT executed
} else if(z==15){
System.out.println("Z is 15");//executed. Rest of the if else are skipped.
} else {
System.out.println("Z is Something Else.");//NOT executed
}

z = 18;
if(z==10){
System.out.println("Z is 10");//NOT executed
} else if(z==12){
System.out.println("Z is 12");//NOT executed
} else if(z==15){
System.out.println("Z is 15");//NOT executed
} else {
System.out.println("Z is Something Else.");//executed
}

What are Variable Arguments or varargs?
Variable Arguments allow calling a method with different number of parameters. Consider the example method sum below. This sum method can be called with 1 int parameter or 2 int parameters or more int parameters.

    //int(type) followed ... (three dot's) is syntax of a variable argument. 
    public int sum(int... numbers) {
        //inside the method a variable argument is similar to an array.
        //number can be treated as if it is declared as int[] numbers;
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        VariableArgumentExamples example = new VariableArgumentExamples();
        //3 Arguments
        System.out.println(example.sum(1, 4, 5));//10
        //4 Arguments
        System.out.println(example.sum(1, 4, 5, 20));//30
        //0 Arguments
        System.out.println(example.sum());//0
    }
What are Asserts used for?
Assertions are introduced in Java 1.4. They enable you to validate assumptions. If an assert fails (i.e. returns false), AssertionError is thrown (if assertions are enabled). Basic assert is shown in the example below

private int computerSimpleInterest(int principal,float interest,int years){
assert(principal>0);
return 100;
}
When should Asserts be used?
Assertions should not be used to validate input data to a public method or command line argument. IllegalArgumentException would be a better option. In public method, only use assertions to check for cases which are never supposed to happen.

What is Garbage Collection?
Garbage Collection is a name given to automatic memory management in Java. Aim of Garbage Collection is to Keep as much of heap available (free) for the program as possible. JVM removes objects on the heap which no longer have references from the heap.

Can you explain Garbage Collection with an example?
Let’s say the below method is called from a function.

void method(){
Calendar calendar = new GregorianCalendar(2000,10,30);
System.out.println(calendar);
}
An object of the class GregorianCalendar is created on the heap by the first line of the function with one reference variable calendar.

After the function ends execution, the reference variable calendar is no longer valid. Hence, there are no references to the object created in the method.

JVM recognizes this and removes the object from the heap. This is called Garbage Collection.

When is Garbage Collection run?
Garbage Collection runs at the whims and fancies of the JVM (it isn't as bad as that). Possible situations when Garbage Collection might run are

when available memory on the heap is low
when cpu is free
What are best practices on Garbage Collection?
Programmatically, we can request (remember it’s just a request - Not an order) JVM to run Garbage Collection by calling System.gc() method.

JVM might throw an OutOfMemoryException when memory is full and no objects on the heap are eligible for garbage collection.

finalize() method on the objected is run before the object is removed from the heap from the garbage collector. We recommend not to write any code in finalize();

What are Initialization Blocks?
Initialization Blocks - Code which runs when an object is created or a class is loaded

There are two types of Initialization Blocks

Static Initializer: Code that runs when a class is loaded.

Instance Initializer: Code that runs when a new object is created.

What is a Static Initializer?
Look at the example below:Code within static{ and } is called a static initializer. This is run only when class is first loaded. Only static variables can be accessed in a static initializer. Even though three instances are created static initializer is run only once.

public class InitializerExamples {
static int count;
int i;

    static{
        //This is a static initializers. Run only when Class is first loaded.
        //Only static variables can be accessed
        System.out.println("Static Initializer");
        //i = 6;//COMPILER ERROR
        System.out.println("Count when Static Initializer is run is " + count);
    }

    public static void main(String[] args) {
        InitializerExamples example = new InitializerExamples();
        InitializerExamples example2 = new InitializerExamples();
        InitializerExamples example3 = new InitializerExamples();
    }
}
Example Output
Static Initializer

Count when Static Initializer is run is 0

What is an Instance Initializer Block?
Let’s look at an example : Code within instance initializer is run every time an instance of the class is created.

public class InitializerExamples {
static int count;
int i;
{
//This is an instance initializers. Run every time an object is created.
//static and instance variables can be accessed
System.out.println("Instance Initializer");
i = 6;
count = count + 1;
System.out.println("Count when Instance Initializer is run is " + count);
}

    public static void main(String[] args) {
        InitializerExamples example = new InitializerExamples();
        InitializerExamples example1 = new InitializerExamples();
        InitializerExamples example2 = new InitializerExamples();
    }

}
Example Output

      Instance Initializer
      Count when Instance Initializer is run is 1
      Instance Initializer
      Count when Instance Initializer is run is 2
      Instance Initializer
      Count when Instance Initializer is run is 3

What are Regular Expressions?
Regular Expressions make parsing, scanning and splitting a string very easy. We will first look at how you can evaluate a regular expressions in Java – using Patter, Matcher and Scanner classes. We will then look into how to write a regular expression.

What is Tokenizing?
Tokenizing means splitting a string into several sub strings based on delimiters. For example, delimiter ; splits the string ac;bd;def;e into four sub strings ac, bd, def and e.

Delimiter can in itself be any of the regular expression(s) we looked at earlier.

String.split(regex) function takes regex as an argument.

Can you give an example of Tokenizing?
private static void tokenize(String string,String regex) {
String[] tokens = string.split(regex);
System.out.println(Arrays.toString(tokens));
}

tokenize("ac;bd;def;e",";");//[ac, bd, def, e]

How can you Tokenize using Scanner Class?
private static void tokenizeUsingScanner(String string,String regex) {
Scanner scanner = new Scanner(string);
scanner.useDelimiter(regex);
List<String> matches = new ArrayList<String>();
while(scanner.hasNext()){
matches.add(scanner.next());
}
System.out.println(matches);
}

tokenizeUsingScanner("ac;bd;def;e",";");//[ac, bd, def, e]
How do you add hours to a date object?
Lets now look at adding a few hours to a date object. All date manipulation to date needs to be done by adding milliseconds to the date. For example, if we want to add 6 hour, we convert 6 hours into millseconds. 6 hours = 6 * 60 * 60 * 1000 milliseconds. Below examples shows specific code.

Date date = new Date();

//Increase time by 6 hrs
date.setTime(date.getTime() + 6 * 60 * 60 * 1000);
System.out.println(date);

//Decrease time by 6 hrs
date = new Date();
date.setTime(date.getTime() - 6 * 60 * 60 * 1000);
System.out.println(date);
How do you format Date Objects?
Formatting Dates is done by using DateFormat class. Let’s look at a few examples.

//Formatting Dates
System.out.println(DateFormat.getInstance().format(
date));//10/16/12 5:18 AM
Formatting Dates with a locale

System.out.println(DateFormat.getDateInstance(
DateFormat.FULL, new Locale("it", "IT"))
.format(date));//marted“ 16 ottobre 2012

System.out.println(DateFormat.getDateInstance(
DateFormat.FULL, Locale.ITALIAN)
.format(date));//marted“ 16 ottobre 2012

//This uses default locale US
System.out.println(DateFormat.getDateInstance(
DateFormat.FULL).format(date));//Tuesday, October 16, 2012

System.out.println(DateFormat.getDateInstance()
.format(date));//Oct 16, 2012
System.out.println(DateFormat.getDateInstance(
DateFormat.SHORT).format(date));//10/16/12
System.out.println(DateFormat.getDateInstance(
DateFormat.MEDIUM).format(date));//Oct 16, 2012

System.out.println(DateFormat.getDateInstance(
DateFormat.LONG).format(date));//October 16, 2012
What is the use of Calendar class in Java?
Calendar class (Youtube video link - https://www.youtube.com/watch?v=hvnlYbt1ve0) is used in Java to manipulate Dates. Calendar class provides easy ways to add or reduce days, months or years from a date. It also provide lot of details about a date (which day of the year? Which week of the year? etc.)

How do you get an instance of Calendar class in Java?
Calendar class cannot be created by using new Calendar. The best way to get an instance of Calendar class is by using getInstance() static method in Calendar.

//Calendar calendar = new Calendar(); //COMPILER ERROR
Calendar calendar = Calendar.getInstance();
Can you explain some of the important methods in Calendar class?
Setting day, month or year on a calendar object is simple. Call the set method with appropriate Constant for Day, Month or Year. Next parameter is the value.

calendar.set(Calendar.DATE, 24);
calendar.set(Calendar.MONTH, 8);//8 - September
calendar.set(Calendar.YEAR, 2010);
Calendar get method
Let’s get information about a particular date - 24th September 2010. We use the calendar get method. The parameter passed indicates what value we would want to get from the calendar – day or month or year or .. Few examples of the values you can obtain from a calendar are listed below.

System.out.println(calendar.get(Calendar.YEAR));//2010
System.out.println(calendar.get(Calendar.MONTH));//8
System.out.println(calendar.get(Calendar.DATE));//24
System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));//4
System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));//39
System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//267
System.out.println(calendar.getFirstDayOfWeek());//1 -> Calendar.SUNDAY
What is the use of NumberFormat class?
Number format is used to format a number to different locales and different formats.

Format number Using Default locale
System.out.println(NumberFormat.getInstance().format(321.24f));//321.24        
Format number using locale
Formatting a number using Netherlands locale

System.out.println(NumberFormat.getInstance(new Locale("nl")).format(4032.3f));//4.032,3
Formatting a number using Germany locale

System.out.println(NumberFormat.getInstance(Locale.GERMANY).format(4032.3f));//4.032,3
Formatting a Currency using Default locale
System.out.println(NumberFormat.getCurrencyInstance().format(40324.31f));//$40,324.31
Format currency using locale
Formatting a Currency using Netherlands locale

System.out.println(NumberFormat.getCurrencyInstance(new Locale("nl")).format(40324.31f));//? 40.324,31


What are new features in Java 5?
New features in Java 5 are :

Generics
Enhanced for Loop
Autoboxing/Unboxing
Typesafe Enums
Varargs
Static Import
Concurrent Collections
Copy on Write
Compare and Swap
Locks
For more details about these new features, refer Core and Advanced Java Interview Questions.

What are the new features in Java 6?
Java 6 has very few important changes in terms of api’s. There are a few performance improvements but none significant enough to deserve a mention.

What are the new features in Java 7?
New features in Java 7 are :

Diamond Operator. Example : Map<String , List <Trade>> trades = new TreeMap <> ();
Using String in switch statements
Automatic resource management : try(resources_to_be_cleant){ // your code }
Numeric literals with underscores
Improved exception handling : Multiple catches in same block- catch(ExceptionOne | ExceptionTwo | ExceptionThree e)
File change notifications
What are the new features in Java 8?
New features in Java 8 are :

Lamda Expressions. Example : Runnable java8Runner = () -> { sop("I am running"); };
Nashorn : javascript engine that enables us to run javascript to run on a jvm
String.join() function
Streams


What are Generics?
Generics are used to create Generic Classes and Generic methods which can work with different Types(Classes).

Why do we need Generics? Can you give an example of how Generics make a program more flexible?
Consider the class below:

class MyList {
private List<String> values;

    void add(String value) {
        values.add(value);
    }

    void remove(String value) {
        values.remove(value);
    }
}
MyList can be used to store a list of Strings only.

        MyList myList = new MyList();
        myList.add("Value 1");
        myList.add("Value 2");
To store integers, we need to create a new class. This is problem that Generics solve. Instead of hard-coding String class as the only type the class can work with, we make the class type a parameter to the class.

Example with Generics
Let’s replace String with T and create a new class. Now the MyListGeneric class can be used to create a list of Integers or a list of Strings

class MyListGeneric<T> {
private List<T> values;

    void add(T value) {
        values.add(value);
    }

    void remove(T value) {
        values.remove(value);
    }

    T get(int index) {
        return values.get(index);
    }
}

MyListGeneric<String> myListString = new MyListGeneric<String>();
myListString.add("Value 1");
myListString.add("Value 2");

MyListGeneric<Integer> myListInteger = new MyListGeneric<Integer>();
myListInteger.add(1);
myListInteger.add(2);
How do you declare a Generic Class?
Note the declaration of class:Instead of T, We can use any valid identifier.

class MyListGeneric<T>
What are the restrictions in using generic type that is declared in a class declaration?
If a generic is declared as part of class declaration, it can be used any where a type can be used in a class - method (return type or argument), member variable etc. For Example: See how T is used as a parameter and return type in the class MyListGeneric.

How can we restrict Generics to a subclass of particular class?
In MyListGeneric, Type T is defined as part of class declaration. Any Java Type can be used a type for this class. If we would want to restrict the types allowed for a Generic Type, we can use a Generic Restrictions. Consider the example class below: In declaration of the class, we specified a constraint "T extends Number". We can use the class MyListRestricted with any class extending (any sub class of) Number - Float, Integer, Double etc.

class MyListRestricted<T extends Number> {
private List<T> values;

    void add(T value) {
        values.add(value);
    }

    void remove(T value) {
        values.remove(value);
    }

    T get(int index) {
        return values.get(index);
    }
}

MyListRestricted<Integer> restrictedListInteger = new MyListRestricted<Integer>();
restrictedListInteger.add(1);
restrictedListInteger.add(2);
String not valid substitute for constraint "T extends Number".

//MyListRestricted<String> restrictedStringList =
//                new MyListRestricted<String>();//COMPILER ERROR
How can we restrict Generics to a super class of particular class?
In MyListGeneric, Type T is defined as part of class declaration. Any Java Type can be used a type for this class. If we would want to restrict the types allowed for a Generic Type, we can use a Generic Restrictions. In declaration of the class, we specified a constraint "T super Number". We can use the class MyListRestricted with any class that is a super class of Number class.

Can you give an example of a Generic Method?
A generic type can be declared as part of method declaration as well. Then the generic type can be used anywhere in the method (return type, parameter type, local or block variable type).

Consider the method below:

    static <X extends Number> X doSomething(X number){
        X result = number;
        //do something with result
        return result;
    }
The method can now be called with any Class type extend Number.

Integer i = 5;
Integer k = doSomething(i);