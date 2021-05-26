package nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class DataTransferBetweenChannels {
    public static void main(String[] argv) throws Exception
    {
        //Input files
        String[] inputFiles = new String[]{
                "src/main/java/nio/channel/fileChannel1.txt",
                "src/main/java/nio/channel/fileChannel2.txt",
                "src/main/java/nio/channel/fileChannel3.txt"
        };

        //Files contents will be written in these files
        String outputFile = "src/main/java/nio/channel/fileResultChannel.txt";

        //Get channel for output file
        FileOutputStream fos = new FileOutputStream(new File(outputFile));
        WritableByteChannel targetChannel = fos.getChannel();

        for (int i = 0; i < inputFiles.length; i++)
        {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fis.close();
        }

        //finally close the target channel
        targetChannel.close();
        fos.close();
    }
}
