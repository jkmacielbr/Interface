import model.MFile;
import model.MFileAnnotationTypeEnum;
import orchestrator.FileOrchestrator;

import java.util.ArrayList;
import java.util.List;

public class HandlerFile extends FileOrchestrator {

    private List <MFile> mFileList = new ArrayList<>();

    public HandlerFile(MFile mFile) {
        if (mFile.getType().equals(MFileAnnotationTypeEnum.IMAGE)){
            mFileList.add(mFile);
            saveAllListOfImagesFiles(mFileList);

        }

    }

    public HandlerFile(){

    }








}
