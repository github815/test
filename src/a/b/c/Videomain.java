package a.b.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Videomain {
	static BufferedReader cr;
	public static void main(String[] args) {
		start();
	}
	public static void start() {
		cr = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("## ���Ͻô� �޴��� �������ּ���. ##");
		while (true) {
			try {
				mainmenue();
			} catch (NumberFormatException e){
				System.out.println("���ڸ� �Է��� �ּ���.");
			} catch (Exception e) {
				break;
			}
		}
		try {
			cr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		System.out.println("## �Է��� ����˴ϴ�. ##");
		}
	
	public static void mainmenue() throws Exception {
		System.out.print("[1] ȸ������ ,[2] �������� ,[3] �뿩����, [0] ����: ");
		String tempvm = cr.readLine();
		int act = Integer.parseInt(tempvm);
		switch (act){
		case 1:
			new Customer().startProcess();
			break;
		case 2:
			new Video().startm();
			break;
		case 3:
			new Rental().startr();
			break;
		case 0:
			throw new Exception();  //���ѹݺ�
		}
		
	} 

}
