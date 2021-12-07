package jar;
	
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

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
		assertEquals(-1, App.maxArray(numbers));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaxArrayWhenNull() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> App.maxArray(null));
		assertEquals("Null input!", exception.getMessage());
	}
	
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testMaxArrayWhenEmpty() {
		int numbers[]= {};
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> App.maxArray(numbers));
		assertEquals("Array empty!", exception.getMessage());
	}
}
