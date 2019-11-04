package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.print.PrintException;

import remotePrintService.PrintServiceRemote;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PrintService implements PrintServiceRemote {

	
	
	public Collection<String> getIntalledPrinters() {
		 
		return PrintersFunction.getInstalledPrinters();
	}

	public void PrintPdfDocument(String printerName,ByteArrayOutputStream PdfDocument) throws PrintException, IOException {
		PrintersFunction.PrintPdf(printerName, PdfDocument);
		
	}
	
	
	
	
	

	
	
	
}