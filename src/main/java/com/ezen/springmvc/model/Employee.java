package com.ezen.springmvc.model;

public class Employee {
	
	private Integer emp_id;
	
	// hashCode() : �� Ŭ������ �ν��Ͻ��� �����ϰ� ������ �� �ִ� ��. �⺻�� = �޸𸮻��� �ּ�
	@Override
	public int hashCode() {		
		return emp_id;
	}
	
	public Employee(Integer emp_id) {
		this.emp_id = emp_id;
	}
	
	// equals() : ���� �ν��Ͻ��� ���޹��� �ν��Ͻ��� ���Ͽ� �� �ν��Ͻ��� ���� ��ü���� �Ǻ��� �� �ִ� �޼���
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
