import model.MFile;
import model.MFileAnnotationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> mFileLista = new ArrayList<>();
    static String directory, nameFile, content, nameImage;
    static MFileAnnotationType type = null;
    static int op;
    static Scanner tc = new Scanner(System.in);

    public static void main(String[] args) {

        int opMenu;
        do {
            Screen.screenMenu();
            opMenu = tc.nextInt();
            tc.nextLine();

            switch (opMenu) {
                case 1 -> folderManager();

                case 2 -> {
                    Screen.screenImage();
                    imageManager();
                }
                case 3 -> {
                    Screen.screenFile();
                    op = tc.nextInt();
                    tc.nextLine();
                    fileManager();
                }

            }

        } while (opMenu != 0);
    }


    public static void folderManager() {

        do {
            Screen.screenFolder();
            op = tc.nextInt();

            if (op == 1) {
                do {
                    tc.nextLine();
                    directory = new HandlerFile().typeDirectory();

                    mFileLista.add(directory);
                    System.out.println("[0] SAIR");
                    System.out.println("[1] NEW DIRECTORY");
                    op = tc.nextInt();
                } while (op != 0);
                new HandlerFile().createFolders(mFileLista);

            } else if (op == 2) {
                do {
                    System.out.println("[0] SAIR");
                    System.out.println("[1] DELETE FOLDER");
                    op = tc.nextInt();

                    if (op == 1) {
                        tc.nextLine();
                        directory = new HandlerFile().typeDirectory();

                        mFileLista.add(directory);
                    }

                } while (op != 0);
                System.out.println(directory);
                new HandlerFile().removeFolders(mFileLista);

            } else if (op == 3) {
                new HandlerFile().listAllFoldersCreated();

            } else if (op != 0) {
                System.out.println("Invalid Option");
            }

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
                content = tc.nextLine();
                new HandlerFile(new MFile(content, nameFile, MFileAnnotationType.IMAGE));
            } else if (op == 2) {
                System.out.println("IMAGE NAME");
                tc.nextLine();
                nameImage = tc.nextLine();
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();

                new HandlerFile().removeImageFile(directory + "/image/", nameImage);
            } else if (op == 3) {
                tc.nextLine();
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();
                new HandlerFile().listAllImageFiles(directory);
            } else if (op == 4) {
                tc.nextLine();
                System.out.println("DIRECTORY IMAGE");
                directory = tc.nextLine();
                System.out.println("NAME IMAGE");
                nameImage = tc.nextLine();
                new HandlerFile().recoveryImageFile(directory, nameFile);
            }

            System.out.println("[0] EXIT");
            System.out.println("[1] CONTINUE");
            op = tc.nextInt();

            tc.nextLine();

        } while (op != 0);

    }

    public static MFileAnnotationType checkType() {
        System.out.println("[1] REMINDER \t\t[2] IMPORTANT \t\t [3] SIMPLE");
        op = tc.nextInt();
        if (op == 1) {
            type = MFileAnnotationType.REMINDER;
        } else if (op == 2) {
            type = MFileAnnotationType.IMPORTANT;
        } else if (op == 3) {
            type = MFileAnnotationType.SIMPLE;
        } else {
            System.out.println("INVALID OPTION");
            return checkType();
        }

        return type;

    }

    public static void fileManager() {
        switch (op) {

            case 1 -> {

                System.out.println("CONTENT");
                content = tc.nextLine();
                System.out.println("NAME FILE");
                nameFile = tc.nextLine();

                type = checkType();
                new HandlerFile(new MFile(content, nameFile, type));
            }
            case 2 -> {

                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();
                System.out.println("NAME FILE");
                nameFile = tc.nextLine();

                new HandlerFile().recoveryFile(directory, nameFile, type);

            }

            case 3 -> {
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();
                System.out.println("NAME FILE");
                nameFile = tc.nextLine();
                type = checkType();
                new HandlerFile().removeFile(directory, nameFile, type);


            }
            case 4 -> {
                System.out.println("DIRECTORY PATH");
                directory = tc.nextLine();
                new HandlerFile().listAllFiles(directory);
            }

        }

    }
}