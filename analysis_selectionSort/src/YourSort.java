/**
     * YourSort class to create sort methods by recursion 
     * and iteration, and counting operation of loops and start/ end time of each sort execution 
     * 
     * reference: MEMORYNOTFOUND JAVA PROGRAMMING TUTORIALS website http://memorynotfound.com/calculating-elapsed-time-java/
     *            Geeks for Geeks website http://www.geeksforgeeks.org/selection-sort/
     *            cs.pomona.edu websirehttp:  //www.cs.pomona.edu/~kim/CSC051GF14/lectures/Lecture39/Lecture39_1.html
     *            
     */

public class YourSort implements SortInterface{

	//Identify variables
    long timeIteration,  timeRecursion;
    
    int countIteration,  countRecursion ;
    
    UnsortedException errors;



   //iterative selection sort method, modified from Geeks for Geeks website
  // reference address:http://www.geeksforgeeks.org/selection-sort/

    public void iterativeSort (int [] array) throws Exception {

    	countIteration = 0;

    	// compare elements, which is related to finding critical operation count (loops)
        long startTime = System.nanoTime(); //start time of iteration 

        // One by one move through elements of array 
        for (int i = 0; i < array.length - 1; i++){

            //find the minimum and its index in the array , and count it

            int min = array[i];

            int minIndex = i;


            for (int j = i + 1; j < array.length; j++){

                if (min > array[j]){

                	min = array[j];

                	minIndex = j;

                }

                countIteration++; // main operations counter

            }


            //swap found minimum element with the default element

            if (minIndex != i){

            	array[minIndex] = array[i];

            	array[i] = min;

            }


        }

        long endTime = System.nanoTime(); // end time of iteration

        timeIteration = endTime - startTime; // actual time of iteration
        
        // check the result has the correct order, or it does not  for UnsortedException

        for (int i = 0; i < array.length - 1; i++){
        	

            if (array[i] > array [i + 1]){

            	errors = new UnsortedException ("incorrect sort operation for iteration!");

                throw errors;

            }

        }             

    }

   

    //recursive selection sort method from cs.pomona.edu websire
    // reference address: http://www.cs.pomona.edu/~kim/CSC051GF14/lectures/Lecture39/Lecture39_1.html

    public void recursiveSort(int [] array) throws Exception {

    	// start from index 0
    	countRecursion = 0;

        recursiveSort(array, 0, array.length - 1);

    }

    public void recursiveSort(int [] array, int firstIndex, int lastIndex)throws Exception{         

             
         // compare elements, which is related to finding critical operation count (loops)
        long startTime = System.nanoTime(); // start time of recursion

        if (firstIndex < lastIndex) { 

            //find the smallest element and its index 

        	int min = array[firstIndex];
        	
            int minIndex = firstIndex;

            // compare elements
            for (int i = firstIndex + 1; i <= lastIndex; i++){

                    if (array[i] < min) {

                    min = array[i];

                    minIndex = i;              

                }

                    countRecursion++; // main operations counter

            }

         

            //swap found minimum element with the default element 

            array[minIndex] = array[firstIndex];

            array[firstIndex] = min;

       

            // continue sort operation recursively 

            recursiveSort(array, firstIndex + 1, lastIndex);


        }

        long endTime = System.nanoTime(); // end time of recursion

        timeRecursion = endTime - startTime; // actual time of recursion 

        
     // check the result has correct order, or it does not for UnsortedException 

        for (int i = 0; i < array.length - 1; i++){

            if (array[i] > array [i + 1]){

            	errors = new UnsortedException ("incorrect sort operation for recursion!");

                throw errors;

            }

        }

    }

 // total count of both sorts
    public int getCount(){

        int totalCount = countIteration + countRecursion;

        countIteration = 0;

        countRecursion = 0;     

        return totalCount;

    }

  // total time of both sorts
    public long getTime(){

        long totalTime = timeIteration + timeRecursion;

        timeIteration = 0;

        timeRecursion = 0;

        return totalTime;

    }

}

