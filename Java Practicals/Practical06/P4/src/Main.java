import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "/Users/debdootmanna/Desktop/source.txt";
        String destinationFile = "/Users/debdootmanna/Documents/destination.txt";

        try {
            Path sourcePath = Paths.get(sourceFile);
            Path destinationPath = Paths.get(destinationFile);

            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File copied successfully!");
            System.out.println("From: " + sourcePath);
            System.out.println("To: " + destinationPath);
            System.out.println("This Practical is made by 23CS043 Debdoot Manna");

        } catch (IOException e) {
            System.err.println("An error occurred while copying the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}