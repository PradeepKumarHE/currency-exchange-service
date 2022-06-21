package com.pradeep.microservice;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	private Environment	environment;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrecnyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		return new CurrecnyExchange(1000l,from,to,BigDecimal.valueOf(50),environment.getProperty("local.server.port"));
	}
}
