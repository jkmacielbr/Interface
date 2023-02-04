package orchestrator;

import interfaces.FolderManagement;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FolderOrchestrator implements FolderManagement {
    File file;
    Scanner tc = new Scanner(System.in);


    public void createFolders(List<String>mFileListPath){
        for (String path: mFileListPath) {

            createAFolder(path);
        }

    }
    public void removeFolders(List<String>mFileListPath){

        for (String path: mFileListPath) {

            removeAFolder(path);
        }

    }

    public void delete(File file){
        if(file.isDirectory()){
            File [] files = file.listFiles();
            for (File filelist : files){
                delete(filelist);
            }
        } file.delete();
    }

    @Override
    public void createAFolder(String path) {
        file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

    }

    @Override
    public void removeAFolder(String path) {
      file = new File(path);
        delete(file);


    }

    @Override
    public void listAllFoldersCreated() {
        System.out.println("DIRECTORY PATH");
        String directory = tc.nextLine();
        file = new File(directory+"/");
        File [] aFile = file.listFiles();
        Arrays.sort(aFile);
        if(file.isDirectory()){
        for (File listFile: aFile) {
            if (listFile.isDirectory()) {
                System.out.println(listFile.getName());
            }

        }
        } else System.out.println("NOT FOUND FOLDERS");


    }
}
