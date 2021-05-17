import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Helper.DbHelper;
import Helper.Metod_Helper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Name;
	private JTextField txt_Surname;
	private JPasswordField passfld_p1;
	private JPasswordField passfld_p2;
	private JTextField txt_mail;
	private JTextField txt_TCNo;
	private DbHelper dbhelper = new DbHelper();
	private Member member = new Member();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setResizable(false);
		setTitle("Kay\u0131t Ol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_Name = new JLabel("Ad:");
		lbl_Name.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Name.setBounds(32, 50, 160, 24);
		contentPane.add(lbl_Name);

		JLabel lbl_Surname = new JLabel("Soyad:");
		lbl_Surname.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Surname.setBounds(32, 73, 160, 24);
		contentPane.add(lbl_Surname);

		JLabel lbl_Password1 = new JLabel("\u015Eifreniz:");
		lbl_Password1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Password1.setBounds(32, 121, 160, 24);
		contentPane.add(lbl_Password1);

		JLabel lbl_Password2 = new JLabel("\u015Eifrenizi Tekrar giriniz:");
		lbl_Password2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Password2.setBounds(32, 144, 160, 24);
		contentPane.add(lbl_Password2);

		JLabel lbl_Name_Email = new JLabel("E-Mail Adresiniz:");
		lbl_Name_Email.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Name_Email.setBounds(32, 167, 160, 24);
		contentPane.add(lbl_Name_Email);

		JCheckBox chckbx_Confirm = new JCheckBox("Uyelik Bilgilerimin, bu veritabaninda saklanmasina izin veriyorum.");
		chckbx_Confirm.setBackground(SystemColor.inactiveCaption);
		chckbx_Confirm.setFont(new Font("Tahoma", Font.ITALIC, 12));
		chckbx_Confirm.setBounds(32, 198, 365, 23);
		contentPane.add(chckbx_Confirm);

		JButton btn_Register = new JButton("Kayit Ol");
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_Name.getText().length() == 0 || txt_Surname.getText().length() == 0
						|| txt_TCNo.getText().length() == 0 || txt_mail.getText().length() == 0
						|| passfld_p1.getText().length() == 0 || passfld_p2.getText().length() == 0) {
					Metod_Helper.showMsg("fill");

				}
				if (!(passfld_p1.getText().equals(passfld_p2.getText()))) {
					JOptionPane.showMessageDialog(null, "Tekrar girdiðiniz þifre ile þifreniz uyuþmuyor.", "Mesaj",
							JOptionPane.ERROR_MESSAGE);
					passfld_p2.setText("");
				} else if (!chckbx_Confirm.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Kullanýcý sözleþmesini ve davranýþ kurallarýný kabul etmelisiniz.", "Mesaj",
							JOptionPane.INFORMATION_MESSAGE);
					passfld_p2.setText("");
				} else { // kayýt ol kýsmý -------------------------------------
					boolean control = member.register(txt_TCNo.getText(), passfld_p1.getText(), txt_Name.getText(),
							txt_mail.getText(), txt_Surname.getText());

					if (control && (txt_Name.getText().length() != 0 || txt_Surname.getText().length() != 0
							|| txt_TCNo.getText().length() != 0 || txt_mail.getText().length() != 0
							|| passfld_p1.getText().length() != 0 || passfld_p2.getText().length() != 0)) {
						Metod_Helper.showMsg("succes");
						Login login = new Login();
						login.setVisible(true);
						dispose();

					}
					if (!control && (txt_Name.getText().length() != 0 || txt_Surname.getText().length() != 0
							|| txt_TCNo.getText().length() != 0 || txt_mail.getText().length() != 0
							|| passfld_p1.getText().length() != 0 || passfld_p2.getText().length() != 0)) {
						Metod_Helper.showMsg(
								txt_TCNo.getText() + "Girilen T.C. kimlik Numarasý daha önce sisteme kayýtlý.");
					}

				}

			}
		});
		btn_Register.setBackground(SystemColor.inactiveCaption);
		btn_Register.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btn_Register.setBounds(175, 221, 89, 39);
		contentPane.add(btn_Register);

		JButton btn_GoBack = new JButton("Geri Dön");
		btn_GoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btn_GoBack.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_GoBack.setBackground(SystemColor.inactiveCaption);
		btn_GoBack.setBounds(340, 11, 83, 24);
		contentPane.add(btn_GoBack);

		txt_Name = new JTextField();
		txt_Name.setBounds(189, 49, 208, 20);
		txt_Name.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ý' || ke.getKeyChar() == 'ð' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'þ' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'Ý' || ke.getKeyChar() == 'Ð' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Þ' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_Name.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_Name.setEditable(true);
					} else {
						txt_Name.setEditable(false);
					}

				} else {
					txt_Name.setEditable(false);

				}
			}
		});
		contentPane.add(txt_Name);
		txt_Name.setColumns(10);

		txt_Surname = new JTextField();
		txt_Surname.setColumns(10);
		txt_Surname.setBounds(189, 72, 208, 20);
		txt_Surname.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ý' || ke.getKeyChar() == 'ð' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'þ' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'Ý' || ke.getKeyChar() == 'Ð' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Þ' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_Surname.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_Surname.setEditable(true);
					} else {
						txt_Surname.setEditable(false);
					}

				} else {
					txt_Surname.setEditable(false);

				}
			}
		});
		contentPane.add(txt_Surname);

		passfld_p1 = new JPasswordField();
		passfld_p1.setBounds(189, 120, 208, 20);
		passfld_p1.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (passfld_p1.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						passfld_p1.setEditable(true);
					} else {
						passfld_p1.setEditable(false);
					}

				} else {
					passfld_p1.setEditable(false);

				}
			}
		});
		contentPane.add(passfld_p1);

		passfld_p2 = new JPasswordField();
		passfld_p2.setBounds(189, 143, 208, 20);
		passfld_p2.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (passfld_p2.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						passfld_p2.setEditable(true);
					} else {
						passfld_p2.setEditable(false);
					}

				} else {
					passfld_p2.setEditable(false);

				}
			}
		});
		contentPane.add(passfld_p2);

		txt_mail = new JTextField();
		txt_mail.setColumns(10);
		txt_mail.setBounds(189, 166, 208, 20);
		contentPane.add(txt_mail);

		JLabel lbl_TCNo = new JLabel("T.C. Numarasi:");
		lbl_TCNo.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_TCNo.setBounds(32, 96, 160, 24);
		contentPane.add(lbl_TCNo);

		txt_TCNo = new JTextField();
		txt_TCNo.setColumns(10);
		txt_TCNo.setBounds(189, 95, 208, 20);
		txt_TCNo.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
						|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
						|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_TCNo.getText().length() < 11 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_TCNo.setEditable(true);
					} else {
						txt_TCNo.setEditable(false);
					}

				} else {
					txt_TCNo.setEditable(false);

				}
			}
		});
		contentPane.add(txt_TCNo);

		JLabel lbl_Eye = new JLabel();
		ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/eyeOff.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
		lbl_Eye.setIcon(new ImageIcon(newimg));
		lbl_Eye.addMouseListener(new MouseAdapter() {
			boolean eye = false;

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!eye) {
					ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/eyeOn.png"));
					Image image = imageIcon.getImage();
					Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
					lbl_Eye.setIcon(new ImageIcon(newimg));

					passfld_p1.setEchoChar((char) 0);
					passfld_p2.setEchoChar((char) 0);

					eye = true;
				} else {
					ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/eyeOff.png"));
					Image image = imageIcon.getImage();
					Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
					passfld_p1.setEchoChar('*');
					passfld_p2.setEchoChar('*');
					lbl_Eye.setIcon(new ImageIcon(newimg));
					eye = false;
				}
				super.mouseClicked(e);
			}
		});
		lbl_Eye.setBounds(401, 120, 20, 22);
		contentPane.add(lbl_Eye);

		passfld_p2.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				if (!(passfld_p1.getText().equals(passfld_p2.getText()))) {
					passfld_p1.setBackground(Color.red);
					passfld_p2.setBackground(Color.red);
				}

				if (passfld_p1.getText().equals(passfld_p2.getText())) {
					passfld_p1.setBackground(Color.green);
					passfld_p2.setBackground(Color.green);
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (passfld_p1.getText().length() == 0 || passfld_p2.getText().length() == 0) {
					passfld_p1.setBackground(Color.white);
					passfld_p2.setBackground(Color.white);
				}

				else if (!(passfld_p1.getText().equals(passfld_p2.getText()))) {
					passfld_p1.setBackground(Color.red);
					passfld_p2.setBackground(Color.red);
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

		});
		passfld_p1.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				if (passfld_p2.getText().length() > 0 && !(passfld_p1.getText().equals(passfld_p2.getText()))) {
					passfld_p1.setBackground(Color.red);
					passfld_p2.setBackground(Color.red);
				}

				if (passfld_p1.getText().equals(passfld_p2.getText())) {
					passfld_p1.setBackground(Color.green);
					passfld_p2.setBackground(Color.green);
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (passfld_p1.getText().length() == 0 || passfld_p2.getText().length() == 0) {
					passfld_p1.setBackground(Color.white);
					passfld_p2.setBackground(Color.white);
				} else if (!(passfld_p1.getText().equals(passfld_p2.getText()))) {
					passfld_p1.setBackground(Color.red);
					passfld_p2.setBackground(Color.red);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}
}