/**
 * 
 */
package com.mediaocean.ecommerce.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.ecommerce.product.Product;
import com.mediaocean.ecommerce.product.ProductRepository;

/**
 * @author prafulljoshi
 *
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(method = RequestMethod.GET)
	public List<Order> listOrders() {
		return this.orderRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(method = RequestMethod.POST)
	public Order createOrder(@RequestBody Order order) {
		// TODO Order Items Price calculations
		List<OrderItem> orderItems = order.getOrderItems();
		Long orderPrice = 0L;
		Long orderTax = 0L;
		Long orderTotalPrice = 0L;
		for(OrderItem orderItem : orderItems) {
			Product productInput = orderItem.getProduct();
			
			Optional<Product> foundProduct = this.productRepository.findById(productInput.getProductId());
			Product product = foundProduct.get();
			
			Long price = product.getPrice();
			orderItem.setPrice(price);
			Long tax = product.getCategory().getTaxPercentage() * price / 100;
			Long totalPrice = price + tax;
			orderItem.setPrice(price);
			orderItem.setTax(tax);
			orderItem.setTotalPrice(totalPrice);
			
			orderPrice = orderPrice + price;
			orderTax = orderTax + tax;
			orderTotalPrice = orderTotalPrice + totalPrice;
		}
		
		order.setPrice(orderPrice);
		order.setTax(orderTax);
		order.setTotalPrice(orderTotalPrice);
		
		this.orderItemRepository.saveAll(orderItems);
		this.orderItemRepository.flush();
		Order savedOrder = this.orderRepository.saveAndFlush(order);
		return savedOrder;
	}
	
	@RequestMapping(value = "load", method = RequestMethod.GET)
	public void loadDummyOrder() {
		
		long countOfOrders = this.orderRepository.count();
		if(countOfOrders > 0) {
			return;
		}
		
		Order order = new Order();
		order.setPrice(1234L);
		order.setTax(100L);
		order.setTotalPrice(123234L);
		
			List<OrderItem> orderItems = new ArrayList<>();
			OrderItem orderItem = new OrderItem();
				Optional<Product> findById = this.productRepository.findById(5L);
				Product product = findById.get();
			Long price = product.getPrice();
			orderItem.setPrice(price);
			Long tax = product.getCategory().getTaxPercentage() * price / 100;
			Long totalPrice = price + tax;
			orderItem.setPrice(price);
			orderItem.setTax(tax);
			orderItem.setTotalPrice(totalPrice);
			
			orderItem.setProduct(product);
			orderItems.add(orderItem);
			orderItem.setOrder(order);
		order.setOrderItems(orderItems);

		this.orderItemRepository.saveAll(orderItems);
		this.orderItemRepository.flush();
		this.orderRepository.saveAndFlush(order);
	}
}
