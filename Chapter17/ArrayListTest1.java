/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest1 {
	public static void main(String[] args) {
		// 문자열 배열 생성.
		String[] name = {"kim", "lee", "park", "jung", "oh"};
		
		// 문자열 배열을 이용하여 리스트 객체(제네릭) 생성.
		ArrayList<String> lname = new ArrayList<String>(Arrays.asList(name));
		System.out.println("초기값 : " + lname);
		
		// 리스트 마지막에 추가.	add(값)
		lname.add("ha");
		System.out.println("ha 추가 : " + lname);
		
		// 리스트 값 변경	set(index, 값)
		lname.set(0, "김");	// 0번지 값을 "김"으로 변경.
		System.out.println("0번지 김으로 변경 : " + lname);
		
		// 리스트 중간(원하는 번지)에 추가.	add(index, 값)
		lname.add(3, "곽");	// 추가로 인한 인덱스는 자동으로 조정 됨.
		System.out.println("3번지 곽 추가 : " + lname);
		
		// 무작위로 재배열. - Collections 클래스의 shuffle(리스트) 메소드 활용.
		Collections.shuffle(lname);
		System.out.println("무작위 재배열 : " + lname);
		
		// 리스트 정렬. - Collections 클래스의 sort(리스트) 메소드 활용
		Collections.sort(lname);
		System.out.println("리스트 정렬 : " + lname);
		
		// 원하는 값 출력. - 5번째 요소 출력	get(index)
		System.out.println("5번째 요소 출력 : " + lname.get(4));
		
		// 리스트의 모든 요소를 "김" 으로 채우기.
		Collections.fill(lname, "김");
		System.out.println("모든 요소를 \"김\" 으로 변경 : " + lname);
	}
}
