import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            System.out.println("Enter some text (type 'exit' to finish):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text has been written to output.txt");
            System.out.println("\nThis Practical is made by 23CS043 Debdoot Manna");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("output.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            System.out.println("\nReading the file using byte stream:");
            int byteRead;
            while ((byteRead = bis.read()) != -1) {
                System.out.print((char) byteRead);
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}