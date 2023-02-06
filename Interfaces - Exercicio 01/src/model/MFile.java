package model;

public class MFile {
    private String content;
    private String nameFile;
    private MFileAnnotationType type;

    public MFile(String content, String nameFile, MFileAnnotationType type) {
        this.content = content;
        this.nameFile = nameFile;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getNameFile() {
        return nameFile;
    }


    public MFileAnnotationType getType() {
        return type;
    }

}
