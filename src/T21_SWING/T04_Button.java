package T21_SWING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T04_Button extends JFrame{
//	JButton = btn1, btn2, btn2, btn4,
			JButton  btnExit;
	
	public T04_Button() {
		super("버튼연습");
		setSize(1000, 700);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
		setVisible(true);
		
		/*	=====================================	*/
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T04_Button();
	}
}
