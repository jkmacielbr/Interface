package interfaces;

import model.MFileAnnotationType;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationType type, String nameFile);

    void recoveryFile(String directory,String nameFile, MFileAnnotationType type);

    void removeFile(String directory, String nameFile, MFileAnnotationType type);

    void listAllFiles(String directory);

}
