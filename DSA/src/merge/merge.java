package merge;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class merge {

    public static void main(String[] args) {
            int a[] = {1, 3, 5, 7}, b[] = {2, 4, 6, 8};
            int size = a.length;
            int size1 = b.length;

            // Function call
            mergeArrays(a, b, size, size1);
        }



    static void mergeArrays(int a[], int b[], int n, int m) {

        // Declaring a map.
        // using map as a inbuilt tool
        // to store elements in sorted order.
        Set<Integer> mp = new TreeSet<>();

        // Inserting values to a map.
        for (int i = 0; i < n; i++) {
            mp.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            mp.add(b[i]);
        }

        // Printing keys of the map.
        for (Integer i:mp) {
            System.out.print(" " + i);
        }
    }

}

    // Driver Code
