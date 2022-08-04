package com.ezen.springmvc.model;

public class Employee {
	
	private Integer emp_id;
	
	// hashCode() : 이 클래스의 인스턴스를 유일하게 구분할 수 있는 값. 기본값 = 메모리상의 주소
	@Override
	public int hashCode() {		
		return emp_id;
	}
	
	public Employee(Integer emp_id) {
		this.emp_id = emp_id;
	}
	
	// equals() : 현재 인스턴스와 전달받은 인스턴스를 비교하여 두 인스턴스가 같은 객체인지 판별할 수 있는 메서드
	@Override
	public boolean equals(Object obj) {
		
		return obj.hashCode() == this.hashCode();
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(1);
		Employee emp2 = new Employee(2);
		Employee emp3 = new Employee(1);
		
		System.out.println(emp1.hashCode());
		System.out.println(Integer.toString(emp1.hashCode(), 16));
		System.out.println(Integer.toString(emp2.hashCode(), 16));
		
		System.out.println(emp1.equals(emp2));
		System.out.println(emp1.equals(emp3));
	}

}
