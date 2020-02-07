package hackerhank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class ArrayManipulation {
		
	static long arrayManipulation2(int n, int[][] queries) {
		AtomicLongArray array 	= new AtomicLongArray(new long[n]);
		AtomicLong atomicSum 	= new AtomicLong(0l);
		//int queriesSize 		= queries.length;
		
		Arrays
			.stream(queries)
			.parallel()
			.forEach(operationLine -> {
				synchronized (array) {
					int start 	= operationLine[0];			
					int end 	= operationLine[1];

					for (int j = start - 1; j < end; j++) {
						synchronized (atomicSum) {
							long newValue = array.get(j) + operationLine[2];
							array.set(j, newValue);
							if (newValue > atomicSum.get()) atomicSum.set(newValue);
						}						
					}
				}
			});
			
		return atomicSum.get();
	}
	
	static long arrayManipulation(int n, int[][] queries) {
		long[] array = new long[n];
		
		long biggerSum = 0l;
		int queriesSize = queries.length;

		for (int i = 0; i < queriesSize; i++) {

			int start 	= queries[i][0];
			int end 	= queries[i][1];

			for (int j = start - 1; j < end; j++) {
				array[j] = array[j] + queries[i][2];
				if (array[j] > biggerSum) biggerSum = array[j];	
			}
		}
		return biggerSum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine()
		        .split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine()
			        .split(" ");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);
		
		System.out.println(result);

		scanner.close();
	}

}
