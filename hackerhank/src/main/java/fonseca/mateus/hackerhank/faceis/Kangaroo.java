package fonseca.mateus.hackerhank.faceis;
import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {
	static String kangaroo(int x1, int v1, int x2, int v2) {
		
		boolean isPossible = false;
		
		for(int i = 1; i <= 10000; i++) {
			if(x1 < x2 && v1 <= v2) break;
			else if(x1 + (v1 * i) == x2 + (v2 * i)) {
				isPossible = true;
				break;
			}
		}
		
		return isPossible ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = 21;//Integer.parseInt(x1V1X2V2[0]);

        int v1 = 6;//Integer.parseInt(x1V1X2V2[1]);

        int x2 = 47;//Integer.parseInt(x1V1X2V2[2]);

        int v2 = 3;//Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);
        
        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

}
