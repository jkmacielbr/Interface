package orchestrator;

import interfaces.FolderManagement;

import java.io.File;

public class FolderOrchestrator implements FolderManagement {
    File file;

    @Override
    public void createAFolder(String path) {
        file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        } else System.out.println("Diretório ja existe");

    }

    @Override
    public void removeAFolder(String path) {
        file = new File(path);
        file.delete();


    }

    @Override
    public void listAllFoldersCreated() {

    }
}
