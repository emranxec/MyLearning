package company;

public class test1 {

    public static void main(String args[]) {
        Parent parent=new Parent(1);
        parent.newKm(2);
        parent.dispalyKm();
    }

}

class Parent{
int km;

Parent(int defaultKm){
    km=defaultKm;
}

void newKm(int newKm){
    this.km=newKm;
}

void dispalyKm(){
    System.out.println(km);
}

}

class Child extends Parent{
    int km;

    Child(int defaultKm){
        super(defaultKm);
        km=defaultKm;
    }

    void newKm(int newKm){
        newKm=newKm+3;
        this.km=newKm;
    }

    void dispalyKm(){
        System.out.println(km);
    }
}

