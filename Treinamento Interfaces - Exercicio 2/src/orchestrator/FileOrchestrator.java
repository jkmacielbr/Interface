package orchestrator;

import interfaces.FileDatabase;
import interfaces.ImageFileDatabase;
import model.MFile;
import model.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
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
            System.out.println("DIRECTORY PATH");
            String diretorio = tc.nextLine();
            diretorio += "/image/";

            file = new File(diretorio);

            if (file.exists()) {

                saveImageFile(diretorio, lista.getContent(), lista.getNameFile());
            } else System.out.println("DIRECTORY NOT FOUND");

        }
    }

    public void saveAllListOfFiles(List<MFile> mFileList) {
        for (MFile lista : mFileList) {
            System.out.println("DIRECTORY PATH");
            String diretorio = tc.nextLine();
            file = new File(diretorio);
            if (file.exists()) {
                saveFile(diretorio, lista.getContent(), lista.getType(), lista.getNameFile());
            } else System.out.println("DIRECTORY NOT FOUND");

        }

    }

    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {
        if (type.equals(MFileAnnotationTypeEnum.REMINDER)){
            directory += "/reminder";
        }
        else if (type.equals(MFileAnnotationTypeEnum.IMPORTANT)) {
            directory +="/important";

        } else if(type.equals((MFileAnnotationTypeEnum.SIMPLE))){
            directory = directory;
        } else{
            System.out.println("TYPE NOT EXIST");
        }

        file = new File(directory);
        if (file.exists()) {
            directory = file + "/"+nameFile;

            try {
                BufferedWriter escreverTxt = new BufferedWriter(new FileWriter(directory));
                escreverTxt.write(content);
                escreverTxt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("DIRECTORY NOT FOUND");


    }

    @Override
    public void listAllImageFiles(String directory) {
        file = new File(directory + "/image");
        File afile[] = file.listFiles();
        int i = 0;
        if(afile!= null){
        for (int j = afile.length; i < j; i++) {
            Arrays.sort(afile);
            File files = afile[i];
            System.out.println(files.getName());


        }
        } else System.out.println("NOT FOUND DIRECTORY");
    }

    @Override
    public void removeImageFile(String directory, String nameFile) {
        file = new File(directory + nameFile);

        if (file.isFile()) {
            file.delete();
        } else System.out.println("NOT FOUND IMAGE");

    }

    @Override
    public void recoveryImageFile(String directory, String nameFile) {
        directory +="/image/"+nameFile;
        file = new File(directory);

        if (file.isFile()){
            System.out.println(file.getName());

        }


    }

    @Override
    public void recoveryFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

        System.out.println("[1] REMINDER \t\t[2] IMPORTANT \t\t [3] SIMPLE");
        int op = tc.nextInt();
        if (op == 1) {
            directory += "/reminder/";
        } else if (op == 2) {
            directory += "/important/";
        } else if (op == 3) {
            directory += "/";
        }
        else {
            System.out.println("INVALID OPTION");

        }
        String path = directory+nameFile;
        try (BufferedReader leitor = new BufferedReader(new FileReader(path))){
            String lido = leitor.readLine();
            while (lido != null) {
                System.out.println(lido);
                lido = leitor.readLine();
            }

        }catch (IOException e){
            System.out.println("Error"+ e.getMessage());
        }




    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

        if (type.equals(MFileAnnotationTypeEnum.REMINDER)){
            directory += "/reminder/";
        } else if (type.equals(MFileAnnotationTypeEnum.IMPORTANT)) {
            directory += "/important/";

        } else if (type.equals(MFileAnnotationTypeEnum.SIMPLE)) {
            directory += "/";

        } else System.out.println("TYPE NOT EXISTS");

        file = new File(directory + nameFile);
        if(file.exists()) {
            file.delete();
        } else System.out.println("NOT FOUND");


    }

    @Override
    public void listAllFiles(String directory) {
        System.out.println("[1] REMINDER \t\t[2] IMPORTANT \t\t [3] SIMPLE");
        int op = tc.nextInt();

        if (op == 1) {
            directory += "/reminder/";
        } else if (op == 2) {
            directory += "/important/";
        } else if (op == 3) {
            directory += "/";
        }
        else {
            System.out.println("INVALID OPTION");
            listAllFiles(directory);
        }
        file = new File(directory);
        File [] aFile = file.listFiles();

        if (aFile!= null){
        for (File list: aFile) {
            if(list.isFile()){
                System.out.println(list.getName());
            }

        }
        } else System.out.println("NOT FOUND FILES");

    }
}
