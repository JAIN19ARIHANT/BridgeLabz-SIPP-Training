import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destinationPath = "destination.txt";

        File sourceFile = new File(sourcePath);

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist: " + sourcePath);
            return;
        }

        // Try-with-resources to handle streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destinationPath);

        } catch (IOException e) {
            System.out.println("An error occurred while handling the file:");
            e.printStackTrace();
        }
    }
}