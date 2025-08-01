import java.io.*;

public class UpperCaseToLowerCase {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        File inputFile = new File(sourceFile);

        if (!inputFile.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            return;
        }

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(Character.toLowerCase((char) byteData));
            }

            System.out.println("File copied successfully to " + destFile);

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing files.");
            e.printStackTrace();
        }
    }
}
