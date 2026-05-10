package app;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final String BASE_PATH = "files/";

    static void main(String[] args) {

        String fileName = "myFile";
        String content = "Super information.";
        String path = BASE_PATH + fileName + ".txt";

        FileHandler handler = new FileHandler();

        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(path, content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    static void getOutput(String output) {
        System.out.println(output);
    }
}
