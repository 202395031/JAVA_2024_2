/*
 * 작성일 : 2024년 09월 20일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 
 * 파일 입출력에 대해 예외처리를 하지않아 오류
 */

import java.io.FileReader;

public class ExceptionTest04 {

	public static void main(String[] args) {
		FileReader file = new FileReader("a.txt");
		
		int i;
		while((i = file.read()) != -1) {
			System.out.println((char)i);
		}
		file.close();
	}

}
