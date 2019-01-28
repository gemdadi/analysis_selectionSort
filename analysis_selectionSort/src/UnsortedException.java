
/**
     * UnsortedException extends from Exception class
     * Required exception class.When the array is not sorted, an exception should be thrown
     */
public class UnsortedException extends Exception  {

	public UnsortedException(String message) {
		// TODO Auto-generated constructor stub
		 super(message);
		System.out.println("Error");
	}

	
	   public UnsortedException() {
	       super();
	   }
    
    

}