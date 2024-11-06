/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest1 {

	public static void main(String[] args) {
		// TreeMap 생성 (이름을 key로, 성적을 value로)
		TreeMap<String, Integer> scores = new TreeMap<String, Integer>();
		
		// 학생 이름과 성적 추가
		scores.put("천승용", 100);
		scores.put("김수종", 92);
		scores.put("김유민", 80);
		scores.put("김현탁", 85);
		scores.put("윤진환", 90);
		
		
		// 성적 출력
		System.out.println("학생 성적 : ");
		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			System.out.println("이름 : " + entry.getKey() + ", 성적 : " + entry.getValue());
		}
		
//		키값을 기준으로 정렬이기에 주석 처리		
//		// 최고 점수와 최저 점수 찾기		정렬 되기 때문에 마지막이 점수가 제일 높고 처음꺼가 점수가 제일 낮음
//		Map.Entry<String, Integer> highest = scores.lastEntry();
//		Map.Entry<String, Integer> lowest = scores.firstEntry();
//		
//		System.out.println("\n최고 점수 : " + highest.getValue() + " (" + highest.getKey() + ")");
//		System.out.println("최저 점수 : " + lowest.getValue() + " (" + lowest.getKey() + ")");
		
		// 점수에 따라 정렬하기 위해 List 생성
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
		
		// 점수 기준으로 정렬 (오름차순) - 람다 표현식 사용
		entryList.sort(Comparator.comparing(Map.Entry::getValue));
		
		System.out.println("점수 순으로 출력 (낮은 점수부터) : " + entryList);
		
		System.out.println("최고 점수 : " + entryList.get(entryList.size()-1).getValue() + " (" + entryList.get(entryList.size()-1).getKey() + ")");
		System.out.println("최저 점수 : " + entryList.get(0).getValue() + " (" + entryList.get(0).getKey() + ")");
	}

}
