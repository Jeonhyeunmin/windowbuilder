package T22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Test4_TextField extends JFrame{
	private JTextField textId, textName, textAge;
	JPanel pn1, pn2, pn3;
	JLabel lblNewLabel,lblID, lblPW, lblName, lblAge, lblBack;
	JButton btnIn, btnRe, btnExit;
	JPasswordField textPwd;
	
	String regAge = "^[0-9]+$";
	
	public Test4_TextField() {
		setTitle("텍스트박스 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBackground(Color.ORANGE);
		pn1.setBounds(0, 0, 584, 64);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 584, 64);
		pn1.add(lblNewLabel);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 62, 584, 290);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblID = new JLabel("아 이 디");
		lblID.setFont(new Font("굴림", Font.BOLD, 15));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(19, 28, 156, 37);
		pn2.add(lblID);
		
		lblPW = new JLabel("비밀번호");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("굴림", Font.BOLD, 15));
		lblPW.setBounds(19, 93, 156, 37);
		pn2.add(lblPW);
		
		lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		lblName.setBounds(19, 158, 156, 37);
		pn2.add(lblName);
		
		lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 15));
		lblAge.setBounds(19, 223, 156, 37);
		pn2.add(lblAge);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.BOLD, 15));
		textId.setBounds(209, 28, 328, 37);
		pn2.add(textId);
		textId.setColumns(10);
		
		textPwd = new JPasswordField();
		textPwd.setFont(new Font("굴림", Font.PLAIN, 15));
		textPwd.setBounds(209, 93, 328, 37);
		pn2.add(textPwd);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.BOLD, 15));
		textName.setColumns(10);
		textName.setBounds(209, 158, 328, 37);
		pn2.add(textName);
		
		textAge = new JTextField();
		textAge.setFont(new Font("굴림", Font.BOLD, 15));
		textAge.setColumns(10);
		textAge.setBounds(209, 223, 328, 37);
		pn2.add(textAge);
		
		lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon(Test4_TextField.class.getResource("/T22_Swing/images/21.jpg")));
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(0, 0, 584, 290);
		pn2.add(lblBack);
		
		pn3 = new JPanel();
		pn3.setBackground(Color.CYAN);
		pn3.setBounds(0, 350, 584, 91);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnIn = new JButton("회원가입");
		btnIn.setFont(new Font("굴림", Font.BOLD, 20));
		btnIn.setBounds(21, 22, 166, 48);
		pn3.add(btnIn);
		
		btnRe = new JButton("다시입력");
		btnRe.setFont(new Font("굴림", Font.BOLD, 20));
		btnRe.setBounds(208, 22, 166, 48);
		pn3.add(btnRe);
		
		btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(395, 22, 166, 48);
		pn3.add(btnExit);
		
		setVisible(true);
		
/*	===========================================	*/
		
//		회원가입 버튼 클릭		
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textId.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					textId.requestFocus();
				}
				else if(textPwd.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					textPwd.requestFocus();
				}
				else if(textName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
					textName.requestFocus();
				}
//				else if(textAge.getText().trim().equals("")) {
				else if(!Pattern.matches(regAge, textAge.getText().trim())) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요. (나이는 숫자만 가능)");
					textAge.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "회원가입 성공!");
				}
			}
		});
		
//		작업종료		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
//		다시입력		
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textPwd.setText("");
				textName.setText("");
				textAge.setText("");		
				textId.requestFocus();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Test4_TextField();
	}
}