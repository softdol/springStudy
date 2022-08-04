package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	
	// �ٸ� ������ ������ ���� ��Ű���̱� ������ import�� �ʿ� ����
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
	 * (1) �����ϸ� ¦���� ���� ������ �����Ͽ� ��ȯ�ϴ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ�
	 * 
	 * (2) � ���ڸ� �ϳ� �����ϸ� �Ҽ����� �ƴ��� �Ǻ����ִ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ�
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
		
		assertFalse("evens�� 0�� �߰ߵǾ����ϴ�.", evens.contains(0));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
