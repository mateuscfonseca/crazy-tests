package fonseca.mateus.hackerhank.faceis;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        return Arrays.stream(ar).boxed().reduce((acc, i) -> {return acc + i;}).orElse(0);
    }
    
    static int[] copyFrom(int[] ar, int begin, int end) {
    	if(ar.length < end || begin > end || begin < 0 || end < 0) throw new RuntimeException("wrong input");
    	if(begin == end) return ar;
    	int[] arr = new int[end - begin];
    	for(int i = begin; i < end;i++) 
    		arr[i - begin] = ar[i];
    	
    	return arr;
    }
     
    static int simpleArraySumR(int[] ar) {
    	if(ar.length == 1)
    		return ar[0];
    	else {    		
    		int[] arr = copyFrom(ar, 0, ar.length - 1);
    		return ar[ar.length - 1] + simpleArraySumR(arr);
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySumR(ar);
        
        System.out.println(String.format("O resultado foi %d", result));

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}