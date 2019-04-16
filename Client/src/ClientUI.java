import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ClientUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI window = new ClientUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome\uFF01+Status");
		lblWelcome.setBounds(27, 62, 99, 15);
		frame.getContentPane().add(lblWelcome);
		
		//Login点击事件
		JLabel lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				LoginFrame loginframe=new LoginFrame();
				loginframe.setVisible(true);
	
				}
			});
		
		lblLogin.setBounds(521, 62, 58, 15);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setBounds(578, 62, 58, 15);
		frame.getContentPane().add(lblLogout);
		
		JLabel label = new JLabel("\u6559\u5BA4\u79DF\u501F\u7CFB\u7EDF");
		label.setBounds(279, 10, 88, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u6D45\u84DD\u8272\u8868\u793A\u53EF\u501F\uFF0C\u6D45\u7D2B\u8272\u8868\u793A\u5DF2\u51FA\u501F");
		label_1.setBounds(224, 35, 233, 23);
		frame.getContentPane().add(label_1);
	
		

		/**
		 * 绘制row*col表格
		 */
		int row=15;
		int col=13;
		JPanel[] panel=new JPanel[211];
		
		for(int i=1;i<row;i++)
			for(int j=1;j<col;j++)
			{
				JPanel temp;
				panel[i*14-14+j]=new JPanel();
				temp=panel[i*14-14+j];
				
				temp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window, SystemColor.window, SystemColor.window));
				temp.setBackground((new Color(176, 224, 230)));
				temp.setBounds((j*40+60),(i*30+100), 40, 30);
				
				//需要更改 把点击事件改为判断用户状态是否登录 如果未登录需发送登录请求，如果登录且点击时间段未出借可出借，否则弹出不可出借的提示框
				temp.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e) {
			            	temp.setBackground(new Color(216, 191, 216));
			            }
			        });          frame.getContentPane().add(panel[i*14-14+j]);
		        
	
			}
		
		for(int j=1;j<col;j++)
		{

			textField = new JTextField();
			
			textField.setDisabledTextColor(new Color(0, 0, 0));
			textField.setForeground(new Color(0, 0, 0));
			textField.setFont(new Font("黑体", Font.PLAIN, 10));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			
			textField.setText((j+7)+":00");
			textField.setBackground(new Color(245, 245, 245));
			textField.setEnabled(false);
			textField.setBounds(j*40+60, 100, 40, 30);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}

		textField = new JTextField();
		textField.setDisabledTextColor(new Color(0, 0, 0));
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("黑体", Font.PLAIN, 10));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("ClassRoom");
		textField.setBackground(new Color(245, 245, 245));
		textField.setEnabled(false);
		textField.setBounds(40, 100, 60, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		for(int i=1;i<row;i++)
		{

			 textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			
			//textField.setText(...);+一个调用classlist显示在文本框内的函数
			textField.setDisabledTextColor(new Color(0, 0, 0));
			textField.setForeground(new Color(0, 0, 0));
			textField.setFont(new Font("黑体", Font.PLAIN, 10));
			textField.setBackground(new Color(245, 245, 245));
			textField.setEnabled(false);

			textField.setBounds(40, i*30+100, 60, 30);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
		}

		

	}
}
