package a.b.c;

import java.io.File;
import java.io.IOException;
 
/**
 * 파일이름 변경
 */
 
public class rename {
    public static void main(String[] args) throws IOException{
        File f = new File("TempFile.txt");
        File t = new File("VideoFile.txt");
        if(f.exists()){
            f.renameTo(t);
            System.out.println("이름바꾸기 완료");
            System.out.print("FileRenameMain.class->");
            System.out.println("FileRenameMain_backup.class");
        }else{
            System.out.println(f.getName() + " 파일이 존재하지 않습니다.");
        }
    }

}
