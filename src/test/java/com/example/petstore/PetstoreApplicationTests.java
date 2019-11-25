package com.example.petstore;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.petstore.entity.Pet;
import com.example.petstore.repository.PetRepository;
import com.example.petstore.service.PetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PetstoreApplicationTests {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
		
	@Autowired 
	private PetService petService;
	
	@MockBean
	private PetRepository petRepository;
	
	@Before
	public void dataSetUp() {
		when(petRepository.findAll()).thenReturn(Stream
				.of(new Pet(1, "Tom", "Cat", 2, 1), new Pet(2, "Donald", "Duck", 1, 2)).collect(Collectors.toList()));
	}
	
	@Test
	public void contextLoads() throws Exception {
		
		mockMvc.perform(get("/getPets"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id",is(1)))
			.andExpect(jsonPath("$[0].name", is("Tom")))
			.andExpect(jsonPath("$[0].type",is("Cat")))
			.andExpect(jsonPath("$[0].age",is(2)))
			.andExpect(jsonPath("$[0].userid",is(1)))
			.andExpect(jsonPath("$[1].id",is(2)))
			.andExpect(jsonPath("$[1].name", is("Donald")))
			.andExpect(jsonPath("$[1].type",is("Duck")))
			.andExpect(jsonPath("$[1].age",is(1)))
			.andExpect(jsonPath("$[1].userid",is(2)));
		
		verify(petRepository,times(1)).findAll();

	}
	
	@Test
	public void testupdateNewPet() throws Exception {
		
		Pet pet = new Pet(11, "Tohru", "Dragon", 2, 4);
		
		when(petRepository.save(pet)).thenReturn(pet);
		
		mockMvc.perform(post("/savePet")
                .content(om.writeValueAsString(pet))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
               // .andDo(print());
                .andExpect(jsonPath("$.id", is(11))) 
				.andExpect(jsonPath("$.name", is("Tohru"))) 
				.andExpect(jsonPath("$.type", is("Dragon")))
				.andExpect(jsonPath("$.age", is(2))) 
				.andExpect(jsonPath("$.userid", is(4)));	

		verify(petRepository,times(1)).save(pet);
				
	}
	

}
