package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.ConnectingToCassandra;
import com.pojo.LoginData;
import com.pojo.ProductDetails;

@RestController
public class UserHomeController 
{
	final static Logger log = LoggerFactory.getLogger(UserHomeController.class);

	@RequestMapping(value = "/arrow/userhome", method = RequestMethod.POST)
	public @ResponseBody Object getUserHomeData(@RequestBody String loginData) {
		log.info("\n\n\t[I am in UserHomeController]\n\n");
		List<ProductDetails> productDetailsList = new ArrayList<>();
		ConnectingToCassandra connectingToCassandra = new ConnectingToCassandra();
		try 
		{
			productDetailsList = connectingToCassandra.getUserHomeData();
		}
		catch (IllegalStateException e) 
		{
			e.printStackTrace();
		}
		return productDetailsList.toArray();
	}
}
