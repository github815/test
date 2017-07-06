package a.b.c;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class read {
    public static void main( String argv[] ) throws IOException{
        BufferedReader inputFile;
        try {
            inputFile = new BufferedReader(new FileReader("VideoFile.txt"));
            String str = null;
            while ((str = inputFile.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}	
