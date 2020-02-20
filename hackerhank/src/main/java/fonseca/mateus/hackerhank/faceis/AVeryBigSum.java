package fonseca.mateus.hackerhank.faceis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AVeryBigSum {
	static long aVeryBigSum(long[] ar) {
        return Arrays
                .stream(ar)
                .sum();              

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        int arCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        long[] ar = new long[arCount];
        long[] ar = {92562531231245632l,9256254131235632l,9256231231545632l,92562513212345632l,925623213545632l,9256123212545632l,31231231231231231l};
//        String[] arItems = scanner.nextLine().split(" ");
//
//        for (int i = 0; i < arCount; i++) {
//            long arItem = Long.parseLong(arItems[i]);
//            ar[i] = arItem;
//        }

        long result = aVeryBigSum(ar);
        
        System.out.println(result);

        scanner.close();
    }

}
