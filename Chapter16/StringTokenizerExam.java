/*
 * 작성일 : 2024년 10월 30일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {
		String s1 = "이름 천승용 성별 남자 나이 21";
		String s2 = "이름,천승용,성별,남자,나이,21";
		String s3 = "이름/천승용/성별/남자/나이/21";
		String s4 = "이름:천승용:성별:남자:나이:21";
		
		System.out.println("------ 빈칸을 기준으로 ------");
		StringTokenizer st1 = new StringTokenizer(s1);	// 기본은 빈칸을 기준으로 함
		while(st1.hasMoreElements()) {	// hasMoreElements() 는 토큰이 더 있는지 없는지를 확인해줌
			String first = st1.nextToken();
			String second = st1.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------ ,를 기준으로 ------");
		StringTokenizer st2 = new StringTokenizer(s2, ",");
		while(st2.hasMoreElements()) {
			String first = st2.nextToken();
			String second = st2.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------ /를 기준으로 ------");
		StringTokenizer st3 = new StringTokenizer(s3, "/");
		while(st3.hasMoreElements()) {	
			String first = st3.nextToken();
			String second = st3.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------ :을 기준으로 ------");
		StringTokenizer st4 = new StringTokenizer(s4, ":");
		while(st4.hasMoreElements()) {
			String first = st4.nextToken();
			String second = st4.nextToken();
			System.out.println(first + "\t" + second);
		}
	}

}
