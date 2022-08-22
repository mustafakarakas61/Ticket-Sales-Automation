package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import Helper.*;

public class UpdateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf_newName;
	private JTextField tf_newSurname;
	private JTextField tf_newPass;
	private JLabel lbl_newPassAgain;
	private JTextField tf_newPassAgain;
	private static user user = new user();
	DbHelper dbHelper = new DbHelper();
	Statement statement = null;
	Connection connection = null;
	ResultSet result = null;
	PreparedStatement pStatement = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateGUI frame = new UpdateGUI();
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
	public UpdateGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateGUI.class.getResource("/Images/ticket.png")));
		setTitle("Bilet Satis Sistemi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lbl_newName = new JLabel("Yeni Ad:");
		lbl_newName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_newName.setBounds(10, 30, 120, 20);
		contentPane.add(lbl_newName);

		tf_newName = new JTextField();
		tf_newName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_newName.setBounds(140, 30, 284, 20);
		contentPane.add(tf_newName);
		tf_newName.setColumns(10);

		JLabel lbl_newSurname = new JLabel("Yeni Soyad:");
		lbl_newSurname.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_newSurname.setBounds(10, 60, 120, 20);
		contentPane.add(lbl_newSurname);

		tf_newSurname = new JTextField();
		tf_newSurname.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_newSurname.setBounds(140, 60, 284, 20);
		contentPane.add(tf_newSurname);
		tf_newSurname.setColumns(10);

		JLabel lbl_newPass = new JLabel("Yeni Sifre:");
		lbl_newPass.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_newPass.setBounds(10, 90, 120, 20);
		contentPane.add(lbl_newPass);

		tf_newPass = new JTextField();
		tf_newPass.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_newPass.setBounds(140, 90, 284, 20);
		contentPane.add(tf_newPass);
		tf_newPass.setColumns(10);
		tf_newPass.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (tf_newPass.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						tf_newPass.setEditable(true);
					} else {
						tf_newPass.setEditable(false);
					}

				} else {
					tf_newPass.setEditable(false);

				}
			}
		});

		lbl_newPassAgain = new JLabel("Yeni Sifre Tekrar:");
		lbl_newPassAgain.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_newPassAgain.setBounds(10, 120, 120, 20);
		contentPane.add(lbl_newPassAgain);

		tf_newPassAgain = new JTextField();
		tf_newPassAgain.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_newPassAgain.setBounds(140, 121, 284, 20);
		contentPane.add(tf_newPassAgain);
		tf_newPassAgain.setColumns(10);
		tf_newPassAgain.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (tf_newPassAgain.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						tf_newPassAgain.setEditable(true);
					} else {
						tf_newPassAgain.setEditable(false);
					}

				} else {
					tf_newPassAgain.setEditable(false);

				}
			}
		});

		int obj = Integer.parseInt(PrimeAdmin.getTf_yoneticiID().getText());

		JButton btn_Update = new JButton("Onayla");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_newName.getText().length() == 0 || tf_newSurname.getText().length() == 0
						|| tf_newPass.getText().length() == 0) {
					Metod_Helper.showMsg("Lutfen gerekli alanlari doldurunuz!");

				} else if (!tf_newPass.getText().equals(tf_newPassAgain.getText())) {
					Metod_Helper.showMsg("Sifrenizin dogru tekrar ettigini kontrol ediniz!");
				}

				else {
					user.updateSubAdmin(obj, tf_newName.getText(), tf_newSurname.getText(), tf_newPass.getText(),
							(tf_newName.getText() + "-" + tf_newSurname.getText()));
					Metod_Helper.showMsg("succes");
					dispose();
					try {
						PrimeAdmin.updateSubAdminList();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		btn_Update.setFocusable(false);
		btn_Update.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Update.setBackground(new Color(153, 255, 153));
		btn_Update.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Update.setBounds(172, 170, 100, 30);
		contentPane.add(btn_Update);
	}

}
