package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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

    public String writeToFile(String path, String content) {
        try {
            if (Files.notExists(Path.of(path))) {
                throw new NoSuchFileException("File not found");
            }
            Files.writeString(Path.of(path), content);
        } catch (NoSuchFileException ex) {
            return ex.getMessage();
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (NoSuchFileException ex) {
            return "File not found";
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
    }
}
