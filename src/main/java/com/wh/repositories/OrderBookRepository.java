package com.wh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wh.entities.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, String> {

}
