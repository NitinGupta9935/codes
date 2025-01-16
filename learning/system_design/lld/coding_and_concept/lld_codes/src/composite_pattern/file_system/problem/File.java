package composite_pattern.file_system.problem;

public class File {
    public String fileName;

    public File (String name) {
        this.fileName = name;
    }

    public void ls() {
        System.out.println("File name " + fileName);
    }

}
