package com.pradeep.microservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrecnyExchange, Long> {
	
	Optional<CurrecnyExchange> findByFromAndTo(String from, String to);
}
