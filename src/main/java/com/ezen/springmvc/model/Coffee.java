package com.ezen.springmvc.model;

import org.springframework.stereotype.Component;

@Component
public class Coffee {
	
	private String name;
	private Integer price;
	private Boolean hot;
	
	// JavaBean Object�� �Ƿ��� �⺻ �����ڰ� �ݵ�� �����ؾ� �Ѵ�
	public Coffee() {
		name = "default name";
		price = 0;
		hot = true;
	}
	
	public Coffee(String name, Integer price, Boolean hot) {
		this.name = name;
		this.price = price;
		this.hot = hot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}
	
	public String getTable() {
		return String.format("%s/%s/%s", name, price, hot); 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s/%s/%s", name, price, hot);
	}

}
