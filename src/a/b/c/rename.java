package a.b.c;

import java.io.File;
import java.io.IOException;
 
/**
 * �����̸� ����
 */
 
public class rename {
    public static void main(String[] args) throws IOException{
        File f = new File("TempFile.txt");
        File t = new File("VideoFile.txt");
        if(f.exists()){
            f.renameTo(t);
            System.out.println("�̸��ٲٱ� �Ϸ�");
            System.out.print("FileRenameMain.class->");
            System.out.println("FileRenameMain_backup.class");
        }else{
            System.out.println(f.getName() + " ������ �������� �ʽ��ϴ�.");
        }
    }

}
