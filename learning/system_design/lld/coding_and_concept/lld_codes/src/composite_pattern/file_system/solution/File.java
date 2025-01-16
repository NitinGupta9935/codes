package composite_pattern.file_system.solution;

public class File implements FileSystem {
    public String fileName;

    public File(String name) {
        this.fileName = name;
    }

    @Override
    public void ls() {
        System.out.println("File name " + fileName);
    }
}
