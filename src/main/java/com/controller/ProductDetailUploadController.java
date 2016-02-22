package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
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
	public @ResponseBody Object productDetailUploadQuery(@RequestParam("file") MultipartFile invoiceFile, @RequestParam("username") String username) 
	{
		MultipartFile a; 
		System.out.println("[I am in SearchQueryController]");
		List<String> brandName = new ArrayList<String>();

		File invoiceFileAsFile = new File("C:/E_Drive/Arrow/Dissect/bill1.pdf");
		System.out.println("Content Type : "+"" );
		try 
		{
			invoiceFile.transferTo(invoiceFileAsFile);
		}
		catch (IllegalStateException|IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PDDocument document;

		/*try 
		{
			document = PDDocument.load(new File("C:/E_Drive/Arrow/Dissect/bill.pdf"));
		
			System.out.println(document.getNumberOfPages());
			for(PDPage page : document.getPages())
			{
				InputStream inputStream = page.getContents();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		        StringBuilder out = new StringBuilder();
		        String line;
		        while ((line = reader.readLine()) != null) 
		        {
		            out.append(line);
		        }
		        System.out.println(out.toString());   //Prints the string content read from input stream
		        reader.close();
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return brandName.toArray();
	}
}
