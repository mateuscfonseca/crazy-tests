package hackerhank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BreakingRecords {
	
	static int[] breakingRecords(int[] scores) {
		int firstScore = scores[0];
		int min = firstScore, max = firstScore;
		int newMin = 0, newMax = 0;
		for(int i = 1;i < scores.length;i++) {
			int currentValue = scores[i];
			if(currentValue > max) {
				newMax++;
				max = currentValue;
			}
			else if(scores[i] < min) {
				newMin++;
				min = currentValue;
			}
		}
		int[] result = {newMax, newMin};
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];

		String[] scoresItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

		Arrays.stream(result).boxed().forEach(System.out::println);

		scanner.close();
	}
}
