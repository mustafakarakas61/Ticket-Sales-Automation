import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SifremiUnuttum extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField fld_Rand;
	private JTextField fld_Dogrula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SifremiUnuttum frame = new SifremiUnuttum();
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
	public SifremiUnuttum() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 242, 194);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_email = new JLabel("E-Mail Adresinizi Giriniz");
		lbl_email.setForeground(new Color(51, 51, 51));
		lbl_email.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lbl_email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_email.setBounds(10, 35, 206, 18);
		contentPane.add(lbl_email);

		textField = new JTextField();
		textField.setBounds(10, 52, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		int sayi1,sayi2,deger;
		loops:
		sayi1=r1.nextInt(10);
		sayi2 = r2.nextInt(10);
		deger = r3.nextInt(2);
		rg(deger, sayi1, sayi2);

		fld_Rand = new JTextField();
		fld_Rand.setFont(new Font("Sitka Heading", Font.PLAIN, 15));
		fld_Rand.setEditable(false);
		if (deger == 0) {
			fld_Rand.setText(" " + sayi1 + "+" + sayi2 + "=?");
		} else if (deger == 1) {
			fld_Rand.setText(" " + sayi1 + "-" + sayi2 + "=?");
		}
		fld_Rand.setBounds(56, 78, 49, 25);
		contentPane.add(fld_Rand);
		fld_Rand.setColumns(10);

		System.out.println(rg(deger, sayi1, sayi2));

		fld_Dogrula = new JTextField();
		fld_Dogrula.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		fld_Dogrula.setColumns(10);
		fld_Dogrula.setBounds(121, 78, 49, 25);
		fld_Dogrula.setText("");
		contentPane.add(fld_Dogrula);

		JButton btnNewButton = new JButton("Gönder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_Dogrula.getText().length()!=0) {
				if (Integer.parseInt(fld_Dogrula.getText()) == rg(deger, sayi1, sayi2)) {
					Login l = new Login();

					JOptionPane.showMessageDialog(null, "E-Mailinize þifrenizi deðiþtirmeniz için mail gönderilmiþtir.",
							"Mesaj", JOptionPane.INFORMATION_MESSAGE);

					l.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Yanlýþ cevap. Lütfen tekrar deneyiniz.",
							"Mesaj", JOptionPane.ERROR_MESSAGE);
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Doðrulama alanýný boþ býrakmayýnýz.",
							"Mesaj", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(67, 110, 89, 39);
		contentPane.add(btnNewButton);

		
	}
	
	
	public int rg(int degerr, int sayi11, int sayi22) {
		int sonuc = 0;
		switch (degerr) {
		case 0:
			sonuc = sayi11 + sayi22;
			break;
		case 1:
			sonuc = sayi11 - sayi22;
			break;
		default:
			break;
		}

		return sonuc;
	}
}
