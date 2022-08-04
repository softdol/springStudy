package com.ezen.util;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int randomInt(int size) {
		return (int)(Math.random() * size);
	}
	
	public int rndEven() {
		
		int num = (int)(Math.random() * 1000);
		
		return num % 2 == 0 ? num : num + 1;
		
		//return ((int)(Math.random() * 1000) + 1) * 2; 
	}
	
	public boolean chkDecimal(int num) {
		if(num < 2) {
			return false;
		}
		
		if(num != 2) {
			//for(int i = 2; i <= Math.sqrt(num); i++) {
			double sqrt = Math.sqrt(num);
			for(int i = 2; i <= sqrt; i++) {
				if(num % i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
