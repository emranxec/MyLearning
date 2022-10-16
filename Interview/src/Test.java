public class Test {

    public static void main(String[] args) {
	// write your code here
      //  Given an array of 0's and 1's in random order . Sepearate 0's on left side and 1's on right side of the array

       // ArrayList myNumbers= Arrays.asList(​​​0,1,1,0,0,1,1,1,1,0,0,0,1,0,0);
        //no build-in methods
        //solution 1
        //move all 0 in diffrent list
        //then merge two list
        //o(n)
        //

       // Array can be of four patterns
        // Increasing,
        // Decresing,
        // Increasing and Decreasing,
        // Decreasing and Increasing.
        // Given an array find which pattern it maches

        //{1,2,4,6,8,9} - ascendign
        //{1,4,6,8,3,1} - ascending and descending

        //solution 1
        //if 1st index is less than last index =increasing
        //if 1th index is more than last index =decreasing
        //
        int[] myIntArray = {1,4,6,8,9,10,11,12,13,14,3,1};

        int[] myIntArray1   = {1,4,6,8,9,10};
        int[] myIntArray1_1 = {1,4,6};
        int[] myIntArray1_2 = {8,9,10};

        int[] myIntArray2   = {11,12,13,14,3,1};
        int[] myIntArray2_1 = {11,12,13};
        int[] myIntArray2_2 = {14,3,1};

        //two comparisons
        //if sorted, 1st element >last =decending
        //if sorted, 1st element <last =ascending
        //biggest having next element then increasing and decreasing
        //else decreasing & increasing



        boolean isIncreasing=false;
        boolean isDecresing=false;
       for(int i=0;i<=myIntArray.length-1;i++){
           if(isIncreasing){
               if(myIntArray[i]<myIntArray[i+1]){
                   System.out.println("Increasing and Decreasing");
                   break;
               }
           }
           if(isDecresing){
               if(myIntArray[i]>myIntArray[i+1]){
                   System.out.println("Decreasing and Increasing");
                   break;
               }
           }
           if(myIntArray[i]>myIntArray[i+1]){
               isIncreasing=true;
           }
           if(myIntArray[i]<myIntArray[i+1]){
               isDecresing=true;
           }
       }

       if(isIncreasing) {
           System.out.println("increasing");
       }else{
           System.out.println("decreasing");
       }

    }


    //linkedList
    //find middle element
    //dont use size
    //com.xec.single loop

    //prevnode
    //value
    //nextNode


    //{}-{}-{}-{}-{}-{}-{}
    //         M
    //                   C
    //getLast
    //getFirst
    //
    //count=1
    //hashMap
    //travelers -count 1,copy the value
    //travelers -count 10,copy the value
    //hashmap
    //middleOne=null
    //getFirst0
    //getLAst0




}
