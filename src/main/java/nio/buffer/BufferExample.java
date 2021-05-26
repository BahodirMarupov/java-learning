package nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferExample {
    public static void main(String[] args)
    {
        String inFileStr = "src/main/java/nio/buffer/Damas.jpg";
        String outFileStr = "src/main/java/nio/buffer/Tico.jpg";
        long startTime, elapsedTime;
        int bufferSizeKB = 4;
        int bufferSize = bufferSizeKB * 1024;

        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");
        System.out.println("Buffer size is " + bufferSize + " KB");
        System.out.println("Using FileChannel with an indirect ByteBuffer of " + bufferSizeKB + " KB");

        try (FileChannel in = new FileInputStream(inFileStr).getChannel();
             FileChannel out = new FileOutputStream(outFileStr).getChannel() )
        {
            // Allocate an indirect ByteBuffer
            ByteBuffer bytebuf = ByteBuffer.allocate(bufferSize);

            startTime = System.nanoTime();

            int bytesCount = 0;
            // Read data from file into ByteBuffer
            while ((bytesCount = in.read(bytebuf)) > 0) {
                // flip the buffer which set the limit to current position, and position to 0.
                bytebuf.flip();
                out.write(bytebuf); // Write data from ByteBuffer to file
                bytebuf.clear(); // For the next read
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
