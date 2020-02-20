package fonseca.mateus.hackerhank.faceis;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ApplesAndOranges {
	
	 // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
//    	if ((a < s) && (s < t) && (t < b) == false) throw new RuntimeException();
//    	if((1/Math.pow(10, 5) > ((double) d))) throw new RuntimeException();
    	int sartHouse 	= s, endHouse = t, applesPoint = a, orangesPoint = b;
    	int size 		= apples.length;
    	int applesSum, 
    			orangesSum = 0;
    	
    	applesSum = (int) IntStream.of(apples).map(distance -> distance + a).filter(distance -> distance >= s && distance <= t).count();
    	orangesSum = (int) IntStream.of(oranges).map(distance -> distance + b).filter(distance -> distance >= s && distance <= t).count();
    	
    	System.out.println(String.format("%d\n%d", applesSum, orangesSum));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }

}
