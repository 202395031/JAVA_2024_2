/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.util.LinkedList;
import java.util.Scanner;

public class QueueTest1 {
	public static void main(String[] args) {
		// Queue 인터페이스를 포함하는 LinkedList 클래스 사용.
		LinkedList<String> queue = new LinkedList<String>();
		
		// 키보드로부터 4개의 과일 이름을 입력받아 queue 에 저장.
		Scanner stdIn = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			System.out.print("과일의 이름을 입력하시오. : ");
			String fruits = stdIn.next();
			queue.offer(fruits);	// 데이터 삽입 offer
		}
		System.out.println("과일 리스트<큐> : " + queue);
		
		// 큐에서 과일 찾기
		System.out.print("찾고 싶은 과일 이름 입력 : ");
		String f_name = stdIn.next();
		int fruit = queue.indexOf(f_name);	// 위치를 찾아줌	 indexOf()
		
		if(fruit != -1) {
			System.out.println("큐에서 " + f_name + "의 위치는 : " + fruit + "번째입니다.");
		}
		else {
			System.out.println("큐에 " + f_name + "가 없습니다.");
		}
		
		System.out.println("과일 리스트 삭제<스택>");
		while(!queue.isEmpty()) {		// queue에 값이 없을때까지	isEmpty()
			String name = queue.poll();	// 삭제	poll()
			System.out.println("스택에서 삭제 : " + name);	// 삭제를 했을때 첫번째 값 부터 삭제 됨
			// 예 q w e r 일때 q w e r 로 출력 됨 FIFO (First In First Out)
		} 
	}
}
