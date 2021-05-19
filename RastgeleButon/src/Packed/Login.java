package Packed;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DbHelper;
import Helper.Metod_Helper;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Username_Login;
	private JPasswordField fld_Password_Login;
	private JTextField fld_Username_Admin;
	private JPasswordField fld_Password_Admin;
	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement ;

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
		setTitle("Login Ekrani");
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
		
		JLabel lbl_Password_Login = new JLabel("Sifre:");
		lbl_Password_Login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Password_Login.setBounds(10, 60, 41, 14);
		w_paneCustomer.add(lbl_Password_Login);
		
		fld_Username_Login = new JTextField();
		fld_Username_Login.setBounds(116, 20, 122, 20);
		w_paneCustomer.add(fld_Username_Login);
		fld_Username_Login.setColumns(10);
		
		fld_Password_Login = new JPasswordField();
		fld_Password_Login.setBounds(116, 58, 122, 20);
		
		fld_Password_Login.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						||ke.getKeyChar() == '.'
						||ke.getKeyChar() == '?'
						||ke.getKeyChar() == '!'
						||(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						||(ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						||(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
						|| ke.getKeyCode()==KeyEvent.VK_ENTER
						|| ke.getKeyCode()==KeyEvent.VK_SHIFT
						|| ke.getKeyCode()==KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode()==KeyEvent.VK_ESCAPE) {

					if (fld_Password_Login.getText().length() <= 30 
							|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode()==KeyEvent.VK_ENTER
							|| ke.getKeyCode()==KeyEvent.VK_SHIFT
							|| ke.getKeyCode()==KeyEvent.VK_CAPS_LOCK
							|| ke.getKeyCode()==KeyEvent.VK_ESCAPE) {
						fld_Password_Login.setEditable(true);
					} else {
						fld_Password_Login.setEditable(false);
					}

				} else {
					fld_Password_Login.setEditable(false);

				}
			}
		});
		
		
		
		
		
		w_paneCustomer.add(fld_Password_Login);
		
		JButton btn_Register = new JButton("Kayýt Ol");
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
			}
		});
		btn_Register.setBackground(Color.ORANGE);
		btn_Register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Register.setBounds(10, 90, 101, 39);
		w_paneCustomer.add(btn_Register);
		
		JButton btn_Login = new JButton("Giriþ Yap");
		//--------------------------------------------------------Login
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fld_Username_Login.getText().length()==0
						||fld_Password_Login.getText().length()==0) {
					Metod_Helper.showMsg("fill");
				}else {
					boolean key = true;
					try {
						
						connection = dbHelper.getConnection();
						
						statement=connection.createStatement();
						
						ResultSet result= statement.executeQuery("select * from booking.register");
						
						
						while (result.next()) {							
								
								if (fld_Username_Login.getText().equals(result.getString("TC_No")) && 
										!fld_Password_Login.getText().equals(result.getString("Pass")))
								{
									Metod_Helper.showMsg("Þifre yanlýþ kontrol ediniz.");
									key=false;
								}
								
									
							if (fld_Username_Login.getText().equals(result.getString("TC_No")) && 
									fld_Password_Login.getText().equals(result.getString("Pass"))) {
								
							
							
								
								if (result.getString("type").equals("user")) {

									user member= new user( 
											  result.getInt("ID")
											, result.getString("Name")
											, result.getString("Surname")
											, result.getString("Pass")
											, result.getString("TC_No")
											, result.getString("Email")
											, result.getString("type")
											);
									
								
								if ((fld_Username_Login.getText().length() ==11 && fld_Password_Login.getText().length() >=6)) {
									
									
									MainScreen ms= new MainScreen(member);
									ms.setVisible(true);
									dispose();
									
								}else {
									Metod_Helper.showMsg("TC No 11 hane parola minimum 6 hane olmalidir");
								}
									
								key = false;
								}
								
							
							}
							
						}
						 
					} catch (SQLException e1) {
						dbHelper.showErrorMessage(e1);
					}
					finally {
						try {
							connection.close();
							statement.close();
						} catch (SQLException e1) {
							
							dbHelper.showErrorMessage(e1);
						}
					}
					
					if (key) 
						Metod_Helper.showMsg("Böyle bir kayýt yok lütfen kaydolunuz.");
					
				}
				
				
				
			
					
				
					
				
			}
		});
		btn_Login.setBackground(Color.GREEN);
		btn_Login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login.setBounds(137, 89, 101, 39);
		w_paneCustomer.add(btn_Login);
		
		JButton btn_Login_Guest = new JButton("Ziyaretçi ?");
		btn_Login_Guest.setBackground(Color.PINK);
		btn_Login_Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestScreen uak;
				try {
					uak = new GuestScreen(null);
					uak.setVisible(true);
				} catch (SQLException e1) {
					
				}
			
				dispose();
			}
		});
		btn_Login_Guest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login_Guest.setBounds(265, 22, 120, 52);
		w_paneCustomer.add(btn_Login_Guest);
		
		JButton btnNewButton = new JButton("Þifremi Unuttum");
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
		
		JLabel lbl_Admin_ID = new JLabel("Yönetici ID:");
		lbl_Admin_ID.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Admin_ID.setBounds(10, 22, 96, 14);
		w_paneAdmin.add(lbl_Admin_ID);
		
		fld_Username_Admin = new JTextField();
		fld_Username_Admin.setColumns(10);
		fld_Username_Admin.setBounds(116, 20, 122, 20);
		w_paneAdmin.add(fld_Username_Admin);
		
		JLabel lbl_Password_Admin = new JLabel("Sifre:");
		lbl_Password_Admin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_Password_Admin.setBounds(10, 60, 41, 14);
		w_paneAdmin.add(lbl_Password_Admin);
		
		fld_Password_Admin = new JPasswordField();
		fld_Password_Admin.setBounds(116, 58, 122, 20);
		
		fld_Password_Admin.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						||ke.getKeyChar() == '.'
						||ke.getKeyChar() == '?'
						||ke.getKeyChar() == '!'
						||(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						||(ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						||(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
						|| ke.getKeyCode()==KeyEvent.VK_ENTER
						|| ke.getKeyCode()==KeyEvent.VK_SHIFT
						|| ke.getKeyCode()==KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode()==KeyEvent.VK_ESCAPE) {

					if (fld_Password_Admin.getText().length() <= 30 
							|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode()==KeyEvent.VK_ENTER
							|| ke.getKeyCode()==KeyEvent.VK_SHIFT
							|| ke.getKeyCode()==KeyEvent.VK_CAPS_LOCK
							|| ke.getKeyCode()==KeyEvent.VK_ESCAPE) {
						fld_Password_Admin.setEditable(true);
					} else {
						fld_Password_Admin.setEditable(false);
					}

				} else {
					fld_Password_Admin.setEditable(false);

				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		w_paneAdmin.add(fld_Password_Admin);
		//---------------------------------------------------------------------Admin login-------------------------
		JButton btn_Login_1 = new JButton("Giris Yap");
		btn_Login_1.setBackground(new Color(255, 235, 205));
		btn_Login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fld_Password_Admin.getText().length()==0 
					|| fld_Username_Admin.getText().length()==0	) {
			
					Metod_Helper.showMsg("fill");
				}else {
					boolean key = true;
					try {
						
						connection = dbHelper.getConnection();
						
						statement=connection.createStatement();
						
						ResultSet result= statement.executeQuery("select * from admin");
						while (result.next()) {
							
							
							if (fld_Username_Admin.getText().equals(result.getString("UserName")) && 
									fld_Password_Admin.getText().equals(result.getString("Pass"))) {
							
								
								if (result.getString("type").equals("prime")) {
									
									user admin= new user( 
											  result.getInt("ID")
											, result.getString("Name")
											,result.getString("Surname")
											, result.getString("Pass")
											,result.getString("UserName")
											, result.getString("type")
											);
									PrimeAdmin pa = new PrimeAdmin(admin);
									pa.setVisible(true);
									dispose();
									key = false;
									
								}
							
								if (result.getString("type").equals("sub")) {
									
									user sub= new user( 
											  result.getInt("ID")
												, result.getString("Name")
												,result.getString("Surname")
												, result.getString("Pass")
												,result.getString("UserName")
												, result.getString("type")
												);
									
									if ((fld_Username_Admin.getText().length() >5 || fld_Password_Admin.getText().length() >5)) {
										
										
										
										SubAdmin sa = new SubAdmin(sub);
										sa.setVisible(true);
										dispose();
										key = false;
									}else {
										Metod_Helper.showMsg("Kullanici adi ve parolasi 5 haneden büyük olmalidir");
									}
									
							
							
							
						}
					}
				}
						 
					} catch (SQLException e1) {
						dbHelper.showErrorMessage(e1);
					}
					finally {
						try {
							connection.close();
							statement.close();
						} catch (SQLException e1) {
							
							dbHelper.showErrorMessage(e1);
						}
					}
					
					if (key) 
						Metod_Helper.showMsg("Sistemde böyle bir yönetici bulunamadý.");
					
				} 
					
				
				
			
			}
		});
		btn_Login_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_Login_1.setBounds(137, 89, 101, 39);
		w_paneAdmin.add(btn_Login_1);
		
		JLabel lbl_ForgottenAdmin = new JLabel("Sifrenizi veya ID'nizi unuttuðunuzda lütfen ilgili yetkiliye den yardým alýnýz.");
		lbl_ForgottenAdmin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lbl_ForgottenAdmin.setBounds(10, 127, 389, 14);
		w_paneAdmin.add(lbl_ForgottenAdmin);
		
		
		ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/admin.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(160, 125, java.awt.Image.SCALE_SMOOTH);

		
		
		JLabel lbl_adminIcon = new JLabel();
		lbl_adminIcon.setBounds(248, 11, 161, 117);
		lbl_adminIcon.setIcon(new ImageIcon(newimg));
		w_paneAdmin.add(lbl_adminIcon);
		
		JLabel lblWelcome = new JLabel("Welcome to Ticket Sales System");
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblWelcome.setBounds(100, 43, 242, 14);
		contentPane.add(lblWelcome);
		
		JLabel lblBGLogo = new JLabel(new ImageIcon(Login.class.getResource("/Images/sinemabg.png")));
		lblBGLogo.setBounds(12, 31, 90, 60);
		contentPane.add(lblBGLogo);
	}
}
