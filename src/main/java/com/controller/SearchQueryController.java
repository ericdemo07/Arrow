package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchQueryController 
{
	@RequestMapping(value = "/arrow/searchquery", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody String query) 
	{
		System.out.println("[I am in SearchQueryController]");
		List<String> brandName = new ArrayList<String>();
		
		if(query.equalsIgnoreCase("Headphones"))
		{
			brandName.add("JBL");
			brandName.add("Philips");
			brandName.add("Boat");
		}
		return brandName.toArray();
	}
}
