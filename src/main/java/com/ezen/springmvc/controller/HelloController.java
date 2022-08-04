package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(value= {"/hello", "/hi","/welcome"})
@Controller
public class HelloController {
	
	@RequestMapping(
			value= {"/news"},
			method = {RequestMethod.GET, RequestMethod.POST})
	public String news() {
		log.info("���� ��Ʈ�ѷ����� �� ������");
		
		// �������� ����ڿ��� �������� �� view�� �̸��� ���ڿ��� �����Ѵ�.
		// ������ ���ڿ� �տ��� /WEB-INF/views/�� �ٰ�
		// �ڿ��� .jsp�� �پ ���� ���� ��θ� �ϼ��Ѵ�
		return "hello/news";
	}
	
	@GetMapping("/blog")
	public String blog() {
		log.info("���� ��Ʈ�ѷ����� �� ������");
		return "hello/blog";
	}
	
//	@GetMapping("/coffee/add")
//	public String coffeeAddForm() {
//		return "coffee/addmenu";
//	}
//	
//	@PostMapping("/coffee/add")
//	public String coffeeAdd() {
//		return "coffee/add";
//	}

}
