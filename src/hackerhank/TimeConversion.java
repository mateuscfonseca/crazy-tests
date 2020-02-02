package hackerhank;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TimeConversion {
	
	static String timeConversion(String s) {
		DateTimeFormatter in = DateTimeFormatter.ofPattern("hh:mm:ssa");
		DateTimeFormatter out = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		return out.format(in.parse(s));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        
        System.out.println(result);

        //bw.write(result);
        //bw.newLine();

        //bw.close();
    }

}
