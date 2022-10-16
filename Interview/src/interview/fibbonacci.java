package interview;

public class fibbonacci {
    static int counter=0;
    public static void main(String[] args) {
        printFibbonacci(100);
    }
    static void printFibbonacci(int n){
        //0,1,1,2,3,5,8,13
        System.out.println(0);
        System.out.println(1);
        findFibbonci(0,1,n);
    }

    private static void findFibbonci(int i, int j,int n) {
        int k=i+j;
        if(counter<n) {
            System.out.println(k);
            counter++;
            i = j;
            j = k;
            findFibbonci(i, j, n);
        }
    }
}
