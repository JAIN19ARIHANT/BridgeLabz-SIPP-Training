import java.io.*;

public class FileCopyPerformance {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) throws IOException {
        File source = new File("source.dat");
        File destinationBuffered = new File("destination_buffered.dat");
        File destinationUnbuffered = new File("destination_unbuffered.dat");

        // Buffered copy
        long startBuffered = System.nanoTime();
        copyWithBufferedStream(source, destinationBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Stream Time: " + ((endBuffered - startBuffered) / 1_000_000) + " ms");

        // Unbuffered copy
        long startUnbuffered = System.nanoTime();
        copyWithUnbufferedStream(source, destinationUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + ((endUnbuffered - startUnbuffered) / 1_000_000) + " ms");
    }

    private static void copyWithBufferedStream(File source, File destination) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source), BUFFER_SIZE);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination), BUFFER_SIZE)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void copyWithUnbufferedStream(File source, File destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
