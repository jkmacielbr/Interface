package interfaces;

import model.MFileAnnotationTypeEnum;

import java.io.IOException;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile);

    void recoveryFile(String directory,String nameFile, MFileAnnotationTypeEnum type);

    void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type);

    void listAllFiles(String directory);

}
