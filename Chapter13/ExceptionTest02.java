/*
 * 작성일 : 2024년 09월 20일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 설명 : 0으로 나눌 경우 예외 처리
*/

import java.util.Scanner;

public class ExceptionTest02 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int num1 = stdIn.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = stdIn.nextInt();
		
		// 단축기 Art + Shift + z
		try {
			System.out.println("나눗셈 결과 : " + num1 / num2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();	// 무슨 에러인지 출력하는 문
			System.out.println("나누는 수가 0이면 안됩니다.");
		}
	}

}
