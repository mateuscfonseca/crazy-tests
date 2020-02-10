package hackerhank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiagonalDifference {

	static class Result {

		/*
		 * Complete the 'diagonalDifference' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts
		 * 2D_INTEGER_ARRAY arr as parameter.
		 */

		public static int diagonalDifference(List<List<Integer>> arr) {
			int dimension = arr.size();
			int leftToRight = 0;

			for(int i = 0; i < dimension;i++) {
				leftToRight += arr.get(i).get(i) - arr.get(i).get((dimension - 1) - i);
			}
			
			return Math.abs(leftToRight);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.diagonalDifference(arr);
		
		System.out.println(result);

		bufferedReader.close();

	}

}
