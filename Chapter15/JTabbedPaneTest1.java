/*
 * 작성일 :  2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

// 성별 판넬 만들기
class RadioPanel extends JPanel  implements ActionListener{
	ButtonGroup gb = new ButtonGroup(); // 성별을 나타내는 라디오 버튼을 그룹으로 묶는다
	
	JLabel jl1 = new JLabel(" | 당신의 성별은 ? ");
	JLabel jl2 = new JLabel("");
	
	JRadioButton[] jr = new JRadioButton[2];
	String[] gender = { "남자", "여자" };
	
	public RadioPanel() {
		for(int i = 0; i < 2; i++) {
			// 성별을 나타내는 라디오 버튼 객체를 배열로 생성.
			jr[i] = new JRadioButton(gender[i]);
			
			// 성별 판넬에 객체 추가.
			add(jr[i]);			

			// 라디오 버튼에 리스너 등록.
			jr[i].addActionListener(this);
			gb.add(jr[i]);	// 버튼 그룹에 객체를 추가.
		}
		
		add(jl1);
		add(jl2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		jl2.setText(s);
	}
}

// 혈액형 판넬 만들기
class ComboPanel extends JPanel implements ItemListener{
	JLabel jl1 = new JLabel(" | 당신의 혈액형은 ? ");
	JLabel jl2 = new JLabel("");
	public ComboPanel() {
		// 콤보 박스 생성
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("A형");
		jcb.addItem("B형");
		jcb.addItem("AB형");
		jcb.addItem("O형");
		
		add(jl1);
		add(jl2);
		add(jcb);
		
		jcb.addItemListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String s = (String)e.getItem();
		jl2.setText(s);
	}
}

class JTabbedPane1 extends JFrame {
	public JTabbedPane1() {
		// 컨테이너 생성
		Container ct = getContentPane();
		
		// JTabbedPane() 객체 생성
		JTabbedPane jtp = new JTabbedPane();
		// RadioPanel() 객체 생성
		RadioPanel rp = new RadioPanel();
		// ComboPanel() 객체 생성
		ComboPanel cp = new ComboPanel();
		
		// JTabbedPane()에 RadioPanel() 추가
		jtp.addTab("성별", rp);
		// JTabbedPane()에 ComboPanel() 추가
		jtp.addTab("혈액형", cp);
		
		// 컨테이너에 추가
		ct.add(jtp);
		
		setTitle("JTabbedPane Test1");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class JTabbedPaneTest1 {

	public static void main(String[] args) {
		new JTabbedPane1();
	}

}
