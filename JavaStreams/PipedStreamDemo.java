import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) throws IOException {
        PipedOutputStream pout = new PipedOutputStream();
        PipedInputStream pin = new PipedInputStream(pout);

        Thread writerThread = new Thread(new WriterThread(pout));
        Thread readerThread = new Thread(new ReaderThread(pin));

        writerThread.start();
        readerThread.start();
    }
}

class WriterThread implements Runnable {
    private PipedOutputStream pout;

    public WriterThread(PipedOutputStream pout) {
        this.pout = pout;
    }

    @Override
    public void run() {
        try {
            String[] messages = {
                "Hello from writer thread",
                "This is inter-thread communication",
                "Using Piped Streams in Java",
                "End"
            };

            for (String msg : messages) {
                pout.write(msg.getBytes());
                pout.write('\n'); 
                pout.flush();
                Thread.sleep(500); 
            }
            pout.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread implements Runnable {
    private PipedInputStream pin;

    public ReaderThread(PipedInputStream pin) {
        this.pin = pin;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pin))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
