package com.ezen.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@ToString
@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@EqualsAndHashCode
public class Apple {
//	@NonNull
	@Setter
	private Integer size;
//	@NonNull
	@Setter
	private Integer price;
	private Boolean red;
	private Boolean fresh;
	
	public static void main(String[] args) {
		//System.out.println(new Apple());
	}
}
