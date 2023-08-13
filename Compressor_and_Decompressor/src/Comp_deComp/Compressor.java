package Comp_deComp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();//gets the path of the next level parent of the file;

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;

        while((len=fis.read(buffer))!=-1) {//loops till the whole length of the inputstream bytes;
            gzip.write(buffer, 0, len);//writes the whole bytes of the buffer array into the outputfile
        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
