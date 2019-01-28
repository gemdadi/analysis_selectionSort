import java.io.File;
import java.io.FileWriter;

/**
     * SortMain class to create 10 different sets 
     * Create new instance benchmarkSorts to send 10 sets
     */

public class SortMain {

    // create 10 different sizes of data sets. 
    //n becomes large
	// call instance of benchmarkStors class

    public static void main(String[] args) throws Exception{

        int[] sizes = {100, 200, 390, 555, 610, 700, 843, 990, 1000, 2020} ;

        System.out.println("| Average Critical Operation Count | " +
        		"Standard Deviation of Count | " +
        		"Average Execution Time  | " +
        		"Standard Deviation of Time |");
        
        
        
        new BenchmarkSorts(sizes);
        
        
        
      }

}
