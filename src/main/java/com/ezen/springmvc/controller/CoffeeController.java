package com.ezen.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(value= {"/coffee"})
@Controller
public class CoffeeController {
	
	@GetMapping("/add")
	public String coffeeAddForm() {
		return "coffee/addmenu";
	}
	
	@PostMapping("/add")
	public String coffeeAdd(HttpServletRequest req) throws UnsupportedEncodingException {
		
		log.info("coffee 데이터가 도착하는 곳");
		
		req.setCharacterEncoding("EUC-KR");
		
		log.info("coffee name :" + req.getParameter("name"));
		log.info("coffee price :" + req.getParameter("price"));
		log.info("coffee hot :" + req.getParameter("hot"));
		
		return "redirect:/";
	}

}
