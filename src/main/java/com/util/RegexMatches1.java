package com.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.constants.RegexPattern;

public class RegexMatches1
{
   /* public static void main( String args[] )
    {
    	String content = null;
     try {
		 content = new String(Files.readAllBytes(Paths.get("C:/E_Drive/Arrow/Dissect/invoiceastext.txt")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     	String patternForCommerceName = "(http://www.)(.+?)(.in)(/returns)";
	    Pattern p = Pattern.compile(patternForCommerceName);
	    Matcher m = p.matcher(content);
	    //System.out.println("CommerceName : "+m.group(0));

      // Create a Pattern object
    //  Pattern r = Pattern.compile(patternForBrandName);

      // Now create matcher object.
     
     // Matcher m = r.matcher(content);
      if (m.find( )) 
      {
         System.out.println("Found value: " + m.toString() );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
         System.out.println("Found value: " + m.group(3) );
         System.out.println("Found value: " + m.group(4) );

      } 
      else 
      {
         System.out.println("NO MATCH");
      }
   }*/
}
