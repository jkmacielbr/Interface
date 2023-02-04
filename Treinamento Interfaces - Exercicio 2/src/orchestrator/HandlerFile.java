package orchestrator;

import model.MFile;
import model.MFileAnnotationTypeEnum;
import orchestrator.FileOrchestrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandlerFile extends FileOrchestrator {

    static Scanner tc = new Scanner(System.in);

    private List <MFile> mFileList = new ArrayList<>();

    public HandlerFile(MFile mFile) {
        if (mFile.getType().equals(MFileAnnotationTypeEnum.IMAGE)){
            mFileList.add(mFile);
            saveAllListOfImagesFiles(mFileList);

        } else if (mFile.getType().equals(MFileAnnotationTypeEnum.REMINDER) || mFile.getType().equals(MFileAnnotationTypeEnum.SIMPLE)
                || mFile.getType().equals(MFileAnnotationTypeEnum.IMPORTANT)){
            mFileList.add(mFile);
            saveAllListOfFiles(mFileList);
        }

    }

    public HandlerFile(){

    }

    public String typeDirectory(){

        System.out.println("DIRECTORY PATH");
        String path = tc.nextLine();
        System.out.println("[1] REMINDER \t\t[2] IMPORTANT \t\t [3] SIMPLE \t\t [4] IMAGE");
        int op = tc.nextInt();
        if (op == 1) {
            path += "/reminder/";
        } else if (op == 2) {
            path += "/important/";
        } else if (op == 3) {
            path += "/";
        } else if (op == 4) {
            path += "/image/";
        }

        return path;
    }








}
