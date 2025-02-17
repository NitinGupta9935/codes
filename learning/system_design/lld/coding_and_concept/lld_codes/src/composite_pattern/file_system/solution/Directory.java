package composite_pattern.file_system.solution;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    public String directoryName;
    List<FileSystem> fileSystemList = new ArrayList<>();

    public Directory(String name) {
        this.directoryName = name;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj) {
        fileSystemList.add(fileSystemObj);
    }

    @Override
    public void ls() {
        System.out.println("Directory name " + directoryName);

        for (FileSystem fileSystemObj: fileSystemList)
            fileSystemObj.ls();
    }
}
