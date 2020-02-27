package fonseca.mateus.hackerhank.medias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoard {

	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		
		List<Integer> scoresDistintas = Arrays.stream(scores).boxed().distinct().collect(Collectors.toList());
		Integer[] scoresd = new Integer[scoresDistintas.size()];
		
		for(int i = 0;i < scoresd.length; i++) {
			scoresd[i] = scoresDistintas.get(i);
		}
		
		List<Integer> aliceList = Arrays.stream(alice).boxed().collect(Collectors.toList());
		
		List<Integer> positions = new ArrayList<>();		
		
		for(Integer score : aliceList) {				
			int index = Arrays.binarySearch(scoresd, (int) score, Comparator.reverseOrder());
			if(index < 0) {
				index = Math.abs(index);				
				positions.add(index);
			} else {
				positions.add(index + 1);				
			}
		}
		
		
		return positions.stream().mapToInt(i -> i).toArray();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			scores[i] = scoresItem;
		}

		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);
		
		for(int v : result) {
			System.out.println(v);
		}

		scanner.close();
	}

}
