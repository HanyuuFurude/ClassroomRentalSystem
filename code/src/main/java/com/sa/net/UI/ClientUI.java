package com.sa.net.UI;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.sa.net.DB.MyTime;
import com.sa.net.DB.Updatesql;
import com.sa.net.client.console.LogoutConsoleCommand;
import com.sa.net.client.console.UpdateConsoleCommand;
import com.sa.net.protocol.LogoutRequestPacket;
import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.Channel;

public class ClientUI {

	/**
	 * 初始化row，col
	 */
	private static String[] classroom = { "J2-101", "J2-102", "J2-103", "J2-104", "J2-201", "J2-202", "J2-203",
			"J2-204", "J2-301", "J2-302", "J2-303", "J2-304", "J2-401", "J2-402" };
	private static String[] Time = { "08:00:00", "09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00",
			"15:00:00", "16:00:00", "17:00:00", "18:00:00", "19:00:00", "20:00:00" };
	// private String[] time = {""};
	private final static Color INICOLOR = new Color(176, 224, 230);
	private final static Color MYCOLOR = new Color(255, 160, 122);
	private final static Color HISCOLOR = new Color(216, 191, 216);
	static int row = 15;
	static int col = 13;
	private Channel channel; // 窗口与
	public JFrame frame;
	private JTextField textField;
	static public JLabel lblLogout;
	static public JLabel lblLogin;
	/**
	 * @Author: Hanyuu
	 * @Description: 重构
	 * @Date: 2019/4/15
	 */
	static private JPanel[] JPlpanel;
	/**
	 * @Author: Hanyuu
	 * @Description:重构
	 * @Date: 2019/4/15
	 */
	static public JPanel Jplcanvas;
	// static public HashMap<String,HashMap<MyTime,Integer>> map;
	static public JLabel lblWelcome;

	static public JLabel updateLabel;

	/**
	 * Launch the application.
	 * 
	 * @return
	 */

	// public static void update_in_UI(Map<String, HashMap<MyTime, Integer>> map)
	public static void update_in_UI(Map<String, HashMap<MyTime, Integer>> map) {
		// TODO classroom
		//MyTime time;
		int cla = 0,sta=0,end=0;
		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++) {
				Jplcanvas = JPlpanel[i * 14 - 14 + j];
				Jplcanvas.setBackground(INICOLOR);
				Jplcanvas.revalidate();
			}
		for(String room:map.keySet())
		{
			for(MyTime ctime:map.get(room).keySet()) {
				System.out.println("-----!!!---");
				System.out.println(room);
				System.out.println(map.get(room).get(ctime));
				System.out.println(ctime.getStartTime().toString() + ctime.getEndTime().toString());
				if(map.get(room).get(ctime).intValue()==1) {
					//找到这一处染黑
					for(int i = 0; i<classroom.length;i++)
					{
						if(room.equals(classroom[i]))
							cla = i+1;
					}
					for(int i = 0;i<Time.length;i++)
					{
						if(ctime.getStartTime().toString().equals(Time[i]))
							sta = i+1;
					}
					for(int i = 0; i<Time.length;i++)
					{
						if(ctime.getEndTime().toString().equals(Time[i]))
							end = i;
					}
					for(int i = sta; i<=end; i++)
					{	
						Jplcanvas = JPlpanel[cla*14-14+i]; 
						Jplcanvas.setBackground(MYCOLOR);
					}
				
	
				}else if(map.get(room).get(ctime).intValue()==0){
					for(int i = 0; i<classroom.length;i++)
					{
						if(room.equals(classroom[i]))
							cla = i+1;
					}
					for(int i = 0;i<Time.length;i++)
					{
						if(ctime.getStartTime().toString().equals(Time[i]))
							sta = i+1;
					}
					for(int i = 0; i<Time.length;i++)
					{
						if(ctime.getEndTime().toString().equals(Time[i]))
							end = i;
					}
					for(int i = sta; i<=end; i++)
					{	
						Jplcanvas = JPlpanel[cla*14-14+i]; 
						Jplcanvas.setBackground(HISCOLOR);
					}

				}
			}
		}
		/*for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++) {
				Jplcanvas = JPlpanel[i * 14 - 14 + j];
			//	time = changeToMyTime(Time[j - 1], Time[j]);
				
				// System.out.println(map.entrySet());
				// System.out.println((map.get(classroom[i]).get(time)));
				
				//if (map.containsKey(classroom[i-1])) {
						//这个time由于是对象，比较不了,也get不了，怎么处理
					//	if(map.get(classroom[i-1]).containsKey(time)) {
						//if (map.get(classroom[i-1]).get(time).intValue() == 1) {
							//System.out.println("本人");
							//Jplcanvas.setBackground(MYCOLOR);
						//} else if (map.get(classroom[i-1]).get(time).intValue() == 0) {
							//System.out.println("他人");
							//Jplcanvas.setBackground(HISCOLOR);
						
					//}}else {
					/*	System.out.println("w人");
						Jplcanvas.setBackground(INICOLOR);
			}
						
				} else {
					System.out.println("wu人");
					Jplcanvas.setBackground(INICOLOR);
				}
				Jplcanvas.setBackground(INICOLOR);
				Jplcanvas.revalidate();
			}*/

		System.out.println("染色");
	}


	private static MyTime changeToMyTime(String start, String end) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date ds = null;
		Date de = null;
		try {
			ds = format.parse(start);
			de = format.parse(end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Time startTime = new java.sql.Time(ds.getTime());
		java.sql.Time endTime = new java.sql.Time(de.getTime());
		return new MyTime(startTime, endTime);
	}

	/*
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public vosid run() { try { ClientUI window = new ClientUI();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 */
	/**
	 * Create the application.
	 */
	public ClientUI(Channel channel) {
		this.channel = channel;
		initialize();
	}

	public static void UpdateName(Channel channel) {
		lblWelcome.setText("Welcome!"+SessionUtil.getName(channel));
		lblWelcome.revalidate();
	}

	public static void UpdateLogin(Channel channel) {
		lblLogin.setVisible(false);
		lblLogout.setVisible(true);
		lblLogin.revalidate();
		lblLogout.revalidate();
	}

	public static void UpdateLogout(Channel channel) {
		lblLogin.setVisible(true);
		lblLogout.setVisible(false);
		lblLogin.revalidate();
		lblLogout.revalidate();
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
		String identity = SessionUtil.getName(channel);
		/*
		ImageIcon icon=new ImageIcon("main.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		frame.getContentPane().add(label);
		*/
		lblWelcome = new JLabel("Welcome!"+identity);
		lblWelcome.setSize(40, 20);
		lblWelcome.setBounds(27, 62, 150, 15);
		frame.getContentPane().add(lblWelcome);

		// Login点击事件
		lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame loginframe = new LoginFrame(channel);
				loginframe.setVisible(true);

			}
		});
		lblLogin.setBounds(578, 62, 58, 15);
		frame.getContentPane().add(lblLogin);
		// update
		updateLabel = new JLabel("Update");
		updateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateConsoleCommand updateConsoleCommand = new UpdateConsoleCommand();
				UpdateRequestPacket updateRequestPacket = new UpdateRequestPacket(SessionUtil.getIdentify(channel));
				updateConsoleCommand.exec(updateRequestPacket, channel);

			}
		});
		updateLabel.setBounds(500, 62, 58, 15);
		frame.getContentPane().add(updateLabel);

		lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
				LogoutConsoleCommand logoutConsole = new LogoutConsoleCommand();
				logoutConsole.exec(logoutRequestPacket, channel);
			}
		});
		lblLogout.setBounds(578, 62, 58, 15);
		frame.getContentPane().add(lblLogout);
		lblLogout.setVisible(false);

		JLabel iconLabel = new JLabel("教室管理系统");
		iconLabel.setBounds(279, 10, 88, 15);
		frame.getContentPane().add(iconLabel);

		JLabel label_1 = new JLabel(
				"浅蓝色未借出，浅黄色自己已借，浅紫色别人已借");
		label_1.setBounds(180, 35, 500, 23);
		frame.getContentPane().add(label_1);

		/**
		 * 生成最上面一行的事件 textField
		 */
		JTextField[] time_textField = new JTextField[col + 1];
		for (int j = 1; j < col; j++) {

			time_textField[j] = new JTextField();

			time_textField[j].setDisabledTextColor(new Color(0, 0, 0));
			time_textField[j].setForeground(new Color(0, 0, 0));
			time_textField[j].setFont(new Font("黑体", Font.PLAIN, 10));
			time_textField[j].setHorizontalAlignment(SwingConstants.CENTER);

			time_textField[j].setText((j + 7) + ":00");
			time_textField[j].setBackground(new Color(245, 245, 245));
			time_textField[j].setEnabled(false);
			time_textField[j].setBounds(j * 40 + 60, 100, 40, 30);
			frame.getContentPane().add(time_textField[j]);
			time_textField[j].setColumns(10);
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

		/**
		 * 生成最左侧一行的教室TextField
		 */
		JTextField[] class_textField = new JTextField[row + 1];
		for (int i = 1; i < row; i++) {

			class_textField[i] = new JTextField();
			class_textField[i].setHorizontalAlignment(SwingConstants.CENTER);
			class_textField[i].setText(classroom[i-1]);
			class_textField[i].setDisabledTextColor(new Color(0, 0, 0));
			class_textField[i].setForeground(new Color(0, 0, 0));
			class_textField[i].setFont(new Font("黑体", Font.PLAIN, 10));
			class_textField[i].setBackground(new Color(245, 245, 245));
			class_textField[i].setEnabled(false);

			class_textField[i].setBounds(40, i * 30 + 100, 60, 30);
			frame.getContentPane().add(class_textField[i]);
			class_textField[i].setColumns(10);
			// j++;
		}

		// class_textField[10].setText(time_textField[5].getText()); ���Դ��룬��ʼʱ��=j+7

		JPlpanel = new JPanel[row * col + 1];

		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++) {
				Jplcanvas = new JPanel();
				this.JPlpanel[i * 14 - 14 + j] = new JPanel();
				// temp = this.JPlpanel[i * 14 - 14 + j];

				// =temp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.window,
				// SystemColor.window, SystemColor.window, SystemColor.window));
				// temp.setBackground((new Color(176, 224, 230)));
				// temp.setBounds((j * 40 + 60), (i * 30 + 100), 40, 30);
				Jplcanvas = this.JPlpanel[i * 14 - 14 + j];
				Jplcanvas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.window, SystemColor.window,
						SystemColor.window, SystemColor.window));
				// Jplcanvas.setBackground((new Color(176, 224, 230)));
				Jplcanvas.setBackground(INICOLOR);
				Jplcanvas.setBounds((j * 40 + 60), (i * 30 + 100), 40, 30);

				String classroom_name = class_textField[i].getText();
				// 需要更改 把点击事件改为判断用户状态是否登录 如果未登录需发送登录请求，如果登录且点击时间段未出借可出借，否则弹出不可出借的提示框
				// 或者考虑点击之后弹框要求输入起止时间，同样需要客户输入的时间格式要求，以及通过textField获取到的应该是一个String类型的起止时间，存疑
				/**
				 * @Author: Hanyuu
				 * @Description:�ع����������temp�������鵽�������
				 * @Date: 2019/4/15
				 */
//                temp.addMouseListener(new MouseAdapter() {
				Jplcanvas.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						e.getSource();
						if (SessionUtil.getIdentify(channel) == 0) {
							LoginFrame loginframe = new LoginFrame(channel);
							loginframe.setVisible(true);
						} else {
							OrderUI orderui = new OrderUI(classroom_name, channel);// 只用了一个临时变量classromm_name
							// 可能会出现多个frame的调用ui事件一致 存疑
							orderui.setVisible(true);
						}
						// 传递的参数 classroom_name(已有获取方式) 起止时间(有获取String类型和int类型的方式，需要转化)
						// 缺少一个发送订单的函数 根据返回的statuscode调用info，以及比对返回值确认是否改色(更新)
//                        temp.setBackground(new Color(216, 191, 216));
						// 改色命令((JPanel)e.getSource()).setBackground(new Color(216, 191, 216));
					}
				});
				frame.getContentPane().add(this.JPlpanel[i * 14 - 14 + j]);

			}

	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}