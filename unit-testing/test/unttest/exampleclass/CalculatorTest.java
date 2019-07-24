package unttest.exampleclass;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	
	@BeforeEach // JUnit 5 szintaxis
	public void create() {
		this.calculator = new Calculator();
	}
	
	@Test
	void positiveNumbersAdditionTest() {
		assertEquals(3, calculator.add(1, 2));
	}
	
	@Test
	void positiveAndNegativeNumberAdditionTest() {
		assertEquals(-1, calculator.add(1, -2));
	}
	
}
