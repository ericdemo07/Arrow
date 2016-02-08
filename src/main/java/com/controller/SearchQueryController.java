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
	@RequestMapping(value = "/arrow/searchbrand", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody String query) 
	{
		System.out.println("[I am in SearchQueryController]");
		List<String> brandName = new ArrayList<String>();

		if(query.trim().equalsIgnoreCase("Headphones"))
		{
			brandName.add("JBL");
			brandName.add("Philips");
			brandName.add("Boat");
		}
		System.out.println("BrandName : "+brandName);
		return brandName.toArray();
	}
	
	@RequestMapping(value = "/arrow/searchmodel", method = RequestMethod.POST)
	public @ResponseBody Object brandModelSearchRequest(@RequestBody String brandName) 
	{
		System.out.println("[I am in brandModelSearchRequest]");
		List<String> brandModelList = new ArrayList<String>();

		if(brandName.trim().equalsIgnoreCase("Boat"))
		{
			brandModelList.add("500");
			brandModelList.add("400");
			brandModelList.add("200");
		}
		if(brandName.trim().equalsIgnoreCase("JBL"))
		{
			brandModelList.add("T100");
			brandModelList.add("T280");
			brandModelList.add("T200");
		}
		if(brandName.trim().equalsIgnoreCase("Philips"))
		{
			brandModelList.add("SHS390");
			brandModelList.add("SHP1900");
		}
		System.out.println("BrandName : "+brandName);
		return brandModelList.toArray();
	}
}
