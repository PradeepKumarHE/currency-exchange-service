package com.pradeep.microservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired	
	private Environment	environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrecnyExchange retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		Optional<CurrecnyExchange> optionalCurrecnyExchange=currencyExchangeRepository.findByFromAndTo(from, to);
		if(optionalCurrecnyExchange.isEmpty()) {
			throw new RuntimeException("Unable to find data for "+from+" to "+to);
		}
		CurrecnyExchange currecnyExchange=optionalCurrecnyExchange.get();
		currecnyExchange.setApplicationPortNumber(environment.getProperty("local.server.port"));
		return currecnyExchange;
	}
}
