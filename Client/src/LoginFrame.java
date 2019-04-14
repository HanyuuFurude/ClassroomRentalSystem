import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
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
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(179, 175, 165, 37);
		contentPane.add(textField_password);
		
		JLabel lblUsername = new JLabel("username :");
		lblUsername.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		lblUsername.setBounds(66, 114, 103, 37);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
		lblPassword.setBounds(66, 175, 103, 37);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Welcome to the classroom rental system!");
		lblNewLabel.setBounds(86, 38, 290, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		 btnLogin.addMouseListener(new MouseAdapter() {
			String username=textField_username.getText();
			String password=textField_password.getText();@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnLogin.setBounds(66, 260, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.setBounds(279, 260, 97, 23);
		contentPane.add(btnLeave);
	}
}
