package main;

import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;

public class PrintersFunction {
	
	public static Collection<String> getInstalledPrinters () {
		Collection<String> printers = new ArrayList<String>();
		
		 PrintService[] printServices = PrinterJob.lookupPrintServices();

		 for (PrintService printService : printServices){
			printers.add(printService.getName());
			 
		 }
		return printers;
	}
	
	
	
	
	 public static void PrintPdf(String printerName,byte[] PdfDocument) throws PrintException, IOException {

		 PrintService stampante = null;

		 PrintService[] printServices = PrinterJob.lookupPrintServices();

		 for (PrintService printService : printServices) {
		 if(printService.getName().equals(printerName)) {
		 stampante = printService;
		 }

		 }
		 if(stampante==null)
			 throw new PrintException("Printer not Installed");
		
		 

		             InputStream is = new ByteArrayInputStream(PdfDocument);
		             DocFlavor flavor =  DocFlavor.INPUT_STREAM.AUTOSENSE;

		            
		             PrintRequestAttributeSet  pras = new HashPrintRequestAttributeSet();
		             //pras.add(new JobName("Lavoro_1", Locale.ITALIAN));
		             //pras.add(OrientationRequested.PORTRAIT);
		             pras.add(MediaSizeName.ISO_A4);
		            // pras.add(new Copies(copie));
		             //pras.add(Sides.TWO_SIDED_LONG_EDGE);
		             //pras.add(Finishings.STAPLE);
		            
		             // Create the print job
		             
		             
		             
		             DocPrintJob job = stampante.createPrintJob();
		             
		             
		             
		             Doc doc= new SimpleDoc(is, flavor, null);
		            
		           

		             // Print it
		             job.print(doc, pras);
		             is.close();

		 }
	
	
	
	
	 public static void PrintZpl(String zplCode,String printer) throws PrintException {
		 
	        
	        PrintService stampante = null;

			 PrintService[] printServices = PrinterJob.lookupPrintServices();

			 for (PrintService printService : printServices) {
			 if(printService.getName().equals(printer)) {
			 stampante = printService;
			 }

			 }
			 if(stampante==null)
				 throw new PrintException("Printer not Installed");

	        DocPrintJob job = stampante.createPrintJob();
	        DocFlavor flvr = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	        Doc doc = new SimpleDoc(zplCode.getBytes(), flvr, null);
	        try {
	            job.print(doc, null);
	        } catch (PrintException e) {
	           throw e;
	        }
		 
		 
	

		 
	 }
	
	
	
	
	
	
	
	
	
	
}
