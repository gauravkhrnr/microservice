package com.demo.microservices.currencyconversionservice.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.demo.microservices.currencyconversionservice.CurrencyConversionBean;

//Create proxy interface
//enabling feign
//@FeignClient(name="currency-exchange-service", url="localhost:8000") 
@FeignClient(name="currency-exchange-service")
//enabling ribbon  
@RibbonClient(name="currency-exchange-service")  
public interface CurrencyExchangeServiceClient {
	@GetMapping("/currency-exchange/from/{from}/to/{to}") 
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to);
}
