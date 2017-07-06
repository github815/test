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
		System.out.println("## 원하시는 메뉴를 선택해주세요. ##");
		while (true) {
			try {
				mainmenue();
			} catch (NumberFormatException e){
				System.out.println("숫자를 입력해 주세요.");
			} catch (Exception e) {
				break;
			}
		}
		try {
			cr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		System.out.println("## 입력이 종료됩니다. ##");
		}
	
	public static void mainmenue() throws Exception {
		System.out.print("[1] 회원관리 ,[2] 비디오관리 ,[3] 대여관리, [0] 종료: ");
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
			throw new Exception();  //무한반복
		}
		
	} 

}
