import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Username_Login;
	private JPasswordField fld_PasswordLogin;
	private JTextField fld_Username_Admin;
	private JPasswordField fld_Password_Admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Login Ekran\u0131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 82, 414, 168);
		contentPane.add(tabbedPane);
		
		JPanel w_paneCustomer = new JPanel();
		w_paneCustomer.setBackground(Color.WHITE);
		tabbedPane.addTab("Giriþ", null, w_paneCustomer, null);
		w_paneCustomer.setLayout(null);
		
		JLabel lbl_UserTC = new JLabel("T.C. Kimlik No:");
		lbl_UserTC.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_UserTC.setBounds(10, 22, 108, 14);
		w_paneCustomer.add(lbl_UserTC);
		
		JLabel lbl_Password_Login = new JLabel("\u015Eifre:");
		lbl_Password_Login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Password_Login.setBounds(10, 60, 41, 14);
		w_paneCustomer.add(lbl_Password_Login);
		
		fld_Username_Login = new JTextField();
		fld_Username_Login.setBounds(116, 20, 122, 20);
		w_paneCustomer.add(fld_Username_Login);
		fld_Username_Login.setColumns(10);
		
		fld_PasswordLogin = new JPasswordField();
		fld_PasswordLogin.setBounds(116, 58, 122, 20);
		w_paneCustomer.add(fld_PasswordLogin);
		
		JButton btn_Register = new JButton("Kay\u0131t Ol");
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register ko = new Register();
				ko.setVisible(true);
				dispose();
			}
		});
		btn_Register.setBackground(Color.ORANGE);
		btn_Register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Register.setBounds(10, 90, 101, 39);
		w_paneCustomer.add(btn_Register);
		
		JButton btn_Login = new JButton("Giri\u015F Yap");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen ae= new MainScreen();
				ae.setVisible(true);
				dispose();
			}
		});
		btn_Login.setBackground(Color.GREEN);
		btn_Login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login.setBounds(137, 89, 101, 39);
		w_paneCustomer.add(btn_Login);
		
		JButton btn_Login_Guest = new JButton("\u00DCyesiz Giri\u015F");
		btn_Login_Guest.setBackground(Color.PINK);
		btn_Login_Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestScreen uak= new GuestScreen();
				uak.setVisible(true);
				dispose();
			}
		});
		btn_Login_Guest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login_Guest.setBounds(265, 22, 120, 52);
		w_paneCustomer.add(btn_Login_Guest);
		
		JButton btnNewButton = new JButton("\u015Eifremi Unuttum");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgottenPassword su= new ForgottenPassword();
				su.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(204, 204, 255));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNewButton.setBounds(265, 90, 120, 39);
		w_paneCustomer.add(btnNewButton);
		
		JPanel w_paneAdmin = new JPanel();
		w_paneAdmin.setBackground(Color.WHITE);
		tabbedPane.addTab("Yönetici Giriþi", null, w_paneAdmin, null);
		w_paneAdmin.setLayout(null);
		
		JLabel lbl_Admin_ID = new JLabel("Y\u00F6netici ID:");
		lbl_Admin_ID.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Admin_ID.setBounds(10, 22, 96, 14);
		w_paneAdmin.add(lbl_Admin_ID);
		
		fld_Username_Admin = new JTextField();
		fld_Username_Admin.setColumns(10);
		fld_Username_Admin.setBounds(116, 20, 122, 20);
		w_paneAdmin.add(fld_Username_Admin);
		
		JLabel lbl_Password_Admin = new JLabel("\u015Eifre:");
		lbl_Password_Admin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Password_Admin.setBounds(10, 60, 41, 14);
		w_paneAdmin.add(lbl_Password_Admin);
		
		fld_Password_Admin = new JPasswordField();
		fld_Password_Admin.setBounds(116, 58, 122, 20);
		w_paneAdmin.add(fld_Password_Admin);
		
		JButton btn_Login_1 = new JButton("Giri\u015F Yap");
		btn_Login_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login_1.setBounds(137, 89, 101, 39);
		w_paneAdmin.add(btn_Login_1);
		
		JLabel lbl_ForgottenAdmin = new JLabel("\u015Eifrenizi veya ID'nizi unuttu\u011Funuzda l\u00FCtfen ilgili yetkiliye dan\u0131\u015F\u0131n\u0131z.");
		lbl_ForgottenAdmin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lbl_ForgottenAdmin.setBounds(10, 127, 389, 14);
		w_paneAdmin.add(lbl_ForgottenAdmin);
		
		JLabel lblWelcome = new JLabel("Welcome to Ticket Sales System");
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblWelcome.setBounds(100, 43, 242, 14);
		contentPane.add(lblWelcome);
		
		JLabel lblBGLogo = new JLabel(new ImageIcon(getClass().getResource("sinemabg.png")));
		lblBGLogo.setBounds(12, 31, 90, 60);
		contentPane.add(lblBGLogo);
	}
}
