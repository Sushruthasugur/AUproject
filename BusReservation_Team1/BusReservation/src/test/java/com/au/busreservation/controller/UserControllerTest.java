package com.au.busreservation.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.au.busreservation.model.User;
import com.au.busreservation.resource.UserController;
import com.au.busreservation.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
class UserControllerTest 
{
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
	
	@Test
	void testSaveUser() throws Exception
	{
		User mockTicket = new User();
		mockTicket.setId(1234);
		mockTicket.setName("sushrutha");
		mockTicket.setEmail("sushrutha.s@accolitedigital.com");
		mockTicket.setPassword("sushrutha");
		mockTicket.setGender("Female");
		mockTicket.setDob("27-11-2000");
		mockTicket.setMobileno("9121797682");
		
		String inputInJson = this.mapToJson(mockTicket);
		
		String URI = "/api/user/addUser";
		
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(mockTicket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
