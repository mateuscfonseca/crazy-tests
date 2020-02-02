package hackerhank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinMaxSum {

	static void miniMaxSum(long[] arr) {
		final int limit	= arr.length - 1;
		
		long minSum = 0, maxSum = 0;
		List<Long> integerList = Arrays
									.stream(arr)
									.boxed()
									.collect(Collectors.toList());
		
		minSum = integerList
					.stream()
					.sorted()
					.limit(limit)
					.reduce((acc, val) -> acc + val)
					.orElse(0l);
		
		maxSum = integerList
					.stream()
					.sorted(Comparator.reverseOrder())
					.limit(limit)
					.reduce((acc, val) -> acc + val)
					.orElse(0l);
		
		System.out.print(String.format("%d %d", minSum, maxSum));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long[] arr = new long[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}

}
