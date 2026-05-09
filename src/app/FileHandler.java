package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException ex) {
            return "File already exists!";
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (FileNotFoundException ex) {
            return "File not found";
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (FileNotFoundException ex) {
            return "File not found";
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
    }
}
