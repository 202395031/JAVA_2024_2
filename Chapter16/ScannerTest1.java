/*
 * 작성일 : 2024년 10월 30일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.util.Scanner;

public class ScannerTest1 {

	public static void main(String[] args) {
		String day = "happy day, smile day, nice day, joyful day, ";
		
		Scanner stdIn = new Scanner(day);
		stdIn.useDelimiter("day, ");	// 분리자 지정.
		
		// 다음 토큰이 있을 때까지 읽어서 출력
		while(stdIn.hasNext()) {	// 다음 토큰이 있는지 없는지 확인해줌
			System.out.println(stdIn.next());
		}
		
	}

}
