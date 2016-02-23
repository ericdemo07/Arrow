package com.pojo;

import java.util.List;

import lombok.Data;

public @Data class ProductInvoice 
{
	String supplier;
	String invoiceNumber;
	List<ProductDetails> productDetails;
	String orderId;
	String dateOfPurchase;
	String supplierAddress;
	String eCommerceSupplier;
}
