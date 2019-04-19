package com.sa.net.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sa.net.DB.MyTime;
import com.sa.net.client.console.OrderConsoleCommand;
import com.sa.net.protocol.OrderRequestPacket;

import io.netty.channel.Channel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

public class OrderUI extends JFrame {

	private JPanel contentPane;
	private Channel channel;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUI frame = new OrderUI("J2-201");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public OrderUI(String classroom,Channel channel) {
		this.channel = channel;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassroom = new JLabel("ClassRoom:");
		lblClassroom.setBackground(Color.BLACK);
		lblClassroom.setBounds(75, 118, 86, 31);
		contentPane.add(lblClassroom);
		
		JLabel label_3 = new JLabel(classroom);
		label_3.setBounds(304, 118, 127, 31);
		contentPane.add(label_3);
		
		JLabel lblStarttime = new JLabel("StartTime:");
		lblStarttime.setForeground(new Color(0, 0, 0));
		lblStarttime.setBounds(75, 193, 134, 31);
		contentPane.add(lblStarttime);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"08:00:00",
				"09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", 
				"15:00:00", "16:00:00", "17:00:00", "18:00:00", "19:00:00"}));
		comboBox_1.setMaximumRowCount(12);
		comboBox_1.setBounds(304, 193, 141, 31);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {
				"09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", 
				"15:00:00", "16:00:00", "17:00:00", "18:00:00", "19:00:00","20:00:00"}));
		comboBox_2.setMaximumRowCount(12);
		comboBox_2.setBounds(304, 272, 141, 31);
		contentPane.add(comboBox_2);
		
		JLabel lblEndtime = new JLabel("EndTime:");
		lblEndtime.setBounds(75, 272, 134, 31);
		contentPane.add(lblEndtime);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String startTime_in_OrderUI = (String) comboBox_1.getSelectedItem();
				String endTime_in_OrderUI = (String) comboBox_2.getSelectedItem();
				if (compareTime(startTime_in_OrderUI,endTime_in_OrderUI))
				{
					ErrorTip errortip=new ErrorTip("开始时间晚于结束时间");
					errortip.setVisible(true);
				}
				else
				{
					
					//发order 参数为 label_3.getText(),startTime_in_OrderUI,endTime_in_OrderUI
					//if 函数=true，返回主界面update
					/*else 
					 * {
					 * errorTip errortip=new errorTip(string类型的错误信息);
				       	errortip.setVisible(true);
				       	}
					*/
					OrderRequestPacket orderRequestPacket = new OrderRequestPacket();
					orderRequestPacket.setClassRoom(label_3.getText());
					orderRequestPacket.setTime(changeToMyTime(startTime_in_OrderUI,endTime_in_OrderUI));
					new OrderConsoleCommand().exec(orderRequestPacket, channel);
					dispose();
				}
			}
		});
		btnOk.setBounds(93, 368, 97, 23);
		contentPane.add(btnOk);
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnLeave.setBounds(318, 368, 97, 23);
		contentPane.add(btnLeave);

		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the time to use the classroom");
		lblPleaseChooseThe.setBounds(108, 44, 398, 23);
		contentPane.add(lblPleaseChooseThe);
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
	
	private static boolean compareTime(String start,String end) {
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
	     if(startTime.getTime()>endTime.getTime()) {
	    	 return true;
	     }
	     else {
	    	 return false;
	     }
		
	}
}
