package com.partnerships.interview;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.partnerships.interview.app.InterviewApplication;
import com.partnerships.interview.model.Event;
import com.partnerships.interview.model.Venue;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = InterviewApplication.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class InterviewApplicationTests {

	private MockMvc mockMvc;
	ObjectMapper mapper ;


	private static Integer ID_TO_DELETE;
	private static Integer EVENT_ID;
	private static String EVENT_NAME;

	private Event event;


	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.event =new Event();
		Venue venue = new Venue();
		venue.setCity("Phoenix");
		venue.setState("AZ");
		venue.setName("Camelback Ranch");
		this.event.setDate(new Date());
		this.event.setName("Los Angeles Dodgers vs. Seattle Mariners");
		this.event.setVenue(venue);
		EVENT_NAME="CHICAGO WHITE SOX VS. CHICAGO CUBS";
		EVENT_ID=1;
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.mapper= new ObjectMapper();
	}


	@Test
	public void testAGetAllEvents() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/events"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(3))).andDo(print());

	}




	@Test
	public void testBCreateEvent() throws Exception {
		MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/events")
				.content(mapper.writeValueAsString(event))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.name", is(event.getName())))
				.andExpect(jsonPath("$.venue.name", is(event.getVenue().getName())))
				.andExpect(jsonPath("$.venue.city", is(event.getVenue().getCity()))).andDo(print())
				.andReturn();
		this.ID_TO_DELETE= this.mapper.readValue(
				mvcResult.getResponse().getContentAsByteArray(),Event.class).getId();


	}

	@Test
	public void testCUpdateEvent() throws Exception {
		event.setId(4);
		event.getVenue().setId(4);
		event.setName("Test Event");
		mockMvc.perform(MockMvcRequestBuilders.put("/events")
				.content(mapper.writeValueAsString(event))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", is(event.getId())))
				.andExpect(jsonPath("$.name", is("Test Event"))).andDo(print());
	}

	@Test
	public void testDGetById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/events/{id}",EVENT_ID))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", is(EVENT_ID)))
				.andExpect(jsonPath("$.name", is(EVENT_NAME))).andDo(print());
	}

	@Test
	public void testEDeleteById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/events/{id}",ID_TO_DELETE))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
