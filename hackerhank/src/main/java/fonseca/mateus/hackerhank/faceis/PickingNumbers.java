package fonseca.mateus.hackerhank.faceis;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PickingNumbers {

	static class Result {

		/*
		 * Complete the 'pickingNumbers' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts
		 * INTEGER_ARRAY a as parameter.
		 */

		public static int pickingNumbers(List<Integer> a) {
			a.sort(Comparator.naturalOrder());

			Integer current = a.get(0);

			int count = 1;

			int finalCount = 0;

			for (Integer value : a.subList(1, a.size())) {
				if (Math.abs(value - current) <= 1) {
					count++;								
				} else {
					count = 1;
					current = value;					
				}
				if (finalCount < count && count >= 2)
					finalCount = count;
			}

			return finalCount;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result.pickingNumbers(a);

		System.out.println(result);

		bufferedReader.close();
	}

}
