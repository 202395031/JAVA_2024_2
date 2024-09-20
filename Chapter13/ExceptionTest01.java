/*
 * 작성일 : 2024년 09월 20일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 설명 : 두개의 숫자를 입력받아 나눗셈의 결과 출력.
*/

import java.util.Scanner;

public class ExceptionTest01 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int num1 = stdIn.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = stdIn.nextInt();
		
		System.out.println("나눗셈 결과 : " + num1 / num2);
	}

}
