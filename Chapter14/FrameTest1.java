/*
 * 작성일 : 2024년 09월 27일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

// UI 클래스
class FirstFrame1 {
	// 생성자 생성.
	public FirstFrame1() {
		// 프레임 객체를 생성한다.
		JFrame jf = new JFrame("첫 번째 GUI 프로그램");	// 이게 프레임 틀
		
		// 프레임으로부터 컨테이너(쟁반으로 비유) 생성.
		Container ct = jf.getContentPane();
		
		// 버튼 컴포넌트 생성.
		JButton jb = new JButton("테스트 버튼");
		
		// 컨테이너에 버튼을 추가
		ct.add(jb);
		
		// 프레임의 크기
		jf.setSize(400, 300);
		
		// 프레임을 화면에 출력
		jf.setVisible(true);
	}
}

public class FrameTest1 {

	public static void main(String[] args) {
		// UI 관련된 클래스 호출
		new FirstFrame1();
	}

}
