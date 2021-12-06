package jar;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class CubeCalculatorTest{
	
	@Before
	public void SetUp(){ 
        System.out.println("Testing cubeCalculator(int) method");
    }
	
	@Test(timeout = 10)
	public void testCubeCalc() {
		assertEquals(8, App.cubeCalculator(2));
		assertEquals(0, App.cubeCalculator(0));
		assertSame(true, App.cubeCalculator(-1) == -1);
	}
}
