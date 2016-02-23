/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.util;

import java.io.OutputStream;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.contentstream.operator.Operator;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an example on how to remove all text from PDF document.
 *
 * @author Ben Litchfield
 */
public final class PDFRemoveAllText
{
  /*  public static void main( String[] args ) throws IOException
    {
    	 PDDocument document = null;
         try
         {
             document = PDDocument.load(new File("C:/E_Drive/Arrow/Dissect/atoz.pdf"));
             PDFTextStripperByArea stripper = new PDFTextStripperByArea();
             stripper.setSortByPosition( true );
             Rectangle rect = new Rectangle( 0, 0, 2750, 600 );
             stripper.addRegion( "class1", rect );
             stripper.getText(document);
             PDPage firstPage = document.getPage(0);
             stripper.extractRegions( firstPage );
             System.out.println( "Text in the area:" + rect );
             System.out.println( stripper.getTextForRegion( "class1" ) );
         }
         finally
         {
             if( document != null )
             {
                 document.close();
             }
         }
    }*/
}