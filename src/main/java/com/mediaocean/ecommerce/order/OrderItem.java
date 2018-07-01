/**
 * 
 */
package com.mediaocean.ecommerce.order;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mediaocean.ecommerce.product.Product;

/**
 * @author prafulljoshi
 *
 */
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	private Long price;
	private Long tax;
	private Long totalPrice;
	
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	
//	@OneToOne
//	@OneToOne(mappedBy = "orderItems")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	@JsonIgnore
	private Order order;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
