/*
 * 작성일 :  2024년 10월 11일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JList1 extends JFrame implements ListSelectionListener{
	// 과일 배열
	private String fruitsList[] = {"apple", "banana", "cherry", "grape", "pear", "persimmom"};
	
	// 과일 배열로 리스트 객체
	private JList jlist = new JList(fruitsList);
	
	// 아이콘 이미지 객체 배열 생성.
	private ImageIcon[] fruitIcons = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/cherry.jpg"),
			new ImageIcon("images/grape.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/persimmom.jpg")
	};
	
	// 이미지 아이콘과 과일 이름 출력 라벨
	private JLabel[] jlicon = new JLabel[6];
	private JLabel jlname = new JLabel();
	
	public JList1() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		// 이미지 영역
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 2, 5, 5));	// 행, 열, 세로여백, 가로여백
									// 지금 3행 2열에 모든 여백이 5인 그리드
		
		// 그리드에 아이콘 붙이기
		for(int i = 0; i < 6; i++) {
			jp1.add(jlicon[i] = new JLabel());
		}
		
		// 과일이름을 출력할 영역
		JPanel jp2 = new JPanel();
		jp2.add(jlname);
		
		ct.add(jlist, BorderLayout.WEST);
		ct.add(jp1, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.EAST);
		
		jlist.addListSelectionListener(this);
		
		setTitle("JList Test1");
		setSize(700, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		for(int i = 0; i < 6; i++) {
			jlicon[i].setIcon(null);
		}
		// 리스트의 내용 가져오기
		int[] indices = jlist.getSelectedIndices();
		String s = "당신이 선택한 항목은 : ";
		
		// 리스트 길이까지 반복하면서
		for(int i = 0; i < indices.length; i++) {
			// 과일 아이콘 리스트의 이미지를 가져온다.
			jlicon[i].setIcon(fruitIcons[indices[i]]);
			
			// 과일 이름 가져오기
			s = s + fruitsList[indices[i]] + " ";
		}
		
		jlname.setText(s);	// 출력
	}

}
public class JListTest1 {

	public static void main(String[] args) {
		new JList1();
	}

}
