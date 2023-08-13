package Comp_deComp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class deCompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();//gets the path of the next level parent of the file;

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);//takes compressed gzip file as input
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");// gives output as normal file;

        byte[] buffer = new byte[1024];
        int len;

        while((len=gzip.read(buffer))!=-1) {//loops till the whole length of the inputstream bytes;
             fos.write(buffer, 0, len);//writes the whole bytes of the buffer array into the outputfile
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
