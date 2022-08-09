package com.ezen.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Coffee;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(value= {"/coffee"})
@Controller
public class CoffeeController {
	
	@GetMapping("/add")
	public String coffeeAddForm() {
		return "coffee/addmenu";
	}
	
	@PostMapping("/add1")
	public String coffeeAdd(HttpServletRequest req) throws UnsupportedEncodingException {
		
		log.info("coffee add1 (자동 바인딩을 사용하지 않음)");
		
		req.setCharacterEncoding("EUC-KR");
		
		log.info("coffee name :" + req.getParameter("name"));
		log.info("coffee price :" + req.getParameter("price"));
		log.info("coffee hot :" + req.getParameter("hot"));
		
		req.setAttribute("coffee", new Coffee(
										req.getParameter("name"), 
										Integer.parseInt(req.getParameter("price")), 
										Boolean.parseBoolean(req.getParameter("hot"))
										));
		
		return "home";
	}
	
	@PostMapping("/add2")
	public String coffeeAdd2(Coffee coffee) {
		
		log.info("coffee add2 데이터가 도착하는 곳");
				
		log.info(coffee);
		
		if(coffee.isHot()) {
			log.info("뜨거운 커피가 추가되었습니다.");
		}else {
			log.info("차가운 커피가 추가되었습니다.");
		}
		
		//return "redirect:/";
		return "home";
	}
	
	@PostMapping("/add3")
	public String coffeeAdd3(
			@ModelAttribute("name") String name, 
			@ModelAttribute("price") Integer price, 
			@ModelAttribute("hot") Boolean hot) {
		
		log.info("name : " + name);
		log.info("price : " + price);
		log.info("hot : " + hot);
		
		return "home";
		
	}

	@RequestMapping(value = "/garden", method = RequestMethod.GET)
	public void garden() {
		log.info("garden controller");		
	}
	
	@RequestMapping(value = "/redirect")
	public String redirect() {
		return "redirect:/coffee/add";
	}
	
}
