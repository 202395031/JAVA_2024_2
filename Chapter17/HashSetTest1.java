/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {

	public static void main(String[] args) {
		// HashSet 객체 생성.
		HashSet<Integer> odd = new HashSet<Integer>();
		HashSet<Integer> even = new HashSet<Integer>();
		
		for (int i = 1; i <= 10; i += 2) {
			odd.add(i);		// 홀수 저장
			even.add(i+1);	// 짝수 저장
		}
		
		// 셋에 저장된 내용 출력
		System.out.println("odd 집합 내용 : " + odd);
		System.out.println("even 집합 내용 : " + even);
		
		boolean setChanged = odd.add(5);
		System.out.println("odd에 5추가 성공? " + setChanged);
		// 셋은 중복을 허용하지 않음	false
		
		setChanged = even.add(12);
		System.out.println("even에 12추가 성공? " + setChanged);
		
		System.out.println("odd 집합 내용 : " + odd);
		System.out.println("even 집합 내용 : " + even);
		
		System.out.println("odd에서 가장 작은 값 : " + Collections.min(odd));
		System.out.println("evee에서 가장 큰 값 : " + Collections.max(even));
		
		// Iterator 객체를 제네릭으로 생성.
		Iterator<Integer> even_it = even.iterator();
		int sum = 0;
		
		// evrn_it 객체를 이용하여 Hashset 의 각 요소를 순차 검색
		while(even_it.hasNext()) {
			sum = sum + even_it.next();
		}
		
		System.out.println("even 집합의 합 : " + sum);
		
		Iterator<Integer> odd_it = odd.iterator();
		sum = 0;
		
		// evrn_it 객체를 이용하여 Hashset 의 각 요소를 순차 검색
		while(odd_it.hasNext()) {
			sum = sum + odd_it.next();
		}
		
		System.out.println("odd 집합의 합 : " + sum);
	}

}
