import converter.DocumentConverter;
import converter.PdfConverter;
import document.Document;

public class Main {
    public static void main(String[] args) {
        DocumentConverter converter = new PdfConverter();
        Document document = converter.convertDocument("word");

        System.out.println("Document is converted to " + document.getName());
    }
}