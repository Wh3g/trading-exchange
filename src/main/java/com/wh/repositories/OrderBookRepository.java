package com.wh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wh.entities.Exchange;
import com.wh.entities.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, String> {

	@Query("SELECT ob FROM OrderBook ob Where exchangeCode = :exchangeCode")
	public List<OrderBook> findByExchange(@Param("exchangeCode") Exchange exchange);
}
