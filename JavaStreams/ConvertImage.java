import java.io.*;

public class ConvertImage {
    private static final String File1 = "source.txt";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(File1);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                baos.write(byteData);
            }

            System.out.println("Original content from file:");
            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
