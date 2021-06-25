package main;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.print.PrintException;

import remotePrintService.PrintServiceRemote;
/**
 * 
 * @author ironblaster, Vidaniello
 *
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PrintService implements PrintServiceRemote {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8892292741230001812L;







	public Collection<String> getIntalledPrinters() {
		 
		return PrintersFunction.getInstalledPrinters();
	}

	
	




	public void printPdfDocument(String printerName, byte[] pdfDocument) throws PrintException, IOException {
		
		PrintersFunction.PrintPdf(printerName, pdfDocument);
		
	}







	@Override
	public void printZplLabel(String printerName, String ZplCode) throws PrintException, IOException {
		
		PrintersFunction.PrintZpl(ZplCode, printerName);
	}

	
	
	
	
	

	
	
	
}