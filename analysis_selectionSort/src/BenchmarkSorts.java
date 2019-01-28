/**
     * BenchmarkSorts class calculate Average Critical Operation Count, Standard Deviation of Count, Average Execution Time,Standard Deviation of Time
     * reference http://www.dummies.com/education/math/statistics/how-to-calculate-standard-deviation-in-a-statistical-data-set/
     * 
     */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkSorts {
	
	//Identify variables 
	YourSort yourSort = new YourSort();
	
	
    int [] array;

    int counterIteration = 0;

    int counterRecursive = 0;

    long iterativeTime, recursiveTime;

    int runIteration = 0;  //  counting run activity of sets for iteration

    int runRecursion = 0;  // counting run activity of  sets  for recursion

    long [] iterativeTimeSet = new long[50];// array of executed times of iterative sort

    long []recursiveTimeSet = new long[50]; // array of executed times of recursive sort
    
    int [] iterativeCountSet = new int [50]; // array of counted operations of iterative sort

    int [] recursiveCountSet = new int [50]; // array of counted operations of recursive sort


    int set;

 
    /**
     * Constructs BenchmarkSorts
     * Create new instance benchmarkSorts
     */

    public BenchmarkSorts (int[] sizes)throws Exception{

     

        for (int t = 0; t < sizes.length; t++){

            set = sizes[t];

            BenchmarkSorts benchmark = new BenchmarkSorts(set);         

        }

       

}
    /**
     * Constructs BenchmarkSorts
     * create random 50 numbers for each set and call runSort method, 
     * and call displayReport to show calculated record
     */

    public BenchmarkSorts (int set) throws Exception{

    	
        for (int i = 1; i < 50; i++){

            array = new int [set];

            for (int j = 0; j < set; j++){ // randomly generate data to pass to the sorting methods.

                Random random = new Random();

                array[j] = (random.nextInt(2021)); // numbers are less than 2021 because set size range is less than and equal  2020
               
               

            }

            
            runSorts();

        }

        displayReport(set);
        
    }

    /**
     *  runSorts method
     * calculating execution time and operation count for all sets
     */

	public void runSorts() throws Exception{

     int getCount; long getTime;

      int [] iterativeArray = array;

      int [] recursiveArray = array;
      
      //find iteration time and operation count to calculate Average and Standard Deviation

      yourSort.iterativeSort(iterativeArray);

      getCount = yourSort.getCount(); // total comparison for sorting both iteration and recursion

      getTime = yourSort.getTime();  // total time for both recursion and iteration

      counterIteration = counterIteration + getCount; // add each set elements operations

      iterativeTime = iterativeTime + getTime; // // add each set elements execution time 

      iterativeCountSet[runIteration] = getCount; 

      iterativeTimeSet[runIteration] = getTime;

      runIteration++; // how many run action is happened for iteration

  
    //find recursive time and counter to calculate Average and Standard Deviation

      yourSort.recursiveSort(recursiveArray);

      getCount = yourSort.getCount();

      getTime = yourSort.getTime();

      counterRecursive = counterRecursive + getCount;

      recursiveTime = recursiveTime + getTime;

      recursiveCountSet[runRecursion] = counterRecursive;

      recursiveTimeSet[runRecursion] = recursiveTime;

      runRecursion++;    // how many run action is happened for recursion

    }
	
	 /**
     * displayReport method
     * calculating Average Critical Operation Count,
        		   Standard Deviation of Count,
        		   Average Execution Time,
        		   Standard Deviation of Time
     */

    public void displayReport(int set){

    	// 8 groups of asked output result
        double iDeviationCount = 0; // iterative deviation for counter
        double iDeviationTime = 0;  // iterative deviation for time
        double rDeviationCount = 0; // recursive deviation for counter
        double rDeviationTime = 0; //  recursive deviation for time
        double iterationAveCount = 0;
        double iterationAveTime = 0;
        double recursionAveCount = 0;
        double recursionAveTime = 0;
        


        // calculate average count and time for 50 set

        iterationAveCount = counterIteration / 49;

        iterationAveTime = iterativeTime / 49;

        recursionAveCount = counterRecursive / 49;

        recursionAveTime = recursiveTime / 49;

     

        //calculate Standard Deviation for set=50 by 
        //Taking each value in the data set, and subtract the average from it,then
        //Square each of the differences(part1) (dummies website)
        // reference http://www.dummies.com/education/math/statistics/how-to-calculate-standard-deviation-in-a-statistical-data-set/
        
        for (int i = 1; i < 50; i++){

            iDeviationCount = iDeviationCount + Math.pow((iterativeCountSet[i] - iterationAveCount), 2);

            iDeviationTime = iDeviationTime + Math.pow((iterativeTimeSet[i] - iterationAveTime), 2);

            rDeviationCount = rDeviationCount + Math.pow((recursiveCountSet[i] - recursionAveCount), 2);

            rDeviationTime = rDeviationTime + Math.pow((recursiveTimeSet[i] - recursionAveTime), 2);

        }

     
        // square root = power 1/2=.5 over set size( part2 of calculating Standard Deviation)
        
        iDeviationCount = Math.pow(iDeviationCount, (float)1 / 2) / set;

        iDeviationTime = Math.pow(iDeviationTime, (float)1 / 2) / set;

        rDeviationCount = Math.pow(rDeviationCount, (float)1 / 2) / set;

        rDeviationTime = Math.pow(rDeviationTime, (float)1 / 2) / set;

    
     try {
    	 
    	 
    	
    	 
    	// write result in sortResult.txt file and console
		File file = new File("sortResult.txt");
		FileWriter fileWriter = new FileWriter(file,true);
		
        
        System.out.println();
        
        
        fileWriter.append("\n");
        
       
         //iterative result
         fileWriter.append(String.format("%1$"+22+ "s", set)+String.format("%1$"+22+ "s", iterationAveCount)+String.format("%1$"+22+ "s", iDeviationCount)+
         String.format("%1$"+22+ "s", iterationAveTime)+String.format("%1$"+22+ "s", iDeviationTime));
         //recursive result
         fileWriter.append(String.format("%1$"+22+ "s", recursionAveCount)+String.format("%1$"+22+ "s", rDeviationCount)+
                 String.format("%1$"+22+ "s", recursionAveTime)+String.format("%1$"+22+ "s", rDeviationTime));
                 
		
	    fileWriter.flush();
		fileWriter.close();
        
        // display result on console for iteration
        System.out.println("Iterative Selection Sort Results, data set size n = "+ set);
        System.out.println();
        
        System.out.println("|\t"+iterationAveCount+"\t|"
        		+"\t"+iDeviationCount+"\t|"+"\t"+iterationAveTime+"\t|"+"\t"+iDeviationTime);
       
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println();
        
        // display result on console for recursion
        System.out.println("Recursive Selection Sort Results, data set size n = "+ set);
        System.out.println();
        
        System.out.println("|\t"+recursionAveCount+"\t|"
        		+"\t"+rDeviationCount+"\t|"+"\t"+recursionAveTime+"\t|"+"\t"+rDeviationTime);
        
        System.out.println("------------------------------------------------------------------------------------------------");
        
	} catch (IOException e) {
		    System.out.println(" unsuccessful file writing ");
			e.printStackTrace();
   }
        
        
        
        
        
        
        
    }

    
    
    
}