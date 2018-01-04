package com.pratik.stockservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import yahoofinance.YahooFinance;

@Configuration
public class Configurations {
	
//	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public YahooFinance yahooFinance(){
		return new YahooFinance();
	}

}
