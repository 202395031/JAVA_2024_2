/*
 * 작성일 : 2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

class JScrollPane1 extends JFrame {
	public JScrollPane1() {
		Container ct = getContentPane();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(20, 5));
		
		// 패널(jp)에 100개의 버튼 추가
		for (int i = 0; i <= 100; i++) {
			jp.add(new JButton(i + "번"));
		}
		
		// 가로, 세로 스크롤 생성.
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		// 스크롤 팬 생성.
		JScrollPane jsp = new JScrollPane(jp, v, h);
		
		// 컨테이너에 추가.	- BorderLayout의 가운데에 넣기
		ct.add(jsp, BorderLayout.CENTER);
		
		setSize(300, 300);
		setTitle("JScrollPane Test1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class JScrollPaneTest1 {

	public static void main(String[] args) {
		new JScrollPane1();
	}

}
