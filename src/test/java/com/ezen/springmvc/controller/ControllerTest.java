package com.ezen.springmvc.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
			"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		}
		
	)
public class ControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void testSetup() {
		// 매 테스트 마다 MockMvcBuilder로 새로운 MockMvc를 생성한다
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Ignore
	@Test
	public void testBlogCtl() {
		try {
			String nextView = mockMvc.perform(
					MockMvcRequestBuilders.get("/hi/blog")
				).andReturn().getModelAndView().getViewName();
			
			log.info("next view : " + nextView);
			
			assertEquals("hello/blog", nextView);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void saveFile() throws Exception {
		
		MockMultipartFile mockFile = new MockMultipartFile("file", "test.txt", "text/plain", "My File Upload...".getBytes());
			
		mockMvc.perform(multipart("/fileupload/").file(mockFile));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
