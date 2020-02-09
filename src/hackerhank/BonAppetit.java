package hackerhank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BonAppetit {
	
	private static final String SUCCESS_MESSAGE = "Bon Appetit";
	
	 // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
    	int total = bill.stream().reduce((acc, v) -> acc + v).get();
    	int annaShare = (total - bill.get(k)) / 2;
    	
    	String message = annaShare == b ? SUCCESS_MESSAGE : String.format("%d", b - annaShare);
    	
    	System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }

}
