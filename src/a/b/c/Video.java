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
		System.out.println("\r\n## 비디오 관리 화면입니다. ##");
		while (true) {
			try{
				videomenue();
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요.");
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
			System.out.print("[1] 추가 , [2] 목록 , [3] 검색 , [4] 수정 , [5] 삭제 ,[0] 초기메뉴로 가기 : ");
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
				System.out.println("## 비디오 관리 화면을 나갑니다. ##\r\n"); 
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
			System.out.print("영화의 제목을 입력해주세요 :");
			moviename = br.readLine();
			System.out.print("영화의 출시일을 입력해주세요 :");
			releasedate = br.readLine();
			System.out.print("영화의 장르를 입력해주세요 :");
			genre = br.readLine();
			bfw.write(moviename + "\r\n");
			bfw.write(releasedate + "\r\n");
			bfw.write(genre + "\r\n");
			//bfw.newLine();
			System.out.println("파일에 저장되었습니다\r\n");
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
				System.out.print(no + ". " + "영화이름 : " + s);
				s = bfr.readLine();
				System.out.print("  " + "출시일 : " + s);
				s = bfr.readLine();
				System.out.println("  " + "장르 : " + s);
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
			System.out.print("검색어를 입력해 주세요 : ");
			String keyword = br.readLine();
			while ((s = bfr.readLine()) != null){
				if (s.contains(keyword)) {
					System.out.print("영화제목 : " + s);
					s = bfr.readLine();
					System.out.print("  " + "출시일 : " + s);
					s = bfr.readLine();
					System.out.println("  " + "장르 : " + s);
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
			System.out.print("수정할 키워드를 입력해주세요");
			String keyword = br.readLine();
			System.out.print("대체할 키워드를 입력해주세요");
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
			System.out.print("삭제할 영화 제목을 입력해주세요");
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
