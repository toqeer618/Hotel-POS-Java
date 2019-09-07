package ViewPkg;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class createPdf {
	public  createPdf()
	{
		System.out.println("::::");
	}
	
	public static void genBill(String[][] arr, String custDetails, int orderID)
	{
	try {	///.out.println(arr[0][0]);
		String filename="C:\\eclipse\\bill"+orderID+".pdf";
			Document doc1 = new Document();
			PdfWriter.getInstance(doc1, new FileOutputStream (filename));
		    doc1.open();
		    Font font = new Font();
		    font.setSize(12);

		    Paragraph para= new Paragraph("        							The Conquorers    ");
			doc1.add(para);
			
			doc1.add(new Paragraph("Customer ID:				"+custDetails));
			doc1.add(new Paragraph("OrderID:				"+Integer.toString(orderID)));
			doc1.add(new Paragraph(" "));
			doc1.add(new Paragraph(" "));
			
			
			PdfPTable table = new PdfPTable(3);
			PdfPCell c1 = new PdfPCell(new Phrase("Name of Item"));
			table.addCell(c1);
			
			c1= new PdfPCell(new Phrase("Quantity of Item"));
			table.addCell(c1);
			
			c1= new PdfPCell(new Phrase("Total Price"));
			table.addCell(c1);
			table.setHeaderRows(1);
			for(int i=0; i<arr.length; i++)
			{	table.addCell(arr[i][0]);
			table.addCell(arr[i][1]);
			table.addCell(arr[i][2]);
			
			}
			doc1.add(table);
			doc1.close();
			
			JOptionPane.showMessageDialog(null, "Pdf Generated in C:\\eclipse\\ by name of bill"+orderID+".pdf");
		
	} catch (Exception e) {
		System.out.println(arr[0][0]+"    "+ custDetails+"    "+orderID);
		System.out.println("error");
	}	

	
	}

	
}
