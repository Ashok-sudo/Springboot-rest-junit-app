package com.xtglobal.rest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xtglobal.bindings.Book;
import com.xtglobal.service.BookService;

@WebMvcTest(value=BookRestController.class)
public class BookRestControllerTest 
{
	@MockBean
	BookService bookService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAddBook01() throws Exception
	{
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book book = new Book(101, "Spring",450.00);
		
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(book);
		
		MockHttpServletRequestBuilder reqBuilder=MockMvcRequestBuilders.post("/addbook")
		.contentType(MediaType.APPLICATION_JSON)
		.content(bookJson);
		
		ResultActions perform = mockMvc.perform(reqBuilder);
		
		MvcResult andReturn = perform.andReturn();
		
		MockHttpServletResponse response = andReturn.getResponse();
		
		int status = response.getStatus();
		
		System.out.println(status);
		
		//assertEquals(201, status);
		
		
	}
	
	@Test
	public void testAddBook02() throws Exception
	{
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book book = new Book(101, "Spring",450.00);
		
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(book);
		
		MockHttpServletRequestBuilder reqBuilder=MockMvcRequestBuilders.post("/addbook")
		.contentType(MediaType.APPLICATION_JSON)
		.content(bookJson);
		
		ResultActions perform = mockMvc.perform(reqBuilder);
		
		MvcResult andReturn = perform.andReturn();
		
		MockHttpServletResponse response = andReturn.getResponse();
		
		int status = response.getStatus();
		
		System.out.println(status);
		
		//assertEquals(400, status);
		
		
	}
	

	

}
