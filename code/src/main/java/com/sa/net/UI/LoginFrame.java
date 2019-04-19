package com.sa.net.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.sa.net.client.NettyClient;
import com.sa.net.client.console.LoginConsoleCommand;
import com.sa.net.protocol.LoginRequestPacket;

import io.netty.channel.Channel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;

public class  LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField textField_password;
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame(channel);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public LoginFrame(Channel channel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_username = new JTextField();
		textField_username.setBounds(179, 116, 165, 37);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JPasswordField();
		textField_password.setColumns(10);
		textField_password.setBounds(179, 175, 165, 37);
		contentPane.add(textField_password);
		textField_password.setEchoChar('*');

		
		JLabel lblUsername = new JLabel("username :");
		lblUsername.setFont(new Font("宋体", Font.PLAIN, 18));
		lblUsername.setBounds(66, 114, 103, 37);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 18));
		lblPassword.setBounds(66, 175, 103, 37);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Welcome to the classroom rental system!");
		lblNewLabel.setBounds(86, 38, 290, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		 btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//if login函数返回值为true,登录成功 dispose(); 以user身份update主界面
				LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
				loginRequestPacket.setUuid(textField_username.getText());
				loginRequestPacket.setPassword(textField_password.getText());
				LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
				loginConsoleCommand.exec(loginRequestPacket, channel);
				dispose();
			}
		});
		
		btnLogin.setBounds(66, 260, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnLeave.setBounds(279, 260, 97, 23);
		contentPane.add(btnLeave);
	}
}
