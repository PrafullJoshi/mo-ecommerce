/**
 * 
 */
package com.mediaocean.ecommerce.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
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
	
		// String expectedProducts = "[{"productId":1,"name":"Product 0","description":"Description for Product 0","category":{"categoryType":"C","taxPercentage":0},"price":57},{"productId":2,"name":"Product 1","description":"Description for Product 1","category":{"categoryType":"C","taxPercentage":0},"price":86},{"productId":3,"name":"Product 2","description":"Description for Product 2","category":{"categoryType":"C","taxPercentage":0},"price":94},{"productId":4,"name":"Product 3","description":"Description for Product 3","category":{"categoryType":"B","taxPercentage":20},"price":99},{"productId":5,"name":"Product 4","description":"Description for Product 4","category":{"categoryType":"A","taxPercentage":10},"price":93},{"productId":6,"name":"Product 5","description":"Description for Product 5","category":{"categoryType":"A","taxPercentage":10},"price":70},{"productId":7,"name":"Product 6","description":"Description for Product 6","category":{"categoryType":"C","taxPercentage":0},"price":58},{"productId":8,"name":"Product 7","description":"Description for Product 7","category":{"categoryType":"A","taxPercentage":10},"price":65},{"productId":9,"name":"Product 8","description":"Description for Product 8","category":{"categoryType":"C","taxPercentage":0},"price":70},{"productId":10,"name":"Product 9","description":"Description for Product 9","category":{"categoryType":"B","taxPercentage":20},"price":67}]"
		
		mvc.perform(get("/api/v1/products").contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	               .andExpect(content().string(Matchers.containsString("Product 0")))
	               .andExpect(content().string(Matchers.containsString("Product 1")))
	               .andExpect(content().string(Matchers.containsString("Product 2")))
	               .andExpect(content().string(Matchers.containsString("Product 3")))
	               .andExpect(content().string(Matchers.containsString("Product 4")))
	               .andExpect(content().string(Matchers.containsString("Product 5")))
	               .andExpect(content().string(Matchers.containsString("Product 6")))
	               .andExpect(content().string(Matchers.containsString("Product 7")))
	               .andExpect(content().string(Matchers.containsString("Product 8")))
	               .andExpect(content().string(Matchers.containsString("Product 9")));
			      // .andExpect(jsonPath("$[0].name", is("Product0")));
	}
}
