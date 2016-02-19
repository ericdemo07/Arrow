package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductDetailUploadController 
{
	@RequestMapping(value = "/arrow/productdetailupload", method = RequestMethod.POST)
	public @ResponseBody Object productDetailUploadQuery(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) 
	{
		MultipartFile a; 
		System.out.println("[I am in SearchQueryController]");
		List<String> brandName = new ArrayList<String>();

		System.out.println("productInvoice : "+file.getSize());
		return brandName.toArray();
	}
	
}
