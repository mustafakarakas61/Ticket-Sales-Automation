import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KayitOl extends JFrame {

	private JPanel contentPane;
	private JTextField fld_ad;
	private JTextField fld_soyad;
	private JPasswordField passfld_p1;
	private JPasswordField passfld_p2;
	private JTextField fld_mail;
	private JTextField fld_TCNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitOl frame = new KayitOl();
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
	public KayitOl() {
		setResizable(false);
		setTitle("Kay\u0131t Ol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Ad = new JLabel("Ad:");
		lbl_Ad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Ad.setBounds(32, 50, 160, 24);
		contentPane.add(lbl_Ad);
		
		JLabel lbl_Soyad = new JLabel("Soyad:");
		lbl_Soyad.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Soyad.setBounds(32, 73, 160, 24);
		contentPane.add(lbl_Soyad);
		
		JLabel lbl_Sifre1 = new JLabel("\u015Eifreniz:");
		lbl_Sifre1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Sifre1.setBounds(32, 121, 160, 24);
		contentPane.add(lbl_Sifre1);
		
		JLabel lbl_Sifre2 = new JLabel("\u015Eifrenizi Tekrar giriniz:");
		lbl_Sifre2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Sifre2.setBounds(32, 144, 160, 24);
		contentPane.add(lbl_Sifre2);
		
		JLabel lbl_Ad_Email = new JLabel("E-Mail Adresiniz:");
		lbl_Ad_Email.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Ad_Email.setBounds(32, 167, 160, 24);
		contentPane.add(lbl_Ad_Email);
		
		JCheckBox chckbx_Onayla = new JCheckBox("\u00DCyelik Bilgilerimin, bu veritaban\u0131nda saklanmas\u0131na izin veriyorum.");
		chckbx_Onayla.setBackground(SystemColor.inactiveCaption);
		chckbx_Onayla.setFont(new Font("Tahoma", Font.ITALIC, 12));
		chckbx_Onayla.setBounds(32, 198, 365, 23);
		contentPane.add(chckbx_Onayla);
		
		JButton btn_kayitOl = new JButton("Kay\u0131t Ol");
		btn_kayitOl.setBackground(SystemColor.inactiveCaption);
		btn_kayitOl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btn_kayitOl.setBounds(175, 221, 89, 39);
		contentPane.add(btn_kayitOl);
		
		JButton btn_geriDon = new JButton("Geri D\u00F6n");
		btn_geriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btn_geriDon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_geriDon.setBackground(SystemColor.inactiveCaption);
		btn_geriDon.setBounds(340, 11, 83, 24);
		contentPane.add(btn_geriDon);
		
		fld_ad = new JTextField();
		fld_ad.setBounds(189, 49, 208, 20);
		contentPane.add(fld_ad);
		fld_ad.setColumns(10);
		
		fld_soyad = new JTextField();
		fld_soyad.setColumns(10);
		fld_soyad.setBounds(189, 72, 208, 20);
		contentPane.add(fld_soyad);
		
		passfld_p1 = new JPasswordField();
		passfld_p1.setBounds(189, 120, 208, 20);
		contentPane.add(passfld_p1);
		
		passfld_p2 = new JPasswordField();
		passfld_p2.setBounds(189, 143, 208, 20);
		contentPane.add(passfld_p2);
		
		fld_mail = new JTextField();
		fld_mail.setColumns(10);
		fld_mail.setBounds(189, 166, 208, 20);
		contentPane.add(fld_mail);
		
		JLabel lbl_TCNo = new JLabel("T.C. Numaras\u0131:");
		lbl_TCNo.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_TCNo.setBounds(32, 96, 160, 24);
		contentPane.add(lbl_TCNo);
		
		fld_TCNo = new JTextField();
		fld_TCNo.setColumns(10);
		fld_TCNo.setBounds(189, 95, 208, 20);
		contentPane.add(fld_TCNo);
	}
}
