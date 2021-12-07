package jar;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
	

	@Test()
	public void testReverseWord() {
		assertEquals("olleH", App.reverseWord(test_word));
	}
	@Test()
	public void testReverseWord2() {
		assertEquals("oppo", App.reverseWord(test_word2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaxArrayWhenEmpty() {
		String s = "";
		assertThrows(IllegalArgumentException.class, () -> App.reverseWord(s));
	}
	
}
