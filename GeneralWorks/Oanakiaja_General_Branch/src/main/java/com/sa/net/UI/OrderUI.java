package com.sa.net.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class OrderUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUI frame = new OrderUI(" ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderUI(String classroom) {
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
		
		JLabel lblStarttime = new JLabel("StartTime:");
		lblStarttime.setForeground(new Color(0, 0, 0));
		lblStarttime.setBounds(75, 193, 134, 31);
		contentPane.add(lblStarttime);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"}));
		comboBox_1.setMaximumRowCount(12);
		comboBox_1.setBounds(304, 193, 141, 31);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
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
				if (Integer.parseInt(startTime_in_OrderUI)>=(Integer.parseInt(endTime_in_OrderUI)))
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
		
		JLabel label_3 = new JLabel(classroom);
		label_3.setBounds(304, 118, 127, 31);
		contentPane.add(label_3);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the time to use the classroom");
		lblPleaseChooseThe.setBounds(108, 44, 398, 23);
		contentPane.add(lblPleaseChooseThe);
	}
}
