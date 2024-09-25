/*
 * 작성일 : 2024년 09월 25일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderTest1 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		try {
			System.out.print("읽어 올 파일명을 입력하세요. : ");
			String s = stdIn.next() + ".txt";
			
			// 읽어 올 파일명으로 객체 생성.
			FileReader fr = new FileReader(s);
			
			int i;
			while((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.print("파일이 없습니다.");
		} catch (IOException e) {
			System.out.print("파일이 없습니다.");
		}
	}

}