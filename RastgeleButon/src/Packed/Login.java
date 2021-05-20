package Packed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DbHelper;
import Helper.Metod_Helper;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Username_Login;
	private JPasswordField fld_Password_Login;
	private JTextField fld_Username_Admin;
	private JPasswordField fld_Password_Admin;
	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Images/ticket.png")));
		setResizable(false);
		setTitle("Bilet Satis Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tabbedPane.setFocusable(false);
		tabbedPane.setBounds(10, 82, 484, 268);
		contentPane.add(tabbedPane);

		JPanel w_paneCustomer = new JPanel();
		w_paneCustomer.setBackground(Color.WHITE);
		tabbedPane.addTab("Kullanici Girisi", null, w_paneCustomer, null);
		w_paneCustomer.setLayout(null);

		JLabel lbl_UserTC = new JLabel("T.C. Kimlik No:");
		lbl_UserTC.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserTC.setBounds(84, 20, 100, 20);
		w_paneCustomer.add(lbl_UserTC);

		JLabel lbl_Password_Login = new JLabel("Sifre:");
		lbl_Password_Login.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password_Login.setBounds(84, 50, 100, 20);
		w_paneCustomer.add(lbl_Password_Login);

		fld_Username_Login = new JTextField();
		fld_Username_Login.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Username_Login.setBounds(194, 20, 275, 20);
		w_paneCustomer.add(fld_Username_Login);
		fld_Username_Login.setColumns(10);
		fld_Username_Login.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (fld_Username_Login.getText().length() < 11 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						fld_Username_Login.setEditable(true);
					} else {
						fld_Username_Login.setEditable(false);
					}

				} else {
					fld_Username_Login.setEditable(false);

				}
			}
		});

		fld_Password_Login = new JPasswordField();
		fld_Password_Login.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Password_Login.setBounds(194, 50, 275, 20);

		fld_Password_Login.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (fld_Password_Login.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
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

		JButton btn_Register = new JButton("Kayit Ol");
		btn_Register.setFocusable(false);
		btn_Register.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
			}
		});
		btn_Register.setBackground(new Color(153, 255, 102));
		btn_Register.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Register.setBounds(70, 165, 150, 40);
		w_paneCustomer.add(btn_Register);

		JButton btn_Login = new JButton("Giris Yap");
		btn_Login.setFocusable(false);
		btn_Login.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		// --------------------------------------------------------Login
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (fld_Username_Login.getText().length() == 0 || fld_Password_Login.getText().length() == 0) {
					Metod_Helper.showMsg("fill");
				} else if (fld_Username_Login.getText().length() != 11) {
					Metod_Helper.showMsg("Hatali T.C. Kimlik No girisi, 11 haneli degil!");
				} else {
					boolean key = true;
					try {

						connection = dbHelper.getConnection();

						statement = connection.createStatement();

						ResultSet result = statement.executeQuery("select * from booking.register");

						while (result.next()) {

							if (fld_Username_Login.getText().equals(result.getString("TC_No"))
									&& !fld_Password_Login.getText().equals(result.getString("Pass"))) {
								Metod_Helper.showMsg("Sifre yanlis kontrol ediniz.");
								key = false;
							}

							if (fld_Username_Login.getText().equals(result.getString("TC_No"))
									&& fld_Password_Login.getText().equals(result.getString("Pass"))) {

								if (result.getString("type").equals("user")) {

									user member = new user(result.getInt("ID"), result.getString("Name"),
											result.getString("Surname"), result.getString("Pass"),
											result.getString("TC_No"), result.getString("Email"),
											result.getString("type"));

									if ((fld_Username_Login.getText().length() == 11
											&& fld_Password_Login.getText().length() >= 6)) {

										MainScreen ms = new MainScreen(member);
										ms.setVisible(true);
										dispose();

									} else {
										Metod_Helper.showMsg("TC No 11 hane parola minimum 6 hane olmalidir");
									}

									key = false;
								}

							}

						}

					} catch (SQLException e1) {
						dbHelper.showErrorMessage(e1);
					} finally {
						try {
							connection.close();
							statement.close();
						} catch (SQLException e1) {

							dbHelper.showErrorMessage(e1);
						}
					}

					if (key)
						Metod_Helper.showMsg("Boyle bir kayit yok lutfen kaydolunuz.");

				}

			}
		});
		btn_Login.setBackground(new Color(255, 255, 51));
		btn_Login.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Login.setBounds(70, 105, 150, 40);
		w_paneCustomer.add(btn_Login);

		JButton btn_Login_Guest = new JButton("Ziyaretci Girisi");
		btn_Login_Guest.setFocusable(false);
		btn_Login_Guest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Login_Guest.setBackground(new Color(153, 255, 255));
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
		btn_Login_Guest.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Login_Guest.setBounds(259, 105, 150, 40);
		w_paneCustomer.add(btn_Login_Guest);

		JButton btnNewButton = new JButton("Sifremi Unuttum");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ForgottenPassword su = new ForgottenPassword();
				su.setVisible(true);

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(259, 165, 150, 40);
		w_paneCustomer.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/user.png")));
		lblNewLabel.setBounds(10, 10, 64, 64);
		w_paneCustomer.add(lblNewLabel);

		JPanel w_paneAdmin = new JPanel();
		w_paneAdmin.setBackground(Color.WHITE);
		tabbedPane.addTab("Yonetici Girisi", null, w_paneAdmin, null);
		w_paneAdmin.setLayout(null);

		JLabel lbl_Admin_ID = new JLabel("Yonetici ID:");
		lbl_Admin_ID.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Admin_ID.setBounds(84, 20, 100, 20);
		w_paneAdmin.add(lbl_Admin_ID);

		fld_Username_Admin = new JTextField();
		fld_Username_Admin.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Username_Admin.setColumns(10);
		fld_Username_Admin.setBounds(194, 20, 275, 20);
		w_paneAdmin.add(fld_Username_Admin);

		JLabel lbl_Password_Admin = new JLabel("Sifre:");
		lbl_Password_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password_Admin.setBounds(84, 50, 100, 20);
		w_paneAdmin.add(lbl_Password_Admin);

		fld_Password_Admin = new JPasswordField();
		fld_Password_Admin.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Password_Admin.setBounds(194, 50, 275, 20);

		fld_Password_Admin.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (fld_Password_Admin.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
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
		// ---------------------------------------------------------------------Admin
		// login-------------------------
		JButton btn_Login_1 = new JButton("Giris Yap");
		btn_Login_1.setFocusable(false);
		btn_Login_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Login_1.setBackground(new Color(255, 255, 51));
		btn_Login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (fld_Password_Admin.getText().length() == 0 || fld_Username_Admin.getText().length() == 0) {

					Metod_Helper.showMsg("fill");
				} else {
					boolean key = true;
					try {

						connection = dbHelper.getConnection();

						statement = connection.createStatement();

						ResultSet result = statement.executeQuery("select * from admin");
						while (result.next()) {

							if (fld_Username_Admin.getText().equals(result.getString("UserName"))
									&& fld_Password_Admin.getText().equals(result.getString("Pass"))) {

								if (result.getString("type").equals("prime")) {

									user admin = new user(result.getInt("ID"), result.getString("Name"),
											result.getString("Surname"), result.getString("Pass"),
											result.getString("UserName"), result.getString("type"));
									PrimeAdmin pa = new PrimeAdmin(admin);
									pa.setVisible(true);
									dispose();
									key = false;

								}

								if (result.getString("type").equals("sub")) {

									user sub = new user(result.getInt("ID"), result.getString("Name"),
											result.getString("Surname"), result.getString("Pass"),
											result.getString("UserName"), result.getString("type"));

									if ((fld_Username_Admin.getText().length() > 5
											|| fld_Password_Admin.getText().length() > 5)) {

										SubAdmin sa = new SubAdmin(sub);
										sa.setVisible(true);
										dispose();
										key = false;
									} else {
										Metod_Helper.showMsg("Kullanici adi ve parolasi 5 haneden buyuk olmalidir");
									}

								}
							}
						}

					} catch (SQLException e1) {
						dbHelper.showErrorMessage(e1);
					} finally {
						try {
							connection.close();
							statement.close();
						} catch (SQLException e1) {

							dbHelper.showErrorMessage(e1);
						}
					}

					if (key)
						Metod_Helper.showMsg("Sistemde boyle bir yonetici bulunamadi.");

				}

			}
		});
		btn_Login_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Login_1.setBounds(164, 130, 150, 40);
		w_paneAdmin.add(btn_Login_1);

		JLabel lbl_ForgottenAdmin = new JLabel(
				"Giris bilgilerinizi hatirlayamiyorsaniz lutfen ilgili birimle iletisime geciniz");
		lbl_ForgottenAdmin.setBackground(new Color(255, 255, 255));
		lbl_ForgottenAdmin.setFont(new Font("SansSerif", Font.ITALIC, 11));
		lbl_ForgottenAdmin.setBounds(10, 209, 459, 20);
		w_paneAdmin.add(lbl_ForgottenAdmin);

		ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/primex64.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(160, 125, java.awt.Image.SCALE_SMOOTH);

		JLabel lbl_adminIcon = new JLabel();
		lbl_adminIcon.setBounds(10, 10, 64, 64);
		lbl_adminIcon.setIcon(new ImageIcon(Login.class.getResource("/Images/primex64.png")));
		w_paneAdmin.add(lbl_adminIcon);

		JLabel lblWelcome = new JLabel("Bilet Satis Sistemine  Hosgeldiniz");
		lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblWelcome.setBounds(107, 40, 300, 25);
		contentPane.add(lblWelcome);

		JLabel lblBGLogo = new JLabel(new ImageIcon(Login.class.getResource("/Images/ticket.png")));
		lblBGLogo.setBounds(33, 11, 64, 64);
		contentPane.add(lblBGLogo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/ticket.png")));
		lblNewLabel_1.setBounds(406, 11, 64, 64);
		contentPane.add(lblNewLabel_1);
	}
}
