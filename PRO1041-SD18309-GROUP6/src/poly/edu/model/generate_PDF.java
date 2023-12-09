
package poly.edu.model;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileNotFoundException;

/**
 *
 * @author Yen Nhi
 */
public class generate_PDF {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "PDF_File.pdf"; // name file
        PdfWriter pdfwriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfwriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        
        Document document = new Document(pdfDocument);
        document.add(new Paragraph("This is my code error")); //document
        
        // layout
        float twocol = 285f;
        float twocol150 = twocol + 150f;
        float twocolumWidth[] = {twocol150, twocol};
        
        Table table = new Table(twocolumWidth);
//        table.addCell(new Cell().add("HÓA ĐƠN"));
        document.add(table);
        
        document.close();
    }
}
