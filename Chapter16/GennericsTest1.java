/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */
class Box<T>{	// 제네릭 클래스 선언.
	T vol;		// 변수를 제네릭으로 선언.
	void setVolume(T v) {	// 메소드의 매개변수를 제네릭으로 선언.
		vol = v;
	}
	
	T getVolume() {		// 반환 값의 형을 제네릭으로 선언.
		return vol;
	}
}

public class GennericsTest1 {

	public static void main(String[] args) {
		Box<Integer> ibox = new Box<Integer>();	// 제네릭 형을 지정하여 객체 생성
		ibox.setVolume(200);
//		ibox.setVolume(32.3);	// 형이 다르니까 오류 발생. Integer 로 선언되었는데 Double 의 값을 넣음
		System.out.println("<Integer>박스의 부피는 : " + ibox.getVolume());
		
		Box<Double> dbox = new Box<Double>();	// 제네릭 형을 지정하여 객체 생성
		dbox.setVolume(123.456);
//		dbox.setVolume(300);	// 형이 다르니까 오류 발생. Double 로 선언되었는데 Integer 의 값을 넣음
		System.out.println("<Double>박스의 부피는 : " + dbox.getVolume());
	}

}
