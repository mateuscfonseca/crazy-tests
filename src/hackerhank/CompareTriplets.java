package hackerhank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompareTriplets {


	    // Complete the compareTriplets function below.
	    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
	    	if( (b.size() != a.size()) 
	    			|| (a.size() < 1)
	    				|| (a.size() > 100)) return new ArrayList<Integer>();
	    	
	    	Integer[] res = {0,0};
	    	
	    	for(int i = 0; i < a.size();i++) {
	    		int ca = a.get(i);
	    		int cb = b.get(i);
	    		if(ca == cb) continue;
	    		
	    		int winner = ca > cb ? 0 : 1;
	    		
	    		res[winner] += 1;
	    	}
	    	
	    	return Arrays.asList(res);
	    	
	    }

	    public static void main(String[] args) throws IOException {
	        Scanner scanner = new Scanner(System.in);
	        
	    	List<Integer> a = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

	        List<Integer> b = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
	        List<Integer> result = compareTriplets(a, b);
	        
	        System.out.println(result);
	        
	        scanner.close();

	    
	}


}
