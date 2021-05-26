package nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class VectoredIOExample {
    public static void main(String params[])
    {
        String data = "Assalomu alaykum aziz do'stlar!!!";
        gatherBytes(data);
        scatterBytes();
    }

    /* gatherBytes() is used for reading the bytes from the buffers and write it to a file channel.
     */
    public static void gatherBytes(String data)
    {
        //The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);
        GatheringByteChannel gatherer = createChannelInstance("src/main/java/nio/buffer/vectorIO.txt", true);
        //Write the data into file
        try
        { gatherer.write(new ByteBuffer[] { buffer1, buffer2 });
        }
        catch (Exception e)
        { e.printStackTrace();
        }
    }

    /* scatterBytes() is used for reading the bytes from a file channel into a set of buffers.
     */
    public static void scatterBytes()
    {
        //The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        ScatteringByteChannel scatter = createChannelInstance("src/main/java/nio/buffer/vectorIO.txt", false);
        //Reading a data from the channel
        try
        { scatter.read(new ByteBuffer[] { buffer1, buffer2 });
        }
        catch (Exception e)
        { e.printStackTrace();
        }
        //Read the two buffers seperately
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        //Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);
    }

    public static FileChannel createChannelInstance(String file, boolean isOutput)
    {
        FileChannel FChannel = null;
        try
        {
            if (isOutput) {
                FChannel = new FileOutputStream(file).getChannel();
            } else {
                FChannel = new FileInputStream(file).getChannel();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return FChannel;
    }
}
