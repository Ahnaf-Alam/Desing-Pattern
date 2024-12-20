package document;

public class PdfDocument extends Document {
    private String content = "Here is the content of the pdf document";
    private String name = "A-pdf-doc";
    private String type = "This is a pdf document";
    private String size = "10KB";

    public PdfDocument() {
        setName(name);
        setSize(size);
        setType(type);
        setContent(content);
    }
}
