/**
 * 
 */
package com.mediaocean.ecommerce.product.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prafulljoshi
 *
 */
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listCategories() {
		return this.categoryRepository.findAll();
	}
}
