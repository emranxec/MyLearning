package master;

import java.util.ArrayList;
import java.util.HashSet;

public class StackwithArrayList {

    public static void main(String[] args) {
        //findFirstOcc();

        stackPushPop();



    }

    private static void stackPushPop() {

        //top(value(Discord),next(Udemy)), bottom(value(google),next(null)),
        //top(value(Udemy),next(google)), bottom(value(google),next(null)),
        //top(value(google),next(null)), bottom(value(google),next(null)),

        Stack1 stack = new Stack1();
        System.out.println(stack.push(new String("Google")));
        System.out.println(stack.push(new String("Udemy")));
        System.out.println(stack.push(new String("Discord")));
        System.out.println(stack.peek());
        System.out.println(stack.pop()?"removed":"didnt find any");
        System.out.println(stack);
        System.out.println(stack.pop()?"removed":"didnt find any");
        System.out.println(stack);
        System.out.println(stack.pop()?"removed":"didnt find any");
        System.out.println(stack);
    }

    private static void findFirstOcc() {
        int[] findFirstRec = {2, 3, 4, 2, 1, 2, 4, 5};

        HashSet<Integer> dup = new HashSet<>();
        for (int element : findFirstRec) {
            if (!dup.contains(element)) {
                dup.add(element);
            } else {
                System.out.println(element);
                break;
            }
            // System.out.println(dup);
        }
        System.out.println("not found");
    }

}


class Node1{
    Object value;
    Node1 Next;
    protected Object userObject = null;


    Node1(Object value){
        this.value=value;
        this.Next=null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", Next=" + Next +
                ", userObject=" + userObject +
                '}';
    }
}

class Stack1{
    ArrayList<Node1> nodeList;
    public Stack1() {
        nodeList=new ArrayList<>();
    }

    Node1 peek(){
        return nodeList.get(nodeList.size()-1);
    }

    Stack1 push(Object value){
        Node1 newNode=new Node1(value);
        nodeList.add(newNode);
        return this;
    }
    boolean pop(){
        if(nodeList.size()!=0){
            nodeList.remove(nodeList.size()-1);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Stack1{" +
                "nodeList=" + nodeList +
                '}';
    }
}



