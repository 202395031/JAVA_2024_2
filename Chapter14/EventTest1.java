/*
 * 작성일 :  2024년 10월 02일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 
 * 	GUI 만드는 순서
 * 	1. 프레임으 만든다(상속)
 * 	2. 컨테이너를 생성
 * 	3. 배치 관리자 설정
 * 	4. 버튼, 레이블 (필요한 거 추가) 생성
 * 	5. 컨테이너에 등록
 *
 *	GUI 클래스에 이벤트 처리.
 *	1. 처리할 이벤트 종류 결정.
 *	2. 이벤트에 적합한 이벤트 리스너 인터페이스를 사용.
 *	3. 이벤트를 받아 들일 버튼에 리스너 등록
 *	4. 리스너 인터페이스에 선언된 메소드를 오버라이딩 하여 이벤트 처리 루틴 작성
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// GUI 클래스
class Event1 extends JFrame implements ActionListener{
	JLabel jl;
	
	public Event1() {
		Container ct = getContentPane();
		
		// 배치 관리자 설정. FlowLayout
		ct.setLayout(new FlowLayout());
		
		// 버튼, 레이블 추가
		JButton jb = new JButton("버튼");
		jl = new JLabel("버튼을 눌러주세요.");
		
		// 이벤트를 받아 들일 리스너
		jb.addActionListener(this);

		// 컨테이너에 등록
		ct.add(jb);
		ct.add(jl);
		setTitle("Event Test1");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// 리스너 인터페이스에 선언된 메소드를 오버라이딩 하여 이벤트 처리 루틴 작성
	@Override
	public void actionPerformed(ActionEvent e) {
		jl.setText("안녕하세요.");
	}
}

// 메인 클래스
public class EventTest1 {

	public static void main(String[] args) {
		new Event1();
	}

}
