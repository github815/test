package a.b.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Rental {

	BufferedReader br;
	FileReader frc;
	FileReader frv;
	FileReader frr;
	FileWriter fw;
	String rentalname;
	String moviename;
	String rentalperiod;
	
	
	public void startr() {
		br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\r\n## ���� �뿩 ȭ���Դϴ�. ##");
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
			System.out.print("[1] �뿩 , [2] �ݳ� , [3]��� , [4] �˻� , [5] ���� , [6] ���� ,[0] �ʱ�޴��� ���� : ");
			String tempv = br.readLine();
			int act = Integer.parseInt(tempv);
			switch (act) {
			case 1:
				rentaladd();
				break;
			case 2:
				returned();
				break;
			case 3:
				rentallist();
				break;
			case 4:
				rentalsearch();
				break;
			case 5:
				rentalmodify();
				break; 
			case 6: 
				rentaldelete(); 
				break; 
			case 0: 
				System.out.println("## ���� �뿩 ȭ���� �����ϴ�. ##\r\n"); 
				Videomain.start(); 
			}
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rentaladd() throws IOException {
		BufferedReader bfrc;
		BufferedReader bfrv;
		BufferedWriter bfw;
		try {
			frc = new FileReader("CustomerFile.txt");
			bfrc = new BufferedReader(frc);
			frv = new FileReader("VideoFile.txt");
			bfrv = new BufferedReader(frv);
			fw = new FileWriter("RentalFile.txt",  true);
			bfw = new BufferedWriter(fw);
			System.out.print("ȸ���� �̸��� �Է����ּ��� :");
			rentalname = br.readLine();
			System.out.print("��ȭ�� ������ �Է����ּ��� :");
			moviename = br.readLine();
			System.out.print("�뿩 �������� �Է����ּ��� :");
			rentalperiod = br.readLine();
			String s = null;
			while ((s = bfrc.readLine()) != null){
				if (s.equals(rentalname)) {
					bfw.write(s);
					bfw.newLine();
					s = bfrc.readLine();
					bfw.write(s);	
					bfw.newLine();
				}				
			}
			while ((s = bfrv.readLine()) != null){
				if (s.equals(moviename)) {
					bfw.write(s);
					bfw.newLine();
					s = bfrv.readLine();
					bfw.write(s);
					bfw.newLine();
					s = bfrv.readLine();
					bfw.write(s);		
					bfw.newLine();
					bfw.write(rentalperiod);
					bfw.newLine();
				}
			}
			bfrc.close();
			frc.close();
			bfw.close();
			fw.close();
			} catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
			
	public void returned() throws IOException{
		BufferedReader bfr;
		BufferedWriter bfw;
		try{
			frr = new FileReader("RentalFile.txt");
			bfr = new BufferedReader(frr);
			fw = new FileWriter("TempFile.txt");
			bfw = new BufferedWriter(fw);
			String s = null;
			System.out.print("�ݳ� ó���� ȸ������ �Է����ּ���");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.equals(keyword)){
					bfw.write(s);
					s = bfr.readLine();
					bfw.newLine();
					bfw.write(s);
					s = bfr.readLine();
					bfw.newLine();
					bfw.write(s);
					s = bfr.readLine();
					bfw.newLine();
					bfw.write(s);
					s = bfr.readLine();
					bfw.newLine();
					bfw.write(s);
					s = bfr.readLine();
					s = "�ݳ�";
					bfw.newLine();
				}
				bfw.write(s);
				bfw.newLine();
			}
			bfr.close();
			frr.close();
			bfw.close();
			fw.close();
			File file = new File("TempFile.txt");
			File fileNew = new File("RentalFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void rentallist() throws IOException{
		BufferedReader bfr;
		try {
			frr = new FileReader("RentalFile.txt");
			bfr = new BufferedReader(frr);
			String s = null;
			int no = 1;
			while ((s = bfr.readLine()) != null) {
				System.out.print(no + "." + "ȸ���� : " + s );
				s = bfr.readLine();
				System.out.print("   " + "�ڵ�����ȣ : " + s );
				s = bfr.readLine();
				System.out.print("   "+ "��ȭ���� : " + s );
				s = bfr.readLine();
				System.out.print("   "+ "����� : " + s );
				s = bfr.readLine();
				System.out.print("   "+ "�帣 : " + s );
				s = bfr.readLine();
				System.out.println("   "+ "�뿩������ : " + s );
				no++;
			}
			bfr.close();
			frr.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void rentalsearch() throws IOException {
		BufferedReader bfr;
		try{
			frr = new FileReader("RentalFile.txt");
			bfr = new BufferedReader(frr);
			String s = null;
			System.out.print("�˻��� ȸ������ �Է��� �ּ��� : ");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.contains(keyword)){
					System.out.print("ȸ���� : " + s );
					s = bfr.readLine();
					System.out.print("   " + "�ڵ�����ȣ : " + s );
					s = bfr.readLine();
					System.out.print("   "+ "��ȭ���� : " + s );
					s = bfr.readLine();
					System.out.print("   "+ "����� : " + s );
					s = bfr.readLine();
					System.out.print("   "+ "�帣 : " + s );
					s = bfr.readLine();
					System.out.println("   "+ "�뿩 ������ : " + s );
					s = bfr.readLine();
				}
			} 
		} catch (FileNotFoundException e){
				e.printStackTrace();
			}
	}
	
	public void rentalmodify() throws IOException {
		BufferedReader bfr;
		BufferedWriter bfw;
		try{
			frr = new FileReader("RentalFile.txt");
			bfr = new BufferedReader(frr);
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
			frr.close();
			bfw.close();
			fw.close();
			File file = new File("TempFile.txt");
			File fileNew = new File("RentalFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void rentaldelete() throws IOException{
		BufferedReader bfr;
		BufferedWriter bfw;
		try{
			frr = new FileReader ("RentalFile.txt");
			bfr = new BufferedReader(frr);
			fw = new FileWriter("TempFile.txt");
			bfw = new BufferedWriter(fw);
			String s = null;
			System.out.print("������ ȸ������ �Է��� �ּ���");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.equals(keyword)){
					s = bfr.readLine();
					s = bfr.readLine();
					s = bfr.readLine();
					s = bfr.readLine();
					s = bfr.readLine();
					
				}
				else {
					bfw.write(s);
					bfw.newLine();
				}
			}
			bfr.close();
			frr.close();
			bfw.close();
			fw.close();
			File file = new File("TempFile.txt");
			File fileNew = new File("RentalFile.txt");
			fileNew.delete();
			file.renameTo(fileNew);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}