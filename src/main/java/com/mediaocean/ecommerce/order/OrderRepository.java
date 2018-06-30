package com.mediaocean.ecommerce.order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prafulljoshi
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
