package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cassandra.ConnectingToCassandra;
import com.pojo.ProductDetails;
import com.util.TesseractImageDisect;

import net.sourceforge.tess4j.TesseractException;

@RestController
public class ProductDetailUploadController {
	final static Logger log = LoggerFactory.getLogger(ProductDetailUploadController.class);

	@RequestMapping(value = "/arrow/productdetailinvoiceupload", method = RequestMethod.POST)
	public @ResponseBody Object productDetailInvoiceUploadQuery(@RequestParam("file") MultipartFile invoiceFile,
			@RequestParam("username") String username) {

		log.info("\n\n\t[I am in ProductDetailController]\n\n");
		// TODO: to be removed
		List<String> brandName = new ArrayList<String>();
		log.info("\tContent Type : [" + invoiceFile.getContentType());
		ProductDetails productDetails = new ProductDetails();
		TesseractImageDisect tesseractImageDissect = new TesseractImageDisect();
		try {
			productDetails = tesseractImageDissect.invoiceDissect(invoiceFile);
		} catch (IllegalStateException | IOException | TesseractException e) {
			e.printStackTrace();
		}

		// TODO: here comes cassandra
		ConnectingToCassandra connectingToCassandra = new ConnectingToCassandra();
		connectingToCassandra.insertProductDetails(productDetails);

		return brandName.toArray();
	}
}
