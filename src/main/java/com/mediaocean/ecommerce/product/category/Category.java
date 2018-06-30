/**
 * 
 */
package com.mediaocean.ecommerce.product.category;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mediaocean.ecommerce.product.Product;

/**
 * @author prafulljoshi
 *
 */
@Entity
@Table(name = "TB_CATEGORY")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8037262786918461476L;

	@Id
	@Enumerated(EnumType.STRING)
	private CategoryType categoryType;
	
	private Long taxPercentage;
	
//	@OneToOne(fetch = FetchType.LAZY,
//			cascade = CascadeType.ALL)
//	@JoinColumn(name = "product_id")
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public Long getTaxPercentage() {
		return taxPercentage;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public void setTaxPercentage(Long taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
