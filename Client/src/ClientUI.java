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
		
		//Login����¼�
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
		lblLogout.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
		//update(); �п� Ҫ��visitor����ݵ���update @Override
		}
		});
		lblLogout.setBounds(578, 62, 58, 15);
		frame.getContentPane().add(lblLogout);
		
		JLabel label = new JLabel("\u6559\u5BA4\u79DF\u501F\u7CFB\u7EDF");
		label.setBounds(279, 10, 88, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u6D45\u84DD\u8272\u8868\u793A\u53EF\u501F\uFF0C\u6D45\u7D2B\u8272\u8868\u793A\u5DF2\u51FA\u501F");
		label_1.setBounds(224, 35, 233, 23);
		frame.getContentPane().add(label_1);
	
		/**
		 * ��ʼ��row��col
		 */
		int row=15;
		int col=13;	

		
		/**
		 * ����������һ�е�ʱ��textField
		 */
		JTextField []time_textField=new JTextField[col+1];
		for(int j=1;j<col;j++)
		{

			time_textField[j] = new JTextField();
			
			time_textField[j].setDisabledTextColor(new Color(0, 0, 0));
			time_textField[j].setForeground(new Color(0, 0, 0));
			time_textField[j].setFont(new Font("����", Font.PLAIN, 10));
			time_textField[j].setHorizontalAlignment(SwingConstants.CENTER);
			
			time_textField[j].setText((j+7)+":00");
			time_textField[j].setBackground(new Color(245, 245, 245));
			time_textField[j].setEnabled(false);
			time_textField[j].setBounds(j*40+60, 100, 40, 30);
			frame.getContentPane().add(time_textField[j]);
			time_textField[j].setColumns(10);
		}

		textField = new JTextField();
		textField.setDisabledTextColor(new Color(0, 0, 0));
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("����", Font.PLAIN, 10));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("ClassRoom");
		textField.setBackground(new Color(245, 245, 245));
		textField.setEnabled(false);
		textField.setBounds(40, 100, 60, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		/**
		 * ���������һ�еĽ���textField
		 */
		JTextField []class_textField=new JTextField[row+1];
		for(int i=1;i<row;i++)
		{

			class_textField[i] = new JTextField();
			class_textField[i] .setHorizontalAlignment(SwingConstants.CENTER);
			
			//ȱ��class_textField.setText(...);+һ������classlist��ʾ���ı����ڵĺ���
			class_textField[i] .setDisabledTextColor(new Color(0, 0, 0));
			class_textField[i] .setForeground(new Color(0, 0, 0));
			class_textField[i] .setFont(new Font("����", Font.PLAIN, 10));
			class_textField[i] .setBackground(new Color(245, 245, 245));
			class_textField[i] .setEnabled(false);

			class_textField[i] .setBounds(40, i*30+100, 60, 30);
			frame.getContentPane().add(class_textField[i] );
			class_textField[i] .setColumns(10);
		}
		
		//class_textField[10].setText(time_textField[5].getText()); ���Դ��룬��ʼʱ��=j+7
		/**
		 * ����row*col���
		 */
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
				
				String classroom_name=class_textField[i].getText();
				//��һ����ȡ�˽�������(String����),��һ��Ҫ����ֹʱ�䣬����ͨ��j�����ȡ����Ҫ�����ʽҪ��
				//��Ҫ���� �ѵ���¼���Ϊ�ж��û�״̬�Ƿ��¼ ���δ��¼�跢�͵�¼���������¼�ҵ��ʱ���δ����ɳ��裬���򵯳����ɳ������ʾ��
				//���߿��ǵ��֮�󵯿�Ҫ��������ֹʱ�䣬ͬ����Ҫ�ͻ������ʱ���ʽҪ���Լ�ͨ��textField��ȡ����Ӧ����һ��String���͵���ֹʱ�䣬����
				temp.addMouseListener(new MouseAdapter(){
			            public void mouseClicked(MouseEvent e) {
			            	//���ݵĲ���  classroom_name(���л�ȡ��ʽ) ��ֹʱ��(�л�ȡString���ͺ�int���͵ķ�ʽ����Ҫת��)
			                //ȱ��һ�����Ͷ����ĺ��� ���ݷ��ص�statuscode����info���Լ��ȶԷ���ֵȷ���Ƿ��ɫ(����)
			            	temp.setBackground(new Color(216, 191, 216));
			            }
			        });          frame.getContentPane().add(panel[i*14-14+j]);
		        
	
			}
		

		

	}
}
