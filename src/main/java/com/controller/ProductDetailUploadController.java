package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		}
		catch (IllegalStateException|IOException|TesseractException e) 
		{
			e.printStackTrace();
		}
		System.out.println(invoiceFileAsFile.getAbsolutePath());

		return brandName.toArray();
	}
}
