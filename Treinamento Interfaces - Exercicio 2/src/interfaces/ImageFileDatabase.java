package interfaces;

public interface ImageFileDatabase {

    void saveImageFile(String directory, String content, String nameFile);

    void listAllImageFiles(String directory);

    void removeImageFile(String directory, String nameFile);

    void recoveryImageFile(String fileName);



}
