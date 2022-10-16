// In this program, we will see how multiple functions are created with the same name,
// but the compiler decides which function to call easily at the compile time itself.
class CompileTimePolymorphism{
    // 1st method with name add
    public int add(int x, int y){
        return x+y;
    }
    // 2nd method with name add
    public int add(int x, int y, int z){
        return x+y+z;
    }
    // 3rd method with name add
    public int add(double x, int y){
        return (int)x+y;
    }
    // 4th method with name add
    public int add(int x, double y){
        return x+(int)y;
    }
}

class AnyVehicle{
    public void move(AnyVehicle anyVehicle){
        System.out.println("Any vehicle should move!!");
    }
}

class Bike extends AnyVehicle {
    public void move(Bike anyVehicle){
        System.out.println("Bike can move too!!");
    }
}

class ABC
{
    int x;

    ABC(int y)
    {
        x = y;
    }
    // Copy constructor
    ABC(ABC abc)
    {
        x = abc.x;
    }
}


class Scaler
{
    static int i;

    static
    {
        System.out.println("a");

        i = 100;
    }
}

class StaticBlock
{
   static
   {
       System.out.println("b");
   }

   public static void main(String[] args)
   {
       System.out.println("c");

       System.out.println(Scaler.i);
   }
}

class OOP{
    public static void main(String[] args){
        /*CompileTimePolymorphism demo=new CompileTimePolymorphism();
        // In the below statement, the Compiler looks at the argument types and decides to call method 1
        System.out.println(demo.add(2,3));
        // Similarly, in the below statement, the compiler calls method 2
        System.out.println(demo.add(2,3,4));
        // Similarly, in the below statement, the compiler calls method 4
        System.out.println(demo.add(2,3.4));
        // Similarly, in the below statement, the compiler calls method 3
        System.out.println(demo.add(2.5,3));*/

  /*      AnyVehicle vehicle = new Bike();
        // In the above statement, as you can see, the object vehicle is of type AnyVehicle
        // But the output of the below statement will be “Bike can move too!!”,
        // because the actual implementation of object ‘vehicle’ is decided during runtime vehicle.move();
      //  vehicle = new AnyVehicle();
        // Now, the output of the below statement will be “Any vehicle should move!!”,
        vehicle.move(new AnyVehicle());
        vehicle.move(new Bike());
*/

      /*  ABC abc=new ABC(new ABC(1));
        System.out.println(abc.x);*/

        printMissingNumber(new int[]{1, 2, 3, 5}, 4);
    }


    static void printMissingNumber(int[] nums,int n){
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++)
            sum -= nums[i];
        System.out.println(sum);

    }
}

/*
class Base {

    // Static method in base class which will be hidden in subclass
    public static void display() {
        System.out.println("Static or class method from Base");
    }

    // Non-static method which will be overridden in derived class
    public void print()  {
        System.out.println("Non-static or Instance method from Base");
    }
}

// Subclass
class Derived extends Base {

    // Static is removed here (Causes Compiler Error)
    public  void display() {
        System.out.println("Non-static method from Derived");
    }

    // Static is added here (Causes Compiler Error)
    public static void print() {
        System.out.println("Static method from Derived");
    }
}*/
