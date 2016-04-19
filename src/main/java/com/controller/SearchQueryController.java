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

@RestController
public class SearchQueryController {
	final static Logger log = LoggerFactory.getLogger(SearchQueryController.class);

	@RequestMapping(value = "/arrow/searchbrand", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody String productType) {
		log.info("\n\n\t[I am in SearchQueryController]\n\n");
		List<String> brandName = new ArrayList<String>();
		if (productType.trim().equalsIgnoreCase("Headphones")) {
			brandName.add("JBL");
			brandName.add("Philips");
			brandName.add("Boat");
		}
		log.info("\tProductTypeSelected : [" + productType);
		return brandName.toArray();
	}

	@RequestMapping(value = "/arrow/searchmodel", method = RequestMethod.POST)
	public @ResponseBody Object brandModelSearchRequest(@RequestBody String brandName) {
		List<String> brandModelList = new ArrayList<String>();

		if (brandName.trim().equalsIgnoreCase("Boat")) {
			brandModelList.add("500");
			brandModelList.add("400");
			brandModelList.add("200");
		}
		if (brandName.trim().equalsIgnoreCase("JBL")) {
			brandModelList.add("T100");
			brandModelList.add("T280");
			brandModelList.add("T200");
		}
		if (brandName.trim().equalsIgnoreCase("Philips")) {
			brandModelList.add("SHS390");
			brandModelList.add("SHP1900");
		}
		log.info("\tBrandNameSelected : [" + brandName);
		return brandModelList.toArray();
	}
}
