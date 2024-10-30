/*
 * 작성일 : 2024년 10월 30일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);	// 사용자(키보드)로 부터 값을 입력받기위한 스캐너
		System.out.print("검색을 원하는 학생의 학번을 입력하시오. : ");
		int id = stdIn.nextInt();
		
		try {
			Scanner idNum = new Scanner(new File("phone.txt"));
			
			while(idNum.hasNext()) {
				if(id == idNum.nextInt()) {
					System.out.println(id + " 학생의 전화번호 : " + idNum.next());
					return;
				}
				else {
					idNum.next();
				}
			}
			System.out.println("해당 학생의 전화번호가 없습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		}
	}

}
