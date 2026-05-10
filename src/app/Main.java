package app;

public class Main {

    private static final String BASE_PATH = "files/";

    static void main(String[] args) {

        String fileName = "myFile.txt";
        String content = "Super information.";
        String path = BASE_PATH + fileName;

        FileHandler handler = new FileHandler();

        try {
            handler.createFile(path);
            handler.writeToFile(path, content);
            handler.readFromFile(path);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
