package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFDisection 
{
	/*public static void main(String...args)
	{
		PDDocument document;
		try 
		{
			document = PDDocument.load(new File("C:/E_Drive/Arrow/Dissect/bill.pdf"));
		
			System.out.println(document.getNumberOfPages());
			for(PDPage page : document.getPages())
			{
				InputStream inputStream = page.getContents();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		        StringBuilder out = new StringBuilder();
		        String line;
		        while ((line = reader.readLine()) != null) {
		            out.append(line);
		        }
		        System.out.println(out.toString());   //Prints the string content read from input stream
		        reader.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/
}
