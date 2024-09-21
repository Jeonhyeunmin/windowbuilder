package T23_Hoewon;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class HoewonSearch extends JFrame{
	private JTable table;
	JPanel pn1, pn2, pn3;
	JButton btnExit, btnCondition, JButton, btnList;
	Vector title, vData;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	private JComboBox cbConditon, cbAlign, cbList;
	private JTextField txtCondition;
	
	HoewonDAO dao = new HoewonDAO();

	public HoewonSearch() {
		setTitle("회원리스트");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 70);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		cbConditon = new JComboBox();
		cbConditon.setFont(new Font("굴림", Font.BOLD, 20));
		cbConditon.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일", "주소"}));
		cbConditon.setBounds(0, 11, 145, 49);
		pn1.add(cbConditon);
		
		txtCondition = new JTextField();
		txtCondition.setHorizontalAlignment(SwingConstants.LEFT);
		txtCondition.setFont(new Font("굴림", Font.BOLD, 20));
		txtCondition.setBounds(157, 10, 148, 50);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건검색");
		
		btnCondition.setFont(new Font("굴림", Font.BOLD, 20));
		btnCondition.setBounds(586, 9, 162, 50);
		pn1.add(btnCondition);
		
		cbAlign = new JComboBox();
		cbAlign.setBounds(449, 9, 119, 50);
		pn1.add(cbAlign);
		cbAlign.setFont(new Font("굴림", Font.BOLD, 20));
		cbAlign.setModel(new DefaultComboBoxModel(new String[] {"오름차순", "내림차순"}));
		
		cbList = new JComboBox();
		cbList.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "가입일", "주소"}));
		cbList.setFont(new Font("굴림", Font.BOLD, 20));
		cbList.setBounds(317, 10, 119, 50);
		pn1.add(cbList);
		
		pn2 = new JPanel();
		pn2.setBounds(10, 90, 762, 368);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		pn3 = new JPanel();
		pn3.setBounds(12, 468, 760, 83);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnExit = new JButton("종료");
		
		
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(571, 10, 175, 65);
		pn3.add(btnExit);
		
		btnList = new JButton("전체검색");
		btnList.setBounds(12, 10, 163, 65);
		pn3.add(btnList);
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		
//		전체회원검색
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getHoewonList();
				dtm.setDataVector(vData, title);
			}
		});
		
		
		title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("나이");
		title.add("성별");
		title.add("가입일");
		title.add("주소");
		
		vData = dao.getHoewonList();
		
		dtm = new DefaultTableModel(vData, title);
		
		table = new JTable(dtm);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 762, 349);
		pn2.add(scrollPane);
		
		
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(0).setResizable(false);
		
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(3).setResizable(false);
		
		table.getColumnModel().getColumn(4).setResizable(false);
		
		table.getColumnModel().getColumn(5).setResizable(false);
		
		table.getTableHeader().setReorderingAllowed(false);
		
//		테이블안의 셀의 재용을 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
/*	===================================================	*/		
		setVisible(true);
/*	===================================================	*/	

//		조건검색
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cbCondi = cbConditon.getSelectedItem().toString();
				String txtCondi = txtCondition.getText();
				String align = cbAlign.getSelectedItem().toString();
				String list = cbList.getSelectedItem().toString();
				
				if(list.equals("성명")) {
					list = "name";
				}
				else if(list.equals("나이")) {
					list = "age";
				}
				else if(list.equals("성별")) {
					list = "gender";
				}
				else if(list.equals("가입일")) {
					list = "joinday";
				}
				else if(list.equals("주소")) {
					list = "address";
				}
				
				if(align.equals("오름차순")) {
					align = "a";
				}
				else {
					align = "d";					
				}
				
				if(txtCondi.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
					txtCondition.requestFocus();
					return;
				}
				if(cbCondi.equals("성명")) {
					vData = dao.getConditionSearch("name", txtCondi, align, list);
				}
				else if(cbCondi.equals("나이")) {
				
					vData = dao.getConditionSearch("age", txtCondi, align, list);
				}
				else if(cbCondi.equals("성별")) {
					vData = dao.getConditionSearch("gender", txtCondi, align, list);
				}
				else if(cbCondi.equals("가입일")) {
					vData = dao.getConditionSearch("joinday", txtCondi, align, list);
				}
				else if(cbCondi.equals("주소")) {
					vData = dao.getConditionSearch("address", txtCondi, align, list);
				}
				
				dtm.setDataVector(vData, title);
				}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HoewonMain();
			}
		});
	}
}
