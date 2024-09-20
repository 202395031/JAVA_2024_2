/*
 * 작성일 : 2024년 09월 20일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 
 * 나이를 입력 받아 출력하시오,
 * 입력받은 나이가 정수가 아닐 경우 예외처리 하시오,
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest08 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		try {
			System.out.print("나이를 입력해주세요. : ");
			int age = stdIn.nextInt();
			System.out.println("입력받은 나이는 : " + age + "살");		
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("정수를 입력해주세요.");
		}
	}

}
