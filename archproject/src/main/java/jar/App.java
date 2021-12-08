package jar;

public class App 
{

	//1. Write a function that returns maximum number taking as innput an integer array
	//Follow the TDD methods.
	//Example :
	//input : [2,9,30,1,20]
	// output : 30
	
	public static int maxArray(int[] num_list) {
		if (num_list == null)
			throw new IllegalArgumentException("Null input!");
		if (num_list.length==0) 
			throw new ArrayIndexOutOfBoundsException ("Array empty!");
		int max = num_list[0];
		for (int i = 1; i< num_list.length; i++) {
			if (num_list[i]>max)
				max = num_list[i];
		}
		return max;
	}
	
	
	//2.Write a function that reverse words.
	//Follow tthe TDD.
	//Example :
	// input  : Follow
	// output : wolloF
	public static String reverseWord(String word) {
		if (word==null || word.length()==0)
			throw new IllegalArgumentException("Can't reverse empty string!");
		String newWord="";
		for (int i=word.length()-1; i>=0; i--) {
			newWord +=word.charAt(i);
		}
		return newWord;
	}
		
	//3. Write a cube
	//Follow the TDD
	//Example :
	//input : 2
	// output : 8
		
	public static int cubeCalculator(int num) {
		return num*num*num;
	}	
	
	
    public static void main( String[] args )
    {
        System.out.println( "JUnit Exercises - 06/12/2021");
        
    }
}
