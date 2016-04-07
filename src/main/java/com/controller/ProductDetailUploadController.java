package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.constants.RegexPattern;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
public class ProductDetailUploadController 
{
	@RequestMapping(value = "/arrow/productdetailupload", method = RequestMethod.POST)
	public @ResponseBody Object productDetailUploadQuery(@RequestParam("file") MultipartFile invoiceFile, @RequestParam("username") String username) 
	{
		System.out.println("[I am in SearchQueryController]");
		List<String> brandName = new ArrayList<String>();

		File invoiceFileAsFile = new File("C:/E_Drive/Arrow/UploadedFiles/invoice.pdf");
		System.out.println("Content Type : "+invoiceFile.getContentType());
		Tesseract instance = new Tesseract();
		String invoiceDataExtracted = null;
		try 
		{
			invoiceFile.transferTo(invoiceFileAsFile);
			System.out.println(invoiceFileAsFile.exists());
			invoiceDataExtracted = instance.doOCR(invoiceFileAsFile);
			System.out.println("invoiceDataExtracted : [ "+invoiceDataExtracted);
			
			//using regex to parse data
		    String patternForCommerceName = RegexPattern.COMMERCE_NAME;
		    Pattern p = Pattern.compile(patternForCommerceName);
		    Matcher m = p.matcher(invoiceDataExtracted);
		    if (m.find( )) 
		    {
		    	System.out.println("CommerceName : "+m.group(2));
		    }
		    else
		    {
		         System.out.println("NO Commerce Name MATCH");
		    }
		    String patternSupplierName = RegexPattern.SUPPLIER_NAME;
		    
		    Pattern p1 = Pattern.compile(patternSupplierName);
		    Matcher m1 = p1.matcher(invoiceDataExtracted);
		    if (m1.find( )) 
		    {
		    	System.out.println("SupplierName : "+m1.group(2));
		    }
		    else
		    {
		         System.out.println("NO Supplier Name MATCH");
		    }
		}
		catch (IllegalStateException|IOException|TesseractException e) 
		{
			e.printStackTrace();
		}
		System.out.println(invoiceFileAsFile.getAbsolutePath());

		return brandName.toArray();
	}
}
