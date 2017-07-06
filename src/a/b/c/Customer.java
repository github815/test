package a.b.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	BufferedReader br;
	BufferedWriter bw;
	FileReader fr;
	FileWriter fw;
	List<String> list;
	String name;
	String mobile;
		
	public void startProcess() {
		br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		System.out.println("## �ּҷ� ���� ȭ���Դϴ�. ##\r\n");
		while (true) {
			try {
				router();
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��� �ּ���.");
			} catch (Exception e) {
				break;
			}
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//public void router() throws Exception {
	public void router() {
		try{
			System.out.print("[1] �߰� , [2] ��� , [3] �˻� , [4] ���� , [5] ���� ,[0] �ʱ�޴��� ���� : ");
		String tempc = br.readLine();
		int act = Integer.parseInt(tempc);
		
		switch (act) {
		case 1: // �Է�
			addressadd();
			break;
		case 2: // ���
			addresslist();
			break;
		case 3: // �˻�
			addresssearch();
			break;
		case 4: // ����
			addressmodify();
			break; 
		case 5: 
			addressdelete(); 
			break;
		case 0: // ������
			System.out.println("## �ּҷ� ���� ȭ���� �����ϴ�. ##\r\n");
			Videomain.start();
			//throw new Exception();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void addressadd() {
		BufferedWriter bfw;
		try {
			fw = new FileWriter("CustomerFile.txt",  true);
			bfw = new BufferedWriter(fw);
			System.out.print("�̸��� �Է��� �ּ��� : ");
			name = br.readLine();
			System.out.print("�޴��� ��ȣ�� �Է��� �ּ��� : ");
			mobile = br.readLine();
			bfw.write(name + "\r\n");
			bfw.write(mobile + "\r\n");
			System.out.println("���Ͽ� ����Ǿ����ϴ�\r\n");
			bfw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean contains(String keyword) {
		return name.contains(keyword) || mobile.contains(keyword);
	}
	
//	@Override
	//public String toString() {
	//	return name + " - " + mobile;
	//}
	
	public void addresslist() throws IOException{
		BufferedReader bfr;
		try {
			fr = new FileReader("CustomerFile.txt");
			bfr = new BufferedReader(fr);
			String s = null;
			int no = 1;
			while ((s = bfr.readLine()) != null) { 
				System.out.print(no + ". " + "ȸ���� : " + s);
				s = bfr.readLine();
				System.out.println("  " + "������ ��ȣ : " + s);
				no++;
			}
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void addresssearch() throws IOException{
		BufferedReader bfr;
		try{
			fr = new FileReader("CustomerFile.txt");
			bfr = new BufferedReader(fr);
			String s = null;
			System.out.print("�˻��� ȸ������ �Է��� �ּ��� : ");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.contains(keyword)) {
					System.out.print("ȸ���� : " + s);
					s = bfr.readLine();
					System.out.println("  " + "������ ��ȣ : " + s);
				}
			
		}
			bfr.close();
			fr.close();
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	public void addressmodify() throws IOException {
		BufferedReader bfr;
		BufferedWriter bfw;
		try{
			fr = new FileReader("CustomerFile.txt");
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
			File fileNew = new File("CustomerFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch(IOException e){
			e.printStackTrace();
		}
			
	}
	
	public void addressdelete() throws IOException{
		BufferedReader bfr;
		BufferedWriter bfw;
		
		try{
			fr = new FileReader("CustomerFile.txt");
			bfr = new  BufferedReader(fr);
			fw = new FileWriter("TempFile.txt");
			bfw = new BufferedWriter(fw);
			String s = null;
			System.out.print("������ ȸ������  �Է����ּ���");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.equals(keyword)){
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
			File fileNew = new File("CustomerFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


