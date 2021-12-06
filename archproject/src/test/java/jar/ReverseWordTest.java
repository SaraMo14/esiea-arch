package jar;
	
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordTest{

	

	public String test_word = "";
	public String test_word2 = "";
	
	@Before
	public void SetUp(){ 
        System.out.println("Testing reverseWord(String) method"); 
		test_word = "Hello";
		test_word2 = "oppo";
    }
  
	@After 
	public void TearDown(){
		test_word = null;
		test_word2 = null;
    } 
	

	@Test(timeout = 10)
	public void testReverseWord1() {
		//String word = "Hello";
		assertEquals("olleH", App.reverseWord(test_word));
		//String word2 = "oppo";
		assertEquals("oppo", App.reverseWord(test_word2));
	}
	
}
