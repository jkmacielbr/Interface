package orchestrator;

import interfaces.FileDatabase;
import interfaces.ImageFileDatabase;
import model.MFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    File file;

    @Override
    public void saveImageFile(String directory, String content, String nameFile) {
        BufferedImage image;
        try {
            URL url = new URL(content);
            image = ImageIO.read(url);
            ImageIO.write(image, "jpeg", new File(directory + nameFile));
        } catch (IOException e) {
            e.printStackTrace();


        }

    }

    public void saveAllListOfImagesFiles(List<MFile> mImageFileList) {
        for (MFile lista : mImageFileList) {
            String diretorio = "src/Diretorios Arquivos/images/";

            file = new File(diretorio);
            if (file.exists()) {

                saveImageFile(diretorio, lista.getContent(), lista.getNameFile());
            } else System.out.println("Diretório não existe");

        }
    }

    @Override
    public void listAllImageFiles(String directory) {
        file = new File(directory);
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            Arrays.sort(afile);
            File arquivos = afile[i];
            System.out.println(arquivos.getName());


        }
    }

    @Override
    public void removeImageFile(String directory, String nameFile) {
        file = new File(directory);
        File [] aFile = file.listFiles();
        for (File listFile : aFile) {
            if (listFile.getName().equals(nameFile)) {
                listFile.delete();
                System.out.println("Deletada com sucesso");
            }


        }
    }

    @Override
    public void recoveryImageFile(String directory) {

    }

}
