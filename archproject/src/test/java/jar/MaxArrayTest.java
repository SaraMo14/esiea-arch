package jar;
	
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;	

public class MaxArrayTest extends TestCase{
	@Before
	public void SetUp(){ 
		System.out.println("Testing maxArray(int[]) method");  
    }
	
	@Test
	public void testMaxArray() {
		int numbers[] = {8,9,-1,9,0,5};
		assertEquals(9, App.maxArray(numbers));
	}
	@Test
	public void testMaxArrayWhenNegativeValues() {
		int numbers[] = {-1, -3, -5};
		assertEquals(-5, App.maxArray(numbers));
	}
	
}
