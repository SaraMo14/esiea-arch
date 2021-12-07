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
	
	@Test()
	public void testCubeCalcWhenPositive() {
		assertEquals(8, App.cubeCalculator(2));
	}
	
	@Test()
	public void testCubeCalcWhenZero() {
		assertEquals(0, App.cubeCalculator(0));
	}
	
	@Test()
	public void testCubeCalcWhenNegative() {
		assertSame(true, App.cubeCalculator(-1) == -1);
	}
}
