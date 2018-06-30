/**
 * 
 */
package com.mediaocean.ecommerce.order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prafulljoshi
 *
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
