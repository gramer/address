package com.ligs.address.module;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( {"classpath:applicationContext.xml", "classpath:springWebContext.xml"})
public class AddressWebControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void list() throws Exception {
		ResultActions result = mockMvc.perform(get("/addresses/0"));
		result.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("kkj"));
	}
	
	@Test
	public void searchByName() throws Exception {
		ResultActions result = mockMvc.perform(get("/addresses?search=kkj"));
		result.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].name").value("kkj"));
	}
	

}