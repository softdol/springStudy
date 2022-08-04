package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	
	// 다른 폴더에 있지만 같은 패키지이기 때문에 import가 필요 없다
	Calculator calc = new Calculator();
	int a, b;
	int i;
	
//	@Before
//	public void before() {
//			
//		for(int i = 2; i <= Math.sqrt(10); i++) {
//			System.out.println(i);
//		}
//	}
//	
//	@After
//	public void after() {
//		System.out.println("Execute @After (" + i + ")");		
//	}
	
	@Ignore
	@Test
	public void addTest() {
		
		int result = calc.add(a, b);
		
		assertEquals(30, result);
		
		System.out.println("addTest");
		
	}
	
	
	@Ignore
	@Test
	public void rndTest1() {
		
		for(int i = 10; i < 100; i++) {
			assertTrue(calc.randomInt(i) < i - 1);
		}
		
		System.out.println("rndTest");
	}
	
	@Ignore
	@Test
	public void rndTest2() {
		
		for(int i = 10; i < 100; i++) {
			assertTrue(calc.randomInt(i) < i - 1);
		}
		
		System.out.println("rndTest");
	}
	
	/*
	 *
	 * (1) 실행하면 짝수인 양의 정수를 생성하여 반환하는 메서드를 정의한 후 알맞은 테스트 케이스를 작성
	 * 
	 * (2) 어떤 숫자를 하나 전달하면 소수인지 아닌지 판별해주는 메서드를 정의한 후 알맞은 테스트 케이스를 작성
	 * 
	 */

	@Test
	public void rndEven() {
		
		for(int i = 0; i < 1000; i++) {
			int result = calc.rndEven();
			
			//assertTrue(result % 2 == 0 && result > 0);
			assertTrue(result % 2 == 0);
			assertFalse(result % 2 == 1);
		}
		
	}
	
	@Test
	public void chkDecimal() {

		for(int i = 1; i < 1000; i++) {
			int chkCnt = 0;
			
			for(int j = 1; j <= i; j++) {
				chkCnt = i % j == 0 ? chkCnt + 1 : chkCnt;
			}
			
			assertTrue((chkCnt == 2) == calc.chkDecimal(i));
		}		
	}
	
	@Test
	public void getEvenTest3() {
		ArrayList<Integer> evens = new ArrayList<Integer>();
		
		for(int i = 0; i < 20000; i++) {
			evens.add(calc.rndEven());
		}
		
		assertFalse("evens에 0이 발견되었습니다.", evens.contains(0));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
