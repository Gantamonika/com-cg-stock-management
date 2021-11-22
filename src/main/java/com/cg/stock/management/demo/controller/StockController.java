package com.cg.stock.management.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.stock.management.demo.model.Stock;
import com.cg.stock.management.demo.services.StockServices;


@RestController
public class StockController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockServices stockService;
	
	@PostMapping("/addStockDetails")
	public ResponseEntity<Stock> addStockDetails(@RequestBody Stock stock)
	{
		LOG.info("addStockDetails");
		Stock stk= stockService.addStockDetails(stock);
		HttpHeaders headers=new HttpHeaders();
		headers.add("message","This stock is added in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Stock> response=new ResponseEntity<Stock> (stk, headers, HttpStatus.OK);
		return response;
		
	}

}
