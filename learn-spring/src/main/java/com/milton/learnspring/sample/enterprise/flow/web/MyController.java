package com.milton.learnspring.sample.enterprise.flow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.milton.learnspring.sample.enterprise.flow.business.BusinessService;

//Sending response in the right format
//@RestController

@Component
public class MyController {

	@Autowired
	private BusinessService businessService;
	
	//"/sum" => 100
  //@GetMapping("/sum")
	public long displaySum() {
		return businessService.calculateSum();
	}

}
