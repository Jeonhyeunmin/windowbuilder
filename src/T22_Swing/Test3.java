package T22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Test3 extends JFrame{
	JPanel pn1, pn2, pn3, pn4;
	JButton btn1, btn2, btn3, btn4, btnExit, btnRandom;
	JLabel pct1, pct2, pct3, pct4, lblMsg1, lblMsg2, lblMsg3, lblMsg4;
	int count[] = new int[4];
	JLabel lbl[] = new JLabel[4];
	
	public Test3() {
		setTitle("연습하기");
		setSize(800, 648);
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
		
		btnExit = new JButton("종료");
		
		btnExit.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btnExit.setBounds(614, 9, 151, 64);
		pn1.add(btnExit);
		
		btnRandom = new JButton("랜덤보기");
		btnRandom.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btnRandom.setBounds(12, 10, 151, 64);
		pn1.add(btnRandom);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 84, 784, 394);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lbl[0] = new JLabel("");
		lbl[0].setHorizontalAlignment(SwingConstants.CENTER);
		lbl[0].setIcon(new ImageIcon(Test3.class.getResource("/T22_Swing/images/11.jpg")));
		lbl[0].setBounds(0, 0, 784, 394);
		pn2.add(lbl[0]);
		
		lbl[1] = new JLabel("");
		lbl[1].setHorizontalAlignment(SwingConstants.CENTER);
		lbl[1].setIcon(new ImageIcon(Test3.class.getResource("/T22_Swing/images/12.jpg")));
		lbl[1].setBounds(0, 0, 784, 394);
		pn2.add(lbl[1]);
		
		lbl[2] = new JLabel("");
		lbl[2].setHorizontalAlignment(SwingConstants.CENTER);
		lbl[2].setIcon(new ImageIcon("D:\\javaGroup\\java\\works2\\windowBuilder\\Images\\13.jpg"));
		lbl[2].setBounds(0, 0, 784, 394);
		pn2.add(lbl[2]);
		
		lbl[3] = new JLabel("");
		lbl[3].setHorizontalAlignment(SwingConstants.CENTER);
		lbl[3].setIcon(new ImageIcon("D:\\javaGroup\\java\\works2\\windowBuilder\\Images\\14.jpg"));
		lbl[3].setBounds(0, 0, 784, 394);
		pn2.add(lbl[3]);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 477, 784, 84);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btn1 = new JButton("그림1");
		
		btn1.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn1.setBounds(36, 10, 151, 64);
		pn3.add(btn1);
		
		btn2 = new JButton("그림2");
		btn2.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn2.setBounds(223, 10, 151, 64);
		pn3.add(btn2);
		
		btn3 = new JButton("그림3");
		btn3.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn3.setBounds(410, 10, 151, 64);
		pn3.add(btn3);
		
		btn4 = new JButton("그림4");
		btn4.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		btn4.setBounds(597, 10, 151, 64);
		pn3.add(btn4);
		
		pn4 = new JPanel();
		pn4.setBounds(0, 559, 784, 50);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		pct1 = new JLabel("그림 1 횟수 :");
		pct1.setHorizontalAlignment(SwingConstants.LEFT);
		pct1.setBounds(20, 10, 82, 30);
		pn4.add(pct1);
		
		lblMsg1 = new JLabel("");
		lblMsg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg1.setBounds(97, 10, 100, 30);
		pn4.add(lblMsg1);
		
		pct2 = new JLabel("그림 2 횟수 :");
		pct2.setHorizontalAlignment(SwingConstants.LEFT);
		pct2.setBounds(209, 10, 82, 30);
		pn4.add(pct2);
		
		pct3 = new JLabel("그림 3 횟수 :");
		pct3.setHorizontalAlignment(SwingConstants.LEFT);
		pct3.setBounds(398, 10, 82, 30);
		pn4.add(pct3);
		
		pct4 = new JLabel("그림 4 횟수 :");
		pct4.setHorizontalAlignment(SwingConstants.LEFT);
		pct4.setBounds(587, 10, 82, 30);
		pn4.add(pct4);
		
		lblMsg2 = new JLabel("");
		lblMsg2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg2.setBounds(286, 10, 100, 30);
		pn4.add(lblMsg2);
		
		lblMsg3 = new JLabel("");
		lblMsg3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg3.setBounds(475, 10, 100, 30);
		pn4.add(lblMsg3);
		
		lblMsg4 = new JLabel("");
		lblMsg4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg4.setBounds(672, 10, 100, 30);
		pn4.add(lblMsg4);
		
		for(int i = 0; i < lbl.length; i++) {
			lbl[i].setVisible(false);
		}
		
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
				lbl[0].setVisible(true);
				lbl[1].setVisible(false);
				lbl[2].setVisible(false);
				lbl[3].setVisible(false);
				count[0]++;
				lblMsg1.setText(count[0]+"");
			}
		});
		
//		2번 그림 보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl[0].setVisible(false);
				lbl[1].setVisible(true);
				lbl[2].setVisible(false);
				lbl[3].setVisible(false);
				count[1]++;
				lblMsg2.setText(count[1]+"");
			}
		});
		
//		3번 그림 보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl[0].setVisible(false);
				lbl[1].setVisible(false);
				lbl[2].setVisible(true);
				lbl[3].setVisible(false);
				count[2]++;
				lblMsg3.setText(count[2]+"");
			}
		});
		
//		4번 그림 보기
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl[0].setVisible(false);
				lbl[1].setVisible(false);
				lbl[2].setVisible(false);
				lbl[3].setVisible(true);
				count[3]++;
				lblMsg4.setText(count[3]+"");
			}
		});
		
//		랜덤보기		
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int rand = random.nextInt(4);
				for(int i = 0; i < lbl.length; i++) {
				lbl[i].setVisible(false);
				}
				lbl[rand].setVisible(true);
				count[rand]++;
				
				lblMsg1.setText(count[0]+"");
				lblMsg2.setText(count[1]+"");
				lblMsg3.setText(count[2]+"");
				lblMsg4.setText(count[3]+"");
			}
		});
	}
	
	public static void main(String[] args) {
		new Test3();
	}
}