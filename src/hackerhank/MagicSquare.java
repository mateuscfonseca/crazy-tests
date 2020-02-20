package hackerhank;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MagicSquare {
	static int[] paths(int pair) {
		int[] r = new int[2];
		if (pair / 2 == 1) {
			r[0] = 7;
			r[1] = 9;
		} else if (pair / 2 == 2) {
			r[0] = 3;
			r[1] = 9;
		} else if (pair / 2 == 3) {
			r[0] = 1;
			r[1] = 7;
		} else if (pair / 2 == 4) {
			r[0] = 1;
			r[1] = 3;
		}

		return r;
	}

	static int[] verifyPosition(int[] s) {
		Map<Integer, Integer> usedNumbers = new HashMap<>();

		int[] ss = Arrays.copyOf(s, 9);

		for (int i = 0; i < s.length; i++) {
			if (i == 4)
				continue;
			if ((i % 2 == 0 && ss[i] % 2 > 0) 
					|| (i % 2 > 0 && ss[i] % 2 == 0)) {
				ss[i] = 0;

			} else if (usedNumbers.containsKey(ss[i])) {
				int oldPosition = usedNumbers.get(ss[i]);
				usedNumbers.put(ss[i], i);
				ss[oldPosition] = 0;
				ss[i] = 0;
			} else {
				usedNumbers.put(ss[i], i);
			}
		}

		return ss;
	}

	static int sumLines(int offSet, int[] s) {
		return s[offSet] + s[offSet + 1] + s[offSet + 2];
	}

	static int biggerIndex(int offSet, int[] s) {
		int bigger = 0;
		for (int j = 0; j < 3; j++) {
			int current = offSet + j;
			if (s[current] > s[bigger])
				bigger = current;
		}
		return bigger;
	}

	static int lowerIndex(int offSet, int[] s) {
		int lower = 0;
		for (int j = 0; j < 3; j++) {
			int current = offSet + j;
			if (s[current] < s[lower])
				lower = current;
		}
		return lower;
	}

	static int[] removePlus(int[] s) {
		final int[] ss = Arrays.copyOf(s, 9);
		for (int i = 0; i < 3; i++) {
			int offSet = (i % 3) * 2;
			int sum = sumLines(offSet, ss);
			if (sum >= 15) {
				int bigger = biggerIndex(offSet, ss);
				ss[bigger] = 0;
				continue;
			} else if (sum <= 5) {
				int lower = lowerIndex(offSet, ss);
				ss[lower] = 0;
				continue;
			} else {
				i++;
			}
		}

		return ss;
	}

	static int[] combineReflections(int[] s) {
		int[] ss = Arrays.copyOf(s, 9);
		int end = s.length - 1;
		for (int i = 0; i < s.length / 2; i++) {
			int a = ss[i];
			int b = ss[end - i];
			if (a + b != 10 && (a > 0 || b > 0)) {
				if (a > 0)
					ss[end - i] = Math.abs(10 - a);
				else if (b > 0) {
					ss[i] = Math.abs(10 - b);
				}
			}
		}
		return ss;
	}

	static int[] rotateOdds(int[] s, int oddIndex) {
		int[] ss = Arrays.copyOf(s, 9);
		int odd = ss[oddIndex];
		int newOdd = ss[oddIndex + 2];
		ss[oddIndex] = newOdd;
		ss[oddIndex + 2] = odd;

		return ss;
	}

	static int[] normalizeCombination(int[] s) {
		int[] ss = Arrays.copyOf(s, 9);
		
		int sum = sumLines(0, ss);
		if(sum != 15) {
			ss = rotateOdds(ss, 1);
			sum = sumLines(0,ss);
		}
		
		if(sum != 15) {
			ss = rotateOdds(ss, 1);
		} else {
			ss = removePlus(ss);
			ss = combineReflections(ss);
		}
		
		sum = sumLines(6, ss);
		if(sum != 15) {
			ss = rotateOdds(ss, 5);
			sum = sumLines(0,ss);
		}
		
		if(sum != 15) {
			ss = rotateOdds(ss, 5);
		} else {
			ss = removePlus(ss);
			ss = combineReflections(ss);
		}		
		return ss;
	}
	
	static int[] addRemaning(int[] s) {
		List<Integer> ss = Arrays.stream(s).boxed().collect(Collectors.toList());
		
		Optional<Integer> firstMissing = IntStream
			.range(1, 10)
			.boxed()
			.filter(v -> ss.contains(v) == false)
			.limit(1)
			.findFirst();
		
		if(firstMissing.isPresent()) {
			int index = ss.indexOf(0);
			s[index] = firstMissing.get();
		}
		return s;
	}

	static int formingMagicSquare(int[][] s) {

		int[] ss = new int[9];
		int[] sss = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ss[j + i * 3] = s[i][j];
			}
		}
		
		sss = Arrays.copyOf(ss, 9);
		int count = Math.abs(5 - ss[4]);
		ss[4] = 5;

		ss = verifyPosition(ss);

		ss = removePlus(ss);
		ss = combineReflections(ss);
		ss = normalizeCombination(ss);
		
		ss = addRemaning(ss);
		
		ss = removePlus(ss);
		ss = combineReflections(ss);
		ss = normalizeCombination(ss);
		
		count += countDiffs(sss, ss);
		
		return count;
	}

	

	static int countDiffs(int[] s, int[] ss) {
		int count = 0;
		for(int i = 0;i < 9;i++) {
			count += Math.abs(s[i] - ss[i]);
		}
		return count;
	}

	static int formingMagicSquare2(int[][] s) {

		int[] ss = new int[9];
		int[] sss = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ss[j + i * 3] = s[i][j];
			}
		}
		List<Integer> quinas = IntStream.of(2, 4, 6, 8).boxed().collect(Collectors.toList());
		List<Integer> meios = IntStream.of(1, 3, 7, 9).boxed().collect(Collectors.toList());

		int count = Math.abs(5 - ss[4]);
		int bestMatch;

		bestMatch = quinas.stream()
				.reduce(quinas.get(0), (acc, val) -> Math.abs(ss[0] - val) < Math.abs(ss[0] - acc) ? val : acc)
				.intValue();
		sss[0] = bestMatch;
		count += Math.abs(bestMatch - ss[0]);
		quinas.removeIf(q -> q == sss[0]);
		bestMatch = 10 - bestMatch;
		sss[8] = bestMatch;

		int[] paths = paths(sss[0]);
		boolean isFirst = Math.abs(paths[0] - ss[1]) <= Math.abs(paths[1] - ss[1]);
		bestMatch = paths[isFirst ? 0 : 1];
		sss[1] = bestMatch;
		count += Math.abs(bestMatch - ss[1]);
		meios.removeIf(m -> m == sss[1]);
		bestMatch = 10 - sss[1];
		sss[7] = bestMatch;
		count += Math.abs(bestMatch - ss[7]);
		meios.removeIf(m -> m == sss[7]);

		bestMatch = quinas.stream().filter(q -> q == Math.abs(15 - sss[0] - sss[1])).findFirst().get();
		sss[2] = bestMatch;
		count += Math.abs(sss[2] - ss[2]);
		quinas.removeIf(q -> q == sss[2]);
		bestMatch = quinas.get(0);
		sss[6] = bestMatch;
		count += Math.abs(sss[6] - ss[6]);
		quinas.remove(0);

		bestMatch = meios.stream().filter(m -> m == 15 - sss[0] - sss[6]).findFirst().get();
		sss[3] = bestMatch;
		count += Math.abs(bestMatch - ss[3]);
		meios.removeIf(m -> m == sss[3]);
		bestMatch = 10 - sss[3];
		sss[5] = bestMatch;
		count += Math.abs(bestMatch - ss[5]);
		meios.removeIf(m -> m == sss[5]);

		System.out.println(sss);

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		System.out.println(result);

		scanner.close();
	}
}
