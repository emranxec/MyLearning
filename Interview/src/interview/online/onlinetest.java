package interview.online;

import java.util.ArrayList;
import java.util.List;

public class onlinetest {

    public static void main(String[] args){
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int operationsCount = Integer.parseInt(bufferedReader.readLine().trim());*/

        List<String> operations =new ArrayList<>();
/*        List<String> operations = IntStream.range(0, operationsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(Collectors.toList());*/

        //00L   ZBC
        //22L   ZBB
        //02R   ACC
        operations.add("00L");
        operations.add("22L");
        operations.add("02R");

        String result = Result.rollingString("abc", operations);
        System.out.println(result);

      /*  bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

class Result {

    /*
     * Complete the 'rollingString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING_ARRAY operations
     */

    public static String rollingString(String s, List<String> operations) {
        // Write your code here
        //      abc
        //00L   ZBC
        //22L   ZBB
        //02R   ACC

        //abc
        //a,b,c
        //operations
        char[] input=s.toCharArray();
        char[] newChar=new char[2];
        for(String op:operations){
            char[] ops=op.toCharArray();
            //00L
            for(int i=ops[0];i<=ops[1];i++){
                if(ops[2]=='R'){
                    newChar[i]=input[i];
                }
                if(ops[2]=='L'){
                    newChar[i]=input[i];
                }
            }
            input=newChar;
        }
        return new String(input);
    }

}

