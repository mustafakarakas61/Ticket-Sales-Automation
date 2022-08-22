package Packed;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Name;
	private JTextField txt_Surname;
	private JPasswordField passfld_p1;
	private JPasswordField passfld_p2;
	private JTextField txt_mail;
	private JTextField txt_TCNo;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/Images/ticket.png")));
		setResizable(false);
		setTitle("Kayit Ol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lbl_Name = new JLabel("Ad:");
		lbl_Name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Name.setBounds(20, 50, 150, 20);
		contentPane.add(lbl_Name);

		JLabel lbl_Surname = new JLabel("Soyad:");
		lbl_Surname.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Surname.setBounds(20, 73, 160, 20);
		contentPane.add(lbl_Surname);

		JLabel lbl_Password1 = new JLabel("Sifreniz:");
		lbl_Password1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password1.setBounds(20, 121, 150, 20);
		contentPane.add(lbl_Password1);

		JLabel lbl_Password2 = new JLabel("Sifrenizi Tekrar giriniz:");
		lbl_Password2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password2.setBounds(20, 144, 150, 20);
		contentPane.add(lbl_Password2);

		JLabel lbl_Name_Email = new JLabel("E-Mail Adresiniz:");
		lbl_Name_Email.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Name_Email.setBounds(20, 167, 150, 20);
		contentPane.add(lbl_Name_Email);

		JCheckBox chckbx_Confirm = new JCheckBox("Uyelik Bilgilerimin, bu veritabaninda saklanmasina izin veriyorum.");
		chckbx_Confirm.setBackground(new Color(204, 204, 255));
		chckbx_Confirm.setFont(new Font("SansSerif", Font.ITALIC, 13));
		chckbx_Confirm.setBounds(20, 200, 424, 20);
		contentPane.add(chckbx_Confirm);

		JButton btn_Register = new JButton("Kayit Ol");
		btn_Register.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Register.setFocusable(false);
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_Name.getText().length() == 0 || txt_Surname.getText().length() == 0
						|| txt_TCNo.getText().length() == 0 || txt_mail.getText().length() == 0
						|| passfld_p1.getText().length() == 0 || passfld_p2.getText().length() == 0) {
					Metod_Helper.showMsg("fill");

				}
				if (!(passfld_p1.getText().equals(passfld_p2.getText()))) {
					JOptionPane.showMessageDialog(null, "Tekrar girdiginiz sifre ile sifreniz uyusmuyor.", "Mesaj",
							JOptionPane.ERROR_MESSAGE);
					passfld_p2.setText("");
				} else if (!chckbx_Confirm.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Kullanici, sozlesmesini ve davranis kurallarini kabul etmelisiniz.", "Mesaj",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (txt_TCNo.getText().length() != 11) {
					Metod_Helper.showMsg("T.C. Kimlik Numarasi 11 haneli olmalidir.");
				} else if (passfld_p1.getText().length() < 6 || passfld_p2.getText().length() < 6) {
					Metod_Helper.showMsg("Sifreniz en az 6 haneli olmalidir.");
				}

				else {
					boolean control = member.register(txt_TCNo.getText(), passfld_p1.getText(), txt_Name.getText(),
							txt_mail.getText(), txt_Surname.getText());

					if (control && (txt_Name.getText().length() != 0 || txt_Surname.getText().length() != 0
							|| txt_TCNo.getText().length() == 11 || txt_mail.getText().length() != 0
							|| passfld_p1.getText().length() >= 6 || passfld_p2.getText().length() >= 6)) {
						Metod_Helper.showMsg("succes");
						Login login = new Login();
						login.setVisible(true);
						dispose();

					}

				}

			}
		});
		btn_Register.setBackground(new Color(153, 255, 102));
		btn_Register.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Register.setBounds(167, 235, 130, 35);
		contentPane.add(btn_Register);

		JButton btn_GoBack = new JButton("Geri Don");
		btn_GoBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_GoBack.setFocusable(false);
		btn_GoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btn_GoBack.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_GoBack.setBackground(new Color(153, 204, 255));
		btn_GoBack.setBounds(354, 11, 90, 25);
		contentPane.add(btn_GoBack);

		txt_Name = new JTextField();
		txt_Name.setBounds(189, 50, 225, 20);
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
		txt_Surname.setBounds(189, 73, 225, 20);
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
		passfld_p1.setBounds(189, 121, 225, 20);
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
		passfld_p2.setBounds(189, 144, 225, 20);
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
		txt_mail.setBounds(189, 167, 225, 20);
		contentPane.add(txt_mail);

		JLabel lbl_TCNo = new JLabel("T.C. Numarasi:");
		lbl_TCNo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TCNo.setBounds(20, 96, 150, 20);
		contentPane.add(lbl_TCNo);

		txt_TCNo = new JTextField();
		txt_TCNo.setColumns(10);
		txt_TCNo.setBounds(189, 96, 225, 20);
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
		lbl_Eye.setBounds(424, 119, 20, 22);
		contentPane.add(lbl_Eye);

		passfld_p2.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

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

			}

		});
		passfld_p1.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

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

			}

		});

	}
}
