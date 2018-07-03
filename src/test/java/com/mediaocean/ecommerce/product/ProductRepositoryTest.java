/**
 * 
 */
package com.mediaocean.ecommerce.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mediaocean.ecommerce.product.category.Category;
import com.mediaocean.ecommerce.product.category.CategoryRepository;
import com.mediaocean.ecommerce.product.category.CategoryType;

/**
 * @author prafulljoshi
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void whenFindByProductId_thenReturnTheProduct() {
		// Given
		Category category = new Category();
		category.setCategoryType(CategoryType.B);
		category.setTaxPercentage(10L);
		
		Product product = new Product();
		product.setName("Compass");
		product.setDescription("Shows Directions");
		product.setPrice(10L);
		product.setCategory(category);

		this.entityManager.persist(category);
		Product persistedProduct = this.entityManager.persist(product);
		this.entityManager.flush();
		
		//When
		Optional<Product> found = this.productRepository.findById(persistedProduct.getProductId());
		Product foundProduct = found.get();
		
		//Then
		assertThat(foundProduct.getName()).isEqualTo(persistedProduct.getName());
	}
}
