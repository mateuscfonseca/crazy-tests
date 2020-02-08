package hackerhank;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DivisibleSumPairs {

	static int divisibleSumPairs2(int n, int k, int[] ar) {
		int[] m = new int[k];

		for (int i = 0; i < n; i++) {
			m[ar[i] % k]++;
		}
		int sum = 0;
		sum += (m[0] * (m[0] - 1)) / 2;
		for (int i = 1; i <= k / 2 && i != k - i; i++) {
			sum += m[i] * m[k - i];
		}
		if (k % 2 == 0)
			sum += (m[k / 2] * (m[k / 2] - 1)) / 2;
		return sum;
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

		int k = Integer.parseInt(nk[1]);

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = divisibleSumPairs2(n, k, ar);

		System.out.println(result);

		scanner.close();
	}

}
