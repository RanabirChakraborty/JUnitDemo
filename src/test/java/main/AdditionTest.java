package main;

import static org.junit.Assume.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing the calculator")
class AdditionTest {
	
	Calculator obj;
	
	@BeforeAll
	static void beforeAllClass() {                 //for TestInstance PER_CLASS we don't need to the method to be static.
		System.out.println("Test started.");
	}
	
	@BeforeEach
	void beforeEachMethod() {
		obj = new Calculator();
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("Executed the method.");
	}
	
	@AfterAll
	static void afterAllClass() {                   //for TestInstance PER_CLASS we don't need to the method to be static.
		System.out.println("Test ended.");
	}

	@RepeatedTest(5)
	@Tag("Calculator")								//@Tag is used to filter the test-cases from other test plans.
	@DisplayName("Testing add method")				//to display in JUnit test what the Testing method name is (Not necessary)
	void testAdd (RepetitionInfo repetitionInfo) {
		repetitionInfo.notify();                    //can play with Repeated test accordingly.
		int sum = obj.add(1, 1);
		assertEquals(2, sum, () -> "The add method should add two numbers.");
	}
	
	@Test
	@Tag("Calculator")
	@EnabledOnOs(OS.LINUX)							//to enable the test only for a particular platform.
	void testDivide() {
		boolean isSomethingBreaking = true;
		assumeFalse(isSomethingBreaking);						//suppose here something broke before the test runs, it'll help to change the state to true.
		assertThrows(NullPointerException.class, () -> obj.divide(0, 1) , "It's a divide method");
	}
	
	@Test
	@Tag("Calculator")
	@DisplayName("Multiply method test")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, obj.multiply(2, 2)),
				() -> assertEquals(0, obj.multiply(2, 0)),
				() -> assertEquals(-6, obj.multiply(-2, 3))
				);
	}
	
	@Nested
	@Tag("Calculator")
	class testDeduction {
		
		@Test
		@DisplayName("Testing for positive num deduction")
		void posDiduction() {
			assertEquals(4, obj.deduction(7, 3), "success");
		}
		
		@Test
		@DisplayName("Testing for negative num deduction")
		void negDiduction() {
			assertEquals(-4, obj.deduction(-7, -3), "success");
		}
	}
	
	@Test
	@Tag("Square")
	void testAreaSquare() {
		assertEquals(4, obj.areaSquare(2), "Test area of a square.");
	}
}
