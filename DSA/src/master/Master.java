package master;

import java.util.HashSet;

public class Master {

    public static void main(String[] args) {
        //findFirstOcc();

        stackPushPop();



    }

    private static void stackPushPop() {

        //top(value(Discord),next(Udemy)), bottom(value(google),next(null)),
        //top(value(Udemy),next(google)), bottom(value(google),next(null)),
        //top(value(google),next(null)), bottom(value(google),next(null)),

        Stack stack = new Stack();
        System.out.println(stack.push(new String("Google")));
        System.out.println(stack.push(new String("Udemy")));
        System.out.println(stack.push(new String("Discord")));
        System.out.println(stack.peek());
        System.out.println(stack.pop()?"removed":"didnt find any");
        System.out.println(stack.pop()?"removed":"didnt find any");
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


   class Node{
        Object value;
        Node Next;
        protected Object userObject = null;


        Node(Object value){
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

    class Stack{
        Node top;
        Node bottom;
        int length;


        public Stack() {
            this.top = null;
            this.bottom = null;
            this.length = 0;
        }

        Node peek(){
                return this.top;
        }

        Stack push(Object value){
            Node newNode=new Node(value);
            if(this.length==0){
                this.top=newNode;
                this.bottom=newNode;
            }else{
                Node holder=this.top;
                this.top=newNode;
                this.top.Next=holder;
            }
            this.length++;
            return this;
        }
        boolean pop(){
            if(this.top!=null){

                if(this.top==this.bottom){
                    this.bottom=null;
                }
                this.top=this.top.Next;
                this.length--;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "top=" + top +
                    ", bottom=" + bottom +
                    ", length=" + length +
                    '}';
        }
    }



