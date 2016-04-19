package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cassandra.ConnectingToCassandra;
import com.pojo.ProductDetails;
import com.pojo.ProductInvoice;
import com.util.TesseractImageDisect;

import net.sourceforge.tess4j.TesseractException;

@RestController
public class ProductDetailUploadController {
	final static Logger log = LoggerFactory.getLogger(ProductDetailUploadController.class);

	ProductDetails productDetails = new ProductDetails();

	@RequestMapping(value = "/arrow/productimage1upload", method = RequestMethod.POST)
	public @ResponseBody Object productImage1UploadQuery(@RequestParam("file") MultipartFile productimage1,
			@RequestParam("username") String username) {
		List<String> brandName = new ArrayList<String>();
		productDetails.setProductImage1(productimage1);
		log.info("\tProductImage1Uploaded");
		return brandName.toArray();
	}

	@RequestMapping(value = "/arrow/productimage2upload", method = RequestMethod.POST)
	public @ResponseBody Object productImage2UploadQuery(@RequestParam("file") MultipartFile productimage2,
			@RequestParam("username") String username) {
		List<String> brandName = new ArrayList<String>();
		productDetails.setProductImage2(productimage2);
		log.info("\tProductImage2Uploaded");
		return brandName.toArray();
	}

	@RequestMapping(value = "/arrow/productimage3upload", method = RequestMethod.POST)
	public @ResponseBody Object productImage3UploadQuery(@RequestParam("file") MultipartFile productimage3,
			@RequestParam("username") String username) {
		List<String> brandName = new ArrayList<String>();
		productDetails.setProductImage3(productimage3);
		log.info("\tProductImage3Uploaded");
		return brandName.toArray();
	}

	@RequestMapping(value = "/arrow/productinvoiceupload", method = RequestMethod.POST)
	public @ResponseBody Object productInvoiceUploadQuery(@RequestParam("file") MultipartFile invoiceFile,
			@RequestParam("username") String username) {

		log.info("\n\n\t[I am in ProductDetailController]\n\n");
		productDetails.setProductInvoice(invoiceFile);
		// TODO: to be removed
		List<String> brandName = new ArrayList<String>();
		log.info("\tContent Type : [" + invoiceFile.getContentType());
		ProductInvoice productDetails = new ProductInvoice();
		TesseractImageDisect tesseractImageDissect = new TesseractImageDisect();
		try {
			productDetails = tesseractImageDissect.invoiceDissect(invoiceFile);
		} catch (IllegalStateException | IOException | TesseractException e) {
			e.printStackTrace();
		}

		// TODO: here comes cassandra
		ConnectingToCassandra connectingToCassandra = new ConnectingToCassandra();
		try {
			connectingToCassandra.insertProductDetails(productDetails, invoiceFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return brandName.toArray();
	}

	@RequestMapping(value = "/arrow/producttextdetailsupload", method = RequestMethod.POST)
	public @ResponseBody Object productTextDetailsUploadQuery(@RequestBody ProductDetails productTextDetails) {
		List<String> brandName = new ArrayList<String>();
		productDetails.setProductDescription(productTextDetails.getProductDescription());
		productDetails.setProductType(productTextDetails.getProductType());
		productDetails.setBrandName(productTextDetails.getBrandName());
		productDetails.setModelName(productTextDetails.getModelName());

		log.info("\tProductImage3Uploaded : [" + productDetails.toString());
		return brandName.toArray();
	}
}
