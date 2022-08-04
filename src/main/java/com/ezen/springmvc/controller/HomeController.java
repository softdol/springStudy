package com.ezen.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springmvc.model.Coffee;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */

@Log4j2
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory..getLogger(HomeController.class);
	
	//private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	Coffee coffee;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
//		System.out.println("coffee : " + coffee);
		log.error("This is error message2.");
		log.debug("I am debug message2.");		
		log.info("information2");
		log.trace("trace message2.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("coffee", coffee );
		
		return "home";
		
//		<!-- Application Loggers 
//		<logger name="com.ezen.springmvc">
//			<level value="info" />
//		</logger>
//		
//		<!-- 3rdparty Loggers 
//		<logger name="org.springframework.core">
//			<level value="info" />
//		</logger>
//		
//		<logger name="org.springframework.beans">
//			<level value="info" />
//		</logger>
//		
//		<logger name="org.springframework.context">
//			<level value="info" />
//		</logger>
//
//		<logger name="org.springframework.web">
//			<level value="info" />
//		</logger>
//		-->
//		<!-- Root Logger -->
	}
	
}
