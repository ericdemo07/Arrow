package com.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public @Data class ProductDetails 
{
	String productDescription;
	String productType;
	String brandName;
	String modelName;
	MultipartFile productImage1;
	MultipartFile productImage2;
	MultipartFile productImage3;
	MultipartFile productInvoice;
}
