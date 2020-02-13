package hackerhank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DayOfTheProgrammer {
	// Complete the dayOfProgrammer function below.
//    static String dayOfProgrammer(int year) {
//    	
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        //String result = dayOfProgrammer(year);
        
        //System.out.println(result);
        
        int add = year == 1918 ? 13 : year % 4 == 0 ? -1 : 0;
        
        //LocalDate date = LocalDate.of(year, 1, 1).plusDays(255l + year == 1918 ? 13 : (year % 4 == 0 && year) ? -1 : 0);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        
        System.out.println(LocalDate.of(year, 1, 1).plusDays(255l + (year == 1918 ? 13l : (year % 4 == 0 && year < 2000 && year % 100 == 0) ? -1 : 0)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        bufferedReader.close();
    }
}
