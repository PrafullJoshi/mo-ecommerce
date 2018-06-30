/**
 * 
 */
package com.mediaocean.ecommerce.product;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mediaocean.ecommerce.product.category.Category;

/**
 * @author prafulljoshi
 *
 */
@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5525763906768572754L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String name;
	private String description;
	
//	@OneToOne(fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL,
//			mappedBy = "categoryType")
//	@JoinColumn(name = "categoryType", nullable = false)
//	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "categoryType")
	private Category category;
	
	private Long price;
	      

	public Category getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Long getPrice() {
		return price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
