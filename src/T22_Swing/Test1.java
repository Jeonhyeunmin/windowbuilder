package T22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Test1 extends JFrame {

	private JPanel contentPane;


	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 500);
		setSize(800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 281);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnStart = new JButton("시작");
		btnStart.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		btnStart.setBounds(83, 50, 150, 50);
		pn1.add(btnStart);
		
		JButton btnStop = new JButton("정지");
		btnStop.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		btnStop.setBounds(316, 50, 150, 50);
		pn1.add(btnStop);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		btnExit.setBounds(549, 50, 150, 50);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 280, 784, 281);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMessage = new JLabel("New label");
		lblMessage.setIcon(new ImageIcon("D:\\javaGroup\\java\\works2\\windowBuilder\\Images\\11.png"));
		lblMessage.setBackground(Color.DARK_GRAY);
		lblMessage.setBounds(12, 10, 743, 246);
		pn2.add(lblMessage);
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
