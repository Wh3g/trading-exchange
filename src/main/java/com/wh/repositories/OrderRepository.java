package com.wh.repositories;
import com.wh.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wh.entities.Order;

import jakarta.transaction.Transactional;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Modifying
    @Transactional
    @Query("UPDATE Order o SET o.price = :price WHERE o.id = :orderId")
    void updateOrderPrice(@Param("orderId") Long orderId, @Param("price") Double price);


}
