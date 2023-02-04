package model;

public class MFile {
    private String content;
    private String nameFile;
    private MFileAnnotationTypeEnum type;

    public MFile(String content, String nameFile, MFileAnnotationTypeEnum type) {
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


    public MFileAnnotationTypeEnum getType() {
        return type;
    }

}
