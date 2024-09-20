package T22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Test2 extends JFrame{
	JPanel pn1, pn2, pn3;
	
	public Test2() {
		setTitle("연습하기");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 84);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("이미지 연습 창");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(216, 10, 386, 64);
		pn1.add(lblTitle);
		
		JButton btnExit = new JButton("종료");
		
		btnExit.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btnExit.setBounds(614, 9, 151, 64);
		pn1.add(btnExit);
		
		JButton btnRandom = new JButton("랜덤보기");
		btnRandom.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btnRandom.setBounds(12, 10, 151, 64);
		pn1.add(btnRandom);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 84, 784, 394);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setIcon(new ImageIcon(Test2.class.getResource("/T22_Swing/images/11.jpg")));
		lbl1.setBounds(0, 0, 784, 394);
		pn2.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setIcon(new ImageIcon(Test2.class.getResource("/T22_Swing/images/12.jpg")));
		lbl2.setBounds(0, 0, 784, 394);
		pn2.add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setIcon(new ImageIcon("D:\\javaGroup\\java\\works2\\windowBuilder\\Images\\13.jpg"));
		lbl3.setBounds(0, 0, 784, 394);
		pn2.add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setIcon(new ImageIcon("D:\\javaGroup\\java\\works2\\windowBuilder\\Images\\14.jpg"));
		lbl4.setBounds(0, 0, 784, 394);
		pn2.add(lbl4);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 477, 784, 84);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btn1 = new JButton("그림1");
		
		btn1.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn1.setBounds(36, 10, 151, 64);
		pn3.add(btn1);
		
		JButton btn2 = new JButton("그림2");
		btn2.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn2.setBounds(223, 10, 151, 64);
		pn3.add(btn2);
		
		JButton btn3 = new JButton("그림3");
		btn3.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn3.setBounds(410, 10, 151, 64);
		pn3.add(btn3);
		
		JButton btn4 = new JButton("그림4");
		btn4.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn4.setBounds(597, 10, 151, 64);
		pn3.add(btn4);
		
		
		
		setVisible(true);
		
/*	===========================================================================	*/
		
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
//		1번 그림 보기
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
//		2번 그림 보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(true);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
//		3번 그림 보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(true);
				lbl4.setVisible(false);
			}
		});
//		4번 그림 보기
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
