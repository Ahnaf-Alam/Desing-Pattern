package document;

public abstract class Document {
    private String name;
    private String size;
    private String type;
    private String content;

    public void writeContent() {
        System.out.println("Content : " + content);
        System.out.println("Document type: " + type);
        System.out.println("Size of the document: " + size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
