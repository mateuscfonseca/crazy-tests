package fonseca.mateus.hackerhank.faceis;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

	static int countingValleys(int n, String s) {
		s = s.toUpperCase();
		int valleysCount = 0;
		int altitude = s.charAt(0) == 'U' ? 1 : -1;
		int direction = altitude;
		for(int i = 1; i < n;i++) {
			switch(s.charAt(i)) {
				case 'U' : 
					altitude += 1;
					break;
				case 'D' : 
					altitude -= 1;
					break;		
				default:
					break;
			}
			if(altitude >= 0 && direction == -1) {
				valleysCount++;
				direction = 1;
			}
			else if(altitude < 0 && direction == 1) {
				direction = -1;
			}	
		}
		
		return valleysCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		System.out.println(result);

		scanner.close();
	}

}
