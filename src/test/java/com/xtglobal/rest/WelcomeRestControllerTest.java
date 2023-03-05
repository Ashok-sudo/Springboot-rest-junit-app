package com.xtglobal.rest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xtglobal.service.WelcomeService;

@WebMvcTest(value=WelcomeRestController.class)
public class WelcomeRestControllerTest 
{
	@MockBean
	private WelcomeService welcomeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWelcomeMsg() throws Exception
	{
	when(welcomeService.getWelcomeMsg()).thenReturn("Good Morning...!!");
		
	MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/welcome");
	
	ResultActions perform = mockMvc.perform(reqBuilder);
	
	MvcResult mvcResult = perform.andReturn();
	
	MockHttpServletResponse response = mvcResult.getResponse();
	
	int status = response.getStatus();
	
	System.out.println(status);
	
	assertEquals(404, status);
	
	
	}
}
