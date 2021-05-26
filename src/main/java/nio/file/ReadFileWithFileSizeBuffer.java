package nio.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileWithFileSizeBuffer {
    public static void main(String args[]) {
        try {

            /*
            The Java RandomAccessFile class in the Java IO API allows you to move navigate a file
            and read from it or write to it as you please. You can replace existing parts of a file too.
            This is not possible with the FileInputStream or FileOutputStream.
             */
            RandomAccessFile aFile = new RandomAccessFile("src/main/java/nio/file/test.txt", "r");  // r - read only (rw - read and write)

            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();

            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            buffer.flip();

            //Verify the file content
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) buffer.get());
            }

            inChannel.close();
            aFile.close();
        } catch (IOException exc) {
            System.out.println(exc);
            System.exit(1);
        }
    }
}
