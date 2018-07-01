/**
 * 
 */
package com.mediaocean.ecommerce.product;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.ecommerce.product.category.Category;
import com.mediaocean.ecommerce.product.category.CategoryRepository;
import com.mediaocean.ecommerce.product.category.CategoryType;

/**
 * @author prafulljoshi
 *
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	private Logger LOGGER = Logger.getLogger(ProductController.class.getName());
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		LOGGER.info("Requested List of Products");
		return productRepository.findAll();
	}
	
	@RequestMapping(value = "load", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8100")
	public void loadData() {

		long countOfLoadedProducts = this.productRepository.count();
		if(countOfLoadedProducts > 0) {
			return;
		}
		
		Category categoryA = new Category();
		categoryA.setCategoryType(CategoryType.A);
		categoryA.setTaxPercentage(10L);

		this.categoryRepository.save(categoryA);
		
		Category categoryB = new Category();
		categoryB.setCategoryType(CategoryType.B);
		categoryB.setTaxPercentage(20L);
		this.categoryRepository.save(categoryB);

		Category categoryC = new Category();
		categoryC.setCategoryType(CategoryType.C);
		categoryC.setTaxPercentage(0L);
		this.categoryRepository.save(categoryC);
		
		Category[] categories = {categoryA, categoryB, categoryC};
		
		for(int productCounter = 0; productCounter < 10; productCounter++) {
			Product product = new Product();
			product.setName("Product " + productCounter);
			product.setDescription("Description for Product " + productCounter);
			product.setPrice(getRandomIntegerBetweenRange(50, 100));
			int randomIntegerBetweenRange = (int) getRandomIntegerBetweenRange(0, 2);
			product.setCategory(categories[randomIntegerBetweenRange]);
			this.productRepository.save(product);
			
		}
		
		this.categoryRepository.flush();
		this.productRepository.flush();
		
	}
	
	public static long getRandomIntegerBetweenRange(double min, double max){
	    double x = (Math.random() * ((max-min) + 1)) + min;
	   
	    return (long) (x);
	}
}
