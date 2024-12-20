package converter;

import document.Document;
import document.PdfDocument;
import document.WordDocument;

public abstract class DocumentConverter {
    public Document createDocument(String type) {
        if(type.equalsIgnoreCase("pdf")) {
            return new PdfDocument();
        } else if(type.equalsIgnoreCase("word")) {
            return new WordDocument();
        }

        return null;
    }

    public Document convertDocument(String type) {
        Document document = null;

        document = createDocument(type);

        document.writeContent();

        return document;
    }
}
