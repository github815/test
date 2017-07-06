package a.b.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Video {

	BufferedReader br;
	BufferedWriter bw;
	FileReader fr;
	FileWriter fw;
	List<String> List;
	String moviename;
	String releasedate;
	String genre;
	
	
	public void startm() {
		br= new BufferedReader(new InputStreamReader(System.in));
		List = new ArrayList<>();
		System.out.println("\r\n## ���� ���� ȭ���Դϴ�. ##");
		while (true) {
			try{
				videomenue();
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��� �ּ���.");
			} catch (Exception e){
				break;
			}
		}
		try {
			br.close();
		} catch (Exception e){
			e.printStackTrace();
	 	}
	
	}
	
	public void videomenue() {
		try{
			System.out.print("[1] �߰� , [2] ��� , [3] �˻� , [4] ���� , [5] ���� ,[0] �ʱ�޴��� ���� : ");
			String tempv = br.readLine();
			int act = Integer.parseInt(tempv);
			switch (act) {
			case 1:
				movieadd();
				break;
			case 2:
				movielist();
				break;
			case 3:
				moviesearch();
				break;
			case 4:
				moviemodify();
				break; 
			case 5: 
				moviedelete(); 
				break; 
			case 0: 
				System.out.println("## ���� ���� ȭ���� �����ϴ�. ##\r\n"); 
				Videomain.start(); 
			}
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void movieadd() {
		BufferedWriter bfw;
		try {
			fw = new FileWriter("VideoFile.txt",  true);
			bfw = new BufferedWriter(fw);
			System.out.print("��ȭ�� ������ �Է����ּ��� :");
			moviename = br.readLine();
			System.out.print("��ȭ�� ������� �Է����ּ��� :");
			releasedate = br.readLine();
			System.out.print("��ȭ�� �帣�� �Է����ּ��� :");
			genre = br.readLine();
			bfw.write(moviename + "\r\n");
			bfw.write(releasedate + "\r\n");
			bfw.write(genre + "\r\n");
			//bfw.newLine();
			System.out.println("���Ͽ� ����Ǿ����ϴ�\r\n");
			bfw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(String keyword){
		return moviename.contains(keyword) || releasedate.contains(keyword) || genre.contains(keyword);
	}
	
	public void movielist()	throws IOException{
		BufferedReader bfr;
		try {
			fr = new FileReader("VIdeoFile.txt");
			bfr = new BufferedReader(fr);
			String s = null;
			int no = 1;
			while ((s = bfr.readLine()) != null) { 
				System.out.print(no + ". " + "��ȭ�̸� : " + s);
				s = bfr.readLine();
				System.out.print("  " + "����� : " + s);
				s = bfr.readLine();
				System.out.println("  " + "�帣 : " + s);
				no++;
			}
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public void moviesearch() throws IOException{
		BufferedReader bfr;
		try{
			fr = new FileReader("VideoFile.txt");
			bfr = new BufferedReader(fr);
			String s = null;
			System.out.print("�˻�� �Է��� �ּ��� : ");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.contains(keyword)) {
					System.out.print("��ȭ���� : " + s);
					s = bfr.readLine();
					System.out.print("  " + "����� : " + s);
					s = bfr.readLine();
					System.out.println("  " + "�帣 : " + s);
				}
		}
			bfr.close();
			fr.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void moviemodify()throws IOException {
		BufferedReader bfr;
		BufferedWriter bfw;
		try{
			fr = new FileReader("VideoFile.txt");
			bfr = new BufferedReader(fr);
			fw = new FileWriter("TempFile.txt");
			bfw = new BufferedWriter(fw);
			String s = null;
			System.out.print("������ Ű���带 �Է����ּ���");
			String keyword = br.readLine();
			System.out.print("��ü�� Ű���带 �Է����ּ���");
			String word = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.equals(keyword)){
					s = word;
				}
				bfw.write(s);
				bfw.newLine();
			}
			bfr.close();
			fr.close();
			bfw.close();
			fw.close();
			File file = new File("TempFile.txt");
			File fileNew = new File("VideoFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch(IOException e){
			e.printStackTrace();
		}
			
	}
	
	public void moviedelete() throws IOException{
		BufferedReader bfr;
		BufferedWriter bfw;
		
		try{
			fr = new FileReader("VideoFile.txt");
			bfr = new  BufferedReader(fr);
			fw = new FileWriter("TempFile.txt");
			bfw = new BufferedWriter(fw);
			String s = null;
			System.out.print("������ ��ȭ ������ �Է����ּ���");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.equals(keyword)){
					s = bfr.readLine();
					s = bfr.readLine();  
				}
				else {
					bfw.write(s);
					bfw.newLine();
				}
			}
			
			bfr.close();
			fr.close();
			bfw.close();
			fw.close();
			File file = new File("TempFile.txt");
			File fileNew = new File("VideoFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
