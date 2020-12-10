package com.earbuds.pricecomparisonscraper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrape")
public class AmazonController {

    	@GetMapping("/loadData")
	public String LoadData() {
		return "Hi";

		//this.amazonservice.AmazonLoadData();
	}

}
