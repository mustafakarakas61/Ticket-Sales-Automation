package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Message;

import Helper.DbHelper;
import Helper.Metod_Helper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;

public class ForgottenPassword extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Mail;
	private JTextField fld_Rand;
	private JTextField fld_Confirm;
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
					ForgottenPassword frame = new ForgottenPassword();
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
	public ForgottenPassword() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ForgottenPassword.class.getResource("/Images/ticket.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 220);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lbl_email = new JLabel("E-Mail Adresinizi Giriniz");
		lbl_email.setForeground(new Color(51, 51, 51));
		lbl_email.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_email.setBounds(10, 30, 284, 20);
		contentPane.add(lbl_email);

		fld_Mail = new JTextField();
		fld_Mail.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Mail.setBounds(10, 60, 284, 20);
		contentPane.add(fld_Mail);
		fld_Mail.setColumns(10);

		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		int number1, number2, value;
		loops: number1 = r1.nextInt(10);
		number2 = r2.nextInt(10);
		value = r3.nextInt(2);
		rg(value, number1, number2);

		fld_Rand = new JTextField();
		fld_Rand.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Rand.setEditable(false);
		if (value == 0) {
			fld_Rand.setText(" " + number1 + "+" + number2 + "=?");
		} else if (value == 1) {
			fld_Rand.setText(" " + number1 + "-" + number2 + "=?");
		}
		fld_Rand.setBounds(95, 90, 50, 25);
		contentPane.add(fld_Rand);
		fld_Rand.setColumns(10);

		fld_Confirm = new JTextField();
		fld_Confirm.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Confirm.setColumns(10);
		fld_Confirm.setBounds(169, 90, 50, 25);
		fld_Confirm.setText("");
		fld_Confirm.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
						|| ke.getKeyChar() == '-' || ke.getKeyChar() == '+') {

					if (fld_Confirm.getText().length() < 3 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_Confirm.setEditable(true);
					} else {
						fld_Confirm.setEditable(false);
					}

				} else {
					fld_Confirm.setEditable(false);

				}
			}
		});
		contentPane.add(fld_Confirm);

		JButton btnNewButton = new JButton("Gonder");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (fld_Confirm.getText().length() != 0 && fld_Mail.getText().length() != 0) {
					if (Integer.parseInt(fld_Confirm.getText()) == rg(value, number1, number2)) {
						Login l = new Login();

						///////////////////////////////////////////////////////

						boolean key = true;
						try {

							connection = dbHelper.getConnection();

							statement = connection.createStatement();

							ResultSet result = statement.executeQuery("select * from booking.register");

							while (result.next()) {

								if (fld_Mail.getText().equals(result.getString("Email"))) {

									if (result.getString("type").equals("user")) {

										try {
											TimeUnit.SECONDS.sleep(2);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										JOptionPane.showMessageDialog(null,
												"Sifrenizi sifirlamaniz icin mail gonderilmistir.", "Mesaj",
												JOptionPane.INFORMATION_MESSAGE);

										//////////////////////////////////////// Mail

										//////////////////////////////////

										l.setVisible(true);

										dispose();
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
							Metod_Helper.showMsg("Boyle bir Mail sistemde kayitli degil.");

					} else {
						JOptionPane.showMessageDialog(null, "Yanlis cevap. Lutfen tekrar deneyiniz.", "Mesaj",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				if (fld_Mail.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Sifrenizi sifirlamak icin mailinizi giriniz.", "Mesaj",
							JOptionPane.WARNING_MESSAGE);
				}
				if (fld_Confirm.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Dogrulama alanini bos birakmayiniz.", "Mesaj",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(95, 130, 124, 30);
		contentPane.add(btnNewButton);

	}

	public int rg(int value2, int number3, int number4) {
		int result = 0;
		switch (value2) {
		case 0:
			result = number3 + number4;
			break;
		case 1:
			result = number3 - number4;
			break;
		default:
			break;
		}

		return result;
	}
}
