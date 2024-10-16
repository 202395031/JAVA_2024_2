/*
 * 작성일 :  2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

class JMenu1 extends JFrame implements ActionListener{
	JTextField jtf;
	
	public JMenu1() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		// 1. JMenuBar() 객체 생성
		JMenuBar jmb = new JMenuBar();
		
		// 2. JMenu 객체 생성
		JMenu menu1 = new JMenu("파일");
		JMenu menu2 = new JMenu("편집");
		
		// 3. 서브 메뉴 JMenuItem 객체로 생성
		JMenuItem jmi = new JMenuItem("새파일");
		// 3-1. 이벤트 리스너 등럭
		jmi.addActionListener(this);
		// 3-2. menu1 메뉴에 추가
		menu1.add(jmi);
		
		jmi = new JMenuItem("저장하기");
		jmi.addActionListener(this);
		menu1.add(jmi);
		
		// 4. menu1 메뉴를 JMenuBar에 추가
		jmb.add(menu1);
		
		
		jmi = new JMenuItem("열기");
		jmi.addActionListener(this);
		menu2.add(jmi);
		
		jmi = new JMenuItem("잘라내기");
		jmi.addActionListener(this);
		menu2.add(jmi);
		
		jmi = new JMenuItem("복사");
		jmi.addActionListener(this);
		menu2.add(jmi);
		
		// 3. 서브 메뉴 JCheckBoxMenuItem 객체 생성
		JCheckBoxMenuItem jcbmi = new JCheckBoxMenuItem("눈금자");
		jmi.addActionListener(this);
		menu2.add(jcbmi);
		
		// 3. 서브 메뉴 JRadioButtonMenuItem 객체 생성
		JRadioButtonMenuItem jrbmi = new JRadioButtonMenuItem("수정가능박스");
		jmi.addActionListener(this);
		menu2.add(jrbmi);
		
		// 4. menu2 메뉴를 JMenuBar에 추가
		jmb.add(menu2);
		
		// 5. setJMEnuBar() 메소드로 메뉴바를 프레임에 추가
		setJMenuBar(jmb);
		
		jtf = new JTextField();
		jtf.setEnabled(false);
		ct.add(jtf, BorderLayout.SOUTH);
		
		setTitle("JMenu Test1");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jtf.setText(e.getActionCommand());
	}
}

public class JMenuTest1 {

	public static void main(String[] args) {
		new JMenu1();
	}

}
