import model.MFile;
import model.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> mFileFolders = new ArrayList();
    static String directory, nameFile, content, nameImage;
    static int op;
    static Scanner tc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            screenMenu();
            op = tc.nextInt();
            tc.nextLine();

            switch (op) {
                case 1 -> {
                    folderManager();

                }
                case 2 -> {
                    screenImage();
                    imageManager();


                }
                case 3 -> {
                    screenFile();
                    fileManager();
                }

            }

            screenMenu();
            op = tc.nextInt();
        } while (op != 0);


    }

    public static void screenMenu() {
        System.out.println("[1] DIRECTORY MANAGER");
        System.out.println("[2] IMAGE MANAGER");
        System.out.println("[3] FILE MANAGER");
        System.out.println("[0] EXIT");

    }

    public static void screenImage() {
        System.out.println("[1] SAVE IMAGE");
        System.out.println("[2] DELETE IMAGE");
        System.out.println("[3] LIST IMAGES");
        System.out.println("[4] RECOVERY IMAGE");
        System.out.println("[0] EXIT");
    }

    public static void screenFile() {
        System.out.println("[1] SAVE FILE");
        System.out.println("[2] RECOVERY FILE");
        System.out.println("[3] REMOVE FILE");
        System.out.println("[4] LIST FILES");
        System.out.println("[0] EXIT");

    }

    public static void screenDirectory() {
        System.out.println("[1] REMINDERS");
        System.out.println("[2] IMPORTANT");
        System.out.println("[3] IMAGE");
    }

    public static void folderManager() {

        System.out.println("[1] CREATE FOLDER");
        System.out.println("[2] DELETE FOLDER");
        System.out.println("[3] FOLDER LIST");
        System.out.println("[4] EXIT");

        op = tc.nextInt();
        do {

            if (op == 1) {
                do {

                    System.out.println("DIRECTORY PATH");
                    tc.nextLine();
                    directory = tc.nextLine();
                    screenDirectory();
                    op = tc.nextInt();

                    if (op == 1) directory += "/reminder";

                    else if (op == 2) directory += "/important";

                    else if (op == 3) directory += "/image";

                    else System.out.println("Invalid Option");

                    mFileFolders.add(directory);
                    System.out.println("[0] SAIR");
                    System.out.println("[1] NEW DIRECTORY");
                    op = tc.nextInt();
                } while (op != 0);
                new HandlerFile().createFolders(mFileFolders);

            } else if (op == 2) {
                do {
                    System.out.println("[0] SAIR");
                    System.out.println("[1] DELETE DIRECTORY");
                    op = tc.nextInt();
                    if(op ==1) {

                        System.out.println("DIRECTORY PATH");
                        tc.nextLine();
                        directory = tc.nextLine();
                        mFileFolders.add(directory);
                    }



                } while (op != 0);
                System.out.println(directory);
                new HandlerFile().removeFolders(mFileFolders);

            } else if (op == 3){
                tc.nextLine();
                new HandlerFile().listAllFoldersCreated();

            }

            else System.out.println("Invalid Option");


        } while (op != 0);

    }

    public static void imageManager() {
        op = tc.nextInt();

        do {
            if (op == 1) {

                System.out.println("IMAGE NAME");
                tc.nextLine();
                nameFile = tc.nextLine();
                System.out.println("URL IMAGE");
                content = "https://raw.githubusercontent.com/gabiandrade/programacao-orientada-objetos-java/" +
                        "main/src/com/ada/example/segunda/aula/exercicio/File_.jpeg";
//                System.out.println("DIRECTORY PATH");
//                directory = tc.nextLine();
                new HandlerFile(new MFile(content, nameFile, MFileAnnotationTypeEnum.IMAGE));
            } else if (op == 2) {
                System.out.println("IMAGE NAME");
                tc.nextLine();
                nameImage = tc.nextLine();
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();

                new HandlerFile().removeImageFile(directory + "/image/", nameImage);
            } else if (op == 3){
                tc.nextLine();
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();
                new HandlerFile().listAllImageFiles(directory);
            }
            tc.nextLine();
        } while (op != 0);

    }

    public static void fileManager(){

    }
}