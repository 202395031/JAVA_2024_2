/*
 * 작성일 :  2024년 10월 02일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 * 
 * 독립된 이벤트 처리 클래스
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 이벤트 처리 클래스
// 1) 처리할 이벤트 종류 결정.
// 2) 이벤트에 적합한 이벤트 리스너 인터페이스를 사용.
// 4) 리스너 인터페이스에 선언된 메소드를 오버라이딩 하여 이벤트 처리 루틴 작성
class EventClass implements ActionListener {
	JLabel jl;
	
	public EventClass(JLabel jl) {
		this.jl = jl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jl.setText(e.getActionCommand());
	}
}
class Event3 extends JFrame {
	JLabel jl;
	public Event3() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		JButton jb1 = new JButton("사랑합니다.");
		JButton jb2 = new JButton("행복합니다.");
		jl = new JLabel("버튼을 눌러주세요.");
		
		// 3) 이벤트를 받아 들일 버튼에 리스너 등록
		jb1.addActionListener(new EventClass(jl));
		jb2.addActionListener(new EventClass(jl));
		
		ct.add(jb1);
		ct.add(jb2);
		ct.add(jl);
		
		setTitle("Event Test3");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class EventTest3 {

	public static void main(String[] args) {
		new Event3();
	}

}
