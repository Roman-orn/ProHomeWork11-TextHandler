package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public void createFile(String path) {
        try {
            Files.createFile(Path.of(path));
            System.out.println("Created " + path);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("File already exists! Path: " + path);
            throw new FileProcessingException(ex);
        } catch (IOException ex) {
            System.out.println("Error creating a file by path: " + path);
            throw new FileProcessingException(ex);
        }
    }

    public void writeToFile(String path, String content) {
        try {
            Files.writeString(Path.of(path), content);
            System.out.println("Recorded in " + path);
        } catch (IOException ex) {
            System.out.println("Error writing a file by path: " + path);
            throw new FileProcessingException(ex);
        }
    }

    public void readFromFile(String path) {
        try {
            System.out.println("CONTENT: " + Files.readString(Path.of(path)));
        } catch (IOException ex) {
            System.out.println("Error reading a file by path: " + path);
            throw new FileProcessingException(ex);
        }
    }
}
