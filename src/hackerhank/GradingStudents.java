package hackerhank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class GradingStudents {
	static class Result {

		/*
		 * Complete the 'gradingStudents' function below.
		 *
		 * The function is expected to return an INTEGER_ARRAY. The function accepts
		 * INTEGER_ARRAY grades as parameter.
		 */

		public static List<Integer> gradingStudents(List<Integer> grades) {
			return grades.stream().map((grade) -> {
				if(grade < 38) return grade;
				
				int nextMultiple = ((grade / 5) + 1) * 5;
				int difference = nextMultiple - grade;
				
				if(difference <= 2) return nextMultiple;
				else return grade;
				
			}).collect(Collectors.toList());
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> result = Result.gradingStudents(grades);
		
		System.out.println(result);


		bufferedReader.close();
	}

}
