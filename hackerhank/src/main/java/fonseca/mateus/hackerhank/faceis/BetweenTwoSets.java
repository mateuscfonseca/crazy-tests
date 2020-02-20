package fonseca.mateus.hackerhank.faceis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BetweenTwoSets {
	
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		int lowLimit = a.stream().max(Comparator.naturalOrder()).get();
		int highLimit = b.stream().min(Comparator.naturalOrder()).get() + 1;
		
		return (int) IntStream
							.range(lowLimit, highLimit)
							.boxed()
							.filter(candidate -> {
								return a.stream()
										.allMatch((aInt)-> candidate % aInt == 0);
							})
							.filter(candidate -> {
								return b.stream().allMatch((bInt) -> bInt % candidate == 0);
							})
							.count();
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		int total = getTotalX(arr, brr);
	}
}
