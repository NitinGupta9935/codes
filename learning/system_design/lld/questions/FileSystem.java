// "static void main" must be defined in a public class.

import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.DirectoryManager;

public class FileSystem {
    public static void main(String[] args) {
        FileSystem m = new FileSystem();

        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        
        m.terminal("1", "/Downloads/Movies/dhurander.mp4", "");
        // m.terminal("2", "/Downloads/Movies/dhurander.mp4", "Hello_world");
        // m.terminal("3", "/Downloads/Movies/dhurander.mp4", "");
        // m.terminal("1", "/Downloads/Audio/song.mp3", "");
        // m.terminal("5", "", "");

    }
    
    public void terminal(String command, String path, String data) {
        FileSystemManager fs = FileSystemManager.getInstance();
                
        switch(command) {
            case "1":
                fs.createPath(path);
                System.out.println(path + " is created");
                break;
                
            case "2":
                fs.setFileContent(path, data);
                System.out.println(data + " is written in file " + path);
                break;
                
            case "3":
                data = fs.getFileContent(path);
                System.out.println("Data is: " + data);
                break;
                
            case "4":
                fs.deletePath(path);
                System.out.println("path: " + path + " is successfully deleted");
                break;
                
            case "5":
                fs.display();
                break;
                
            default:
                System.out.println("Wrong command Entered!!!");
        }
    }
}

class FileSystemManager {
    private Node root;
    private static FileSystemManager instance;
    
    private FileSystemManager() {
        root = new Directory("");
    }
    
    public static FileSystemManager getInstance() {
        if (instance == null) {
            synchronized(FileSystemManager.class) {
                if (instance == null)
                    instance = new FileSystemManager();
            }
        }
        
        return instance;
    }
    
    public void createPath(String path) {
        String arr[] = path.split("/");
        int n = arr.length;
        Node node = root;
        
        for (int i = 1; i < n; i++) {
            String name = arr[i];
            
            if (!node.hasChild(name))
                node.addChild(name);
            node = node.getChild(name);
        }
    }
    
    public Node getPath(String path) {
        String arr[] = path.split("/");
        int n = arr.length;
        Node node = root;
        
        for (int i = 1; i < n; i++) {
            String name = arr[i];
            node = node.getChild(name);
        }
        return node;
    }
    
    public void setFileContent(String path, String data) {
        File file = (File) getPath(path);
        file.setContent(data);
    }
    
    public String getFileContent(String path) {
        File file = (File) getPath(path);
        return file.getContent();
    }
    
    public void deletePath(String path) {
        String arr[] = path.split("/");
        int n = arr.length;
        Node node = root;
        
        for (int i = 1; i < n; i++) {
            String name = arr[i];
            Node child = node.getChild(name);
            node.removeChild(name);
            node = child;
        }
    }
    
    public void display() {
        root.display(0);
    }
}

abstract class Node {
    String name;
    Map<String, Node> childrens;
    
    public Node(String name) {
        this.name = name;
        childrens = new HashMap<>();
    }
    
    public boolean hasChild(String name) {
        return childrens.containsKey(name);
    }
    
    public void addChild(String name) {
        Node child;
        if (name.contains("."))
            child = new File(name);
        else
            child = new Directory(name);
        
        childrens.put(name, child);
    }
    
    public Node getChild(String name) {
        return childrens.get(name);
    }
    
    public void removeChild(String name) {
        childrens.remove(name);
    }
    
    public abstract boolean isFile();
    public abstract void display(int index);
}

class Directory extends Node {
    public Directory(String name) {
        super(name);
    }
    
    public boolean isFile() {
        return false;
    }
    
    public void display(int index) {
        for (int i = 0; i < index; i++)
            System.out.print("-");
    
        System.out.println(name);
        
        for (Node child: childrens.values())
            child.display(index + 1);
    }
}

class File extends Node {
    private String data;
    
    public File(String name) {
        super(name);
        data = "";
    }
    
    public boolean isFile() {
        return true;
    }
    
    public void setContent(String data) {
        this.data = data;
    }
    
    public String getContent() {
        return data;
    }
    
    public void display(int index) {
        for (int i = 0; i < index; i++)
            System.out.print("-");
        
        System.out.println(name);
        
        for (Node child: childrens.values())
            child.display(index + 1);
    }
}