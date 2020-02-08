package hackerhank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.stream.IntStream;

public class ArrayManipulation {

	static long arrayManipulationParallel(int n, int[][] queries) {
		AtomicLongArray array = new AtomicLongArray(new long[n]);
		AtomicLong atomicSum = new AtomicLong(0l);

		Arrays.stream(queries).parallel().forEach(operationLine -> {
			synchronized (array) {
				int start = operationLine[0];
				int end = operationLine[1];

				IntStream.range(start - 1, end).parallel().forEach(j -> {
					synchronized (atomicSum) {
						long newValue = array.get(j) + operationLine[2];
						array.set(j, newValue);
						if (newValue > atomicSum.get())
							atomicSum.set(newValue);
					}
				});
			}
		});

		return atomicSum.get();
	}

	static long arrayManipulationParallelFast(int n, int[][] queries) {
		AtomicLongArray array = new AtomicLongArray(new long[n + 1]);
		AtomicLong atomicSum = new AtomicLong(0l);

		Arrays.stream(queries).parallel().forEach(operationLine -> {
			synchronized (array) {
				int start = operationLine[0];
				int end = operationLine[1];
				long newValue = array.get(start) + operationLine[2];
				array.set(start, newValue);
				if ((end + 1) <= n)
					array.getAndAdd(end + 1, -(operationLine[2]));

			}
		});
		AtomicLong accumulator = new AtomicLong(0l);
		IntStream.rangeClosed(0, n).parallel().forEachOrdered(i -> {
			synchronized (accumulator) {
				synchronized (array) {
					accumulator.getAndAdd(array.get(i));					
				}
				synchronized (atomicSum) {
					if (accumulator.get() > atomicSum.get()) {
						atomicSum.set(accumulator.get());
					}
				}
			}
		});

		return atomicSum.get();
	}

	static long arrayManipulationSemDoisLoops(int n, int[][] queries) {
		long[] array = new long[n + 1];

		long biggerSum = 0l;
		int queriesSize = queries.length;

		for (int i = 0; i < queriesSize; i++) {

			int start = queries[i][0];
			int end = queries[i][1];

			array[start] += queries[i][2];
			if ((end) + 1 <= n)
				array[end + 1] -= queries[i][2];
		}
		long x = 0;
		for (int i = 1; i <= n; i++) {
			x += array[i];
			if (x > biggerSum)
				biggerSum = x;
		}

		return biggerSum;

	}

	static long arrayManipulation(int n, int[][] queries) {
		long[] array = new long[n];

		long biggerSum = 0l;
		int queriesSize = queries.length;

		for (int i = 0; i < queriesSize; i++) {

			int start = queries[i][0];
			int end = queries[i][1];

			for (int j = start - 1; j < end; j++) {
				array[j] = array[j] + queries[i][2];
				if (array[j] > biggerSum)
					biggerSum = array[j];
			}
		}
		return biggerSum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulationSemDoisLoops(n, queries);

		System.out.println(result);

		scanner.close();
	}

}
