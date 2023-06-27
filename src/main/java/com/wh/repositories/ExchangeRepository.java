package com.wh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wh.entities.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, String> {

}
