package ayushi;

public class Ayushi {
    public static void main(String[] args) {
       ABC abc=ABC.getInstance();


    }
}


class ABC{
     static ABC abc=null;
     private ABC(){

     }

     static ABC getInstance(){
         if(abc==null){
             abc=new ABC();
         }
         return abc;
     }
}