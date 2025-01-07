package Proxy;

import java.util.*;

public interface File {
    public void downloadFile();
    public void readFile();
}

class RealFile implements File{
    private String fileName;

    public RealFile(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void downloadFile(){
        System.out.println("Downloading File " + fileName);
    }
    
    @Override
    public void readFile(){
        System.out.println("Reading File " + fileName);
    }
}

class FileProxy implements File{
    private RealFile realFile;
    private Map<String, File> filecashe;
    private ArrayList<String> bannedFiles;
    private String fileName;

    public FileProxy(String fileName) {
        this.fileName = fileName;
        filecashe = new HashMap<>();
        bannedFiles = new ArrayList<>();
        bannedFiles.add("Joe");
    }
    
    @Override
    public void downloadFile(){
        if(bannedFiles.contains(fileName))
            System.out.println("Banned File");
        else if(!filecashe.containsKey(fileName)){
            realFile = new RealFile(fileName);
            realFile.downloadFile();
            filecashe.put(fileName, new RealFile(fileName));
        }
        else{
            System.out.println("Already downloaded");
            realFile = (RealFile)filecashe.get(fileName);
        }    
    }
    
    @Override
    public void readFile(){
        if(realFile == null)
            System.out.println("Download File first");
        else
            realFile.readFile();
    }
}

class main {
    public static void main(String[] args) {
        File fileProxy = new FileProxy("Joe");
        fileProxy.downloadFile();
        
        File fileProxy1 = new FileProxy("Beedo");
        fileProxy1.downloadFile();
        fileProxy1.readFile();
        fileProxy1.downloadFile();
    }
}