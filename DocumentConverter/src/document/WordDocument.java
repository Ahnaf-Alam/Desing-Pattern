package document;

public class WordDocument extends Document {
    private String content = "Here is the content of the word document";
    private String name = "A-Word-doc";
    private String type = "This is a word document";
    private String size = "5KB";

    public WordDocument() {
        setName(name);
        setSize(size);
        setType(type);
        setContent(content);
    }
}
