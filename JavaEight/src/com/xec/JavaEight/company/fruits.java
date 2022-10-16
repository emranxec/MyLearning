package com.xec.JavaEight.company;


import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;

public class fruits {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();
        shop.addNewFruit("banana", 15, "imran", "kabir");
        System.out.println("displayAvailableFruits");

      /*  System.out.println("-----strategy pattern---start");
        boolean isSuccess = shop.displayAvailableFruits(a -> true);
        System.out.println("displayAvailableFruits price is 15");
        shop.displayAvailableFruits(a -> a == 15); // shop.displayFruitsByPrice(4);
        System.out.println("displayAvailableFruits price is greater than 4");
        shop.displayAvailableFruits(a -> a >= 40); // shop.displayFruitsByPriceMoreThen(4);
        System.out.println("-----strategy pattern---end");*/

        proxyPatternJava8(shop);


      /*  shop.displayFruitsByPrice(4);
        shop.displayFruitsByPriceMoreThen(4);
        shop.displayAveragePriceByFruit("banana");

        shop.displayAveragePriceforAvailableFruits();
        shop.displayCheaperFruit();
        shop.displayCostlyFruit();

        shop.displayFruitsByPriceCategory(3);
        shop.displayAllVendors();
        shop.displayAllVendorsAndFruits();
        shop.displayAllVendorsByFruit("apple");
        shop.displayAllFruitsAndVendorsByFruit("apple");
        shop.displayAllFruitsByVendor("Imran");

        shop.displayAllPricesOfSelectedFruit("apple");
        shop.displayChepestPrice("apple");
        shop.displayCAveragePrice("apple");*/



        //composed pattern
       /* Mailer.send(mailer ->
                mailer.from("Imran")
                        .to("salman")
                        .subject("hello")
                        .body("Hii")
        );*/


    }

    private static void proxyPatternJava8(Shop shop) throws InterruptedException {
        var isAvailable = new LazyProxy<>(() -> {
            boolean isFruitsAvailable = false;
            try {
                System.out.println("Lazy called");
                isFruitsAvailable = shop.displayAvailableFruits(a -> true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return isFruitsAvailable;
        });

        int x = 3;
        if (x > 4 && isAvailable.get()) {
            System.out.println("Everything is fine" + isAvailable.get());
        } else {
            System.out.println("somethingn is missing");
        }
    }

    static void recalculatePrice(Shop shop) throws InterruptedException {

        System.out.println(shop.getPrices());

    }
}

class LazyProxy<T> {
    private T instance;
    private Supplier<T> supplier;

    public LazyProxy(Supplier<T> theSupplier){
        supplier=theSupplier;
    }



    public T get(){
        System.out.println("get method called");
        if(instance==null){
            instance=supplier.get();
            supplier=null;
        }
        return instance;
    }
}

class FruitVendors {
    String vendorName;


    public FruitVendors(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "FruitVendors{" +
                "vendorName='" + vendorName + '\'' +
                '}';
    }
}

class Shop {
    String shopName;
    List<Fruit> fruits;
    BiFunction<Integer,List<Integer>,List<Integer>> calc;

    BiFunction<Integer,List<Integer>,List<Integer>> fruitDiscount=
            (discount, Prices) -> Prices.stream().map(fruitPrice -> fruitPrice-discount).collect(toList());

    BiFunction<Integer,List<Integer>,List<Integer>> addTax=
            (tax, Prices) -> Prices.stream().map(fruitPrice -> fruitPrice+tax).collect(toList());

    Shop(){
        createFruits();
    }


    public List<Fruit> createFruits() {
        fruits=new ArrayList<>();


        Fruit kashmiri=new Fruit("apple",50,getFruitVendors("Imran","Kabir"));
        Fruit orange=new Fruit("orange",40,getFruitVendors("Imran"));
        Fruit simla=new Fruit("apple",80,getFruitVendors("salman"));
        Fruit karnataka=new Fruit("apple",100,getFruitVendors("Imran"));
        Fruit orange1=new Fruit("orange",50,getFruitVendors("balvir"));
        Fruit maha=new Fruit("apple",120,getFruitVendors("kamal"));
        Fruit grapes=new Fruit("grapes",70,getFruitVendors("balvir"));
        Fruit grapes1=new Fruit("grapes",80,getFruitVendors("balvir"));




        fruits.add(kashmiri);
        fruits.add(orange);
        fruits.add(simla);
        fruits.add(karnataka);
        fruits.add(orange1);
        fruits.add(maha);
        fruits.add(grapes);
        fruits.add(grapes1);

        return fruits;
    }

    private List<FruitVendors> getFruitVendors(String... vendors) {
        List<FruitVendors> appleVendorList=new ArrayList<>();
        for(String vendor:vendors) {
            FruitVendors appleVendor = new FruitVendors(vendor);
            appleVendorList.add(appleVendor);
        }
        return appleVendorList;
    }

    void addNewFruit(String name, int price,String... vendors) throws InterruptedException {
        if(fruits.isEmpty()){
            System.out.println("No fruits available");
            fruits=new ArrayList<Fruit>();
        }
        Fruit newFruit=new Fruit(name,price,getFruitVendors(vendors));
        fruits.add(newFruit);
        System.out.println("new fruit added : " +newFruit.getName() +" price is " +newFruit.getPrice());
        displayAvailableFruits(a->true);
    }

    public boolean displayAvailableFruits(Predicate<Integer> selector) throws InterruptedException {
        //Thread.sleep(5000);
        System.out.println("they called me simply");

        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),mapping((Fruit::getPrice),filtering(selector,toList()))))));

        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),mapping((Fruit::getPrice),toList())))));
        Map<String, Set<List<FruitVendors>>> displayFruits=fruits.stream().collect(groupingBy(Fruit::getName,mapping(Fruit::getVendors,toSet())));



        System.out.println(displayFruits);
        return true;
    }


    public List<Integer> getPrices() throws InterruptedException {
        return fruits.stream().collect(mapping((Fruit::getPrice),toList()));
    }



    public void displayFruitsByPriceCategory(int price) {
        System.out.println("partition");
        System.out.println(fruits.stream().collect(mapping(Fruit::getPrice,partitioningBy(a->a>=price))));
        System.out.println("partition-ends");

    }
    public void displayCostlyFruit() {
        System.out.println("collectingAndThen");
        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),collectingAndThen(maxBy(Comparator.comparing(Fruit::getPrice)),ob->ob.map(Fruit::getPrice))))));
        System.out.println("collectingAndThen ends");

    }

    public void displayCheaperFruit() {
        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),collectingAndThen(minBy(Comparator.comparing(Fruit::getPrice)),ob->ob.map(Fruit::getPrice))))));
    }

    public void displayAveragePriceforAvailableFruits() {
        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),averagingInt(Fruit::getPrice)))));
    }

    public void displayAveragePriceByFruit(String fruit) {
        System.out.println(fruits.stream().collect(filtering(a->a.getName().equals(fruit),(groupingBy((Fruit::getName),averagingInt(Fruit::getPrice))))));
        System.out.println("partition by fruit");
        System.out.println(fruits.stream().collect(mapping(Fruit::getName,partitioningBy(a->a.toLowerCase().contains(fruit)))));

    }

    public void displayFruitsByPrice(int price) {
        System.out.println(fruits.stream().collect(filtering(a->a.price==price,(groupingBy((Fruit::getName),mapping((Fruit::getPrice),toList()))))));
    }

    public void displayFruitsByPriceMoreThen(int price) {
        System.out.println(fruits.stream().collect(groupingBy((Fruit::getName),mapping((Fruit::getPrice),filtering(myPrice-> myPrice>price,toList())))));
    }

    public void displayAllVendors() {
       fruits.stream().flatMap(fruit -> fruit.getVendors().stream()).collect(toList());
    }

    public void displayAllVendorsAndFruits() {
        System.out.println(fruits.stream().
                collect(
                        groupingBy(Fruit::getName,
                                flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(FruitVendors::getVendorName,
                                                toSet())))));
    }


    public void displayAllVendorsByFruit(String selected) {
        System.out.println("displayAllVendorsByFruit-------");
        System.out.println(fruits
                .stream()
                .filter(fruit -> fruit.getName().equals(selected))
                .flatMap(fruit -> fruit.getVendors().stream())
                .map(fruitVendors -> fruitVendors.getVendorName())
                .collect(toSet()));

        System.out.println("displayAllVendorsByFruit-------ends");
    }

    public void displayAllFruitsAndVendorsByFruit(String apple) {
        System.out.println(fruits.stream().
                filter(fruit -> fruit.getName().equals(apple))
                .collect(
                        groupingBy(Fruit::getName,
                                flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(FruitVendors::getVendorName,
                                                toSet())))));
    }

    public void displayAllFruitsByVendor(String vendor) {
        System.out.println("displayAllFruitsByVendor--start");

        System.out.println(fruits.stream()
                .collect(
                        groupingBy(Fruit::getName,
                                collectingAndThen(flatMapping(fruit -> fruit.getVendors().stream(),
                                        mapping(FruitVendors::getVendorName,
                                                toSet())),ob->ob.contains("imran")))));



        System.out.println(fruits.stream().collect((groupingBy((Fruit::getName),collectingAndThen
                (maxBy(Comparator.comparing(Fruit::getPrice)),
                        ob->ob.map(Fruit::getPrice))))));

        System.out.println("displayAllFruitsByVendor--end");





    }

    public void displayAllFruitsByVendorRedesign(String vendor) {
        System.out.println("displayAllFruitsByVendorRedesign--start");

        fruits.stream().collect(groupingBy(Fruit::getName,collectingAndThen(
                flatMapping(fruit -> fruit.getVendors().stream(),mapping(
                        FruitVendors::getVendorName,toSet())),ob->ob.contains("imran"))));


        System.out.println("displayAllFruitsByVendorRedesign--end");





    }


    public void displayAllPricesOfSelectedFruit(String apple) {
        System.out.println("displayAllPricesOfSelectedFruit---start");
        System.out.println(fruits.stream().filter(fruit -> fruit.getName().contains(apple)).map(Fruit::getPrice).collect(toList()));
        System.out.println("displayAllPricesOfSelectedFruit---end");

    }

    public void displayChepestPrice(String apple) {
        System.out.println("displayChepestPrice---start");
        System.out.println(fruits.stream().collect(filtering(fruit -> fruit.getName().contains(apple),minBy(Comparator.comparing(Fruit::getPrice)))));
        System.out.println("displayChepestPrice---end");
    }

    public void displayCAveragePrice(String apple) {
        System.out.println("displayCAveragePrice---start");
        System.out.println(fruits.stream().collect(filtering(fruit -> fruit.getName().contains(apple),averagingInt(Fruit::getPrice))));
        System.out.println("displayCAveragePrice---end");
    }
}
class Fruit{
    String name;
    int price;
    List<FruitVendors> vendors;


    public Fruit(String name, int price, List<FruitVendors> vendors) {
        this.name = name;
        this.price = price;
        this.vendors=vendors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<FruitVendors> getVendors() {
        return vendors;
    }

    public void setVendors(List<FruitVendors> vendors) {
        this.vendors = vendors;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vendors=" + vendors +
                '}';
    }
}





