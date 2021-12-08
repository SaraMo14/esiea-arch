package SingletonImpl;

public class TestSingleton {
	
	// Main driver method
    public static void main(String args[]){
    	//three instances of Singleton
    	Singleton x = Singleton.getInstance();
	    Singleton y = Singleton.getInstance();
	    Singleton z = Singleton.getInstance();
	
	
	    // Printing the hash code for above variable 
	    System.out.println("Hashcode of x is " + x.hashCode());
	    System.out.println("Hashcode of y is " + y.hashCode());
	    System.out.println("Hashcode of z is " + z.hashCode());
	
	    // Condition check
	    if (x == y && y == z)
	        System.out.println( "Three objects point to the same memory location on the heap i.e, to the same object");
	    else
	        System.out.println("Three objects DO NOT point to the same memory location on the heap");
    }
}
