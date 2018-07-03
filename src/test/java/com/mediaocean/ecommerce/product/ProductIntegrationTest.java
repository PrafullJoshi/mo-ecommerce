/**
 * 
 */
package com.mediaocean.ecommerce.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mediaocean.ecommerce.product.category.CategoryRepository;

/**
 * @author prafulljoshi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ProductIntegrationTest {
	
	@Autowired
	MockMvc mvc;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
		// Given Products
		mvc.perform(get("/api/v1/products/load")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
			      //.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
		mvc.perform(get("/api/v1/products")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			      .andExpect(model().size(10));
			      // .andExpect(jsonPath("$[0].name", is("Product0")));
	}
}
