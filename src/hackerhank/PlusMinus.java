package hackerhank;

import java.util.Scanner;

public class PlusMinus {
	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int positive = 0, negative = 0, neutral = 0;
		
		for(int value : arr) {
			if(value >  0) 	positive++;
			if(value == 0) 	neutral++;
			if(value <  0) 	negative++;
		}
		
		double size = (double) arr.length;
		
		System.out.println(String.format("%.6f	\n%.6f	\n%.6f", 
											positive/size, 
												negative/size, 
												neutral/size));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

}
