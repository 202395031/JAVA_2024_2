/*
 * 작성일 : 2024년 09월 20일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 
 * Windows 디렉토리에 대한 내용 출력
 * File 객체 사용
 */

import java.io.File;

public class FileDirTest1 {
	public static void main(String[] args) {
		String directory = "C:\\Windows";
		
		File f1 = new File(directory);
		
		try {
			System.out.println("검색 디렉토리 : " + directory);
			String s[] = f1.list();		// 디렉토리의 모든 요소를 문자열의 배열로 생성.
			
			for(int i = 0; i < s.length; i++) {
				File f = new File(directory + "/" + s[i]);
				if(f.isDirectory()) {
					System.out.println(s[i] + " : 디렉토리");
				}
				else {
					System.out.println(s[i] + " : 파일");					
				}
			}
		} 
		catch (Exception e) {
			System.out.println("지정한 " + directory + "는 존재하지 않습니다.");
			System.out.println(e);
		}
	}
}
