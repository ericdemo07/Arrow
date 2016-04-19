package com.util;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import com.constants.RegexPattern;
import com.pojo.ProductInvoice;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractImageDisect {
	final static Logger log = LoggerFactory.getLogger(TesseractImageDisect.class);

	public ProductInvoice invoiceDissect(MultipartFile invoiceFile)
			throws IllegalStateException, IOException, TesseractException {
		File invoiceFileAsFile = new File("C:/E_Drive/Arrow/UploadedFiles/invoice.pdf");
		String invoiceExtractedData = null;
		Tesseract tesseractInstance = new Tesseract();
		ProductInvoice productDetails = new ProductInvoice();

		invoiceFile.transferTo(invoiceFileAsFile);
		log.info("\tFile Exists : [" + invoiceFileAsFile.exists());
		invoiceExtractedData = tesseractInstance.doOCR(invoiceFileAsFile);
		log.info("\tInvoiceDataExtracted : [ " + invoiceExtractedData);

		// TODO: using regex to parse data
		// patternForCommerceName
		String patternForCommerceName = RegexPattern.COMMERCE_NAME;
		Pattern p = Pattern.compile(patternForCommerceName);
		Matcher m = p.matcher(invoiceExtractedData);
		if (m.find()) {
			log.info("\tCommerceName : [" + m.group(2));
			productDetails.setCommerce(m.group(2).trim());
		} else {
			log.info("\tNO Commerce Name MATCH");
		}
		// patternForVendorName
		String patternForVendorName = RegexPattern.SUPPLIER_NAME;
		Pattern p1 = Pattern.compile(patternForVendorName);
		Matcher m1 = p1.matcher(invoiceExtractedData);
		if (m1.find()) {
			log.info("\tVendorName : [" + m1.group(2));
			productDetails.setVendor(m1.group(2).trim());
		} else {
			log.info("\tNO Vendor Name MATCH");
		}
		return productDetails;
	}
}
