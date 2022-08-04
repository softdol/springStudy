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
		log.info("뉴스 컨트롤러에는 잘 도착함");
		
		// 다음으로 사용자에게 보여져야 할 view의 이름을 문자열로 리턴한다.
		// 리턴한 문자열 앞에는 /WEB-INF/views/가 붙고
		// 뒤에는 .jsp가 붙어서 다음 뷰의 경로를 완성한다
		return "hello/news";
	}
	
	@GetMapping("/blog")
	public String blog() {
		log.info("뉴스 컨트롤러에는 잘 도착함");
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
