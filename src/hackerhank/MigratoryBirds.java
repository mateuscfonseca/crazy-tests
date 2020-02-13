package hackerhank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MigratoryBirds {
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int record = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			int bird = arr.get(i);
			map.compute(bird, (k, v) -> v == null ? 1 : v + 1);
			if (map.get(bird) > map.get(record) || (map.get(bird) >= map.get(record) && bird < record)) {
				record = bird;
			}
		}

		return record;
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		int matches = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((ar[i] + ar[j]) % k == 0)
					matches++;
			}
		}
		return matches;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		List<Integer> ar = new ArrayList<>();

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar.add(arItem);
		}

		int result = migratoryBirds(ar);

		System.out.println(result);

		scanner.close();
	}
}
